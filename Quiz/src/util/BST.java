package util;

public class BST {
    private BSTNode start;

    public BST(){
        start=null;
    }

    public void add(int value){
        //caso es que no hay nada en el nodo
        if(start==null){
            start=new BSTNode(value);
            start.setParent(null);

        }else{
            //Llama el metodo recursivo para agregar si ya tiene algo
            BSTNode node=new BSTNode(value);
            add(start, node);

        }
    }

    public BSTNode getStart() {
        return start;
    }
    public void add(BSTNode current, BSTNode node){
        //Compara si el valor es menor al nodo actual
        if(current.getValue()>(node.getValue())){
            //Busca que el nodo actual sea hoja y/o que su lado izquierdo este vacio
            if(current.getLeft()==null){
                node.setParent(current);
                current.setLeft(node);


            }else{
                //Si no es hoja, se llama recursivamente para agregar el nodo
                add(current.getLeft(),node);
            }
        //
        }else if(current.getValue()<(node.getValue())){
            //Busca que el nodo actual sea hoja y/o que su lado derecho este vacio
            if (current.getRight()==null){
                node.setParent(current);
                current.setRight(node);
            }else {
                //Si no es hoja, se llama recursivamente para agregar el nodo
                add(current.getRight(),node);
            }
        }
    }


    public  String inOrden(){
        return inOrden(start);
    }


    private static String inOrden(BSTNode node){
        String out;
        if(node==null){
            out="";
        }else{
            out=inOrden(node.getLeft());
            out+=node.getValue()+". ";
            out+=inOrden(node.getRight());

        }
        return out;
    }



    private BSTNode search(BSTNode current, int wordKey){
        BSTNode result;
        if(current == null){
            result=null;
        }else if(current.getValue()==(wordKey)){
            result=current;

        }else if( wordKey< (current.getValue())){
            result=search(current.getLeft(), wordKey);
        }else{
            result=search(current.getRight(), wordKey);

        }
        return result;
    }


    public BSTNode search(int wordKey){
        return search(start, wordKey);
    }



    public int obtaintDepth( int wordKey){
        return obtaintDepth( this.start, wordKey)-1;

    }

    public int obtaintDepth(BSTNode current, int wordKey){
        int result;
        if(current == null){
            result= 0;
        }else if(current.getValue()==(wordKey)){
            result= 1;
        }else if( wordKey< (current.getValue())){
            result=obtaintDepth(current.getLeft(), wordKey) + 1;
        }else{
            result=obtaintDepth(current.getRight(), wordKey) + 1;

        }
        return result;
    }

    public String preOrden(BSTNode node){
        String out;
        if(node==null){
            out="";
        }else{
            out=node.getValue()+".  ";
            out+=preOrden(node.getLeft());
            out+=preOrden(node.getRight());

        }
        return out;
    }

    public String preOrden(){
        return preOrden(start);
    }
    public String sucessorMessage(int wordKey){
        String out;
        if(search(wordKey)==null){
            out="No existe el nodo";
        }else{
            BSTNode node = sucessor(wordKey);
            if(node==null){
                out="No tiene sucesor pero antesesor sir, por lo tanto es una hoja";
            }else{
                out="El sucesor es: "+node.getValue();
            }
        }
        return out;
    }

    public BSTNode sucessor(int wordKey){

        return sucessor(search(wordKey));

    }


    public BSTNode sucessor( BSTNode current ){
        BSTNode result;
        if(current.getRight()!=null) {
            result = getMin(current.getRight());
        }else{
            BSTNode dad = current.getParent();
            result = sucessor(dad,current);
        }
        return result;
    }

    public BSTNode sucessor(BSTNode parent, BSTNode son){
        BSTNode result;
        if(!(parent!=null && son==parent.getRight())){
            result=parent;
        }else{
            son=parent;
            parent=parent.getParent();
            result=sucessor(parent, son);
        }
        return result;
    }


    private BSTNode getMin(BSTNode current){
        BSTNode result;
        if(current.getLeft()==null){
            result =current;
        }
        else{
            result = getMin(current.getLeft());
        }
        return result;
    }

    public String predesessorMessage(int wordKey){
        String out;
        if(search(wordKey)==null){
            out="No existe el nodo";
        }else{
            BSTNode node = predesessor(wordKey);
            if(node==null){
                out="No tiene antecesor pero si sucesor, por lo tanto es una hoja";
            }else{
                out="El antecesor es: "+node.getValue();
            }
        }
        return out;
    }

    public BSTNode predesessor(int wordKey){
        return predesessor(start,search(wordKey));
    }

    private BSTNode predesessor(BSTNode current, BSTNode target){
        BSTNode result;
        if(current==null){
            result=null;
        }else if(target.getValue()<current.getValue()) {
            result = predesessor(current.getLeft(), target);
        } else if(target.getValue()>current.getValue()) {
            BSTNode rightPredecessor = predesessor(current.getRight(), target);
            if(rightPredecessor==null) {
                result = current;
            }else{
                result = rightPredecessor;
            }

        }else{
            result = getMax(current.getLeft());
        }
        return result;
    }

    public BSTNode getMax(BSTNode current){
        BSTNode result;
        if(current!=null && current.getRight()==null  ){
            result =current;
        }
        else{
            if(current!=null && current.getRight()!=null) {
                result = getMax(current.getRight());
            }else{
                result=null;
            }
        }
        return result;
    }

    public int obtainDepth(){
        return obtainDepth(start)-1;
    }

    private int obtainDepth(BSTNode current){
        int result;
        int leftDepth = 0;
        int rightDepth = 0;
        if(current == null){
            result= 0;
        }else{
            leftDepth = obtainDepth(current.getLeft());
            rightDepth = obtainDepth(current.getRight());
            result= Math.max(leftDepth, rightDepth) + 1;
        }
        return result;
    }

    public int obtainWidth(){
        return getWidth(start);
    }
    public int getWidth(BSTNode root) {
        int height = getHeight(root);
        int[] levelCounts = new int[height];
        getWidthRecursive(root, 0, levelCounts);
        int maxWidth = 0;
        maxWidth=maximunNumber(maxWidth,0, levelCounts);
        return maxWidth;
    }

    private int maximunNumber( int maximun, int index, int[] array){
        int max;
        if(index==array.length){
            max=maximun;
        }else{
            if(array[index]>maximun){
                maximun=array[index];
            }
            max=maximunNumber(maximun, index+1, array);
        }
        return max;
    }

    private int getHeight(BSTNode node) {
        int height;
        if (node == null) {
             height=0;
        }else{
            int leftHeight = getHeight(node.getLeft());
            int rightHeight = getHeight(node.getRight());
            height= Math.max(leftHeight, rightHeight) + 1;
        }
        return height;
    }
    private void getWidthRecursive(BSTNode node, int level, int[] levelCounts) {
        if (node != null) {
            levelCounts[level]++;
            getWidthRecursive(node.getLeft(), level + 1, levelCounts);
            getWidthRecursive(node.getRight(), level + 1, levelCounts);
        }
    }



    public int branchNumber(){
        int result;
        if(start==null){
            result=0;
        }else{
            //Se le suma uno de mas, porque el root es rama
            result=start.branchNumber()+1;
        }
        return result;
    }


}
