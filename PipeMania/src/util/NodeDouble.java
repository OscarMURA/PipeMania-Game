package util;

public class NodeDouble<T> implements Node {

    private NodeDouble<T> next;
    private NodeDouble<T> prev;
    private T c;

    public NodeDouble(T c) {
        this.next = null;
        this.prev = null;
        this.c = c;
    }

    public NodeDouble<T> getNext() {
        return next;
    }

    public NodeDouble<T> getPrev() {
        return prev;
    }

    public void setNext(NodeDouble<T> next) {
        this.next = next;
    }

    public void setPrev(NodeDouble<T> prev) {
        this.prev = prev;
    }

    @Override
    public T getContent() {
        return c;
    }

    @Override
    public void setContent(Object p) {
        c = ((T)(p));
    }

    @Override
    public String toString() {
        return "Nodo: " + c.toString() + ".";
    }

    public NodeDouble<T> get(int index){
        NodeDouble<T> node;
        if(index == 0){
            node = this;
        }else{
            node = next.get(index-1);
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

    public void remove(int index){
        if(index == 0){
            NodeDouble<T> tempNext = next;
            NodeDouble<T> tempPrev = prev;
            next.setPrev(tempPrev);
            prev.setNext(tempNext);
            c = null;
        }else{
            next.remove(index-1);
        }
    }

    public String showAll(){
        String out = "";
        if(next == null){
            out = toString();
        }else{
            out = toString() + next.showAll();
        }
        return out;
    }

}