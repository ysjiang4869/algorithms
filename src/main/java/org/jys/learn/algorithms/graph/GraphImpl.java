package org.jys.learn.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YueSong Jiang
 * @date 2019/7/10
 * @description <p>common graphic</p>
 */
public class GraphImpl implements Graph{

    private final int V;

    private int E;

    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public GraphImpl(int v) {
        this.V = v;
        this.E=0;
        adj=(List<Integer>[]) new List[v];
        for (int i = 0; i < V; i++) {
            adj[i]=new ArrayList<>();
        }
    }


    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public int degree(int v) {
        int degree=0;
        for (int ignored : adj(v)) {
            degree++;
        }
        return degree;
    }

    @Override
    public int maxDegree() {
        int degree=0;
        int max=0;
        for (int v = 0; v < V(); v++) {
            degree=degree(v);
            max=Math.max(max,degree);
        }
        return degree;
    }

    @Override
    public double avgDegree() {
        return 2.0*E()/V();
    }

    @Override
    public int numberOfSelfLoops() {
        int num=0;
        for (int v = 0; v < V(); v++) {
            for (int w: adj(v)) {
                if(v==w){
                    num++;
                }
            }
        }
        return num/2;
    }
}
