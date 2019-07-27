package org.jys.learn.algorithms.graph;

import edu.princeton.cs.algorithms.Queue;
import edu.princeton.cs.algorithms.Stack;

/**
 * @author YueSong Jiang
 * @date 2019/7/25
 * @description <p> </p>
 */
public class BreadFirstPaths {

    private boolean[] marked; //这个顶点上调用过dfs()了吗
    private int[] edgeTo; //c从起点到一个顶点的已知路径上的最后一个顶点
    private final int s; //起点

    public BreadFirstPaths(Graph G,int s) {
        this.s=s;
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        bfs(G,s);
    }

    private void bfs(Graph G, int s){
        Queue<Integer> queue=new Queue<>();
        marked[s]=true;
        queue.enqueue(s);
        while (!queue.isEmpty()){
            int v=queue.dequeue();
            for (int w:G.adj(v)){
                if(!marked[w]){
                    edgeTo[w]=v;
                    marked[w]=true;
                    queue.enqueue(w);
                }
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
