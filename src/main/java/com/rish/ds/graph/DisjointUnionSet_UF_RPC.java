package com.rish.ds.graph;

public class DisjointUnionSet_UF_RPC {
    public static void main(String[] args) {
        int n = 5;
        DisjointSet dus = new DisjointSet(n);

        dus.union(0, 2);
        dus.union(4, 2);
        dus.union(3, 1);

        System.out.println(dus.find(4) == dus.find(0) ? "YES" : "NO");
        System.out.println(dus.find(1) == dus.find(0) ? "YES" : "NO");
    }
}

class DisjointSet {
    int[] parent, rank;
    int n;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        this.n = n;
        makeSet(n);
    }

    private void makeSet(int n) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (parent[i] != i) {
            return find(parent[i]);
        }
        return parent[i];
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) return;

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}