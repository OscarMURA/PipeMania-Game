package util;

public class BSTNode {
    private int value;

    private BSTNode parent;
    private BSTNode left;
    private BSTNode right;


    public BSTNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        parent = null;

    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BSTNode getLeft() {
        return left;
    }


    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }


    public void setRight(BSTNode right) {
        this.right = right;
    }

    public BSTNode getParent() {
        return parent;
    }

    public void setParent(BSTNode parent) {
        this.parent = parent;
    }

    public int branchNumber() {
        int count = 0;
        if (this.left == null && this.right == null) {
            count = -1;
        } else {
            if (this.left != null) {
                count += left.branchNumber() + 1;
            }
            if (this.right != null) {
                count += right.branchNumber() + 1;
            }
        }
        return count;
    }
}
