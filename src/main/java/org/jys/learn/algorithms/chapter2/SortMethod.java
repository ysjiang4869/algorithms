package org.jys.learn.algorithms.chapter2;

/**
 * Created by ysjiang on 2017/12/25.
 *
 * @author Jiang YueSong
 * @date 2017/12/25
 */
class SortMethod {

    boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

    void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}
