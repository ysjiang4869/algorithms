package org.jys.learn.algorithms.chapter2;

/**
 * Created by ysjiang on 2017/12/25.
 *
 * @author Jiang YueSong
 * @date 2017/12/25
 */
public class QuickThreeSort extends QuickSort implements Sort{
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
        int lt=lo,i=lo+1,gt=hi;
        Comparable v=a[lo];
        while (i<=gt){
            int cmp=a[i].compareTo(v);
            if(cmp<0){
                exch(a,lt++,i++);
            }else if (cmp>0){
                exch(a,i,gt--);
            }else {
                i++;
            }
        } //现在a[lo..lt-1]<v=a[lt..gt]<a[gt+1...hi]成立；v在a[]lt和gt之间
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }
}
