package fls.java.school.lecture6;

public class Entry<E> {
    private E data;
    private Entry next;

    public E getData() {
        return data;
    }

    public Entry getNext() {
        return next;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setNext(Entry next) {
        this.next = next;
    }
}
