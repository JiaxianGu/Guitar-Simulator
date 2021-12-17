package es.datastructur.synthesizer;
import java.util.Iterator;



public class ArrayRingBuffer<T> implements BoundedQueue<T>{
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    @Override
    public Iterator<T> iterator() {
        return new BoundedQueueIterator();
    }

    private class BoundedQueueIterator implements Iterator<T> {
        private int wizPos;

        public BoundedQueueIterator() {
            wizPos = 0;
        }

        public T next() {
            T returnItem = rb[wizPos];
            wizPos += 1;
            return returnItem;
        }

        public boolean hasNext() {
            return wizPos < fillCount();
        }
    }

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T []) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;

    }

    @Override
    public int capacity() {
        return rb.length;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {
        if (fillCount() == capacity()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        if (last == rb.length - 1) {
            last = 0;
        } else {
            last += 1;
        }
        fillCount = fillCount + 1;
        return;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {
        if (fillCount() == 0) {
            throw new RuntimeException("Ring Buffer underflow");
        }
        T returnValue = rb[first];
        if (first == rb.length - 1) {
            first = 0;
        } else {
            first += 1;
        }
        fillCount -= 1;
        return returnValue;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T peek() {
        T returnValue = rb[first];
        return returnValue;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if ( this.getClass() != o.getClass() ) {
            return false;
        }
        ArrayRingBuffer other = (ArrayRingBuffer) o;
        Iterator seer = this.iterator();
        Iterator seerO = other.iterator();
        while (seer.hasNext() && seerO.hasNext()) {
            if (seer.next() != seerO.next()) {
                return false;
            }
        }
        return true;
    }

}

