package fls.java.school.lecture6;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class HashSet<T> implements Set<T> {

    private Entry<T>[] buckets;
    private int size;

    public HashSet() {
        buckets = new Entry[16];
        size = 0;
    }

    public HashSet(int capacity) {
        try {
            if (capacity < 0) throw new IllegalArgumentException();
            buckets = new Entry[capacity];
            size = 0;
        }
        catch (IllegalArgumentException e) {
            System.out.println("Initial capacity is lower than 0");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    @Override
    public boolean contains(Object element) {
        int index = hashFunction(element.hashCode());
        Entry current = buckets[index];

        while (current != null) {
            if (current.getData().equals(element)) { return true;}
            current = current.getNext();
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Entry[] array = new Entry[size];
        int index = 0;

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                Entry current = buckets[i];
                while (current != null) {
                    array[index] = current;
                    index++;
                    current = current.getNext();
                }
            }
        }

        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public boolean add(T element) {
        int index = hashFunction(element.hashCode());
        Entry current = buckets[index];

        while (current != null) {
            if (current.getData().equals(element)) { return false; }
            current = current.getNext();
        }

        Entry entry = new Entry();
        entry.setData(element);

        entry.setNext(buckets[index]);
        buckets[index] = entry;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object element) {
        int index = hashFunction(element.hashCode());
        Entry current = buckets[index];
        Entry previous = null;

        while (current != null) {
            if (current.getData().equals(element)) {
                if (previous == null) { buckets[index] = current.getNext(); }
                else { previous.setNext(current.getNext()); }
                size--;
                return true;
            }

            previous = current;
            current = current.getNext();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        if (c.size() == 0) return false;

        Iterator<T> it = c.iterator();
        while (it.hasNext()) {
            T tmp = it.next();
            if (!this.contains(tmp)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        if (c.size() == 0) return false;

        Iterator<T> it = c.iterator();
        while (it.hasNext()) {
            this.add(it.next());
        }
        return true;

    }

    @Override
    public boolean removeAll(Collection c) {
        if (c.size() == 0) return false;

        Iterator<T> it = c.iterator();
        while (it.hasNext()) {
            T tmp = it.next();
            if (this.contains(tmp)) this.remove(tmp);
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
        if (c.size() == 0) return false;

        Iterator<T> it = this.iterator();
        while (it.hasNext()) {
            T tmp = it.next();
            if (!c.contains(tmp)) this.remove(tmp);
        }

        return true;
    }

    @Override
    public void clear() {
        if (size != 0) {
            Arrays.fill(buckets, null);
            size = 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public Iterator iterator() {
        return new HashSetIterator(buckets);
    }

    @Override
    public String toString() {
        Entry currentEntry = null;
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                currentEntry = buckets[i];
                sb.append("[" + i + "]");
                sb.append(" " + currentEntry.getData().toString());
                while (currentEntry.getNext() != null) {
                    currentEntry = currentEntry.getNext();
                    sb.append(" -> " + currentEntry.getData().toString());
                }
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    private int hashFunction(int hashCode) {
        int index = hashCode;
        if (index < 0) { index = -index; }
        return index % buckets.length;
    }

}
