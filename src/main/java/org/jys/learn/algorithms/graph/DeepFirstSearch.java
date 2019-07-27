package org.jys.learn.algorithms.graph;

/**
 * @author YueSong Jiang
 * @date 2019/7/13
 * @description <p> FS适合此类题目：给定初始状态跟目标状态，要求判断从初始状态到目标状态是否有解</p>
 */
public class DeepFirstSearch {

    private boolean[] marked;
    private int count;

    public DeepFirstSearch(Graph G, int s) {
        marked=new boolean[G.V()];

    }

    private void dfs(Graph G, int v){
        marked[v]=true;
        count++;
        for (int w: G.adj(v)){
            if(!marked[w]){
                dfs(G, w);
            }
        }
    }

    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }
}
