package org.jys.learn.algorithms.sort;

/**
 * @author YueSong Jiang
 * @date 2019/6/28
 * @description <p> </p>
 */
public abstract class MergeTemplateMethod<T extends Comparable<T>> extends SortTemplateMethod<T>  {

    //init aux in sub class so it no need to reallocate space
    protected T[] aux;

    /**
     * merge a[lo]-a[mid] and a[mid+1]-a[hi] to origin a[]
     * @param a the array
     * @param lo begin index
     * @param mid the splicer for two array
     * @param hi end index
     */
    public void merge(T[] a, int lo, int mid, int hi){
        //move data to another array
        for (int i = 0; i <= hi; i++) {
            aux[i]=a[i];
        }
        int i=lo;
        int j=mid+1;
        for (int k = lo; k <= hi; k++) {
            if(i>mid){
                //edge,left array has no left
                a[k]=aux[j++];
            }else if(j>hi){
                //edge,right array has no left
                a[k]=aux[i++];
            }else if(less(aux[i],aux[j])){
                //aux[i] is smaller than aux[j]
                a[k]=aux[i++];
            }else {
                a[k]=aux[j++];
            }
        }
    }
}
