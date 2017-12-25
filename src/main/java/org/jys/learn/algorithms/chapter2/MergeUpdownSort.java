package org.jys.learn.algorithms.chapter2;

/**
 * Created by ysjiang on 2017/12/25.
 *
 * @author Jiang YueSong
 * @date 2017/12/25
 */
public class MergeUpdownSort extends MergeSort implements Sort{


    @Override
    public void sort(Comparable[] a) {

        aux=new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private void sort(Comparable a[],int lo,int hi){
        if(hi<=lo){
            return;
        }
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
}
