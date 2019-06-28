package org.jys.learn.algorithms.sort;

import java.util.Arrays;

/**
 * @author YueSong Jiang
 * @date 2019/6/28
 * @description <p> </p>
 */
public class MergeBottomSort<T extends Comparable<T>> extends MergeTemplateMethod<T> {
    @Override
    public void sort(T[] a) {
        aux= Arrays.copyOf(a,a.length);
        //sz is the little array sz
        for (int sz = 1; sz < a.length; sz=sz*2) {
            for(int lo=0;lo<a.length-sz;lo+=sz*2){
                merge(a,lo,lo+sz-1,Math.min(lo+sz*2-1,a.length-1));
            }
        }
    }

    public static void main(String[] args){
        SortTemplateMethod<Integer> sortMethod=new MergeBottomSort<>();
        Integer[] arr=new Integer[]{1,9,2,4,8,2,5,7};
        sortMethod.sort(arr);
        sortMethod.show(arr);
    }
}
