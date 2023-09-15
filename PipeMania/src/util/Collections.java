package util;

/**
 * The abstract class Collections provides a blueprint for classes that implement collection
 * functionality.
 */
public abstract class Collections<T> {

    /** The `public Collections() {}` is a constructor for the `Collections` class. Constructors are
    * special methods that are called when an object of a class is created. In this case, the
    * constructor does not have any code inside its body, so it does not perform any specific actions
    * when called.
    */
    public Collections() {
    }

    /**
     * The add method is an abstract method that takes an Object parameter and does not return
     * anything.
     * 
     * @param o The parameter "o" is of type Object, which means it can accept any type of object as an
     * argument.
     */
    public abstract void add(Object o);
    
    /**
    * The function checks if a data structure is empty.
    * 
    * @return A boolean value is being returned.
    */
    public abstract boolean isEmpty();

}   