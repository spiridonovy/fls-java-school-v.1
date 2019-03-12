package fls.java.school.lecture6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashSetIterator<T> implements Iterator {
    private int currentPointer;
    private int previousPointer;
    private Entry<T> currentEntry;
    private Entry<T> previousEntry;
    private Entry<T>[] buckets;

    public HashSetIterator(Entry<T>[] buckets) {
        currentEntry = null;
        previousEntry = null;
        currentPointer = -1;
        previousPointer = -1;
        this.buckets = buckets;
    }

    @Override
    public boolean hasNext() {
        if (currentEntry != null && currentEntry.getNext() != null) { return true; }

        for (int i = currentPointer + 1; i < buckets.length; i++) {
            if (buckets[i] != null) { return true; }
        }

        return false;
    }

    @Override
    public T next() {
        previousEntry = currentEntry;
        previousPointer = currentPointer;

        if (currentEntry == null || currentEntry.getNext() == null) {
            currentPointer++;
            while (currentPointer < buckets.length && buckets[currentPointer] == null) {
                currentPointer++;
            }

            if (currentPointer < buckets.length) {
                currentEntry = buckets[currentPointer];
            }
            else {
                throw new NoSuchElementException();
            }
        }
        else { currentEntry = currentEntry.getNext(); }
        return currentEntry.getData();
    }
}
