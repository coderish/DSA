package com.rish.ds.tree.bst;

public class BSTTest {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        System.out.println("isEmpty: " + bst.isEmpty());
        bst.insert(10).insert(20).insert(21).insert(12).insert(11).insert(8).insert(5);
        bst.traverse();
        bst.delete(10);
        bst.traverse();
        System.out.println("max: " + bst.getMax());
        System.out.println("min: " + bst.getMin());
        System.out.println("isEmpty: " + bst.isEmpty());
    }
}
