# Topological Sorting
```
1. Returns the order of nodes in which it is attached to a chain of its parents, starting from its utimate parent.
2. Which means for a directed graph a -> b -> (c, d) ...  Topological Sort will be d, c, b, a or c, d, b, a 
3. That is the reason that it can be performed only on DAGs (Directed Acyclic Graphs)
4. And it won't work for cyclic or undirected graphs, because in this case it will be a conflicting situation to find an ultimate parent 
```

### DFS
1. Create Adjacency List from the given edges.
2. Maintain a visited array to skip the nodes if they had already been visited. 
3. Iterate over all the nodes sequentially and perform DFS on it. Mark the nodes as visited when it has been picked up for processing.
4. Add the nodes to the stack when no further DFS calls can be made.
5. Resultant popped values of stack are Topologically sorted.

### BFS
1. Maintain an InDegree Array for all the vertices.
2. Maintain a queue to add and remove elements from it.
3. Elements with a degree of 0 are added to the queue.
4. Perform BFS on the dequeued elements and reduce the inDegree of the nodes.
5. Check if the inDegree results to 0, if it does, then add it to the queue.
6. Stop when the queue is empty.