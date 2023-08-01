package com.rish.ds.tree.bst.balanced.selfBalancing.strictly.avl;

public class AVLTree<T extends Comparable<T>> implements ITree<T> {
    private AVLTreeNode<T> root;

    @Override
    public ITree<T> insert(T data) {
        this.root = insert(data, this.root);
        return this;
    }

    public AVLTreeNode<T> insert(T data, AVLTreeNode<T> node) {
        if (node == null) return new AVLTreeNode<>(data);
        if (data.compareTo(node.data) < 0) node.leftTreeNode = insert(data, node.leftTreeNode);
        else if (data.compareTo(node.data) > 0) node.rightTreeNode = insert(data, node.rightTreeNode);
        else return node;
        updateHeight(node);
        return applyRotation(node);
    }

    private void updateHeight(AVLTreeNode<T> node) {
        int maxHeight = Math.max(getHeight(node.leftTreeNode), getHeight(node.rightTreeNode));
        node.height = 1 + maxHeight;
    }

    private int getHeight(AVLTreeNode<T> node) {
        return node != null ? node.height : 0;
    }

    private AVLTreeNode<T> applyRotation(AVLTreeNode<T> node) {
        int balance = getBalanceFactor(node);
        if (balance > 1) {
            if (getBalanceFactor(node.leftTreeNode) < 0) {
                node.leftTreeNode = rotateLeft(node.leftTreeNode);
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (getBalanceFactor(node.rightTreeNode) > 0) {
                node.rightTreeNode = rotateRight(node.rightTreeNode);
            }
            return rotateLeft(node);
        }
        return node;
    }

    private int getBalanceFactor(AVLTreeNode<T> node) {
        return node != null ? getHeight(node.leftTreeNode) - getHeight(node.rightTreeNode) : 0;
    }

    private AVLTreeNode<T> rotateLeft(AVLTreeNode<T> node) {
        AVLTreeNode<T> rightNode = node.rightTreeNode;
        AVLTreeNode<T> rightLeftNode = rightNode.leftTreeNode;
        rightNode.leftTreeNode = node;
        node.rightTreeNode = rightLeftNode;
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    private AVLTreeNode<T> rotateRight(AVLTreeNode<T> node) {
        AVLTreeNode<T> leftNode = node.leftTreeNode;
        AVLTreeNode<T> leftRightNode = leftNode.rightTreeNode;
        leftNode.rightTreeNode = node;
        node.leftTreeNode = leftRightNode;
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    @Override
    public T getMax() {
        return isEmpty() ? null : getMax(root);
    }

    private T getMax(AVLTreeNode<T> node) {
        if (node.rightTreeNode != null) return getMax(node.rightTreeNode);
        return node.data;
    }

    @Override
    public T getMin() {
        return isEmpty() ? null : getMin(root);
    }

    private T getMin(AVLTreeNode<T> node) {
        if (node.leftTreeNode != null) return getMin(node.leftTreeNode);
        return node.data;
    }

    @Override
    public void delete(T data) {
        this.root = delete(data, root);
    }

    private AVLTreeNode<T> delete(T data, AVLTreeNode<T> node) {
        if (node == null) return null;
        if (data.compareTo(node.data) < 0) node.leftTreeNode = delete(data, node.leftTreeNode);
        else if (data.compareTo(node.data) > 0) node.rightTreeNode = delete(data, node.rightTreeNode);
        else {
            if (node.leftTreeNode == null) return node.rightTreeNode;
            if (node.rightTreeNode == null) return node.leftTreeNode;
            node.data = getMax(node.leftTreeNode);
            node.leftTreeNode = delete(node.data, node.leftTreeNode);
        }
        updateHeight(node);
        return applyRotation(node);
    }

    @Override
    public void traverse() {
        traverseInOrder(root);
        System.out.println("end");
    }

    private void traverseInOrder(AVLTreeNode<T> node) {
        if (node != null) {
            traverseInOrder(node.leftTreeNode);
            System.out.print(node.data + " -> ");
            traverseInOrder(node.rightTreeNode);
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
}
