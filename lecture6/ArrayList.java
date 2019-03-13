package FLS.lesson6;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;


public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private int size;
    private Object[] data;

    ArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    ArrayList(int capacity) {
        if (capacity > 0) {
            this.data = new Object[capacity];
            this.size = 0;
        } else {
            if (capacity == 0) {
                this.data = EMPTY_ELEMENTDATA;
                this.size = 0;
            } else
                throw new IllegalArgumentException();
        }

    }

    public ArrayList(Collection<? extends E> c) {
        this.data = c.toArray();
        this.size = c.size();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new It();
    }

    private class It implements Iterator<E> {

        int cursor;

        It() {
            cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return (cursor < size && data[cursor] != null);
        }

        @Override
        public E next() {
            cursor++;
            if (data[cursor - 1] == null)
                throw new NoSuchElementException();
            return (E) data[cursor - 1];
        }

        @Override
        public void remove() {
            cursor--;
            if (cursor >= size)
                throw new IllegalStateException();
            ArrayList.this.remove(cursor);
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            throw new NotImplementedException();
        }
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public boolean add(E o) {
        ensureCapacity(size + 1);
        data[size++] = o;
        return true;
    }

    private void ensureCapacity(int newCapacity) {
        if (data.length - newCapacity <= 0) {
            data = Arrays.copyOf(data, newCapacity * 3 / 2 + 1);
        }
    }

    private boolean rangeCheck(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bound exception");
        else
            return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (data[index] == null) {
                    remove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(data[index])) {
                    remove(index);
                    return true;
                }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] tempArr = c.toArray();
        int newSize = c.size();
        ensureCapacity(size + newSize);
        System.arraycopy(tempArr, 0, data, size, newSize);
        size += newSize;
        return newSize != 0;
    }

    @Override
    public void sort(Comparator<? super E> c) {
        Arrays.sort((E[]) data, 0, size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        rangeCheck(index);

        Object[] tempArr = c.toArray();
        int newSize = c.size();
        ensureCapacity(size + newSize);

        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(data, index, data, index + newSize, numMoved);

        System.arraycopy(tempArr, 0, data, index, newSize);
        size += newSize;
        return newSize != 0;
    }

    @Override
    public void replaceAll(UnaryOperator operator) {
        throw new NotImplementedException();
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return (E) data[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        Object oldValue = data[index];
        data[index] = element;
        return (E) oldValue;
    }

    @Override
    public void add(int index, E element) {
        rangeCheck(index);
        ensureCapacity(size + 1);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldValue = (E) data[index];

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(data, index + 1, data, index, numMoved);
        size--;
        data = Arrays.copyOf(data, size);

        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (data[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(data[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--)
                if (data[i] == null)
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (o.equals(data[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListIt(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        rangeCheck(index);
        return new ListIt(index);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        rangeCheck(fromIndex);
        rangeCheck(toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("Illegal argument exception");
        List<Object> tempList = new LinkedList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            tempList.add(this.data[i]);
        }
        return tempList;
    }

    @Override
    public Spliterator spliterator() {
        throw new NotImplementedException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean changes = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(this.data[i])) {
                remove(i);
                i--;
                changes = true;
            }
        }
        return changes;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changes = false;
        for (int i = 0; i < size; i++) {
            if (c.contains(this.data[i])) {
                remove(i);
                i--;
                changes = true;
            }
        }
        return changes;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int countElem = 0;
        Iterator<E> it = (Iterator<E>) c.iterator();
        while (it.hasNext()) {
            if (contains(it.next()))
                countElem++;
        }
        if (countElem == c.size())
            return true;
        else
            return false;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(data, size, a.getClass());
        System.arraycopy(data, 0, a, 0, size);
        return a;
    }

    private class ListIt extends It implements ListIterator<E> {
        ListIt(int index) {
            super();
            cursor = index;
        }

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        public E previous() {
            if(data[cursor-1]!=null)
                return (E) data[cursor-1];
            else
                throw  new NoSuchElementException();
        }

        @Override
        public int nextIndex() {
            if(cursor+1<size)
                return cursor+1;
            else
                return size;
        }

        @Override
        public int previousIndex() {
            if(cursor>0)
                return cursor-1;
            else
                return -1;
        }

        @Override
        public void set(E e) {
            ArrayList.this.set(cursor,e);
        }

        @Override
        public void add(E e) {
            rangeCheck(cursor+1);
            ArrayList.this.add(cursor+1,e);
        }
    }
}
