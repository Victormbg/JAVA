
package enquete;
import javax.swing.JOptionPane;

public class Enquete {

    public static void main(String[] args) {

        String resposta = "sim";
        int soma = 0;
        int quantidadeOtimo = 0;
        int quantidadeRegular = 0;
        int quantidadeTotal = 0;
        do{
         int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a sua idade"));
         int opiniao = Integer.parseInt(JOptionPane.showInputDialog("O que você achou do filme?\n "
         +"4 - Ótimo\n"
         +"3 - Bom\n"
         +"2 - Regular\n"
         +"1 - Ruim\n"
         +"0 - Péssimo" )
         );
         
         switch (opiniao){
             case 4:
                 soma= soma + idade;
                 quantidadeOtimo++;
                 break;
             case 2:
                 quantidadeRegular++;
                 break;
         };
         quantidadeTotal++;
         resposta=JOptionPane.showInputDialog("Deseja continuar?\n");
        }
        while(resposta.equalsIgnoreCase("sim") ||
                resposta.equalsIgnoreCase("s"));
        
        double media = soma / quantidadeOtimo;
        
        String saida ="A média das idades das pesssoas que "
                + "acharam o filme ótimo foi "+ media
                + "\n A quantidade das pessoas acharam "
                +"o filme regular foi " +quantidadeRegular
                +"\n O total de pessoas que respoderam a "
                +"pesquisa foi " +quantidadeTotal;
        JOptionPane.showMessageDialog(null,saida);
    }
    
}
