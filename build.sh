rm -rf package-lock.json node_modules package.json target webpack.generated.js &&
npm cache clean --force && npm install && npm audit fix --force &&
mvn clean package -Pproduction
