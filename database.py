from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker, declarative_base
from pymongo import MongoClient

# SQLAlchemy 설정 (MySQL)
DB_URL = "mysql+mysqlconnector://root:123qwe@localhost:3306/testdb"
engine = create_engine(DB_URL)
SessionLocal = sessionmaker(bind=engine)
Base = declarative_base()

# MongoDB 설정
mongo_client = MongoClient('mongodb://localhost:27017/')
mongo_db = mongo_client['testdb']
mongo_users = mongo_db['users']