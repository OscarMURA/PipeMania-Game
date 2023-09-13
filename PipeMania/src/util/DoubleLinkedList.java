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

	@Override
	public void add(Object n) {
		T t=(T)(n);
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
