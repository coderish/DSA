package com.rish.ds.tree.bst.balanced;

import com.rish.ds.tree.bst.impl.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BalancedBST {

    /** 1. It should maintain height logn
     *  2. Difference in height of left subtree and right subtree shouldn't be more than 1
     *  depth = |height(leftSubTree) - height(rightSubTree)|
     */
    public static void main(String[] args) {
        BalancedBST balancedBST = new BalancedBST();
        BinarySearchTree bstRoot = new BinarySearchTree(10);
        bstRoot.addNode(9);
        bstRoot.addNode(15);
        bstRoot.addNode(2);
        bstRoot.addNode(11);
        bstRoot.addNode(4);
        bstRoot.addNode(16);
        BinarySearchTree.print(bstRoot);

        List<Integer> orderedSequence = new ArrayList<>();
        balancedBST.convertToInorderSequence(bstRoot, orderedSequence);
        BinarySearchTree balancedBstRoot = balancedBST.buildBSTFromInorderedList(orderedSequence, 0, orderedSequence.size() - 1);
        BinarySearchTree.print(balancedBstRoot);
    }

    public void convertToInorderSequence(BinarySearchTree node, List<Integer> orderedSequence) {
        if (node != null) {
            convertToInorderSequence(node.leftTreeNode, orderedSequence);
            orderedSequence.add(node.data);
            convertToInorderSequence(node.rightTreeNode, orderedSequence);
        }
    }

    public BinarySearchTree buildBSTFromInorderedList(List<Integer> inorderedSequence, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        BinarySearchTree binarySearchTree = new BinarySearchTree(inorderedSequence.get(mid));
        binarySearchTree.leftTreeNode = buildBSTFromInorderedList(inorderedSequence, start, mid - 1);
        binarySearchTree.rightTreeNode = buildBSTFromInorderedList(inorderedSequence, mid + 1, end);

        return binarySearchTree;
    }
}
