package util;

public class NodeDouble implements Node {

    private NodeDouble next;
    private NodeDouble prev;
    private Object c;

    public NodeDouble(Object c) {
        this.next = null;
        this.prev = null;
        this.c = c;
    }

    public NodeDouble getNext() {
        return next;
    }

    public NodeDouble getPrev() {
        return prev;
    }

    public void setNext(NodeDouble next) {
        this.next = next;
    }

    public void setPrev(NodeDouble prev) {
        this.prev = prev;
    }

    @Override
    public Object getContent() {
        return c;
    }

    @Override
    public void setContent(Object p) {
        c = p;
    }

    @Override
    public String toString() {
        return "Nodo: " + c.toString() + ".";
    }
}