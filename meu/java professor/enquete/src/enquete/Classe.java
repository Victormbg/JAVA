
package enquete;
import javax.swing.JOptionPane;
public class Classe {
     public static void main(String[] args) {
      
      String resposta ="";
        
        int numeroPessoasMaiores50 = 0;
        int somaIdadeAltura150 = 0;
        int numeroPessoasMenores150 = 0;
        int numeroPessoasOlhosAzuis = 0;
        int numeroRuivosSemOlhosAzuis = 0;
        
     do{
      
     int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a sua idade:"));
     int peso = Integer.parseInt(JOptionPane.showInputDialog("Informe o seu peso:"));
    double altura = Double.parseDouble(JOptionPane.showInputDialog("Informe a sua altura:"));
    
    String corOlho = JOptionPane.showInputDialog(
        "Informe a cor dos seus olhos:\n "+
         "A - Azul\n"  +
         "P - Preto\n" +
         "V - Verde\n" +
         "C - Castanho" 
         );
     
     String corCabelo = JOptionPane.showInputDialog(
             "Informe a cor dos cabelos:\n " +
         "P - Preto\n" +
         "C - Castanho\n" +
         "L - Loiro\n" +
         "R - Ruivo "  
         );
        
     if (idade > 50){
      numeroPessoasMaiores50 ++;
     }
     
     if(altura < 1.50 ){
      somaIdadeAltura150 +=idade;
      numeroPessoasMenores150 ++;
     }
     if(corOlho.equalsIgnoreCase("A")){
     numeroPessoasOlhosAzuis ++;
     }
     
     if(corCabelo.equalsIgnoreCase("R") && !corOlho.equalsIgnoreCase("A")){
     numeroRuivosSemOlhosAzuis ++;
     }
     resposta = JOptionPane.showInputDialog("Deseja continuar? S/N");
     }while(resposta.equalsIgnoreCase("sim") ||
            resposta.equalsIgnoreCase("s"));
     
     double media = somaIdadeAltura150 / numeroPessoasMenores150;
     String mensagem = "A quantidade de pessoas com idade  superior a 50 anos = " + numeroPessoasMaiores50
              +"\n A média  das idades das pessoas  com altura inferior a 1.50 = " + media
              +"\n O número de pessoas com olhos azuis = " + numeroPessoasOlhosAzuis
              +"\n A quantidade de pessoas ruivas e que não possuem olhos azuis = "
              +numeroRuivosSemOlhosAzuis;
     
      JOptionPane.showMessageDialog(null,mensagem);
   
   }
}
