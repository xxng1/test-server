# ./go/Dockerfile
FROM golang:1.22 AS build

WORKDIR /app
COPY . .

RUN go build -o server main.go

# ---- Runtime Stage ----
FROM debian:bullseye-slim

WORKDIR /app
COPY --from=build /app/server .

EXPOSE 8080
CMD ["./server"]
