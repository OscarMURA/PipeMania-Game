package util;

/**
 * The BSTNode class represents a node in a binary search tree, storing a value of type T and
 * references to its parent, left child, and right child.
 */
public class BSTNode<T extends  Comparable<T>> implements Node {

    /**The line `private T value;` is declaring a private instance variable `value` of type `T`. The
     type `T` is a generic type parameter that represents the type of value that will be stored in
     the node. By using a generic type parameter, the `BSTNode` class can be used to store values of
     any type that implements the `Comparable` interface. */ 
    private T value;
    /**The line `private BSTNode<T> parent;` is declaring a private instance variable `parent` of type
    BSTNode<T>`. This variable represents the parent node of the current node in a binary search
     tree. It is used to maintain the hierarchical relationship between nodes in the tree. */ 
    private BSTNode<T> parent;
    /**The line `private BSTNode<T> left;` is declaring a private instance variable `left` of type*/
    private int size;

    
    /** The line `private BSTNode<T> left;` is declaring a private instance variable `left` of type
    `BSTNode<T>`. This variable represents the left child node of the current node in a binary
     search tree. It is used to maintain the hierarchical relationship between nodes in the tree*/ 
    private BSTNode <T> left;


    /**The line `private BSTNode<T> right;` is declaring a private instance variable `right` of type
    `BSTNode<T>`. This variable represents the right child node of the current node in a binary
     search tree. It is used to maintain the hierarchical relationship between nodes in the tree. */ 
    private BSTNode <T> right;

    private BSTNode <T> dad;

    public BSTNode(Object value) {
        this.value = (T) value;
        this.left = null;
        this.right = null;
        this.dad = null;
    }

    /**
     * The function returns the parent node of a binary search tree node.
     * 
     * @return The method is returning the parent node of the current node in a binary search tree.
     */
    public BSTNode<T> getParent() {
        return parent;
    }

    /**
     * The getSize() function returns the size of an object.
     * 
     * @return The method is returning the value of the variable "size".
     */
    public int getSize() {
        return size;
    }

    /**
     * The function sets the parent of a binary search tree node.
     * 
     * @param parent The parent parameter is of type BSTNode<T>, which represents the parent node of
     * the current node in a binary search tree.
     */
    public void setParent(BSTNode<T> parent) {
        this.parent = parent;
    }

    /**
     * The getContent() function returns the value of the content.
     * 
     * @return The method is returning the value of type T.
     */
    public T getContent() {
        return this.value;
    }

    /**
     * The function sets the value of a variable to the input parameter.
     * 
     * @param p The parameter "p" is of type Object, which means it can accept any type of object as an
     * argument.
     */
    @Override
    public void setContent(Object p) {
        this.value = (T) p;
    }

    /**
     * The function returns the left child of a binary search tree node.
     * 
     * @return The left child node of the current node in a binary search tree.
     */
    public BSTNode<T> getLeft() {
        return this.left;
    }

    /**
     * The function returns the right child of a binary search tree node.
     * 
     * @return The right child node of the current node in a binary search tree.
     */
    public BSTNode<T> getRight() {
        return this.right;
    }

    /**
     * The function sets the value of a variable.
     * 
     * @param value The parameter "value" is of type T, which means it can be any type specified when
     * the method is called.
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * The function sets the left child of a binary search tree node.
     * 
     * @param left The parameter "left" is of type BSTNode<T>, which represents the left child of a
     * binary search tree node.
     */
    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    /**
     * The function sets the right child of a binary search tree node.
     * 
     * @param right The "right" parameter is of type BSTNode<T>, which represents the right child of a
     * binary search tree node.
     */
    public void setRight(BSTNode<T> right) {
        this.right = right;
    }

    public BSTNode<T> getDad(){
        return dad;
    }

    public void setDad(BSTNode<T> dad){
        this.dad = dad;
    } 

}