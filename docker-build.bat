@echo off
docker build -t client .
docker run --name client --rm -d -p 8080:8080 client
docker ps -a
docker rmi -f client