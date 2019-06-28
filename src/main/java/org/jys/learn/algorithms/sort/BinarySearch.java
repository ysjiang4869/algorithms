package org.jys.learn.algorithms.sort;

import edu.princeton.cs.introcs.StdIn;

import java.util.Arrays;

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

    public static void main(String[] args){
        int[] whitelist=new int[]{1,34,56,23,45,36,863,23,74,346,457};
        Arrays.sort(whitelist);
        System.out.println("the array is:"+Arrays.toString(whitelist));
        System.out.println("enter the num to find: ");
        int target=StdIn.readInt();
        int index=rank(target,whitelist);
        if (index<0){
            System.out.println("can not find");
        }else {
            System.out.println("the index of target is: "+index);
        }
    }
}
