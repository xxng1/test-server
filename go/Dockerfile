# go/Dockerfile
FROM golang:1.21-alpine AS builder

WORKDIR /app
COPY main.go .

# 정적 바이너리 빌드
RUN CGO_ENABLED=0 GOOS=linux GOARCH=amd64 go build -o myapp

# 런타임용 경량 이미지
FROM scratch
COPY --from=builder /app/myapp /myapp
ENTRYPOINT ["/myapp"]
