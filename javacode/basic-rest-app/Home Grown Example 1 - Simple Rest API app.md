#docker_example_app
A simple rest api app, that is containerized.

This uses an env var set in the container that can be seen using spring actuator endpoint:
```
http://localhost:8080/actuator/env
```

It is also printed in when using the default endpoint 
```
localhost:8080/hello
```

