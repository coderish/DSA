package com.rish.ds.tree.bst.balanced.selfBalancing.strictly.avl;

public interface ITree<T extends Comparable<T>> {

    ITree<T> insert(T data);

    T getMax();

    T getMin();

    void delete(T data);

    void traverse();

    boolean isEmpty();
}
