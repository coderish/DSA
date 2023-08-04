package com.rish.algo.graph.shortestPath.dag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopoSortWithDFS {
    public static void main(String[] args) {
//        int vertices = 6, edges = 7;
//        int[][] edgeArr = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};
        int vertices = 7, edges = 8;
        int[][] edgeArr = {{6, 4, 2}, {6, 5, 3}, {5, 4, 1}, {4, 0, 3}, {4, 2, 1}, {0, 1, 2}, {2, 3, 3}, {1, 3, 1}};

        List<List<Pair>> adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edgeArr) {
            adjList.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }
        System.out.println(adjList);

        Stack<Integer> dfsStack = new Stack<>();
        boolean[] vis = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            dfs(i, adjList, vis, dfsStack);
        }
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);

//        System.out.println(dfsStack);

        int node = -1;
        if (!dfsStack.isEmpty()) {
            node = dfsStack.pop();
            dist[node] = 0;
        }
        while (!dfsStack.isEmpty()) {
            for (Pair pair : adjList.get(node)) {
                dist[pair.toNode] = Math.min(dist[node] + pair.distance, dist[pair.toNode]);
            }
            node = dfsStack.pop();
        }
        System.out.println(Arrays.toString(dist));
    }

    private static void dfs(int node, List<List<Pair>> adjList, boolean[] vis, Stack<Integer> dfsStack) {
        if (!vis[node]) {
            vis[node] = true;
            for (Pair pair : adjList.get(node)) {
                dfs(pair.toNode, adjList, vis, dfsStack);
            }
            dfsStack.add(node);
        }
    }
}

class Pair {
    int toNode;
    int distance;

    public Pair(int toNode, int distance) {
        this.toNode = toNode;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "{toNode=" + toNode +
                ", distance=" + distance +
                '}';
    }
}