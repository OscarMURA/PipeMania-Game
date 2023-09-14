package util;

/**
 * The BST class is a generic binary search tree implementation that allows for adding elements,
 * getting the maximum element, checking if the tree is empty, and printing the elements in order.
 */
public class BST <T extends Comparable<T>>  extends Collections{
    /**The line `private BSTNode<T> root;` is declaring a private instance variable `root` of type
     `BSTNode<T>`. This variable represents the root node of the binary search tree.*/
    private BSTNode<T> root;

    
    public BST() {
        root=null;
    }

    /**
    // The `add(Object object)` method is used to add an element to the binary search tree.
     * The add method adds a new node with the given value to the binary search tree.
     * 
     * @param object The object parameter is the value that you want to add to the binary search tree.
     */
    @Override
    public void add(Object object) {
        T value = (T) object;
        if(root==null){
            root=new BSTNode<>(value);
        }else{
            BSTNode<T> node=new BSTNode<>(value);
            add(root, node);
        }
    }
    /**
     * The add function inserts a node into a binary search tree based on its content.
     * 
     * @param current The current node in the binary search tree where we are currently checking for
     * the correct position to insert the new node.
     * @param node The node that you want to add to the binary search tree.
     */
    public void add(BSTNode<T> current, BSTNode<T> node){
        if((current.getContent().compareTo(node.getContent())>0)){
            if (current.getLeft() == null) {
                current.setLeft(node);
            } else {
                add(current.getLeft(), node);
            }

        }else if(current.getContent().compareTo(node.getContent())<0){

            if (current.getRight()==null){
                current.setRight(node);

            }else {
                add(current.getRight(),node);
            }
        }
    }
    /**
     * The function returns a string representation of the in-order traversal of a binary tree using
     * the toString() method.
     * 
     * @return The method is returning a String.
     */
    public String inOrdenWithToString(){
        return inOrdenWithToString(root);
    }

    private String inOrdenWithToString(BSTNode<T> current){
        String result="";
        if(current!=null){
            result+=inOrdenWithToString(current.getLeft());
            result+="* "+current.getContent().toString()+"\n";
            result+=inOrdenWithToString(current.getRight());
        }
        return result;
    }

    /**
     * The function returns the maximum value in a binary tree.
     * 
     * @return The method is returning the maximum value in the binary tree.
     */
    public T getMaximum(){
        return getMaximum(root);
    }

    /**
     * The function recursively finds and returns the maximum value in a binary search tree.
     * 
     * @param current The current node being evaluated in the binary search tree.
     * @return The maximum value in the binary search tree.
     */
    private T getMaximum(BSTNode<T> current){
        T result;
        if(current.getRight()==null){
            result= current.getContent();
        }else{
            result= getMaximum(current.getRight());
        }
        return result;
    }

    /**
     * The function checks if the root of a data structure is null and returns true if it is,
     * indicating that the data structure is empty.
     * 
     * @return The method is returning a boolean value, which indicates whether the root of the data
     * structure is null or not. If the root is null, it means that the data structure is empty, so the
     * method will return true. Otherwise, it will return false.
     */
    @Override
    public boolean isEmpty() {
        return root==null;
    }



}
