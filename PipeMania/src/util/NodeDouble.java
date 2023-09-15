package util;

/**
 * The NodeDouble class is a generic class that implements the Node interface.
 */
public class NodeDouble<T> implements Node {

    /** The line `private NodeDouble<T> next;` is declaring a private instance variable `next` of type
    * `NodeDouble<T>`. This variable represents the next node in a doubly linked list. It is used to
    * maintain the reference to the next node in the list.
    */
    private NodeDouble<T> next;
    /** The line `private NodeDouble<T> prev;` is declaring a private instance variable `prev` of type
    * `NodeDouble<T>`. This variable represents the previous node in a doubly linked list. It is used
    * to maintain the reference to the previous node in the list.
    */
    private NodeDouble<T> prev;
    /** represents the content of the node in a doubly linked list. It is used to store the data
    * associated with the node. The type `T` is a generic type parameter, which means that the actual
    * type will be determined when an instance of the `NodeDouble` class is created.
    */
    private T c;

    /** The `public NodeDouble(T c)` constructor is initializing a new instance of the `NodeDouble`
    * class. It takes a parameter `c` of type `T`, which represents the content of the node.
    * @param c content of the type <T>
    */
    public NodeDouble(T c) {
        this.next = null;
        this.prev = null;
        this.c = c;
    }

    /**
     * The function returns the next node in a doubly linked list.
     * 
     * @return The method is returning a NodeDouble object.
     */
    public NodeDouble<T> getNext() {
        return next;
    }

    /**
     * The function returns the previous node in a doubly linked list.
     * 
     * @return The method is returning a NodeDouble object.
     */
    public NodeDouble<T> getPrev() {
        return prev;
    }

    /**
     * The function sets the next node in a doubly linked list.
     * 
     * @param next The "next" parameter is of type NodeDouble<T>, which represents the next node in a
     * doubly linked list.
     */
    public void setNext(NodeDouble<T> next) {
        this.next = next;
    }

    /**
     * The function sets the previous node of a doubly linked list node.
     * 
     * @param prev The "prev" parameter is of type NodeDouble<T>, which represents the previous node in
     * a doubly linked list.
     */
    public void setPrev(NodeDouble<T> prev) {
        this.prev = prev;
    }

    /**
     * The function returns the content of type T.
     * 
     * @return The method is returning the content of type T.
     */
    @Override
    public T getContent() {
        return c;
    }

    /**
     * The function sets the content of an object to the value of a parameter.
     * 
     * @param p The parameter "p" is of type Object, which means it can accept any type of object as an
     * argument.
     */
    @Override
    public void setContent(Object p) {
        c = ((T)(p));
    }

    /**
     * The toString() function returns a string representation of the object, including the value of
     * the variable "c".
     * 
     * @return The method is returning a string representation of the object. The string being returned
     * is "Nodo: " concatenated with the string representation of the object "c" and then concatenated
     * with a period ".".
     */
    @Override
    public String toString() {
        return "Nodo: " + c.toString() + ".";
    }

    /**
     * The function returns the node at the specified index in a doubly linked list.
     * 
     * @param index The index parameter represents the position of the node that we want to retrieve
     * from the linked list. It is an integer value that indicates the position of the node in the
     * linked list, starting from 0 for the first node.
     * @return The method is returning a NodeDouble<T> object.
     */
    public NodeDouble<T> get(int index){
        NodeDouble<T> node;
        if(index == 0){
            node = this;
        }else{
            node = next.get(index-1);
        }
        return node;
    }

    /**
     * The function sets the value of an object at a specific index in a linked list.
     * 
     * @param index The index parameter represents the position at which the object should be set in
     * the data structure.
     * @param object The "object" parameter is the value that you want to set at the specified index in
     * the linked list.
     */
    public void set(int index, Object object){
        if(index == 0){
            this.setContent(object);
        }else{
            next.set(index-1, object);
        }
    }

    /**
     * The remove function removes a node at a specified index from a doubly linked list.
     * 
     * @param index The index parameter represents the position of the node that needs to be removed in
     * the linked list.
     */
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

    /**
     * The function "showAll" recursively concatenates the string representation of the current object
     * with the string representation of the next object in a linked list.
     * 
     * @return The method is returning a string that represents all the elements in the linked list.
     */
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