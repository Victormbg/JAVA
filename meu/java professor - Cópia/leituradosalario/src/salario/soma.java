package salario;

import java.util.Scanner;

/**
 *
 * @author Raul
 */

public class soma {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite um numero: ");
        int num = entrada.nextInt(), par = num, impar = 1;

        System.out.println("Digite outro numero: ");
        int num2 = entrada.nextInt();
        System.out.println("Numeros Pares: "); 
        int soma = 0 ;
        while(par <= num2){
            if(par%2 == 0){
                soma += par;
            }
            par++;
        }

        System.out.println(soma);
                
        

    }
}