package org.jys.learn.algorithms.sort;

/**
 * @author YueSong Jiang
 * @date 2019/6/17
 * @description <p> </p>
 */
public class Insertion<T extends Comparable<T>> extends SortTemplateMethod<T> {

    @Override
    public void sort(T[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >0; j--) {
                if(less(a[j],a[j-1])){
                    exchange(a,j,j-1);
                }
            }
        }
    }

    public static void main(String[] args){
        SortTemplateMethod<Integer> sortMethod=new Insertion<>();
        Integer[] arr=new Integer[]{1,9,2,4,8,2,5,7};
        sortMethod.sort(arr);
        sortMethod.show(arr);
    }
}
