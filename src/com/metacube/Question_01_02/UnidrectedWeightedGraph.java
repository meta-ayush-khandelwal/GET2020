package com.metacube.Question_01_02;

import java.util.List;

public interface UnidrectedWeightedGraph {

    public boolean isConnected();

    public List<Integer> reachable(int node) throws GraphException;

    public int[][] minimumSpanningTree();

    public int shortestPath(int node1, int node2) throws GraphException;
}
