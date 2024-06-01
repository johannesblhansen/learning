### Using a base image 
#docker_course

Downloading an image from docker hub and running it locally:

```
docker run node
```

This will check if the node image is in the local repo, and if not, download from docker hub. The node image can be found here:
https://hub.docker.com/_/node

It uses the docker run command on that image.

![](Pasted%20image%2020240527215051.png)

Running the image does nothing, as it executes nothing in itself. However, it was downloaded and started and then exited. Even though the node installation in the container has an interactive shell, a docker container is always running in isolation, unless something else is specified.

Check docker ps -a to see the container there or check docker desktop

![](Pasted%20image%2020240527215512.png)

To start an interactive shell in the container use the -it flag

```
docker run -it node
```

That gives us access to the node shell of the docker container.

Another example is using the ubuntu image and running a container with the -it flag, which gives a normal bash shell in the ubuntu container.

If a docker image is already running, a shell can still be started by using the exec command.

```
docker exec -it [container-id] bash
```