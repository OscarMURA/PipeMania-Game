package util;

public class BST <T extends Comparable<T>>  extends Collections{

    private BSTNode root;

    public BST() {
        root=null;
    }


    @Override
    public void add(Object object) {
        T value=(T) object;
        if(root==null){
            root=new BSTNode(value);
        }else{
            BSTNode node=new BSTNode(value);
            add(root, node);
        }
    }

    public void add(BSTNode current, BSTNode node){
        if((current.getValue().compareTo(node.getValue())>0)){
            if (current.getLeft() == null) {
                current.setLeft(node);
            } else {
                add(current.getLeft(), node);
            }

        }else if(current.getValue().compareTo(node.getValue())<0){

            if (current.getRight()==null){
                current.setRight(node);

            }else {
                add(current.getRight(),node);
            }
        }
    }

    public String inOrdenWithToString(){
        return inOrdenWithToString(root);
    }

    private String inOrdenWithToString(BSTNode current){
        String result="";
        if(current!=null){
            result+=inOrdenWithToString(current.getLeft());
            result+="* "+current.getValue().toString()+"\n";
            result+=inOrdenWithToString(current.getRight());
        }
        return result;
    }



    public T getMaximum(){
        return getMaximum(root);
    }

    private T getMaximum(BSTNode current){
        T result;
        if(current.getRight()==null){
            result= (T) current.getValue();
        }else{
            result= getMaximum(current.getRight());
        }
        return result;
    }


    @Override
    public boolean isEmpty() {
        return root==null;
    }
}
