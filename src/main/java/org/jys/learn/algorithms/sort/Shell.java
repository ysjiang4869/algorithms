package org.jys.learn.algorithms.sort;

/**
 * @author YueSong Jiang
 * @date 2019/6/17
 * @description <p> </p>
 */
public class Shell<T extends Comparable<T>> extends SortTemplateMethod<T> {

    @Override
    public void sort(T[] a) {
        int N=a.length;
        int h=1;
        while (h<N/3){
            h=3*h+1;
        }

        while (h>=1){
            //从插入排序而来
            //插入排序的循环，1改成h，处理一下j的结束for循环条件就ok
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >=h; j-=h) {
                    if(less(a[j],a[j-h])){
                        exchange(a,j,j-h);
                    }
                }
            }
            h=h/3;
        }
    }

    public static void main(String[] args){
        SortTemplateMethod<Integer> sortMethod=new Shell<>();
        Integer[] arr=new Integer[]{1,9,2,4,8,2,5,7};
        sortMethod.sort(arr);
        sortMethod.show(arr);
    }
}
