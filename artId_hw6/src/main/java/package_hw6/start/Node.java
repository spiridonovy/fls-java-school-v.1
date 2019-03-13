package package_hw6.start;

public class Node<Type> {
    private Type unit;
    private Node<Type> previous;
    private Node<Type> next;
    private int priority;

    public Node(Type unit, int priority, Node<Type> previous, Node<Type> next){
        this.unit = unit;
        this.previous = previous;
        this.next = next;
        this.priority = priority;
    }

    public Type getUnit(){
        return unit;
    }

    public Node<Type> getNext() {
        return next;
    }

    public Node<Type> getPrevious(){
        return previous;
    }

    public int getPriority(){
        return priority;
    }

    public void setNext(Node<Type> next){
        this.next = next;
    }

    public void setPrevious(Node<Type> previous){
        this.previous = previous;
    }
    
}
