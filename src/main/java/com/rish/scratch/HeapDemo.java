package com.rish.scratch;

import java.util.Arrays;

public class HeapDemo {
    public static void main(String[] args) {

    }
}

interface IHeap<T extends Comparable<T>> {
    IHeap<T> insert(T data);

    T getRoot();

    void sort();
}

abstract class Heap<T extends Comparable<T>> implements IHeap<T> {

    protected T[] heap;
    protected int position = -1;

    public Heap() {
        heap = (T[]) new Comparable[2];
    }

    protected abstract void fixUpward();

    protected abstract void fixDownward(int endIndex);

    @Override
    public IHeap<T> insert(T data) {
        if (isFull()) {
            resize(heap.length * 2);
        }
        heap[++position] = data;
        fixUpward();
        return this;
    }

    @Override
    public T getRoot() {
        if (isEmpty()) {
            return null;
        }
        T result = heap[0];
        heap[0] = heap[position--];
        heap[position + 1] = null;
        fixDownward(position);
        return result;
    }

    @Override
    public void sort() {
        for (int i = 0; i <= position; i++) {
            swap(0, position - i);
            fixDownward(position - i - 1);
        }
        print();
    }

    protected void swap(int firstIndex, int secondIndex) {
        T temp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[firstIndex] = temp;
    }

    private void resize(int capacity) {
        System.arraycopy(heap, 0, heap = (T[]) new Comparable[capacity], 0, position + 1);
    }

    private boolean isFull() {
        return position == heap.length - 1;
    }

    private boolean isEmpty() {
        return heap.length == 0;
    }

    private void print() {
        Arrays.stream(heap).forEach(item -> System.out.print(item + " -> "));
        System.out.println();
    }

}

class MaximumHeap<T extends Comparable<T>> extends Heap<T> {

    @Override
    protected void fixUpward() {
        int index = position;
        int parentIndex = (index - 1) / 2;
        // FIXME - The next 4 lines look buggy.
        // TODO - The second condition should go to the if block inside while block
        while (parentIndex >= 0 && heap[index].compareTo(heap[parentIndex]) > 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    @Override
    protected void fixDownward(int endIndex) {
        if (endIndex == -1) return;
        int index = 0;
        while (index <= endIndex) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            if (leftChildIndex > endIndex) break;
            int childToSwap = rightChildIndex > endIndex ?
                    leftChildIndex : heap[leftChildIndex].compareTo(heap[rightChildIndex]) > 0 ?
                    leftChildIndex : rightChildIndex;
            // FIXME - The next 3 lines look buggy
            // TODO - The condition when false should then execute swapping, else continue
            if (heap[index].compareTo(heap[childToSwap]) > 0) break;
            swap(index, childToSwap);
            index = childToSwap;
        }
    }
}

class MinimumHeap<T extends Comparable<T>> extends Heap<T> {

    @Override
    protected void fixUpward() {

    }

    @Override
    protected void fixDownward(int endIndex) {

    }
}