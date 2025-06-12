# Spring Boot 사용자 관리 애플리케이션

이 프로젝트는 FastAPI로 작성된 애플리케이션을 Spring Boot로 재구현한 버전입니다.

## 기술 스택

- Spring Boot 3.2.0
- Spring Data JPA
- Spring Data MongoDB
- MySQL
- MongoDB
- Lombok

## 프로젝트 구조

```
src/main/java/com/example/demo/
├── DemoApplication.java         # 메인 애플리케이션 클래스
├── controller/                  # REST API 컨트롤러
│   └── UserController.java
├── service/                     # 비즈니스 로직
│   └── UserService.java
├── repository/                  # 데이터 액세스 계층
│   ├── UserRepository.java      # MySQL 리포지토리
│   └── MongoUserRepository.java # MongoDB 리포지토리
├── entity/                      # JPA 엔티티 (MySQL)
│   └── User.java
├── document/                    # MongoDB 문서 모델
│   └── MongoUser.java
└── dto/                         # 데이터 전송 객체
    └── UserDto.java
```

## API 엔드포인트

- `GET /users` - 모든 사용자 조회 (MongoDB 사용)
- `POST /users` - 새 사용자 생성 (MySQL 사용)
- `PUT /users/{userId}` - 사용자 정보 업데이트 (MySQL 사용)
- `DELETE /users/{userId}` - 사용자 삭제 (MySQL 사용)

## 실행 방법

### 사전 요구사항

- Java 17 이상
- Maven
- MySQL 서버 (localhost:3306)
- MongoDB 서버 (localhost:27017)

### 데이터베이스 설정

1. MySQL에 `testdb` 데이터베이스 생성
2. MongoDB에 `testdb` 데이터베이스 생성

### 애플리케이션 실행

```bash
# 프로젝트 디렉토리로 이동
cd springboot

# Maven으로 빌드 및 실행
./mvnw spring-boot:run
```

서버는 기본적으로 8000번 포트에서 실행됩니다.