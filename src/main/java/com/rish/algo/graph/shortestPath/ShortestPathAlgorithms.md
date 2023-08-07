### Finding shortest path on DAGs
1. Perform Topological Sort on the Graph and store the results in a stack.
2. Maintain a dist[] and perform BFS on each popped node from the stack.
3. Swap with the minimum value for a visiting node. 
4. When the stack is empty, resultant dist[] is the shortest path from the starting/source node.

### Finding shortest path on undirected graphs


### Single source shortest path Algorithms
#### Dijkstra's Algorithm
#### Dijkstra's Algorithm using Set for Optimization
#### Bellman Ford Algorithm

### Multi source shortest path Algorithms
#### Floyd Warshall Algorithm