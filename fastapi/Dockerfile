# Python 베이스 이미지 사용
FROM python:3.10

# 작업 디렉토리 설정
WORKDIR /app

# 로컬 파일 복사
COPY . .

# 의존성 설치
RUN pip install --upgrade pip && pip install -r requirements.txt

# 포트 개방
EXPOSE 8000

# 앱 실행 명령은 docker-compose에서 지정함
