#docker_course 

A great example of using docker to self-contain build specific stuff, is using to containerize a node.js app.
A node.js app requires a runtime (given by the node base image) and some commands executed to install dependencies.

The example 2 source code contains the app and a Dockerfile that extends the node image
To build the new image, use the build command.

```
 docker build . -t example2:1
```

After that a container can be created:

```
docker run -p 3000:80 example2:1

```

NOTE: The container does not exit (seen by the no return in cmd), as the CMD given to the container (CMD ["node", "server.js"]) does not exit, but continuously listen on port 80

Remember the p flag. The syntax is port on local machine : docker image
So here the local machine takes requests to 3000 and forwards to 80 in the image.

To test, go to browser and localhost:3000