package com.rish.algo.graph.shortestPath.sssp;

import java.util.*;

public class DijkstrasAlgo {
    public static void main(String[] args) {
        int V = 3, E = 3, S = 0;
        Map<Integer, List<List<Integer>>> adjNodeMap = constructAdjNodeMap();
        int[] shortestDistArray = applyAlgorithm(V, adjNodeMap, S);
        for (int i = 0; i < V; i++) {
            System.out.print(shortestDistArray[i] + " ");
        }
    }

    private static int[] applyAlgorithm(int V, Map<Integer, List<List<Integer>>> adjNodeMap, int S) {
        Queue<DistToNodePair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] distArray = new int[V];
        for (int i = 0; i < V; i++) distArray[i] = (int) (1e9);
        distArray[S] = 0;
        pq.add(new DistToNodePair(0, S));

        while (pq.size() != 0) {
            int shortestDistToCurrentNode = pq.peek().distance;
            int currentNode = pq.peek().toNode;
            pq.remove();

            for (int i = 0; i < adjNodeMap.get(currentNode).size(); i++) {
                int distanceToAdjNode = adjNodeMap.get(currentNode).get(i).get(1);
                int adjNode = adjNodeMap.get(currentNode).get(i).get(0);

                if (shortestDistToCurrentNode + distanceToAdjNode < distArray[adjNode]) {
                    distArray[adjNode] = shortestDistToCurrentNode + distanceToAdjNode;
                    pq.add(new DistToNodePair(distArray[adjNode], adjNode));
                }
            }
        }
        return distArray;
    }

    private static Map<Integer, List<List<Integer>>> constructAdjNodeMap() {
        List<Integer> distEdge1 = new ArrayList<>(){{add(1);add(1);}};
        List<Integer> distEdge2 = new ArrayList<>(){{add(2);add(6);}};
        List<Integer> distEdge3 = new ArrayList<>(){{add(2);add(3);}};
        List<Integer> distEdge4 = new ArrayList<>(){{add(0);add(1);}};
        List<Integer> distEdge5 = new ArrayList<>(){{add(1);add(3);}};
        List<Integer> distEdge6 = new ArrayList<>(){{add(0);add(6);}};

        List<List<Integer>> intersection1 = new ArrayList<>(){{add(distEdge1);add(distEdge2);}};
        List<List<Integer>> intersection2 = new ArrayList<>(){{add(distEdge3);add(distEdge4);}};
        List<List<Integer>> intersection3 = new ArrayList<>(){{add(distEdge5);add(distEdge6);}};

        Map<Integer, List<List<Integer>>> adjNodeMap = new HashMap<>();
        adjNodeMap.put(0, intersection1);
        adjNodeMap.put(1, intersection2);
        adjNodeMap.put(2, intersection3);

        return adjNodeMap;
    }

}

class DistToNodePair {
    int distance;
    int toNode;

    public DistToNodePair(int distance, int toNode) {
        this.distance = distance;
        this.toNode = toNode;
    }
}

