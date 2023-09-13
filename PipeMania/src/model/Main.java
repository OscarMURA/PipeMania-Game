package model;
import util.DoubleLinkedList;
import java.util.Scanner;
    public class Main {

        public static void main(String[] args) {

            Scanner scanner=new Scanner(System.in);
            int x;int y;
            Board board=new Board(8,8);

            int[] matriz = new int[64];

            // Llenar la matriz con valores (solo para demostración)
            for (int i = 0; i < 64; i++) {
                matriz[i] = i;
            }

            // Imprimir la matriz como una cuadrícula de 8x8
            for (int fila = 0; fila < 8; fila++) {
                for (int columna = 0; columna < 8; columna++) {
                    int indice = fila * 8 + columna;
                    System.out.print(matriz[indice] + "\t");
                }
                System.out.println(); // Nueva línea para la siguiente fila
            }

            
            DoubleLinkedList<Pipe> board1 = board.getBoard();
            //init F
            //Final D

            do{
                        
                System.out.println(board.generateBoardPrint());
                System.out.print("Ingrese la columna: ");
                x=scanner.nextInt();
                System.out.print("Ingrese la fila: ");
                y=scanner.nextInt();
                System.out.println("Ingrese String a cambiar:");
                String value=scanner.next();
                board.changePipe(x,y,value);

            }while(x!=-1);
            System.out.println(board.validationPipes());

            scanner.close();
        }
    }


