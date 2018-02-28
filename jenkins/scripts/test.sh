#!/usr/bin/env bash
cd docker
docker kill database_server_test
docker rm database_server_test
docker run -p 8996:8996 --name database_server_test -d database_server:latest
docker kill database_server_test
docker rm database_server_test