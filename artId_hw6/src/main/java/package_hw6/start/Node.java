package package_hw6.start;

public class NodeQ<Type> {
    private Type unit;
    private NodeQ previous;
    private NodeQ next;
    private int priority;

    public NodeQ(Type unit, int priority, NodeQ previous, NodeQ next){
        this.unit = unit;
        this.previous = previous;
        this.next = next;
        this.priority = priority;
    }

    public Type getUnit(){
        return unit;
    }

    public NodeQ getNext() {
        return next;
    }

    public NodeQ getPrevious(){
        return previous;
    }

    public int getPriority(){
        return priority;
    }
}
