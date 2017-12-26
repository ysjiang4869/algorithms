package org.jys.learn.algorithms.chapter2;

/**
 * Created by ysjiang on 2017/12/26.
 *
 * @author Jiang YueSong
 * @date 2017/12/26
 */
public class HeapSort extends HeapMethod implements Sort {
    @Override
    public void sort(Comparable[] a) {
        N=a.length;
        pq=a;
        //完成堆有序,跳过大小为1的子堆
        for(int k=N/2;k>=1;k--){
            sink(k);
        }

        //将最大的放到底部，然后实现堆有序，重复此步骤，就得到了由小到大的排序结果
        while (N>1){
            exch(1,N--);
            sink(1);
        }
    }
}
