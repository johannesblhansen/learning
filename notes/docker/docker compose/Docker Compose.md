Docker compose is an orchestration tool build on top of docker, that helps starting and stopping containers, with all the cli options contained in a configuration file.

The compose spec: [compose file](https://docs.docker.com/compose/compose-file/)

The most basic example with just one container started from an image:
```
version: "3.8"  
services:  
  myjavaapp:  
    build: ./basic-rest-app
```
This creates a service (really a container) with the name of myjavaapp from the image created from the dockerfile withing the ./basic-rest-app folder.

To start it:
```
docker-compose up
```

There is also a down which shuts everything down and cleans up everything.
```
docker-compose down
```

Everything in docker-compose file shares the same default docker network out of the box.

An example with multiple container:
```
version: "3.8"  
services:  
  myjavaapp:  
    container_name: "my-basic-rest-app"  
    ports:  
      - "8080:8080"  
    build: ./basic-rest-app  
  myproducer:  
    container_name: "my-producer-container"  
    build: ./producer-service
```

