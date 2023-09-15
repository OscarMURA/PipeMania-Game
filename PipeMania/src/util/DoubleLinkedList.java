package util;

/**
 * The DoubleLinkedList class is a subclass of the Collections class.
 */
public class DoubleLinkedList<T> extends Collections<T>{


	// The `public DoubleLinkedList()` constructor initializes a new instance of the `DoubleLinkedList`
	// class. It sets the `first` and `last` pointers to `null`, indicating that the list is empty. It
	// also sets the `numItems` variable to 0, indicating that there are no items in the list.
	public DoubleLinkedList() {
		this.first = null;
		this.last = null;
		this.numItems = 0;
	}

	/**
	 * pointer to the first node of the list
	 */
	private NodeDouble<T> first;
	
	/**
	 * pointer to the last node of the list
	 */
	private NodeDouble<T> last;
	
	/**
	 * integer of the number of items in the double linked list
	 */
	private int numItems;


	/**
	 * The addFirst function adds a new node containing the given value to the beginning of a doubly
	 * linked list.
	 * 
	 * @param n The parameter "n" is of type T, which means it can be any data type. It represents the
	 * value that will be added to the beginning of the list.
	 */
	public void addFirst(T n) {
		NodeDouble<T> newNode = new NodeDouble<T>((T)(n));
		
		if(first == null) {// empty list
			first =newNode;
			last= newNode;
		} else {
			newNode.setNext(first);
			first.setPrev(newNode);
			first = newNode;
		}
		numItems++;
	}

	/**
	 * The function searches for a specific object in a doubly linked list and returns the object if
	 * found, otherwise it returns null.
	 * 
	 * @param clave The parameter "clave" is the key or value that we are searching for in the list.
	 * @return The method is returning the object that matches the given key (clave). If no match is
	 * found, it returns null.
	 */
	public Object search(Object clave) {
		Object found =  null;
		NodeDouble<T> current= first;
		
		if (first !=null) { //Si la lista es no es vacIA se hace el recorrido
			
			while(current.getNext() != null && found==null) {
				if (current.getContent().equals(clave))
					found = current.getContent();
				current=current.getNext();
			}
			//si se llegO al ultimo nodo y aun no se encuentra la clave 
			if (current.getNext()==null && found==null) {
				if (current.getContent().equals(clave)) //buscando en el ultimo nodo
					found = current.getContent();
			}
		} // si la lista es vacía no se hace nada
		
		return found;
	}

	/**
	 * The add method adds a new node to the end of a doubly linked list.
	 * 
	 * @param n The parameter `n` is of type `Object` and represents the element to be added to the list.
	 */
	@Override
	public void add(T n) {
		T t= n;
		NodeDouble<T> newNode= new NodeDouble<>(t);
		
		if(last == null) {
			first = newNode;
			last = newNode;
		} else {
			newNode.setPrev(last);
			last.setNext(newNode);
			last = newNode;
		}
		numItems++;
	}

	/**
	 * The function returns the node at the specified index in a doubly linked list.
	 * 
	 * @param index The index parameter represents the position of the node that we want to retrieve from
	 * the linked list.
	 * @return The method is returning a T object.
	 */

	public T get(int index){
		NodeDouble<T> node;
		if(index>=numItems){
			node = null;
		}else if(index == 0){
			node = first;
		}else{
			node = first.get(index);
		}
		
		return node.getContent();
	}

	/**
	 * The function sets the content of a node at a given index in a linked list to a specified object.
	 * 
	 * @param index The index parameter represents the position at which the object should be set in the
	 * data structure.
	 * @param object The object parameter is the new value that you want to set at the specified index in
	 * the data structure.
	 */
	public void set(int index, Object object){
		if(index<numItems){
			if(first.getContent() == object){
				first.setContent(object);
			}else{
				first.set(index, object);
			}
		}
	}

	/**
	 * The function checks if the number of items is zero and returns true if it is, indicating that the
	 * collection is empty.
	 * 
	 * @return The method is returning a boolean value, which indicates whether the collection is empty or
	 * not. If the number of items in the collection is 0, then the method will return true, indicating
	 * that the collection is empty. Otherwise, it will return false, indicating that the collection is
	 * not empty.
	 */
	@Override
	public boolean isEmpty(){
		boolean out = false;
		if(numItems == 0){
			out = true;
		}
		return out;
	}

	/**
	 * The function removes an element at a specified index from a list and returns a boolean indicating
	 * whether the removal was successful.
	 * 
	 * @param index The index parameter represents the position of the element that needs to be removed
	 * from the list.
	 * @return The method is returning a boolean value.
	 */
	public boolean remove(int index){
		boolean out = false;
		if(numItems<index){
			out = true; //Se eliminó correctamente
			first.remove(index);
		}
		numItems--;
		return out;
	}


	/**
	 * The function "showAll" returns a string representation of all the elements in a linked list.
	 * 
	 * @return The method is returning a String value.
	 */
	public String showAll(){
		String out = "";
		if(first == null){
			out = "No hay en la lista";
		}else{
			out = first.showAll();
		}
		return out;
	}

	/**
	 * The function returns the number of items.
	 * 
	 * @return The method is returning the value of the variable "numItems".
	 */
	public int getNumItems(){
		return numItems;
	}
}
