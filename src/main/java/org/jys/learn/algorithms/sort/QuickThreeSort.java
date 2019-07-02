package org.jys.learn.algorithms.sort;

/**
 * @author YueSong Jiang
 * @date 2019/7/1
 * @description <p> </p>
 */
public class QuickThreeSort<T extends Comparable<T>> extends QuickTemplateMethod<T>  {


    @Override
    public void sort(T[] a) {
        sort(a,0,a.length-1);
    }

    private void sort(T[] a, int lo,int hi){
        if(hi<=lo){
            return;
        }
        T v=a[lo];
        int lt=lo;
        int i=lo+1;
        int gt=hi;
        while (i<=gt){
            int cmp=v.compareTo(a[i]);
            if(cmp>0){
                exchange(a,lt,i);
                lt++;
                i++;
            } else if (cmp < 0) {
                exchange(a,gt,i);
                gt--;
            }else {
                i++;
            }
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    public static void main(String[] args){
        SortTemplateMethod<Integer> sortMethod=new QuickThreeSort<>();
        Integer[] arr=new Integer[]{1,9,2,4,8,2,5,7};
        sortMethod.sort(arr);
        sortMethod.show(arr);
    }
}
