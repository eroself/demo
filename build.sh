rm -rf package-lock.json node_modules target vite.generated.js &&
npm cache clean --force && npm install && mvn clean package -Pproduction
