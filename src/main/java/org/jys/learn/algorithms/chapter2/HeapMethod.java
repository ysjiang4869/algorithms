package org.jys.learn.algorithms.chapter2;


/**
 * Created by ysjiang on 2017/12/25.
 *
 * @author Jiang YueSong
 * @date 2017/12/25
 */
class HeapMethod<Key extends Comparable<Key>>  {

    Key[] pq; //存储于pq[1...N]中，pq[0]没有使用
    int N=0;

    boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }

    void  exch(int i,int j){
        Key t=pq[i];
        pq[i]=pq[j];
        pq[j]=t;
    }

    //由下至上实现堆有序
    void swim(int k){
        while (k>1&&less(k/2,k)){
            exch(k/2,k);
            k=k/2;
        }
    }

    //与子节点的较大者交换
    void sink(int k){
        while (2*k<=N){
            int j=2*k;
            if(j<N&&less(j,j+1)){
                j++;
            }
            if(!less(k,j)){
                break;
            }
            exch(k,j);
        }
    }


}
