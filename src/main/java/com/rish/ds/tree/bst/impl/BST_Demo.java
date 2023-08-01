package com.rish.ds.tree.bst.impl;

public class BST_Demo {
    public static void main(String[] args) {
        BinarySearchTree bstRoot = new BinarySearchTree(10);
        bstRoot.addNode(9);
        bstRoot.addNode(15);
        bstRoot.addNode(2);
        bstRoot.addNode(11);
        bstRoot.addNode(4);
        bstRoot.addNode(16);

        BinarySearchTree.print(bstRoot);
        BinarySearchTree.print(bstRoot.getNode(15));



    }
}


