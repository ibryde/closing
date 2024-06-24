FROM node:22-alpine3.19

COPY ./ ./

RUN npm install http-server --save-dev

EXPOSE 5555

CMD ["npm", "start"]
