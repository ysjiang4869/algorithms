package org.jys.learn.algorithms.sort;

public interface Heap<T extends Comparable<T>> {

    void sink(int k);

    void swim(int k);

    void insert(T item);

    default boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    default void exchange(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
