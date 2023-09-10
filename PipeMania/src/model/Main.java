package model;
import java.util.Scanner;
import util.Collections;


public class Main {


    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);
         int x;
         int y;
         Board board=new Board(8,8);

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

    }

}
