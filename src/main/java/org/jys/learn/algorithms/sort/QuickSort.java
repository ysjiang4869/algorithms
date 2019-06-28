package org.jys.learn.algorithms.sort;

/**
 * @author YueSong Jiang
 * @date 2019/6/28
 * @description <p> </p>
 */
public class QuickSort<T extends Comparable<T>> extends QuickTemplateMethod<T> {

    @Override
    public void sort(T[] a) {
        sort(a,0,a.length-1);
    }

    private void sort(T[] a, int lo, int hi){
        if(lo>=hi){
            return;
        }
        int x=partition(a,lo,hi);
        sort(a,lo,x-1);
        sort(a,x+1,hi);
    }

    public static void main(String[] args){
        SortTemplateMethod<Integer> sortMethod=new QuickSort<>();
        Integer[] arr=new Integer[]{1,9,2,4,8,2,5,7};
        sortMethod.sort(arr);
        sortMethod.show(arr);
    }
}
