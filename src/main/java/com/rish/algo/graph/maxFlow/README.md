## FordFulkerson's Algorithm

```
Things to remember
- Given Capacity of all edges (edge capacity)
- A Source (S)
- A Sink (T)

1. Bottleneck Capacity (BC) (Initially 0)
2. Residual Graph (Created by reversing edges and subtracting the current BC from the actual capacity)
3. Augmented Path ()

- Find new bottleneck capacity by traversing an Augmented Path
- New Bottneck capcity = Min(all traversed edge capacities)
```

The original idea was to perform DFS traversal due to which the overall complexity becomes:
```
O(E * maxFlow)
```

## EdmondKarps's Algorithm

- All steps remain the same, except traversal technique.
- Instead of DFS, we perform BFS on it which changes the complexity from depending on maxFlow and changes it to:
```
O(E * NoOfAugmentedPaths) 
= O(V/2 * E) 
= O(VE * E) 
= O(VE^2)
```