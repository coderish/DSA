package com.rish.ds.tree.bst.balanced.selfBalancing.strictly.avl;

public class AVLTreeNode<T extends Comparable<T>> {
    T data;
    int height = 1;
    AVLTreeNode<T> leftTreeNode;
    AVLTreeNode<T> rightTreeNode;

    public AVLTreeNode(T data) {
        this.data = data;
    }

}

