### Managing images and containers through CLI

NOTE: Remember to use documentation from the CLI using --help.

Overview from the course:
![](Pasted%20image%2020240531220632.png)


#### docker run and start
#docker_command
RUN: Creates a new container
START: Starts and existing container

**NOTE:** Docker run and docker start are NOT the same. Start will start up an existing container, _with its saved state_ - run will always create a fresh container.

##### Attached vs Detached mode.
**Attached** mode means that when running a container, it will take over the shell in which it was started. Running in the foreground. Logs might come be visible here. This is default for run command
**Detached** is the opposite. The container will be started but the shell handed back. There will be no stream output, since the shell was detached and given back. This is the default for the start command.
It is possible to chose one or the other via flags. It is also *possible to attach* to a container running in detached mode using the *attach* command
```
docker attach some_name
```
##### Logs
#docker_command 
To get logs from a container user the logs command.
This can be used on both running and stopped containers. If the container is running, use --follow to see older logs AND attach to the stream any new logs.

##### Interactive mode
There is an example of a python app using command line input in the code.
[[Example3. Interactive mode]]

