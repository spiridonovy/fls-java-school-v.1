import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MagicSet<T> implements Set, Iterable {
    private final static int FIXED_SIZE = 100;
    T[] set = (T[]) new Object[FIXED_SIZE];

    public MagicSet() {}

    public MagicSet(T data) {
        set[0] = data;
    }

    public MagicSet(T... data) throws Exception {
        if (data.length > 100)
            throw new Exception("Too much arguments.");
        else {
            Arrays.sort(data);
            for (int i = 0; i < data.length; i++) {
                set[i] = data[i];
            }
        }
    }

    @Override
    public int size() {
        return FIXED_SIZE;
    }

    @Override
    public boolean isEmpty() {
        return (capacity() == 100);
    }

    @Override
    public boolean contains(Object o) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext())
            if (iterator.next() == o)
                return true;
        return false;
    }

    @Override
    public Iterator iterator() {
        return new MagicSetIterator();
    }

    private class MagicSetIterator implements Iterator {
        private int index = 0;
        public boolean hasNext() {
            return index < FIXED_SIZE;
        }

        public T next() {
            return set[index++];
        }
    }

    @Override
    public T[] toArray() {
        return set;
    }

    @Override
    public boolean add(Object o) {
        for (int i = 0; i < FIXED_SIZE; i++) {
            if (set[i] == null) {
                set[i] = (T) o;
                return true;
            }
        }
        System.out.println("Could not add, set is full.");
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < FIXED_SIZE; i++) {
            if (set[i] == o) {
                set[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        if (capacity() < c.size()) {
            System.out.println("Can not add, too much arguments");
            return false;
        } else {
            Iterator iterator = c.iterator();
            for (int i = 0; i < FIXED_SIZE; i++) {
                if (set[i] == null) {
                    set[i] = (T) iterator.next();
                }
            }
            return true;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < FIXED_SIZE; i++)
            set[i] = null;
    }

    @Override
    public boolean removeAll(Collection c) {
        Iterator iterator = c.iterator();
        try {
            while (iterator.hasNext()) {
                T obj = (T) iterator.next();
                remove(obj);
            }
        } catch (Exception e) {
            System.out.println("Something gone wrong.");
            return false;
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean containsAll(Collection c) {
        Iterator iterator = c.iterator();
        try {
            while (iterator.hasNext()) {
                T obj = (T) iterator.next();
                contains(obj);
            }
        } catch (Exception e) {
            System.out.println("Something gone wrong.");
            return false;
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new NotImplementedException();
    }

    public int capacity() {
        int res = 0;
        for (int i = 0; i < FIXED_SIZE; i++) {
            if (set[i] == null)
                res++;
        }
        return res;
    }

    public int occupied() {
        int res = 0;
        for (int i = 0; i < FIXED_SIZE; i++) {
            if (set[i] != null)
                res++;
        }
        return res;
    }

    public void view() {
        for (int i = 0; i < FIXED_SIZE; i++) {
            if (set[i] != null)
                System.out.print(set[i] + " ");
        }
        System.out.println();
    }
}
