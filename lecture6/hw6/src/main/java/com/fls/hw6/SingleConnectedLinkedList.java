package com.fls.hw6;

import java.util.*;

public class SingleConnectedLinkedList<E> implements List<E> {

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    private class Itr implements Iterator<E> {
        Node<E> prevFirstNode = new Node<>(null, first);
        Node<E> itNode = prevFirstNode;

        @Override
        public boolean hasNext() {
            return itNode.next != null;
        }

        @Override
        public E next() {
            itNode = itNode.next;
            return itNode.item;
        }

        @Override
        public void remove() {
            if (itNode == first) {
                unlinkFirst();
                prevFirstNode.next = first;
                itNode = prevFirstNode;
            } else {
                Node<E> prev = getPrevNode(itNode);
                prev.next = itNode.next;
                itNode.next = null;
                itNode.item = null;
                itNode = prev;
            }
            size--;
        }
    }

    private int size = 0;

    private Node<E> first;

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
        return new Itr();
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = first; x != null; x = x.next)
            result[i++] = x.item;
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e, first);
        first = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x = next;
        }
        first = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    @Override
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> node = node(index);
        E oldElem = node.item;
        node.item = element;
        return oldElem;
    }

    @Override
    public void add(int index, E element) {
        checkElementIndex(index + 1);
        Node<E> newNode = new Node<>(element, null);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node<E> prev = node(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);
        E element;
        if (index == 0) {
            element = unlinkFirst();
        } else {
            Node<E> itNode = first;
            for (int i = 0; i < index - 1; i++)
                itNode = itNode.next;
            Node<E> nodeToRemove = itNode.next;
            element = nodeToRemove.item;
            itNode.next = nodeToRemove.next;
            nodeToRemove.next = null;
        }
        size--;
        return element;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = 0;
        int lastIndex = -1;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    lastIndex = index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    lastIndex = index;
                index++;
            }
        }
        return lastIndex;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private Node<E> node(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    private E unlinkFirst() {
        E element = first.item;
        Node<E> nodeToUnlink = first;
        first = nodeToUnlink.next;
        nodeToUnlink.next = null;
        return element;
    }

    private Node<E> getPrevNode(Node<E> node) {
        for (Node<E> x = first; x != null; x = x.next) {
            if (x.next == node) {
                return x;
            }
        }
        return null;
    }
}
