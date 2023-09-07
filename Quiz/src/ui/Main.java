package ui;
import util.BST;

import java.util.Scanner;

public class Main {
    private BST BST;

    public Main(){
       BST = new BST();
    }
    private int  num[]= {0,1,2,3,4,5,6,7,8,9,10, 11,12};
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Main main = new Main();
        BST BST =new BST();
        main.excution();
    }



    public int menu(){
        System.out.println("Bienvenido al menu de opciones");
        System.out.println("1. Ingresar un nuevo array para ingresar al BST");
        System.out.println("2. Buscar objecto en el BST y decir el nivel de profundidad donde esta. ");
        System.out.println("3. Imprimir nodo sucesor de un nodo dado.");
        System.out.println("4. Imprimir nodo predecesor de un nodo dado.");
        System.out.println("5. Profundidad del arbol.");
        System.out.println("6. Ancho del arbol.");
        System.out.println("7. Contar la cantidad de nodos ramas");
        System.out.println("0. Salir del programa");
        System.out.print("Opcion: ");
        return validateInt();
    }

    public void excution(){
        int option=0;
        option=menu();
        if(option==0){
            System.out.println("Gracias por usar el programa");
        }else{
            switch (option){
                case 1->{
                    chooseArray();
                }
                case 2->{
                    if(BST.getStart()!=null){
                        buscarValor();
                    }

                }
                case 3->{
                    if(BST.getStart()!=null){
                        succesors();
                    }

                }
                case 4->{
                    if(BST.getStart()!=null){
                        predecessor();
                    }
                }
                case 5->{
                    if(BST.getStart()!=null){
                        obtainDepth();
                    }
                }
                case 6->{
                    if(BST.getStart()!=null){
                        obtainWidth();

                    }
                }
                case 7->{
                    if(BST.getStart()!=null){
                        countBranches();
                    }
                }

                default -> System.out.println("Opcion invalida");
            }
            if(BST.getStart()==null){
                System.out.println("No se ha ingresado un arbol");
            }
            excution();
        }


    }




    public void buscarValor() {
        System.out.print("Ingresa el valor a buscar: ");
        int value = validateInt();
        if (BST.search(value) == null) {
            System.out.println("No existe el valor en el arbol");

        } else {
            System.out.println("El valor esta en la profundidad partiendo desde 0 es: " + BST.obtaintDepth(value));

        }
    }

    public void succesors(){
        System.out.print("Ingresa el valor a buscar: ");
        int value = validateInt();
        System.out.println(BST.sucessorMessage(value));
    }

    public void predecessor(){
        System.out.print("Ingresa el valor a buscar: ");
        int value = validateInt();
        System.out.println(BST.predesessorMessage(value));
    }

    public void chooseArray(){
        int [] array = new int[13];
        int option=0;
        System.out.println("Quieres usar el array base del sistema o quieres ingresar uno nuevo?");
        System.out.println("1. Usar el array base del sistema de 0-12");
        System.out.println("2. Ingresar un nuevo array con un tamaño de 13");
        System.out.print("Opcion: ");
        option = validateInt();
        switch (option){
            case 1-> {
                System.out.println("El array base del sistema es: ");
                System.out.println("0,1,2,3,4,5,6,7,8,9,10, 11, 12");
                array=num;
            }
            case 2->{
                System.out.print("Ingrese los numeros del array: ");
                array=agregarArray(array, 0);
            }
        }
        agregarArbol(array, 0);
        System.out.println("El arbol es: "+BST.inOrden());
        System.out.println("El arbol en preorden es: "+BST.preOrden());

    }


    private int[] agregarArray(int[] array, int index){
        int[] result;
        if(index==array.length){
            result=array;
        }else{
            System.out.print("Escriba el valor: ");
            int numero = validateInt();
            array[index]=numero;
            result=agregarArray(array, index+1);
        }
        return result;

    }

    /**
     * Este metodo agrega el arbol de la forma más balanceada posible, buscando la mitad de la mitad
     * @param array Array en agregar
     * @param index el indice del array
     */
    private void agregarArbol(int[] array, int index){
        int half = array.length/2;
        int left=0;
        int right=array.length-1;
        if(array.length==1){
            BST.add((array[0]));
        }else{
            BST.add((array[half]));
            int[] leftArray = new int[half];
            int[] rightArray = new int[half];
            for (int i = 0; i < half; i++) {
                leftArray[i]=array[left];
                rightArray[i]=array[right];
                left++;
                right--;
            }
            agregarArbol(leftArray, 0);
            agregarArbol(rightArray, 0);
        }

    }


    public int validateInt(){
        int option = 0;
        if (sc.hasNextInt()) {
            option = sc.nextInt();
        } else {
            sc.next();// limpiar el scanner
            System.out.println("\tInvalid number!");
            System.out.print("\tConrrently Type: ");
            option=validateInt();
        }
        return option;
    }

    public void obtainDepth(){
        System.out.println("La profundidad del arbol partiendo de 0 es: "+BST.obtainDepth());
    }

    public void obtainWidth(){
        System.out.println("El ancho del arbol es: "+BST.obtainWidth());
        System.out.println("El ancho del arbol partiendo de 0 es: "+(BST.obtainWidth()-1));
    }

    public void countBranches(){
        System.out.println("La cantidad de nodos ramas es: "+BST.branchNumber());
    }


}
