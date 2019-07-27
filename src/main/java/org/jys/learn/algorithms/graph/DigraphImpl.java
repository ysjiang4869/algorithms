package org.jys.learn.algorithms.graph;

import edu.princeton.cs.algorithms.Bag;

/**
 * @author YueSong Jiang
 * @date 2019/7/25
 * @description <p> </p>
 */
public class DigraphImpl implements Digraph{

    private final int V;

    private int E;

    private Bag<Integer>[] adj;

    public DigraphImpl(int V) {
        this.V = V;
        this.E=0;
        adj=(Bag<Integer>[]) new Bag[V];
        for (int v = 0; v <V ; v++) {
            adj[v]=new Bag<>();
        }
    }

    @Override
    public int V() {
        return this.V;
    }

    @Override
    public int E() {
        return this.E;
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public Digraph reverse() {
       Digraph g=new DigraphImpl(V);

        for (int v = 0; v < V; v++) {
            for (int w: adj[v]) {
                g.addEdge(w,v);
            }
        }
        return g;
    }
}
