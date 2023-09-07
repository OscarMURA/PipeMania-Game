package util;


public class DoubleLinkedList extends Collections{


	private NodeDouble first;
	
	/**
	 * Referencia al Ultimo elemento de la lista
	 */
	private NodeDouble last;
	
	/**
	 * entero que guarda la cantidad de elementos de la lista
	 */
	private int numItems;


	public void addFirst(Object n) {
		NodeDouble newNode= new NodeDouble(n);
		
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
		NodeDouble newNode= new NodeDouble(n);
		
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

	public Object get(int index){
		NodeDouble node;
		if(index>=numItems){
			node = null;
		}else if(index == 0){
			node = first;
		}else{
			node = first.get(index);
		}
		
		return node.getContent();
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
}
