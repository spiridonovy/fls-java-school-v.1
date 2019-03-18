package MyCollection1;

import java.util.*;

public class MyMap<K, V> implements Map {
    private Entry<K, V>[] map;
    private int size;

    private class Entry<K, V> implements Map.Entry {

        K key;
        V value;

        Entry() {
        }

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(Object value) {
            this.value = (V) value;
            return this.value;
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }

    private class MyMapIterator implements Iterator<K> {
        private int index = -1;

        MyMapIterator() {
            index = -1;
        }

        @Override
        public boolean hasNext() {
            // return this.next()!=null;
            return (index < size && map[index + 1] != null);
        }

        @Override
        public K next() {
            index++;

            if (map[index] == null)
                return null;
            return map[index].getKey();
        }
    }

    public Iterator<K> iterator() {
        return new MyMapIterator();
    }

    public MyMap() {
        map = new Entry[10];
        size = -1;
    }

    public MyMap(Map<K, V> fromMap) {
        try {
            if (fromMap.isEmpty()) throw new IllegalArgumentException();
            var f = new ArrayList<Entry<K,V>>();
            fromMap.entrySet().forEach(entry -> {
                K k = entry.getKey();
                V v = entry.getValue();
                f.add(new Entry<>(k, v));
            });
            map = f.toArray(new Entry[fromMap.size()+1]);
            size = fromMap.size();
        } catch (IllegalArgumentException e) {
            System.out.println("Initial capacity is lower than 0");
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (size == -1)
            return false;
        var set = this.keySet();
        return set.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        if (size == 0)
            return false;
        for (var item : map) {
            if (item.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        if(containsKey(key)) {
            for (var item : map)
                if (item.getKey() == key) return item.getValue();
        }else throw new NoSuchElementException();
        return key;
    }


    @Override
    public Object put(Object key, Object value) {

        if (size + 1 <= map.length) {
            if (this.containsKey(key)) {
                return false;
            } else {
                map[size + 1] = new Entry(key, value);
                size = keySet().size();
                return true;
            }
        } else {
            Entry<K, V>[] newNode = new Entry[size + 3];
            System.arraycopy(map, 0, newNode, 0, map.length);
            return this.put(key, value);
        }
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        var keySet = new HashSet<K>();
        for (Iterator<K> it = this.iterator(); it.hasNext(); ) {
            keySet.add(it.next());

        }
        return keySet;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {

        var temp = new HashSet<Entry>();
        for (var entry : map) {
            if(entry==null)
                continue;
            temp.add(entry);
        }
        return temp;
    }
}
