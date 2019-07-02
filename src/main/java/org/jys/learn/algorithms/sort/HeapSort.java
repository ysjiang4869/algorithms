package org.jys.learn.algorithms.sort;

/**
 * @author YueSong Jiang
 * @date 2019/7/2
 * @description <p> </p>
 */
public class HeapSort<T extends Comparable<T>> extends BinaryMaxHeap<T> implements SortTemplateMethod<T> {


    //因为原数组是从0开始的，所以需要额外创建一个数组
    @Override
    public void sort(T[] a) {
        this.a=(T[]) new Comparable[a.length + 1];
        System.arraycopy(a,0,this.a,1,a.length);
        //构造堆
        n=a.length;
        //不管最底层，从倒数第二层开始下沉构造堆
        for(int k=n/2;k>0;k--){
            sink(k);
        }
        //开始排序，取最大值放到数组末尾，n--从堆中移除数组末尾元素，重新sink平衡堆
        //到只剩下1个元素看可以终止循环了
        while (n>1){
            exchange(this.a,1,n--);
            sink(1);
        }
        System.arraycopy(this.a,1,a,0,a.length);
    }

    public static void main(String[] args){
        SortTemplateMethod<Integer> sortMethod=new HeapSort<>();
        Integer[] arr=new Integer[]{1,9,2,4,8,2,5,7};
        sortMethod.sort(arr);
        sortMethod.show(arr);
    }

    @Override
    public boolean less(T v, T w) {
        return super.less(v,w);
    }

    @Override
    public void exchange(T[] a, int i, int j) {
        super.exchange(a,i,j);
    }

    @Override
    public void insert(T item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T max() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T delMax() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }
}
