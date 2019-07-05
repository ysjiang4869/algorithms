package org.jys.learn.algorithms.search;

/**
 * @author YueSong Jiang
 * @date 2019/7/2
 * @description <p> </p>
 */
public class BinarySearchTree<K extends Comparable<K>,V> {

    private Node root;

    public V get(K key){
        return get(root,key);
    }

    private V get(Node node, K key){
        if(node==null){
            return null;
        }
        int cmp=key.compareTo(node.key);
        if(cmp<0){
            return get(node.left,key);
        }else if(cmp>0){
            return get(node.right,key);
        }else {
            return node.value;
        }
    }

    public void put(K key, V value){
        root=put(root,key,value);
    }

    public K min(){
        return root==null?null:min(root).key;
    }

    private Node min(Node x){
        if(x.left==null){
            return x;
        }
        return min(x.left);
    }

    public K max(){
        return root==null?null:max(root).key;
    }

    private Node max(Node x){
        if(x.right==null){
            return x;
        }
        return max(x.right);
    }

    private Node put(Node node, K key, V value){
        if(node==null){
            return new Node(key,value,1);
        }
        int cmp=key.compareTo(node.key);
        if(cmp<0){
            node.left=put(node.left,key,value);
        }else if(cmp>0){
            node.right=put(node.right,key,value);
        }else {
            node.value=value;
        }
        node.num=size(node.left)+size(node.right)+1;
        return node;
    }

    public int size(){
        return size(root);
    }

    private int size(Node node){
        return node==null?0:node.num;
    }
    private class Node{
        private K key;
        private V value;
        private Node left;
        private Node right;
        //the node num of tree which use this node as root node
        private int num;

        public Node(K key, V value, int num) {
            this.key = key;
            this.value = value;
            this.num = num;
        }
    }
}
