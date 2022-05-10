# simple-singly-linked-list-reverser
This is simple linked list reverser that gives opportunity to reverse nodes
>INPUT: node1 -> node2 -> node3 -> ... -> nodeN
>OUTPUT: nodeN -> nodeN-1 -> nodeN-2 ... -> node2 -> node1
## How it works
* In the `Main` class you are able to config the number of nodes you want to reverse - `NODE_LIST_SIZE` 
(default value: 10) and maximum value of the nodes - `MAX_NODE_VALUE` (default value: 100);
* Values of nodes will be generated randomly.
## Maven clean package
The application supports source code checks regarding Google coding conventions from Google Java Style
    that can be found at https://google.github.io/styleguide/javaguide.html. 
Use command `mvn clean package` in terminal to activate the checking.
## Logger
To save your logs to the file you need to configure `resources/log4j2.xml` (line 7) 
using your ABSOLUTE_PATH to this project;