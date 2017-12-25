package org.jys.learn.algorithms.chapter2;


/**
 * Created by ysjiang on 2017/12/25.
 *
 * @author Jiang YueSong
 * @date 2017/12/25
 */
class HeapMethod<Key extends Comparable<Key>>  {

    Key[] pq; //存储于pq[1...N]中，pq[0]没有使用
    boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }

    void  exch(int i,int j){
        Key t=pq[i];
        pq[i]=pq[j];
        pq[j]=t;
    }

    void swim(int k){

    }

    void sink(int k){

    }


}
