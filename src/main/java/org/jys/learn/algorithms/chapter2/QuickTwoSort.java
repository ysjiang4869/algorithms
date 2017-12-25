package org.jys.learn.algorithms.chapter2;

/**
 * Created by ysjiang on 2017/12/25.
 *
 * @author Jiang YueSong
 * @date 2017/12/25
 */
public class QuickTwoSort extends QuickSort implements Sort {

    @Override
    public void sort(Comparable[] a) {
        sort(a,0,a.length-1);
    }

    private void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo) return;
        /*
        对于小数组，插入排序比快速排序快，所以可以设定数组较小时，启用快速排序
        if(hi<=lo+M){
            Sort sort=new InsertionSort();
            Comparable[] sub=new Comparable[hi-lo+1];
            System.arraycopy(a,lo,sub,0,hi-lo+1);
            sort.sort(sub);
            return;
        }
         */
        int j=partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
}
