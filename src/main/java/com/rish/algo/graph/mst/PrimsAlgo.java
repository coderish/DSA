package com.rish.algo.graph.mst;

import java.util.*;

public class PrimsAlgo {
    public static void main(String[] args) {
//        int[][] edges = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        int[][] edges = {{0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}};
        int verticesCount = 5;
        Set<ConcreteEdge>[] adj = createAdj(edges, verticesCount);
        System.out.println(findMST(adj, verticesCount));
    }

    private static Set<ConcreteEdge>[] createAdj(int[][] edges, int verticesCount) {
        Set<ConcreteEdge>[] adj = new Set[verticesCount];
        for (int i = 0; i < verticesCount; i++) {
            adj[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(new ConcreteEdge(edge[0], edge[1], edge[2]));
            adj[edge[1]].add(new ConcreteEdge(edge[1], edge[0], edge[2]));
        }
        return adj;
    }

    static int findMST(Set<ConcreteEdge>[] adj, int verticesCount) {
        Set<ConcreteEdge> mst = new LinkedHashSet<>();
        int sum = 0;
        boolean visited[] = new boolean[verticesCount];
        ConcreteEdge startingEdge = new ConcreteEdge(-1, 0, 0);
        Queue<ConcreteEdge> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.edgeWeight));
        pq.add(startingEdge);
        while (!pq.isEmpty()) {
            ConcreteEdge currentEdge = pq.peek();
            int toNode = currentEdge.toNode;
            int weight = currentEdge.edgeWeight;
            pq.remove();
            if (visited[toNode]) continue;
            visited[toNode] = true;
            if (currentEdge.fromNode != -1) {
                mst.add(currentEdge);
            }
            sum += weight;
            for (ConcreteEdge ce : adj[toNode]) {
                if (!visited[ce.toNode]) {
                    pq.add(ce);
                }
            }
        }
        System.out.println(mst);
        return sum;
    }
}

class ConcreteEdge {
    int fromNode;
    int toNode;
    int edgeWeight;

    public ConcreteEdge(int fromNode, int toNode, int edgeWeight) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.edgeWeight = edgeWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConcreteEdge that = (ConcreteEdge) o;
        return fromNode == that.fromNode && toNode == that.toNode && edgeWeight == that.edgeWeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromNode, toNode, edgeWeight);
    }

    @Override
    public String toString() {
        return "{fromNode=" + fromNode + ", toNode=" + toNode + ", edgeWeight=" + edgeWeight + '}';
    }
}
