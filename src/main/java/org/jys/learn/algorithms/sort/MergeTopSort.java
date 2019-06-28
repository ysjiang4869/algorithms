package org.jys.learn.algorithms.sort;

import java.util.Arrays;

/**
 * @author YueSong Jiang
 * @date 2019/6/28
 * @description <p> </p>
 */
public class MergeTopSort<T extends Comparable<T>> extends MergeTemplateMethod<T> {


    @Override
    public void sort(T[] a) {
        aux= Arrays.copyOf(a,a.length);
        sort(a,0,a.length-1);
    }

    private void sort(T[]a, int lo, int hi){
        if(lo>=hi){
            return;
        }
        int mid=(lo+hi)/2;
        //sort left hand
        sort(a,0,mid);
        //sort right hand
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    public static void main(String[] args){
        SortTemplateMethod<Integer> sortMethod=new MergeTopSort<>();
        Integer[] arr=new Integer[]{1,9,2,4,8,2,5,7};
        sortMethod.sort(arr);
        sortMethod.show(arr);
    }
}
