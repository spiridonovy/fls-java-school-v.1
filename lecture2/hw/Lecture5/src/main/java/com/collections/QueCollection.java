package com.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class QueCollection<E> implements java.util.Collection<E> {

    private List<E> collection;
    public QueCollection()
    {
        collection = new ArrayList<E>();
    }
    public int size() {
        return collection.size();
    }

    public boolean isEmpty() {
        return collection.isEmpty();
    }

    public boolean contains(Object o) {
        return collection.contains(o);
    }

    public Iterator<E> iterator() {
        return collection.iterator();
    }

    public Object[] toArray() {
        return collection.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return collection.toArray(a);
    }

    public boolean push(E e)
    {
        try
        {
            collection.add(e);
        }
        catch (UnsupportedOperationException ex)
        {
            return false;
        }
        return true;
    }
    public boolean add(E e) {
        return push(e);
    }
    public E pop()
    {
        E el = collection.get(collection.size()-1);
        collection.remove(el);
        return el;
    }
    public boolean remove(Object o) {
        return collection.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return collection.containsAll(c);
    }

    public boolean addAll(Collection<? extends E> c) {
        boolean isAllAdded = false;
        for (E el: c)
        {
            isAllAdded = this.push(el);
        }

        return isAllAdded;
    }

    public boolean removeAll(Collection<?> c) {
        return collection.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return collection.retainAll(c);
    }

    public void clear() {
        collection.clear();
    }
}
