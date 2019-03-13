package package_hw6.start;

import java.util.PriorityQueue;

public class PriorityDeque<Type> extends PriorityQueue<Type> {

    private Node<Type> firstNode;
    private Node<Type> lastNode;
    private int size;

    public PriorityDeque(){
        size = 0;
    }

    public boolean add(Type unit, int priority) {

        Node<Type> newNode = new Node<Type>(unit, priority, null, null);

        if (size == 0){
            firstNode = lastNode = newNode;

        } else if (firstNode.getPriority() >= priority){
            newNode.setNext(firstNode);
            firstNode.setPrevious(newNode);
            firstNode = newNode;

        } else if((lastNode.getPriority() <= priority)) {
            newNode.setPrevious(lastNode);
            lastNode.setNext(newNode);
            lastNode = newNode;

        } else {
            insertInMiddle(newNode);
        }

        size++;
        return true;
    }

    public Type getFirst(){
        if (firstNode == null){
            System.out.println("Первый элемент пусто");
            throw new NullPointerException();
        }

        Node<Type> returnNode = firstNode;
        if (firstNode.getNext() == null){
            firstNode = lastNode = null;

        } else {
            firstNode.getNext().setPrevious(null);
            firstNode = firstNode.getNext();
        }

        size--;
        return returnNode.getUnit();
    }

    public Type getLast(){
        if (lastNode == null){
            System.out.println("Последний элемент пусто");
            throw new NullPointerException();
        }

        Node<Type> returnNode = lastNode;
        if (lastNode.getPrevious() == null){
            lastNode = firstNode = null;
        } else {
            lastNode.getPrevious().setNext(null);
            lastNode = lastNode.getPrevious();
        }

        size--;
        return returnNode.getUnit();
    }

    private void insertInMiddle(Node<Type> newNode){
        Node<Type> nextNode = firstNode;

        while (newNode.getPriority() > nextNode.getPriority()) {
                nextNode = nextNode.getNext();
        }

        newNode.setNext(nextNode);
        newNode.setPrevious(nextNode.getPrevious());

        nextNode.setPrevious(newNode);
        nextNode.getPrevious().setNext(newNode);

    }

    public int size() {
        return size;
    }
}
