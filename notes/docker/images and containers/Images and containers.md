### Images and containers
Images are the building blocks of containers. A container is build from an image, or if using OOP way of thinking, the image is the class file and the container is the object instantiated from that class.

Images can be shared through the [[docker hub]] which is essentially a centralized repo for image.

When trying to use and image, it first checks the local machine repo. If nothing it is found, it will check outside sources such as docker hub.

[Example1. Using a base image](Example1.%20Using%20a%20base%20image.md)

An Image is build from a Dockerfile (A file with no extension called exactly Dockerfile)
Example:

```
FROM node  
  
#Set the working dir inside the image  
WORKDIR /app  
  
# Copy from the relative path of the system to the path of the container  
COPY ./app-code /app  
  
# Running commands in the image  
RUN npm install  
  
#To start the node app, the command is - node server.js  
#NOTE using RUN is wrong here. RUN used when creating an image. We want the app to be started at contianer level  
#Therefore the CMD keyword is used.  
CMD ["node", "server.js"]
```

So a Dockerfile builds and image. An image builds contianers.
##### Extending Images 

Images can be extended, so you use a base image (like the node image). This is the typical usecase.
[Example2. Containerize a Node App](Example2.%20Containerize%20a%20Node%20App.md)

Images are read only. If you want to make changes, the image needs to be rebuild.

##### Image tagging (naming for images)

Tagging consist of 2 parts

![[Pasted image 20240602083629.png]]
#### Image and container relationship

At runtime a container will use image code, which make is possible for the container to be smaller. The code in the image is static, readonly. It has to, as there is still a many to one relationship between containers and images.

##### Image inspect
#docker_command 
To get more detailed look at an image, use the inspect command
```
docker image inspect some_id
```
Here a lot of information of about the image and the containers created from this image can be found. What commands are used, what operating system, what path vars etc etc.