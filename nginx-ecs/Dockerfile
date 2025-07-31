FROM nginx:alpine

# 설정 덮어쓰기
COPY default.conf /etc/nginx/conf.d/default.conf

# 정적 파일 복사
COPY index.html /usr/share/nginx/html/index.html

EXPOSE 80