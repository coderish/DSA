package com.rish.algo.graph.topologicalSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        int vertices = 7, edges = 8;
        int[][] edgeArr = {{6, 4}, {6, 5}, {5, 4}, {4, 0}, {4, 2}, {0, 1}, {2, 3}, {1, 3}};

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edgeArr) {
            adjList.get(edge[0]).add(edge[1]);
        }
        System.out.println(adjList);

        boolean[] vis = new boolean[vertices];
        Stack<Integer> dfsStack = new Stack<>();
        for (int i = 0; i < vertices; i++) {
            topoSortDFS(i, vis, dfsStack, adjList);
        }
        while (!dfsStack.isEmpty()) {
            /*6 5 4 0 2 1 3*/
            System.out.print(dfsStack.pop() + " ");
        }
    }

    private static void topoSortDFS(int node, boolean[] vis, Stack<Integer> dfsStack, List<List<Integer>> adjList) {
        if (!vis[node]) {
            vis[node] = true;
            for (int adjNode : adjList.get(node)) {
                topoSortDFS(adjNode, vis, dfsStack, adjList);
            }
            dfsStack.add(node);
        }
    }
}
