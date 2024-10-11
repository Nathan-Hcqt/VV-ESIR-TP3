package fr.istic.vv;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {

    // Comparator for integers
    Comparator<Integer> comparator = Integer::compare;

    @Test
    void testPushAndPop() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(comparator);
        heap.push(3);
        heap.push(1);
        heap.push(2);

        assertEquals(1, heap.pop()); // Min is 1
        assertEquals(2, heap.pop()); // Next min is 2
        assertEquals(3, heap.pop()); // Finally 3
    }

    @Test
    void testPeek() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(comparator);
        heap.push(5);
        heap.push(1);
        heap.push(3);

        assertEquals(1, heap.peek()); // Peek should return 1 without removing it
        assertEquals(1, heap.pop());  // After peeking, pop should also return 1
    }

    @Test
    void testCount() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(comparator);
        assertEquals(0, heap.count()); // Initially empty

        heap.push(10);
        heap.push(20);
        assertEquals(2, heap.count()); // After adding two elements

        heap.pop();
        assertEquals(1, heap.count()); // After removing one element
    }

    @Test
    void testPopOnEmptyHeap() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(comparator);
        Exception exception = assertThrows(NoSuchElementException.class, heap::pop);
        assertEquals("Heap is empty", exception.getMessage());
    }

    @Test
    void testPeekOnEmptyHeap() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(comparator);
        Exception exception = assertThrows(NoSuchElementException.class, heap::peek);
        assertEquals("Heap is empty", exception.getMessage());
    }
}
