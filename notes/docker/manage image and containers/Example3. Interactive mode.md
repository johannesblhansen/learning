#docker_course 
A python app is given by the course:

```
from random import randint  
  
min_number = int(input('Please enter the min number: '))  
max_number = int(input('Please enter the max number: '))  
  
if (max_number < min_number):   
  print('Invalid input - shutting down...')  
else:  
  rnd_number = randint(min_number, max_number)  
  print(rnd_number)
```

The application expects an input from the user. Therefore building the image and running it, results in an error 

![](Pasted%20image%2020240531225937.png)

The container will try to run, and remember the run command is by default attached, but docker needs STDIN open to listen for the input in container command line.

After all commands that the python app expects have been input, the container shuts down.

Trying to start the container (which is detached by default), it will just exit as there no chance to give and input.