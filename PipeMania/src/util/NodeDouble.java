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

    public NodeDouble get(int index){
        NodeDouble node;
        if(index == 0){
            node = this;
        }else{
            if(next == null){
                node = null;
            }else{
                node = next.get(index-1);
            }
        }
        return node;
    }

    public void set(int index, Object object){
        if(index == 0){
            this.setContent(object);
        }else{
            next.set(index-1, object);
        }
    }
}