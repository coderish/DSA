package com.rish.ds.tree.bst;

public class BSTNode<T extends Comparable<T>> {
    public T data;
    public BSTNode<T> leftTreeNode;
    public BSTNode<T> rightTreeNode;

    public BSTNode(T data) {
        this.data = data;
    }
}
