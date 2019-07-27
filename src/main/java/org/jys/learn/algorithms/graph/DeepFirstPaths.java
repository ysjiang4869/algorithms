package org.jys.learn.algorithms.graph;

import edu.princeton.cs.algorithms.Stack;

/**
 * @author YueSong Jiang
 * @date 2019/7/23
 * @description <p> </p>
 */
public class DeepFirstPaths {

    private boolean[] marked; //这个顶点上调用过dfs()了吗
    private int[] edgeTo; //c从起点到一个顶点的已知路径上的最后一个顶点
    private final int s; //起点

    public DeepFirstPaths(Graph G,int s) {
        this.s=s;
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        dfs(G,s);
    }

    private void dfs(Graph G, int v){
        marked[v]=true;
        for(int w: G.adj(v)){
            if(!marked[w]){
                edgeTo[w]=v;
                dfs(G, w);
            }
        }
    }

    private boolean havePathTo(int v){
        return marked[v];
    }

    private Iterable<Integer> pathTo(int v){
        if(!havePathTo(v)){
            return null;
        }
        Stack<Integer> path=new Stack<>();

        for (int x = v; x!=s ; x=edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
