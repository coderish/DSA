package com.rish.ds.tree.bst.impl;

public class BinarySearchTree {
    public int data;
    /**
     * Left Node containing data-value less that this.data
     */
    public BinarySearchTree leftTreeNode;
    /**
     * Right Node containing data-value more that this.data
     */
    public BinarySearchTree rightTreeNode;

    public BinarySearchTree(int data, BinarySearchTree leftTreeNode, BinarySearchTree rightTreeNode) {
        this.data = data;
        this.leftTreeNode = leftTreeNode;
        this.rightTreeNode = rightTreeNode;
    }

    public BinarySearchTree(int data) {
        this.data = data;
    }

    public boolean addNode(int data) {
        if (this.data == data)
            return false;
        else if (this.data < data) {
            if (this.rightTreeNode == null) {
                this.rightTreeNode = new BinarySearchTree(data);
            } else {
                this.rightTreeNode.addNode(data);
            }
        } else {
            if (this.leftTreeNode == null) {
                this.leftTreeNode = new BinarySearchTree(data);
            } else {
                this.leftTreeNode.addNode(data);
            }
        }
        return true;
    }

    public BinarySearchTree getNode(int value) {
        if (this.data == value)
            return this;
        else if (this.data > value) {
            return (this.leftTreeNode == null) ? null : this.leftTreeNode.getNode(value);
        } else return (this.rightTreeNode == null) ? null : this.rightTreeNode.getNode(value);
    }

    public boolean deleteNode(int value) {
        return false;
    }

    public static void print(BinarySearchTree node) {
        print_Inorder_DFS_LRR(node);
        System.out.println("end");
    }

    private static void print_Inorder_DFS_LRR(BinarySearchTree node) {
        if (node != null) {
            print_Inorder_DFS_LRR(node.leftTreeNode);
            System.out.print(node.data + " -> ");
            print_Inorder_DFS_LRR(node.rightTreeNode);
        }
    }
}
