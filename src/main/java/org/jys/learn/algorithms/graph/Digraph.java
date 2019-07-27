package org.jys.learn.algorithms.graph;

public interface Digraph {

    int V();
    int E();
    void addEdge(int v, int w);
    Iterable<Integer> adj(int v);
    Digraph reverse();
    String toString();
}
