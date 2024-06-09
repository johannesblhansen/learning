![](Pasted%20image%2020240604214515.png)

#### Env variables

Set environments variables in the container, that can be used within the software (read as a system variable)

Example of using an environment variable is in my homegrown example [Home Grown Example 1 - Simple Rest API app](Home%20Grown%20Example%201%20-%20Simple%20Rest%20API%20app.md)

The example just uses one env var. It is also possible to load multiple env vars from a file using the --env-file flag to docker run

#### Arguments

Useful to configure values in an image, but the image code does not change. They do not go into the container environment, but is used at defined at image level,


