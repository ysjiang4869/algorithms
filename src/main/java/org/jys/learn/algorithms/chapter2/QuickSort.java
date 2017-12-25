package org.jys.learn.algorithms.chapter2;

import java.sql.Array;

/**
 * Created by ysjiang on 2017/12/25.
 *
 * @author Jiang YueSong
 * @date 2017/12/25
 */
class QuickSort extends SortMethod{

    int partition(Comparable[]a,int lo,int hi){
        int i=lo,j=hi+1;//左右扫描指针

        Comparable v=a[lo]; //切分元素

        while (true){
            //从左扫描，若左侧出现大于V的，停止扫描；或者指针到最右相遇，停止扫描
            while (less(a[++i],v)){
                if(i==hi){
                    break;
                }
            }

            //从右扫描，出现右侧小于Vde，停止扫描；或者指针到达最左侧停止扫描
            while (less(v,a[--j])){
                if(j==lo){
                    break;
                }
            }
            //直到指针相遇，停止扫描
            if(i>=j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);//交换a[lo]和a[j]，切分值保留在了a[j]中
        return j;
    }
}
