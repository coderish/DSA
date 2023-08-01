package com.rish.ds.tree.bst;

public class BST<T extends Comparable<T>> implements ITree<T> {
    private BSTNode<T> root;

    @Override
    public ITree<T> insert(T data) {
        this.root = insert(data, this.root);
        return this;
    }

    private BSTNode<T> insert(T data, BSTNode<T> node) {
        if (node == null) {
            return new BSTNode<>(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.leftTreeNode = insert(data, node.leftTreeNode);
        } else if (data.compareTo(node.data) > 0) {
            node.rightTreeNode = insert(data, node.rightTreeNode);
        }
        return node;
    }

    @Override
    public void delete(T data) {
        root = delete(data, root);
    }

    private BSTNode<T> delete(T data, BSTNode<T> node) {
        if (root == null) return null;
        if (data.compareTo(node.data) < 0) {
            node.leftTreeNode = delete(data, node.leftTreeNode);
        } else if (data.compareTo(node.data) > 0) {
            node.rightTreeNode = delete(data, node.rightTreeNode);
        } else {
            // one or no children
            if (node.leftTreeNode == null) return node.rightTreeNode;
            else if (node.rightTreeNode == null) return node.leftTreeNode;
            // two children
            node.data = getMax(node.leftTreeNode);
            node.leftTreeNode = delete(node.data, node.leftTreeNode);
        }
        return node;
    }

    @Override
    public T getMax() {
        if (isEmpty()) return null;
        return getMax(this.root);
    }

    private T getMax(BSTNode<T> node) {
        if (node.rightTreeNode != null) {
            return getMax(node.rightTreeNode);
        }
        return node.data;
    }

    @Override
    public T getMin() {
        if (isEmpty()) return null;
        return getMin(this.root);
    }

    private T getMin(BSTNode<T> node) {
        if (node.leftTreeNode != null) {
            return getMin(node.leftTreeNode);
        }
        return node.data;
    }

    @Override
    public void traverse() {
        traverseInOrder(this.root);
        System.out.println("end");
    }

    private void traverseInOrder(BSTNode<T> node) {
        if (node == null) {
            return;
        }
        traverseInOrder(node.leftTreeNode);
        System.out.print(node.data + " -> ");
        traverseInOrder(node.rightTreeNode);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
}
