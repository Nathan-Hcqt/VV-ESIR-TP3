package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

class BinaryHeap<T> {
    private ArrayList<T> heap;
    private Comparator<T> comparator;

    public BinaryHeap(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    // Pop: remove and return the minimum element (root)
    public T pop() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        T minElement = heap.get(0);
        T lastElement = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }
        return minElement;
    }

    // Peek: return the minimum element without removing it
    public T peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0);
    }

    // Push: add a new element to the heap
    public void push(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    // Count: return the number of elements in the heap
    public int count() {
        return heap.size();
    }

    // Heapify down (used after removing the root)
    private void heapifyDown(int index) {
        int leftChildIdx = 2 * index + 1;
        int rightChildIdx = 2 * index + 2;
        int smallest = index;

        if (leftChildIdx < heap.size() && comparator.compare(heap.get(leftChildIdx), heap.get(smallest)) < 0) {
            smallest = leftChildIdx;
        }
        if (rightChildIdx < heap.size() && comparator.compare(heap.get(rightChildIdx), heap.get(smallest)) < 0) {
            smallest = rightChildIdx;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Heapify up (used after adding a new element)
    private void heapifyUp(int index) {
        if (index == 0) return; // Already at the root
        int parentIdx = (index - 1) / 2;
        if (comparator.compare(heap.get(index), heap.get(parentIdx)) < 0) {
            swap(index, parentIdx);
            heapifyUp(parentIdx);
        }
    }

    // Swap elements at two indices in the heap
    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}



