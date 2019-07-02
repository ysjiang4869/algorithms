package org.jys.learn.algorithms.sort;

/**
 * @author YueSong Jiang
 * @date 2019/7/2
 * @description 最大二叉堆，同时扩展实现最大优先队列
 */
public class BinaryMaxHeap<T extends Comparable<T>> implements Heap<T>, MaxPQ<T> {

    protected T[] a;
    protected int n = 0;

    protected BinaryMaxHeap() {

    }

    public BinaryMaxHeap(int maxN) {
        a = (T[]) new Comparable[maxN + 1];
    }

    @Override
    //将位置为k的元素下沉，使得堆有序
    public void sink(int k) {
        //子节点在数组长度内
        while (2 * k <= n) {
            int j = 2 * k;
            //最大堆，k应该大于j和j+1,所以选择其中较大的进行比较和交换
            if (j < n && less(a[j], a[j + 1])) {
                j++;
            }
            if (less(a[k], a[j])) {
                exchange(a, k, j);
                k = j;
            } else {
                break;
            }
        }
    }

    @Override
    //将位置为k的元素上浮，使得堆有序
    public void swim(int k) {
        //j=2k or j=2k+1,so parent is k=j/2
        while (k / 2 >= 1) {
            if (less(a[k / 2], a[k])) {
                exchange(a, 2 / k, k);
                k = k / 2;
            } else {
                break;
            }
        }
    }

    @Override
    public void insert(T item) {
        a[++n] = item;
        swim(n);
    }

    @Override
    public T max() {
        return a[n];
    }

    @Override
    public T delMax() {
        T ret = a[1];
        exchange(a, 1, n);
        a[n--] = null;
        sink(1);
        return ret;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

}
