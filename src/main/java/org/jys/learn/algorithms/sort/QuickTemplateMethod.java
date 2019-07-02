package org.jys.learn.algorithms.sort;

/**
 * @author YueSong Jiang
 * @date 2019/6/28
 * @description <p> </p>
 */
public abstract class QuickTemplateMethod<T extends Comparable<T>> implements SortTemplateMethod<T> {


    public int  partition(T[] a, int lo, int hi){
        T v=a[lo];
        //第一次做，这里写为了i=lo
        //这样，可能把边界lo交换了
        //最后一步的交换lo和j就出错了
        int i=lo+1;
        int j=hi;
        while (true){
            while (less(a[i],v)){
                i++;
                if(i>=hi){
                    break;
                }
            }
            while (less(v,a[j])){
                j--;
                if(j<=lo){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            exchange(a,i,j);
        }
        exchange(a,lo,j);
        return j;
    }
    //参照上面的做法吧，更容易理解，这个hi+1的做法不容易理解
    //这个是书上的做法
    public int  partitionReference(T[] a, int lo, int hi){
        T v=a[lo];
        int i=lo;
        int j=hi+1;
        while (true){
            while (less(a[++i],v)){
                if(i>=hi){
                    break;
                }
            }
            while (less(v,a[--j])){
                if(j<=lo){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            exchange(a,i,j);
        }
        //为什么交换j和lo，上述条件不满足，说明i>=j
        //如果i>j,并且a[i]>v,a[j]<v,就是...a[j]a[i]...,
        //交换i和lo，则交换后左侧的a[lo]>a[i]不满足切分要求
        //准确的说，是交换两个中的较小值，只是这个值一定是a[j]
        exchange(a,lo,j);
        return j;
    }
}
