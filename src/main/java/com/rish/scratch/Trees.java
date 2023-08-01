package com.rish.scratch;

public class Trees {
    public static void main(String[] args) {
        BSTree<Integer> bsTree = new BSTree<>();
        AvlTree<Integer> avlTree = new AvlTree<>();
//        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        traverse(bsTree.root);
        traverse(avlTree.root);
//        traverse(redBlackTree.root);
    }

    static <T extends Comparable<T>> void traverse(Node<T> node) {
        // Use Strategy pattern to traverse (BSS (LevelOrder), DFS(Pre, Post, In))
    }
}


/**
 * Nodes below
 */
interface Node<T extends Comparable<T>> {
}

class BSTNode<T extends Comparable<T>> implements Node<T> {
    T data;
    BSTNode<T> leftNode;
    BSTNode<T> rightNode;

    public BSTNode(T data) {
        this.data = data;
    }
}

class AvlTreeNode<T extends Comparable<T>> implements Node<T> {
    T data;
    int height = 1;
    AvlTreeNode<T> leftNode;
    AvlTreeNode<T> rightNode;

    public AvlTreeNode(T data) {
        this.data = data;
    }
}

class RedBlackNode<T extends Comparable<T>> implements Node<T> {
    T data;
    int height = 1;
    int color = 0;
    RedBlackNode<T> leftNode;
    RedBlackNode<T> rightNode;
}

/**
 * Tree Interfaces below
 */
interface ITree<T extends Comparable<T>> {
    ITree<T> insertNode(T data);

    void delete(T data);

    boolean isEmpty();

    T getMax();

    T getMin();

}

interface IAvlTree<T extends Comparable<T>> extends ITree<T> {
    void updateHeight(AvlTreeNode<T> node);

    int getBalanceFactor(AvlTreeNode<T> node);

    AvlTreeNode<T> applyRotation(AvlTreeNode<T> node);
}

interface IRedBlackTree<T extends Comparable<T>> extends ITree<T> {

}

/**
 * Concrete Tree Classes below
 */
class BSTree<T extends Comparable<T>> implements ITree<T> {

    BSTNode<T> root;

    @Override
    public ITree<T> insertNode(T data) {
        this.root = insertNode(this.root, data);
        return this;
    }

    private BSTNode<T> insertNode(BSTNode<T> node, T data) {
        if (node == null) {
            return new BSTNode<>(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.leftNode = insertNode(node.leftNode, data);
        } else if (data.compareTo(node.data) > 0) {
            node.rightNode = insertNode(node.rightNode, data);
        }
        return node;
    }

    @Override
    public void delete(T data) {
        this.root = delete(this.root, data);
    }

    private BSTNode<T> delete(BSTNode<T> node, T data) {
        if (node == null) return null;
        if (data.compareTo(node.data) < 0) {
            node.leftNode = delete(node.leftNode, data);
        } else if (data.compareTo(node.data) > 0) {
            node.rightNode = delete(node.rightNode, data);
        } else {
            // 0 or 1 child
            if (node.leftNode == null) return node.rightNode;
            if (node.rightNode == null) return node.leftNode;

            // 2 children
            node.data = getMax(node.leftNode);
            node.leftNode = delete(node.leftNode, node.data);
        }
        return node;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public T getMax() {
        if (isEmpty()) return null;
        return getMax(this.root);
    }

    private T getMax(BSTNode<T> node) {
        return node.rightNode != null ? getMax(node.rightNode) : node.data;
    }

    @Override
    public T getMin() {
        if (isEmpty()) return null;
        return getMin(this.root);
    }

    private T getMin(BSTNode<T> node) {
        return node.leftNode != null ? getMin(node.leftNode) : node.data;
    }

}

class AvlTree<T extends Comparable<T>> implements IAvlTree<T> {

    public AvlTreeNode<T> root;

    @Override
    public ITree<T> insertNode(T data) {
        this.root = insertNode(this.root, data);
        return this;
    }

    private AvlTreeNode<T> insertNode(AvlTreeNode<T> node, T data) {
        if (node == null) return new AvlTreeNode<>(data);
        if (data.compareTo(node.data) < 0) {
            node.leftNode = insertNode(node.leftNode, data);
        } else if (data.compareTo(node.data) > 0) {
            node.rightNode = insertNode(node.rightNode, data);
        } else return node;
        updateHeight(node);
        return applyRotation(node);
    }

    @Override
    public void delete(T data) {
        this.root = delete(this.root, data);
    }

    private AvlTreeNode<T> delete(AvlTreeNode<T> node, T data) {
        if (node == null) return null;
        if (data.compareTo(node.data) < 0) {
            node.leftNode = delete(node.leftNode, data);
        } else if (data.compareTo(node.data) > 0) {
            node.rightNode = delete(node.rightNode, data);
        } else {
//            1 or no children
            if (node.leftNode == null) return node.rightNode;
            if (node.rightNode == null) return node.leftNode;
//            2 children
            node.data = getMax(node.leftNode);
            node.leftNode = delete(node.leftNode, node.data);
        }
        updateHeight(node);
        return applyRotation(node);
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public T getMax() {
        return (isEmpty()) ? null : getMax(this.root);
    }

    private T getMax(AvlTreeNode<T> node) {
        return (node.rightNode != null) ? getMax(node.rightNode) : node.data;
    }

    @Override
    public T getMin() {
        return (isEmpty()) ? null : getMin(this.root);
    }

    private T getMin(AvlTreeNode<T> node) {
        return (node.leftNode != null) ? getMax(node.leftNode) : node.data;
    }

    @Override
    public void updateHeight(AvlTreeNode<T> node) {
        node.height = 1 + Math.max(getHeight(node.leftNode), getHeight(node.rightNode));
    }

    private int getHeight(AvlTreeNode<T> node) {
        return node == null ? 0 : node.height;
    }

    @Override
    public int getBalanceFactor(AvlTreeNode<T> node) {
        return node == null ? 0 : getHeight(node.leftNode) - getHeight(node.rightNode);
    }

    @Override
    public AvlTreeNode<T> applyRotation(AvlTreeNode<T> node) {
        int balance = getBalanceFactor(node);
        if (balance > 1) {
            if (getBalanceFactor(node.leftNode) < 0) {
                node.leftNode = rotateLeft(node.leftNode);
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (getBalanceFactor(node.rightNode) > 0) {
                node.rightNode = rotateRight(node.rightNode);
            }
            return rotateLeft(node);
        }
        return node;
    }

    public AvlTreeNode<T> rotateLeft(AvlTreeNode<T> node) {
        AvlTreeNode<T> rightNode = node.rightNode;
        AvlTreeNode<T> rightLeftNode = rightNode.leftNode;

        rightNode.leftNode = node;
        node.rightNode = rightLeftNode;
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    public AvlTreeNode<T> rotateRight(AvlTreeNode<T> node) {
        AvlTreeNode<T> leftNode = node.leftNode;
        AvlTreeNode<T> leftRightNode = leftNode.rightNode;
        leftNode.rightNode = node;
        node.leftNode = leftRightNode;
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }
}

/*
class RedBlackTree<T extends Comparable<T>> implements IRedBlackTree<T> {

    private RedBlackTree<T> root;

}*/
