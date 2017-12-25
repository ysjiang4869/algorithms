package org.jys.learn.algorithms.chapter2;

/**
 * Created by ysjiang on 2017/12/25.
 *
 * @author Jiang YueSong
 * @date 2017/12/25
 */
public class ShellSort extends SortMethod implements Sort{

    @Override
    public void sort(Comparable[] a){
        int N=a.length;
        int h=1;
        while (h<N/3){
            h=3*h+1;
        }

        while (h>=1){
            for(int i=h;i<N;i++){
               for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h){
                   exch(a,j,j-h);
               }
            }
        }
    }
}
