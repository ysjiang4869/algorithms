package org.jys.learn.algorithms.chapter2;


/**
 * Created by ysjiang on 2017/12/25.
 *
 * @author Jiang YueSong
 * @date 2017/12/25
 */
public class MergeSort extends SortMethod {

    static Comparable[] aux; //归并所需的辅助数组

    //合并a[lo...mid]和a[mid+1...hi]
    void merge(Comparable[] a, int lo, int mid, int hi){
        int i=lo,j=mid+1;

        System.arraycopy(a, lo, aux, lo, hi + 1 - lo);

        for(int k=lo;k<=hi;k++){
            if(i>mid){
                a[k]=aux[j++];//左半边元素用尽
            }else if (j>hi){
                a[k]=aux[i++];//右半边元素用尽
            }else if(less(aux[j],aux[i])){
                a[k]=aux[j++];//右半边当前元素小于左半边当前元素，取右半边
            }else {
                a[k]=aux[i++];//左半边当前元素小于右半边当前元素，取左半边
            }
        }
    }
}
