# ./go/Dockerfile
FROM golang:1.22-bookworm AS build

WORKDIR /app
COPY . .
RUN go build -o server main.go

# ---- Runtime Stage ----
FROM debian:bookworm-slim

WORKDIR /app
COPY --from=build /app/server .

EXPOSE 8080
CMD ["./server"]
