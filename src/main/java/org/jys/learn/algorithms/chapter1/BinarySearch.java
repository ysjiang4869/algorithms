package org.jys.learn.algorithms.chapter1;

/**
 * Created by ysjiang on 2017/12/25.
 *
 * @author Jiang YueSong
 * @date 2017/12/25
 */
public class BinarySearch {

    /**
     * binary search,the array must be sorted
     * @param key the key need to search
     * @param a array
     * @return -1 not found, else the find value position
     */
    public static int rank(int key,int[]a){
        int lo=0;
        int hi=a.length-1;

        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(key<a[mid]){
                hi=mid-1;
            }else if(key>a[mid]){
                lo=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
