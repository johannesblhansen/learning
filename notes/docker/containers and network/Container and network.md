
Connection overview:

![](Pasted%20image%2020240609195405.png)

###### Connection to the outside works out the box.

###### Connection to localhost just need to replace localhost with host.docker.internal

###### Connection to other containers, like a mongo db container created from the default official image
```
docker run mongo
```
is possible by looking up network settings of that container:
```
docker container inspect mongodb
```

A better solution for container to container communication is:
#### Container networks

Creating isolated networks for multiple containers
![](Pasted%20image%2020240609204819.png)

It is possible to create a network using:
```
docker network create my-network-name
```
Containers can communicate across containers just by adding the container name as domain in a url, instead for localhost for example

Before - localhost:8080
After - mycontainer:8080

Docker resolves the ip of my container automatically.

Then the network can be added to a container by the network flag:
```
docker run --network my-network-name imageToCreateContainerFrom
```


