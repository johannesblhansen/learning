
## A simple rest api app, that is containerized.

This uses an env var set in the container that can be seen using spring actuator endpoint:
```
http://localhost:8080/actuator/env
```

It is also printed in when using the default endpoint 
```
localhost:8080/hello
```

### Use Case: Overloading a Tomcat embedded server

In this service is also implemented the endpoint helloAsync which will create threads to call a producer service, trying 
to provoke a producer overload error.

It is worth noting, that to achieve this, the number of threads spawned by Spring Async has to be higher than the default 
value. This is done by property:

```
spring.task.execution.pool.core-size=50
```

