rm -rf package-lock.json node_modules target webpack.generated.js &&
npm cache clean --force && npm install && mvn clean package -Pproduction
