## WSL 2
#tools

Windows subsystem for linux

Installs as many linux distros as you would like.

To see what is already install

```
wsl --list
```

To select a distro

```
wsl -d <distro>

example:
wsl -d Ubuntu
```

The installed distro will also be available from the start menu. Searching for Ubuntu after installing Ubuntu will 

This makes it possible to run linux native stuff directly on windows machine, such as kafka or docker.

#### Sharing files
One of the upside to wsl 2 over a vm, is that a distro using wsl can access windows files through mnt:
![](Pasted%20image%2020240619211921.png)
Here the Dev folder on the c: is found through Ubuntu




