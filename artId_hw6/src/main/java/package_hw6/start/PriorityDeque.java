package package_hw6.start;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class PriorityQueue<Type> extends AbstractQueue<Type> implements Queue<Type> {

    /**
     * Returns an iterator over the elements contained in this collection.
     *
     * @return an iterator over the elements contained in this collection
     */
    public Iterator<Type> iterator() {
        return null;
    }

    public int size() {
        return 0;
    }

    /**
     * Inserts the specified element into this queue if it is possible to do
     * so immediately without violating capacity restrictions.
     * When using a capacity-restricted queue, this method is generally
     * preferable to {@link #add}, which can fail to insert an element only
     * by throwing an exception.
     *
     * @param type the element to add
     * @return {@code true} if the element was added to this queue, else
     * {@code false}
     * @throws ClassCastException       if the class of the specified element
     *                                  prevents it from being added to this queue
     * @throws NullPointerException     if the specified element is null and
     *                                  this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *                                  prevents it from being added to this queue
     */
    public boolean offer(Type type) {
        return false;
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    public Type poll() {
        return null;
    }

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    public Type peek() {
        return null;
    }
}
