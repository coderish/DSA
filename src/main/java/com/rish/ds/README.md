# DataStructures:
```
Linear:
    - Stack
    - Queue
    - LinkedList
    - Doubly LinkedList
    - Circular LinkedList

NonLinear:
    - Tree:
      - Binary Tree:
          - Perfect Binary Tree
          - Complete Binary Tree
          - Full Binary Tree
          - Skewed Tree
      - Binary Search Tree
      - Balanced BST:
          - AVL Tree
          - Red Black Tree
      - Threaded Binary Tree
      - Ternary Search Tree (Modified Trie)
      - Heap:
          - Heap Sort
          - Heapify
          - Priority Queue

    Binary Tree
    Balanced Tree
    Skewed Tree
    Binary Search Tree
    AVL Tree
    RedBlackTree
    Splay Tree
    Scapegoat Tree
    Treap (Randomized Binary Search Tree)
    
    Binary Heap
    ThreadedBinaryTree
    
    Trie
    Ternary Search Tree(Modified Trie)
    Segment Tree
    Suffix Tree
    Fenwick/BIT
    
    N-ary Tree (Generic Tree)
    2-3 Tree (MultiWay Search Tree)
    B Tree
    B+ Tree (Index)
    
    K-dimensional Tree

    - Graph:
        Check below
      

Advanced DS:
    - Height Balanced Tree:
        - Scapegoat Tree
        - Splay
        - B-Tree (M-way Search Tree with rules)
        - K-dimensional
        - Treap
    - Trie
    - Segment Tree
    - Binary Indexed Tree or Fenwick Tree
    - Suffix Array
    - B+ Tree

Others:
    - Interval Tree
    - Expression Tree
    - Cartesian Tree
    - Sparse Tree
    - Gomory-Hu Tree
    - Decision Tree
    - Tournament Tree(Winter Tree)
    - Wavelet Tree
        
```

# Problems:

#### **Parenthesis**

```
1. Valid or Well Formed Parentheses | Part – 1
2. Valid Brackets – Part 2 | Stack Method
3. Valid Multiple Parentheses
```

#### **Expressions**

```
0. Infix, Postfix and Prefix Notations/Expressions
1. Evaluation of Infix expressions
2. Evaluation of Prefix Expressions (Polish Notation) | Set 1
3. Evaluation of Prefix Expressions (Polish Notation) | Set 2
5. Evaluation of Postfix Expressions (Polish Postfix notation) | Set 1
6. Evaluation of Postfix Expressions (Polish Postfix notation) | Set 2
7. Convert Postfix to Infix Expression
8. Convert Postfix to Prefix Expression
9. Convert Prefix to Postfix Expression
10. Convert Prefix to Infix Expression
11. Convert Infix to Prefix Expression
12. Convert Infix to Postfix Expression
```

#### **CACHE**

```
1. Least Recently Used (LRU) Cache – Using HashMap and Doubly Linked List | Set 1
2. Least Recently Used (LRU) Cache – Using LinkedHashSet and Deque | Set 2
```
## **Problems on Trees**
```
1. How to find Lowest Common Ancestor of two given nodes.
2. Lowest Common Ancestor in a Binary Tree (Not Binary Search Tree). `LowestCommonAncestor`
3. Lowest Common Ancestor in a Binary Search Tree. `LowestCommonAncestorInBST`
4. Find The Distance From Root To Given Node of a Binary Tree. `DistanceFromRootToNode`
5. Find the Distance between Two Nodes of a Binary Tree. `DistanceFromNodeToNode`
6. Print Paths from root to all leaf nodes in a binary tree. `PrintPathFromRootToAllLeaves`
7. Print All The Nodes Which are X distance from the Root. `PrintAllNodesAtXDistanceFromRoot`
8. Print All The Nodes Which are X distance from the Leaf Nodes `notImplemented - PrintAllNodeAtXDistanceFromLeafNodes`
9. Print All The Nodes Which are X distance from the Given Node `notImplemented - PrintAllNodesAtXDistanceFromAGivenNode`
10. Print All Nodes Between Two Given Levels ``
11. Find the Maximum Depth OR Height of a Binary Tree. `MaximumDepthOfBinaryTree`
12. Diameter Of a Binary Tree. ``
13. Find the Size of the Binary Tree. `SizeOfBinaryTree`
14. Find the Size of a Binary Tree without Recursion ``
15. Find the maximum width of a binary tree ``


16. In a Binary Tree, Check if two nodes are Cousins.
17. In a Binary Tree, Check if Two nodes has the same parent or are siblings
18. Given a binary tree, Print All the Nodes that don’t have Siblings.
19. Given a binary tree, Convert it into its Mirror Tree.
20. Find the Deepest Left Node in a Binary Tree.
21. Print All The Full Nodes in a Binary Tree
22. Find the Max element in a Given Binary Tree
23. Check If One Binary is Mirror Tree of another Binary Tree.
24. Given a binary tree, find out the maximum sum of value from root to each leaf.
25. Determine whether given binary tree is binary search tree(BST) or not
26. Check if Two BST’s are Identical.


27. Tree Traversals
28. Print Left View of a given binary tree
29. Print Right View of a given binary tree
29. Print the Binary Tree in Vertical Order Path.
30. Print The Top View of a Binary Tree
31. Print the Bottom View of the Binary Tree.
32. Level Order Traversal in Zig Zag pattern OR Print in Spiral Pattern
33. Print the Vertical Sum in binary Tree.
34. Breadth-First Search/Traversal in a Binary Tree
35. Depth First Search/Traversal in Binary Tree
36. Inorder Predecessor and Successor in Binary Search Tree
37. Binary Tree – Preorder Traversal – Non-Recursive Approach
38. Binary Tree - Postorder Traversal – Non-Recursive Approach
39. Binary Tree - Inorder Traversal – Non-Recursive Approach
40. Level Order Traversal, Print each level in separate line.
41. Search the Element in a binary tree – With and Without Recursion


42. Introduction to Threaded Binary Tree
43. Single Threaded Binary Tree Complete Implementation
44. Double Threaded Binary Tree Complete Implementation


45. Convert Binary Tree into Threaded Binary Tree
46. Convert BST to Greater Sum Tree
47. Convert binary tree to its Sum tree
48. Delete the Binary Tree


49. AVL Tree – Insertion
50. Construct a binary tree from given Inorder and Level Order Traversal
51. Construct a Binary Tree from Given Inorder and Depth-First-Search.
52. Construct a binary tree from given Inorder and Postorder Traversal
53. Construct a Binary Tree from Given Inorder and Preorder Traversal9.
54. Construct Binary Search Tree from a given Preorder Traversal using Recursion
55. Construct Binary Search Tree from a given Preorder Traversal Using Stack (Without Recursion)
56. Binary Min-Max Heap Implementation


57. Find the Deepest Node in a Binary Tree.
58. Given two binary trees, check if one binary tree is a subtree of another
59. Get the Sum of all left leaves in a Binary Tree
```

## **Properties of Binary Search Trees**
```
1. Binary Search Tree
- Most of the BST operations (e.g., search, max, min, insert, delete.. etc) take O(h) time where h is the height of the BST.
- The cost of these operations may become O(n) for a skewed Binary tree.
2. Balanced Binary Tree
- If we make sure that the height of the tree remains O(log(n)) after every insertion and deletion, then we can guarantee an upper bound of O(log(n)) for all these operations.
 - height - O(logn)
3. AVL Tree
- The height of an AVL tree is always O(log(n)) where n is the number of nodes in the tree.
 - height - O(logn)
 - search - O(logn)
 - insert - O(logn)
 - delete - O(logn)
4. Red-Black Tree
 - height - O(logn)
 - search - O(logn)
 - insert - O(logn)
 - delete - O(logn)
```

## **Problems on Graphs**
```
1. Types of Graph - Undirected, Directed(DiGraph), Weighted Graphs, Special Graphs(Trees), Trees: Rooted Trees - in tree, out tree(arbhorescence tree), DAGs, Bipartite Graph, Complete Graph
2. Representing Graph - Adjacency Matrix, Adjacency List, Edge List
3. Shortest Path Problems (SPP): [BFS(unweighted graph): Dijkstra's, A*, Bellman-Ford, Floyd-Warshall and many more]
3. Connectivity: Union find DS or DFS/BFS
4. Negative cycles: Bellman-Ford, Floyd-Warshall
5. Strongly Connected Components(SCCs): Tarjan's and Kosaraju's Algorithm
6. Travelling Salesman Problem(TSP): Held-Karp, Branch and Bound, Appoximation Algo
7. Bridges or cut edge using Tarjan's Algorithm
6. Articulation Points or Cut vertex / Low Link Values using Tarjan's Algorithm
7. Minimum Spanning Tree(MST): Prim's, Kruskal's & Boruvka's
8. Network Flow - Max Flow: Ford-Fulkerson, Capacity Scaling(heuristic approach over FF), Edmond-Karp, Dinic's Algo, Push Relabel
9. SSSP(Single Source Shortest Path) on DAG: Eager Dijkstra's
10. Finding an Eulerian Path (Directed Graph)
11. Lazy Prim's
12. Topological Sort Algorithm (DFS + Stack) - Leetcode 231(Course Schedule2)
13. Detect Cycle in Directed Graph (Backtracking) - https://www.youtube.com/watch?v=0dJmTuMrUZM
14. Deadlock detection - (Single resource instance distributed system) - Graph Colouring Leetcode 207
14. Topological Sort using Kahn's Algorithm(BFS + Queue + Indegree Array) - Leetcode 210(Course Schedule1)
15. DSUF - Disjoint Set Union and Find - (Cycle Detection)
16. DSRPC - Disjoint Set by Rank and Path Compression
17. Maximum Bipartite Matching (Kuh's Algorithm)

```


## **Useful Links and Resources**
```
https://tutorialhorizon.com/algorithms/category/graphs/
https://cp-algorithms.com/index.html
https://www.bigocheatsheet.com/
https://www.interviewbit.com/google-interview-questions/
https://codeforces.com/problemset
https://www.spoj.com/problems/classical/
https://leetcode.com/problemset/all/
https://www.codingninjas.com/studio/problems?difficulty[]=Ninja
```