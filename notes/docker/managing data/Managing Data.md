Managing Data and volumes.

There are 3 kinds of data to consider when using docker.

![](Pasted%20image%2020240602113841.png)

It is only possible to write data the temporary container layer. When a container is removed, all the data in that container is removed with it.

That might be a problem for many reasons. An obvious one could be, that a new version of an image is published, and we want a container to be updated to be build from that image. But the container might have data we want to keep.
The solution is volumes.

#### Volumes

![](Pasted%20image%2020240602122120.png)

This connection is not like the copy command, but a two-way connection into a container.

There are 2 types of volumes. Anonymous and named volumes. They are both managed by docker, but they are very different. 
Anon is added via the Dockerfile and named is added through a flag when started a container. 
Anon is not persisted after container removal, but the named is.

To manage volumes use the volumes command:
```
docker volume ls
```