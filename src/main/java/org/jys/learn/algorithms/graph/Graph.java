package org.jys.learn.algorithms.graph;

public interface Graph {
    int V();
    int E();
    void addEdge(int v, int w);
    Iterable<Integer> adj(int v);
    int degree(int v);
    int maxDegree();
    double avgDegree();
    int numberOfSelfLoops();
    String toString();
}
