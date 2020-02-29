
package CASO;

import static java.lang.Integer.sum;
import java.util.Scanner;




public class CASO1{
public static void main (String[] args ){
    int number1;
   int number2;
   int som;

   Scanner input = new Scanner(System.in); 
   System.out.print( " Digite primeiro numero: ");
   number1 = input.nextInt();

   System.out.print ( "Digite o segundo numero: ");
   number2 = input.nextInt();

   som = number1 + number2;

   System.out.printf( "A Soma é " +som); 
           
}
}

