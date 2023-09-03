package util;

public class BSTNode<T extends  Comparable<T>> {

    private T value;
    private BSTNode parent;
    private int size;

    private BSTNode left;


    private BSTNode right;

    public BSTNode(T value) {
        this.value = value;
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

    public BSTNode(T value, BSTNode left, BSTNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return this.value;
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
