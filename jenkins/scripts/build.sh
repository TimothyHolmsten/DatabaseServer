#!/usr/bin/env bash
mvn -B -DskipTests clean package
cd docker
docker build -t database_server .