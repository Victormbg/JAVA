/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enquete;

import javax.swing.JOptionPane;

/**
 *
 * @author 391151520171
 */
public class Enquete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String resposta = "sim";
        int soma = 0;
        int quantidadeOtimo = 0;
        int quantidadeRegular = 0;
        int quantidadeTotal = 0;
        do {
           int idade = Integer.parseInt(
                   JOptionPane.showInputDialog("Informe a sua idade")
           );
           int opiniao = Integer.parseInt(
            JOptionPane
                    .showInputDialog("O que você achou do filme?\n" 
                    + "4 - Ótimo\n" 
                    + "3 - Bom\n"
                    + "2 - Regular\n"
                    + "1 - Ruim\n" 
                    + "0 - Péssimo")
           );
           
           switch (opiniao){
               case 4:
                   soma = soma + idade;
                   quantidadeOtimo++;
                   break;
               case 2:
                   quantidadeRegular++;
                   break;
           };
           
           quantidadeTotal++;
           resposta = JOptionPane.showInputDialog("Deseja continuar? S/N");
           
        } while (resposta.equalsIgnoreCase("sim") || 
                resposta.equalsIgnoreCase("s"));
        
        double media = soma / quantidadeOtimo;
        
        String saida = "A média das idades das pessoas que "
                + "acharam o filme ótimo foi " + media
                + "\nA quantidade das pessoas que acharam "
                + "o filme regular foi " + quantidadeRegular
                + "\nO total de pessoas que responderam a "
                + "pesquisa foi " + quantidadeTotal;
        JOptionPane.showMessageDialog(null, saida);
    }
    
}
