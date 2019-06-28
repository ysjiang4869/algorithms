package org.jys.learn.algorithms.sort;

import java.util.Arrays;

/**
 * @author YueSong Jiang
 * @date 2019/6/17
 * @description <p> </p>
 */
public abstract class SortTemplateMethod<T extends Comparable<T>> {

    public abstract void sort(T[] a);

    public boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    public void exchange(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public boolean isSorted(T[] a){
        for (int i = 0; i < a.length-1; i++) {
            if(less(a[i+1],a[i])){
                return false;
            }
        }
        return true;
    }

    public void show(T[] a){
        System.out.println(Arrays.toString(a));
    }
}
