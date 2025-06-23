### Go, Springboot, Fastapi

### CI/CD (+ Automated Release )





---


### Setting
<details>

### MySQL / MongoDB with Docker
window 환경
```

docker run -d --name mysql-container -e MYSQL_ROOT_PASSWORD=rootpw -e MYSQL_DATABASE=testdb -p 3306:3306 mysql:8

docker run -d --name mongo-container -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=adminpw -p 27017:27017 mongo:6


docker exec -it mysql-container mysql -u root -p


docker exec -it mongo-container mongosh -u admin -p adminpw --authenticationDatabase admin


```


### MySQL
```
MYSQL_USER=root
MYSQL_PASSWORD=123qwe
MYSQL_HOST=localhost
MYSQL_PORT=3306
MYSQL_DB=testdb

```

db / 테이블생성
```
CREATE DATABASE IF NOT EXISTS testdb;
USE testdb;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(50) UNIQUE
);
```



더미데이터

```sql
INSERT INTO users (name, email) VALUES
('Alice', 'alice@example.com'),
('Bob', 'bob@example.com'),
('Charlie', 'charlie@example.com');
```

### MongoDB

docker로 설치

```
use testdb
db.createCollection("users")


show dbs              // testdb가 실제로 생겼는지 확인
show collections      // users 컬렉션이 보이는지 확인




db.users.find().pretty()
```


더미테이터

```
db.users.insertMany([
  { name: 'Bob', email: 'bob@example.com' },
  { name: 'Charlie', email: 'charlie@example.com' },
  { name: 'dd', email: 'ddd' },
  { name: 'Eve', email: 'eve@example.com' },
  { name: 'Frank', email: 'frank@example.com' },
  { name: 'Grace', email: 'grace@example.com' },
  { name: 'Hank', email: 'hank@example.com' },
  { name: 'Ivy', email: 'ivy@example.com' },
  { name: 'Jack', email: 'jack@example.com' }
])

```

### 실행

1. 가상환경생성 `python3 -m venv venv`

2. mac: `source venv/bin/activate`  Windows일 경우: `.\venv\Scripts\Activate.ps1`

3. pip install -r requirements.txt

4. uvicorn main:app --reload

</details>