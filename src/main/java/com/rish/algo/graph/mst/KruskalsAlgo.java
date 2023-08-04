package com.rish.algo.graph.mst;

import java.util.*;
import java.util.stream.Collectors;

public class KruskalsAlgo {
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}};
        int v = 5;
        DisjointSet_PathCompression_UnionByRank disjointSet = new DisjointSet_PathCompression_UnionByRank(v);

        Set<Edge> edgeList = Arrays.stream(edges).map(edge -> new Edge(edge[0], edge[1], edge[2])).
                sorted(Comparator.comparingInt(node -> node.weight)).collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(edgeList);
        int sum = 0;
        List<Edge> mst = new ArrayList<>();
        for (Edge edge : edgeList) {
            if (disjointSet.findUParent(edge.node1) != disjointSet.findUParent(edge.node2)) {
                sum += edge.weight;
                mst.add(edge);
                disjointSet.unionByRank(edge.node1, edge.node2);
            }
        }
        System.out.println(sum);
        System.out.println(mst);
    }
}

class Edge {
    int node1;
    int node2;
    int weight;

    public Edge(int node1, int node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{node1=" + node1 +
                ", node2=" + node2 +
                ", weight=" + weight +
                '}';
    }
}

class DisjointSet_PathCompression_UnionByRank {
    List<Integer> parent;
    List<Integer> rank;

    public DisjointSet_PathCompression_UnionByRank(int n) {
        parent = new ArrayList<>();
        rank = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
        }
    }

    public int findUParent(int node) {
        if (node == parent.get(node)) return node;
        int uParent = findUParent(parent.get(node));
        parent.set(node, uParent);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int uParent_u = findUParent(u);
        int uParent_v = findUParent(v);
        if (uParent_u == uParent_v) return;
        if (rank.get(uParent_u) < rank.get(uParent_v)) {
            parent.set(uParent_u, uParent_v);
        } else if (rank.get(uParent_v) < rank.get(uParent_u)) {
            parent.set(uParent_v, uParent_u);
        } else {
            parent.set(uParent_u, uParent_v);
            rank.set(uParent_v, rank.get(uParent_v) + 1);
        }
    }
}

class DisjointSet_PathCompression_UnionBySize {
    List<Integer> parent;
    List<Integer> size;

    public DisjointSet_PathCompression_UnionBySize(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUParent(int node) {
        if (node == parent.get(node)) return node;
        int uParent = findUParent(parent.get(node));
        parent.set(node, uParent);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int uParent_u = findUParent(u);
        int uParent_v = findUParent(v);
        if (uParent_u == uParent_v) return;
        if (size.get(uParent_u) < size.get(uParent_v)) {
            parent.set(uParent_u, uParent_v);
        } else {
            parent.set(uParent_v, uParent_u);
            size.set(uParent_u, size.get(uParent_v) + size.get(uParent_u));
        }
    }

}