from fastapi import FastAPI, Depends, HTTPException, status
from fastapi.middleware.cors import CORSMiddleware
from sqlalchemy.orm import Session
from models import User
from database import SessionLocal, engine, Base, mongo_users
from pydantic import BaseModel
from bson import ObjectId

# FastAPI 앱 초기화
app = FastAPI()

# CORS 설정: React 앱(3000번 포트)에서 접근 허용
app.add_middleware(
    CORSMiddleware,
    allow_origins=["http://localhost:3000"],  # 프론트엔드 주소
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

# DB 테이블 생성
Base.metadata.create_all(bind=engine)

# Pydantic 모델
class UserCreate(BaseModel):
    name: str
    email: str

class UserUpdate(BaseModel):
    name: str
    email: str

# DB 세션 의존성
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

# GET /users : 모든 사용자 조회 (MongoDB 사용)
@app.get("/users")
def read_users():
    # MongoDB에서 사용자 데이터 조회
    users = list(mongo_users.find({}))
    
    # ObjectId를 문자열로 변환 (JSON 직렬화를 위해)
    for user in users:
        user["_id"] = str(user["_id"])
    
    return users

# POST /users : 사용자 생성 (MySQL 사용)
@app.post("/users")
def create_user(user: UserCreate, db: Session = Depends(get_db)):
    db_user = User(name=user.name, email=user.email)
    db.add(db_user)
    db.commit()
    db.refresh(db_user)
    return db_user

# PUT /users/{user_id} : 사용자 정보 업데이트 (MySQL 사용)
@app.put("/users/{user_id}", response_model=None)
def update_user(user_id: int, user: UserUpdate, db: Session = Depends(get_db)):
    db_user = db.query(User).filter(User.id == user_id).first()
    if db_user is None:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail="사용자를 찾을 수 없습니다")
    
    db_user.name = user.name
    db_user.email = user.email
    db.commit()
    db.refresh(db_user)
    return db_user

# DELETE /users/{user_id} : 사용자 삭제 (MySQL 사용)
@app.delete("/users/{user_id}", status_code=status.HTTP_204_NO_CONTENT)
def delete_user(user_id: int, db: Session = Depends(get_db)):
    db_user = db.query(User).filter(User.id == user_id).first()
    if db_user is None:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail="사용자를 찾을 수 없습니다")
    
    db.delete(db_user)
    db.commit()
    return None