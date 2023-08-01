package com.rish.ds.tree.bst;

public interface ITree<T extends Comparable<T>> {

    ITree<T> insert(T data);

    void delete(T data);

    T getMax();

    T getMin();

    void traverse();

    boolean isEmpty();
}
