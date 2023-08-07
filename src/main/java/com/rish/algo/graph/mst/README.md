# Spanning Tree
1. Undirected Weighted Graph having N nodes(vertices) and M edges 
2. A tree in which we have N Nodes and N-1 Edges is a Spanning Tree
3. In a spanning tree, all nodes should be reachable from one another.

# Minimum Spanning Tree
1. Of all the spanning trees, the tree having the lowest sum of all edge weights is an MST

### Prim's Algorithm
1. Initialize a PriorityQueue(Min-Heap) sorted on the basis of weight.
2. Add EdgeObjects(toNode, distance, fromNode) to PQ.
3. Randomly choose a node to start with and add to queue.
4. Dequeue the element on every iteration, ignore the element if already visited
5. Add the edge to MST if the node has not been visited before, then mark the node as visited.
6. Stop when the queue is empty.

### Kruskal's Algorithm
1. Sort the edges on the basis of weight.
2. Add the nodes (Perform Union Operation) of the edges to DisjointSet.
3. If parent (ultimate parent calculated after path compression technique) is the same, ignore the element and 
iterate to the next edge element.
4. After the iteration is complete, resultant DisjointSet is the MST.

### Boruvka's (Also know as Sollen's) Algorithm
