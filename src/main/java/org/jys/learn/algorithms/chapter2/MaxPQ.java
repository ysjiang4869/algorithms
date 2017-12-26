package org.jys.learn.algorithms.chapter2;

import java.util.ArrayList;

/**
 * Created by ysjiang on 2017/12/25.
 *
 * @author Jiang YueSong
 * @date 2017/12/25
 */
public class MaxPQ<Key extends Comparable<Key>> extends HeapMethod<Key>{

    public MaxPQ(int maxN) {
        pq= new ArrayList<Key>(maxN).toArray(pq);
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void Insert(Key v){
        pq[++N]=v;
        swim(N);
    }

    public Key delMax(){
        Key max=pq[1]; //从根结点得到最大元素
        exch(1,N--); //将其和最后一个结点交换
        pq[N+1]=null; //防止越界
        sink(1); //恢复堆的有序性
        return max;
    }
}
