FROM node

#Set the working dir inside the image
WORKDIR /app

# Copy from the relative path of the system to the path of the container
COPY ./app-code /app

# Running commands in the image
RUN npm install

#Optional, used only for documentation purposes. It is best practice
EXPOSE 80

#To start the node app, the command is - node server.js
#NOTE using RUN is wrong here. RUN used when creating an image. We want the app to be started at contianer level
#Therefore the CMD keyword is used.
CMD ["node", "server.js"]

