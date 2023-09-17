package model;
import util.BST;
import util.DoubleLinkedList;
import java.util.Scanner;
    public class Main {

        public static void main(String[] args) {

            BST<Player> lista = new BST<Player>();
            Player p1 = new Player("p1");
            p1.setScore(1);
            p1.setMatch("match1");
            lista.add(p1);
            Player p2 = new Player("p2");
            p2.setScore(2);
            p2.setMatch("match2");
            lista.add(p2);
            Player p3 = new Player("p3");
            p3.setScore(-5);
            p3.setMatch("match3");
            lista.add(p3);
            Player p4 = new Player("p4");
            p4.setScore(-2);
            p4.setMatch("match4");
            lista.add(p4);
            Player p5 = new Player("p5");
            p5.setScore(188);
            p5.setMatch("match5");
            lista.add(p5);
            Player p6 = new Player("p6");
            p6.setScore(150);
            p6.setMatch("match6");
            lista.add(p6);
            Player p7 = new Player("p7");
            p7.setScore(149);
            p7.setMatch("match7");
            lista.add(p7);
            System.out.println(lista.getRanking(4));

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


