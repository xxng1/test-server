# go/Dockerfile

FROM golang:1.21-alpine AS builder

WORKDIR /app

# go.mod, go.sum 먼저 복사하고 의존성 다운로드
COPY go.mod .         
COPY go.sum .         
RUN go mod download

# 그다음 전체 복사
COPY . .

RUN CGO_ENABLED=0 GOOS=linux GOARCH=amd64 go build -o myapp

FROM scratch
COPY --from=builder /app/myapp /myapp
ENTRYPOINT ["/myapp"]
