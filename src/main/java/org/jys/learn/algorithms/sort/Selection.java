package org.jys.learn.algorithms.sort;

/**
 * @author YueSong Jiang
 * @date 2019/6/17
 * @description <p> </p>
 */
public class Selection<T extends Comparable<T>> implements SortTemplateMethod<T> {


    @Override
    public void sort(T[] a) {
        for (int i = 0; i < a.length-1; i++) {
            int min=i;
            // get the min value in rest array
            for (int j = i+1; j < a.length; j++) {
                if(less(a[j],a[min])){
                    min=j;
                }
            }
            // exchange the a[i] and the a[min]
            exchange(a,i,min);
        }
    }

    public static void main(String[] args){
        SortTemplateMethod<Integer> sortMethod=new Selection<>();
        Integer[] arr=new Integer[]{1,9,2,4,8,2,5,7};
        sortMethod.sort(arr);
        sortMethod.show(arr);
    }
}
