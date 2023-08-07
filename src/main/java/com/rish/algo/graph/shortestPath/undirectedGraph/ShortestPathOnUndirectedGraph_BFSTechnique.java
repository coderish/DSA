package com.rish.algo.graph.shortestPath.undirectedGraph;

import java.util.*;

public class ShortestPathOnUndirectedGraph_BFSTechnique {
    public static void main(String[] args) {
        int vertices = 9, edges = 10, src = 0;
        int[][] edgeArr = {{0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}};

        // 1. adjList
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edgeArr) {
            adjList.get(edge[0]).add(new Edge(edge[0], edge[1], 1));
            adjList.get(edge[1]).add(new Edge(edge[1], edge[0], 1));
        }

        // 2. queue
        Queue<ToNode> queue = new LinkedList<>();
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        queue.add(new ToNode(src, 0));

        while (!queue.isEmpty()) {
            ToNode toNode = queue.remove();
            for (Edge currentNode : adjList.get(toNode.node)) {
                int oldVal = dist[currentNode.toNode];
                dist[currentNode.toNode] = Math.min(dist[currentNode.toNode], toNode.distanceSoFar + currentNode.weight);
                if (oldVal != dist[currentNode.toNode]) {
                    queue.add(new ToNode(currentNode.toNode, dist[currentNode.toNode]));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}

class ToNode {
    int node;
    int distanceSoFar;

    public ToNode(int toNode, int distance) {
        this.node = toNode;
        this.distanceSoFar = distance;
    }
}

class Edge {
    int fromNode;
    int toNode;
    int weight;

    public Edge(int fromNode, int toNode, int weight) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{fromNode=" + fromNode +
                ", toNode=" + toNode +
                ", weight=" + weight +
                '}';
    }
}
