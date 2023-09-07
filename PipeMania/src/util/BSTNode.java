package util;

public class BSTNode<T extends  Comparable<T>> implements Node {

    private T value;
    private BSTNode<T> parent;
    private int size;

    private BSTNode <T> left;


    private BSTNode <T> right;

    public BSTNode(Object value) {
        this.value = (T) value;
        this.left = null;
        this.right = null;
    }

    public BSTNode<T> getParent() {
        return parent;
    }

    public int getSize() {
        return size;
    }

    public void setParent(BSTNode<T> parent) {
        this.parent = parent;
    }

    public T getContent() {
        return this.value;
    }

    @Override
    public void setContent(Object p) {
        this.value = (T) p;
    }

    public BSTNode<T> getLeft() {
        return this.left;
    }

    public BSTNode<T> getRight() {
        return this.right;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    public void setRight(BSTNode<T> right) {
        this.right = right;
    }



}
