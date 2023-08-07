package com.rish.algo.graph.topologicalSort;

import java.util.*;

public class BFS_KahnsAlgo {
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
        int[] inDegree = new int[vertices];
        for (List<Integer> adjNodes : adjList) {
            for (int toNode : adjNodes) {
                inDegree[toNode]++;
                // = inDegree[toNode] + 1;
            }
        }
        System.out.println(adjList);
        System.out.println(Arrays.toString(inDegree));

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.remove();
            /*6 5 4 0 2 1 3*/
            System.out.print(node + " ");
            for (int neighbourNode : adjList.get(node)) {
                inDegree[neighbourNode]--;
                // = inDegree[neighbourNode] - 1;
                if (inDegree[neighbourNode] == 0) {
                    queue.add(neighbourNode);
                }
            }
        }
    }
}
