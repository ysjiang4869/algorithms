package org.jys.learn.algorithms.sort;

public interface MaxPQ<T extends Comparable<T>> {

    void insert(T v);

    T max();

    T delMax();

    boolean isEmpty();

    int size();
}
