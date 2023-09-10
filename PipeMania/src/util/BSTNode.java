package util;

public class BSTNode<T extends  Comparable<T>> implements Node {

    private T value;
    private BSTNode parent;
    private int size;

    private BSTNode left;


    private BSTNode right;

    public BSTNode(Object value) {
        this.value = (T) value;
        this.left = null;
        this.right = null;
    }

    public BSTNode getParent() {
        return parent;
    }

    public int getSize() {
        return size;
    }

    public void setParent(BSTNode parent) {
        this.parent = parent;
    }

    public T getContent() {
        return this.value;
    }

    @Override
    public void setContent(Object p) {
        this.value = (T) p;
    }

    public BSTNode getLeft() {
        return this.left;
    }

    public BSTNode getRight() {
        return this.right;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }



}
