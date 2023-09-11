package util;

public class DoubleLinkedList<T> extends Collections{


	public DoubleLinkedList() {
		this.first = null;
		this.last = null;
		this.numItems = 0;
	}

	/**
	 * referencia al primer elemento de la lista
	 */


	private NodeDouble<T> first;
	
	/**
	 * Referencia al Ultimo elemento de la lista
	 */
	private NodeDouble<T> last;
	
	/**
	 * entero que guarda la cantidad de elementos de la lista
	 */
	private int numItems;


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

	@Override
	public void add(Object n) {
		NodeDouble<T> newNode= new NodeDouble<T>((T)(n));
		
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

	public NodeDouble<T> get(int index){
		NodeDouble<T> node;
		if(index>=numItems){
			node = null;
		}else if(index == 0){
			node = first;
		}else{
			node = first.get(index);
		}
		
		return node;
	}

	public void set(int index, Object object){
		if(index<numItems){
			if(first.getContent() == object){
				first.setContent(object);
			}else{
				first.set(index, object);
			}
		}
	}

	@Override
	public boolean isEmpty(){
		boolean out = false;
		if(numItems == 0){
			out = true;
		}
		return out;
	}

	public boolean remove(int index){
		boolean out = false;
		if(numItems<index){
			out = true; //Se eliminó correctamente
			first.remove(index);
		}
		numItems--;
		return out;
	}

	public String showAll(){
		String out = "";
		if(first == null){
			out = "No hay en la lista";
		}else{
			out = first.showAll();
		}
		return out;
	}

	public int getNumItems(){
		return numItems;
	}
}
