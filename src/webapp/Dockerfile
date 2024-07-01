FROM node:22-alpine3.19

WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install http-server --save-dev

COPY . .

EXPOSE 5555

# CMD ["npm", "start"]
CMD ["npx", "http-server", "-p", "5555"]
