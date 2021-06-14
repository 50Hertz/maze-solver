# Maze Solver
**Question:** (TRAVERSING A MAZE) Consider a n x n maze with one entry point and one exit and all free and blocked cells clearly identifieded. Which search algorithm do you think is suitable for traversing the maze? Provide a web-based implementation of the algorithm and test it. You may use Java or C++ to implement the algorithm. Ensure that your implementation includes a graphical display of the maze. All relevant data structures used must be clearly defined.

## Prerequisites

* Java 8
* Spring Boot 2.3.10
* Apache Maven 3.6

## Usage

* Package the maze-traversal-api using Maven: 
  ```maven
  mvn clean package
  ```

* Run .jar in JARs folder or generated .jar file as Java application:
  ```cmd
  java -jar maze-traversal-api-0.0.1-SNAPSHOT
  ```

## Solution
I went with depth-first search as my algorithm for traversing the _n x n_ maze.

_**Depth-First Search:**_ Depth-first search is a recursive algorithm for traversing a tree or graph data structure.
It is so called because it starts from the root node and follows each path to its greatest depth node before moving to the next path.

The advantage of DFS is that it's fast and the memory access patterns involved in running DFS (maintaining the top of a stack and probing places near the most-recently-visited spot) plays well with caches. DFS has an advantage over A*, in the sense that it doesn't have to deal with the associated overhead of maintaining distances in A*. For BFS, probabilistically, start nodes of a maze tend to be at be at the edge of the maze, BFS tends to search outwards from the starting location by exploring paths of progressively longer and longer lengths so a ot of time is spent exploring unnecessary paths.

## Implementation



## Contact
Seyi S. Adedara - adedaraseyi@gmail.com

## References
<a id="1">[1]</a> 
J. Deep. 
"A Maze Solver in Java",
Baeldung Blog,
26 July 2020. [Online]
Available: https://www.baeldung.com/java-solve-maze. 
[Accessed 3 June 2021].
