#!/bin/bash

cd server
./mvnw install
cd ..
cd client
npm install
npm run build
cd ..
docker-compose up -d
