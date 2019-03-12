package com.collection;

import java.util.*;

public class Vector<T> extends AbstractList<T>
        implements List<T> {
    private int elementCount;
    private T[] vectorPtr;

    public Vector(int vectorSize){
        elementCount = 0;
        if (vectorSize < 0){
            throw new IllegalArgumentException();
        }
        vectorPtr = (T[]) new Object[vectorSize];
    }

    public Vector(){
        elementCount = 0;
        vectorPtr = (T[]) new Object[10];
    }

    /**
     * Returns the number of elements stored in this Vector.
     *
     * @return the number of elements in this Vector
     */
    public int size() {
        return elementCount;
    }

    /**
     * Returns true if this Vector is empty, false otherwise
     *
     * @return true if the Vector is empty, false otherwise
     */
    public boolean isEmpty(){
        //  Возвращает true если вектор пуст
        return elementCount == 0;
    }

    /**
     * Returns true when element is contained in this Vector.
     *
     * @param element the element to check
     * @return true if the object is contained in this Vector, false otherwise
     */
    public boolean contains(Object element){
        for (int i = 0; i < vectorPtr.length; i++){
            if (vectorPtr[i] == element){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the element at position index.
     *
     * @param index the position from which an element will be retrieved
     * @return the element at that position
     * @since 1.2
     */
    public T get(int index){
        return vectorPtr[index];
    }

    /**
     * Adds an object at the specified index.  Elements at or above
     * index are shifted up one position.
     *
     * @param index the index at which to add the element
     * @param element the element to add to the Vector
     * @throws ArrayIndexOutOfBoundsException index < 0 || index > vectorPtr.length
     */
    public void add(int index, T element){
        if (index < 0 || index > vectorPtr.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        else {
            // буферный массив для сохранения новых элментов вектора
            T buf[] = (T[]) new Object[vectorPtr.length + 1];
            elementCount++;
            System.arraycopy(vectorPtr, 0, buf, 0, vectorPtr.length - index);
            buf[index] = element;
            System.arraycopy(vectorPtr, index, buf, index + 1, vectorPtr.length - index);
            // выделяем память под новый увеличенный вектор
            vectorPtr = (T[]) new Object[buf.length];
            // копируем элементы из старого вектора в новый
            System.arraycopy(buf, 0, vectorPtr, 0, buf.length);
        }
    }

    /**
     * Adds an object to the Vector.
     *
     * @param element the element to add to the Vector
     * @return true, as specified by List
     */
    public boolean add(T element){
        if (elementCount == 0){
            vectorPtr = (T[]) new Object[1];
            vectorPtr[0] = element;
            elementCount++;
        }
        else {
            // Добавляет в конец вектора определённый элемент
            if (elementCount < vectorPtr.length - 1) {
                elementCount++;
                vectorPtr[elementCount] = element;
            } else {
                T buf[] = (T[]) new Object[vectorPtr.length + 1];
                elementCount++;
                System.arraycopy(vectorPtr, 0, buf, 0, vectorPtr.length);
                // последний элемент это новый элемент
                buf[buf.length - 1] = element;
                // выделяем память под новый увеличенный вектор
                vectorPtr = (T[]) new Object[buf.length];
                // копируем элементы из старого вектора в новый
                System.arraycopy(buf, 0, vectorPtr, 0, buf.length);
            }
        }
        return true;
    }

    public T remove(int index){
        if (index > elementCount || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        T temp = vectorPtr[index];
        elementCount--;
        if (index < elementCount) {
            System.arraycopy(vectorPtr, index + 1, vectorPtr,
                    index, elementCount - index);
        }
        vectorPtr[elementCount] = null;
        return temp;
    }

    /**
     * Clears all elements in the Vector and sets its size to 0.
     */
    public void clear(){
        if (elementCount == 0){
            return;
        }
        elementCount = 0;
        vectorPtr = null;
    }

    /**
     * Returns the first element (index 0) in the Vector.
     *
     * @return the first Object in the Vector
     */
    public T firstElement(){
        return vectorPtr[0];
    }

    /**
     * Returns the last element in the Vector.
     *
     * @return the last Object in the Vector
     */
    public T lastElement(){
        return vectorPtr[elementCount];
    }


    public Iterator<T> iterator(){
        Iterator<T> it = new Iterator<T>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < elementCount &&
                        vectorPtr[currentIndex] != null;
            }

            @Override
            public T next() {
                return vectorPtr[currentIndex++];
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

}

