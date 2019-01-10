/**
 * 
 */
package spacecolonies;

import queue.EmptyQueueException;

/**
 * @author Goodwin Lu
 * @version 11/7/2018
 *          circular array using [en/de]queueIndex and size, with default
 *          capacity 10 and max capacity of 100
 * @param <T>
 *            the type.
 */
public class ArrayQueue<T> implements queue.QueueInterface<T> {
    private T[] queue;
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * the max capacity.
     */
    public static final int MAX_CAPACITY = 100;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;


    /**
     * defualt constructor using default capacity.
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }


    /**
     * constructor with parameter
     * 
     * @param initialCapacity
     *            set capacity
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity) {
        queue = (T[])new Object[initialCapacity + 1];
        size = 0;
        enqueueIndex = 0;
        dequeueIndex = initialCapacity;

    }


    /**
     * dequeue method (throws EmptyQueueException). Removes the front.
     * 
     * @return
     *         the thing dequeued
     */
    public T dequeue() {
        if (isEmpty()) {
            throw (new EmptyQueueException("Tried to dequeue from empty"));
        }
        T front = queue[enqueueIndex];
        queue[enqueueIndex] = null;
        enqueueIndex = (enqueueIndex + 1) % queue.length;
        size--;
        return front;
    } // end dequeue


// optional helper methods are ensureCapacity and incrementIndex. (not
// implemented here)
    /**
     * reset values.
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        size = 0;
        enqueueIndex = 0;
        dequeueIndex = DEFAULT_CAPACITY;
    }


    /**
     * enqueue, doubles size if the queue is full and doesn't exceed capacity
     * 
     * @param newEntry
     *            the object to put in
     */
    public void enqueue(T newEntry) {
        if (size > MAX_CAPACITY) {
            throw (new IllegalStateException("Capacity exceeded maximum"));
        }
        if (isFull()) { // double size of array
            System.out.println("Array is full");
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = size * 2 + 1;
            if (newSize > MAX_CAPACITY) {

                throw (new IllegalStateException("Capacity exceeded maximum"));
            }
            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[])new Object[newSize];
            queue = tempQueue;
            for (int index = 0; index < oldSize - 1; index++) {
                queue[index] = oldQueue[enqueueIndex];
                enqueueIndex = (enqueueIndex + 1) % oldSize;
            } // end for
            enqueueIndex = 0;
            dequeueIndex = oldSize - 2;
        } // end if
        size++;
        dequeueIndex = (dequeueIndex + 1) % queue.length;
        queue[dequeueIndex] = newEntry;
    }


    /**
     * get size
     * 
     * @return
     *         size (how many elements in array)
     */
    public int getSize() {
        return size;
    }


    /**
     * get length of Queue array
     * 
     * @return
     *         length
     */
    public int getLength() {
        // return (size - enqueueIndex + dequeueIndex) % size + 1;
        return queue.length;
    }


    /**
     * if empty
     * 
     * @return
     *         true/false
     */
    public boolean isEmpty() {
        return (enqueueIndex == (dequeueIndex + 1) % queue.length);
    }


    /**
     * if full
     * 
     * @return
     *         true/false
     */
    private boolean isFull() {
        return (enqueueIndex == (dequeueIndex + 2) % queue.length);
    }


    /**
     * return the array version of the arrayQueue.
     * 
     * @return
     *         object array
     */
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        Object[] a = new Object[size];
        // count from enqueue, without manipulating it
        for (int i = 0; i < size; i++) {
            int j = (enqueueIndex + i) % queue.length;
            a[i] = queue[j];
            System.out.println("A at " + i + " was " + a[i].toString());
            // "Increment" The index from queue
        }
        return a;
    }


    /**
     * tostring method
     * 
     * @return
     *         string version, "[]" if empty
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            // "Increment" The index from queue
            int j = (enqueueIndex + i) % queue.length;
            sb.append(queue[j].toString());
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    /**
     * get the front element
     * 
     * @return
     *         front
     */
    public T getFront() {
        if (isEmpty()) {
            throw (new EmptyQueueException("Tried to access front of empty"));
        }
        T front = null;
        front = queue[enqueueIndex];
        return front;
    }


    /**
     * see if two arrays are equal, through checking each element
     * 
     * @return
     *         true or false
     * @param obj
     *            The object
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // they cannot be equal if their sizes are different, or if obj is null,
        // or if their classes are different
        if (obj == null || this.getClass() != obj.getClass() || (this
            .getSize() != ((ArrayQueue<T>)obj).getSize())) {
            return false;
        }
        boolean same = true;
        // System.out.println("Size during equals was " + size);
        for (int i = 0; i < size; i++) {
            T myElement = queue[(enqueueIndex + i) % queue.length];
            ArrayQueue<T> temp = (ArrayQueue<T>)obj;
            int currIndex = (temp.enqueueIndex + i) % temp.queue.length;
            T otherElement = (T)(temp.queue[currIndex]);

            System.out.println("myEle: " + myElement + " Other: "
                + otherElement);

            if (myElement != null && !myElement.equals(otherElement)) {
                same = false;
            }

        }

        return same;
    }
}
