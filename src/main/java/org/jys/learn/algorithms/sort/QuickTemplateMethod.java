package org.jys.learn.algorithms.sort;

/**
 * @author YueSong Jiang
 * @date 2019/6/28
 * @description <p> </p>
 */
public abstract class QuickTemplateMethod<T extends Comparable<T>> extends SortTemplateMethod<T> {

    public int  partition(T[] a, int lo, int hi){
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

    /**
     *下面这种方法是不对的，想了很久的原因，才发现
     * 每次交换完毕后，被交换的数字又参与了一次笔记
     * a[i] 和a[i]交换，下一次循环，又比较了，a[i]和a[j]，
     * 这时候满足条件，i++了，j++了，这时候造成了多余的交换
     * 临界下出错了
     */
    private int  partitionWrong(T[] a, int lo, int hi){
        T v=a[lo];
        int i=lo;
        int j=hi;
        while (true){
            while (less(a[i],v)){
                i++;
                if(i>hi){
                    break;
                }
            }
            while (less(v,a[j])){
                j--;
                if(j<lo){
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
}
