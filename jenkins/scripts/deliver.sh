#!/usr/bin/env bash
cd docker
docker kill database_server
docker rm database_server
docker run -p 9996:9996 --name database_server -d database_server:latest