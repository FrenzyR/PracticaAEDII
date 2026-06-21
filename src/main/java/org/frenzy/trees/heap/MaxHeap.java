package org.frenzy.trees.heap;

import java.util.Arrays;

public class MaxHeap {
    private int[] heap;

    private int size;

    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }


    private void resize() {
        this.capacity *= 2;
        this.heap = Arrays.copyOf(heap, capacity);
    }

    private void
    swap(int i, int j) {
        int aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    public void insert(int value) {
        if (this.size >= this.capacity) {
            resize();
        }

        this.heap[this.size] = value;

        int current = this.size;

        this.size++;

        while (current > 0 && this.heap[current] >= this.heap[this.parent(current)]) {
            this.swap(current, this.parent(current));

            current = this.parent(current);
        }
    }

    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }
}
