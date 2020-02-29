/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleidade;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author 391151520171
 */
public class ControleIdade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String resposta = "";
        
        int numeroPessoasMaiores50 = 0;
        int somaIdadeAltura150 = 0;
        int numeroPessoasMenores150 = 0;
        int numeroPessoasOlhosAzuis = 0;
        int numeroRuivosSemOlhosAzuis = 0;
        
        //ControleIdade controle = new ControleIdade();
        do {
            Pessoa p = new Pessoa();
            //controle.entradaInformacoes(p);
            entradaInformacoes(p);
            
            
            if (p.getIdade() > 50){
                numeroPessoasMaiores50 ++;
            }
            
            if (p.getAltura() < 1.50){
                somaIdadeAltura150 += p.getIdade();
                numeroPessoasMenores150 ++;
            }
            
            if (p.getCorOlhos().equalsIgnoreCase("A")) {
                numeroPessoasOlhosAzuis ++;
            }
        
            if (p.getCorCabelos().equalsIgnoreCase("R") && !p.getCorOlhos().equalsIgnoreCase("A")){
                numeroRuivosSemOlhosAzuis ++;
            }
            resposta = JOptionPane.showInputDialog("Deseja continuar? S/N");
        } while (resposta.equalsIgnoreCase("sim") ||
                resposta.equalsIgnoreCase("s"));
        
        double media = somaIdadeAltura150 / numeroPessoasMenores150;
        String mensagem = "A quantidade de pessoas com idade superior a 50 anos = " + numeroPessoasMaiores50    
                        + "\nA média das idades das pessoas com altura inferior a 1.50 = " + media
                        + "\nO número de pessoas com olhos azuis = " + numeroPessoasOlhosAzuis
                        + "\nA quantidade de pessoas ruivas e que não possuem olhos azuis = " 
                + numeroRuivosSemOlhosAzuis;
        
        JOptionPane.showMessageDialog(null, mensagem);


    }

    public static Pessoa entradaInformacoes() {
        return new Pessoa();
    }
    
    private static void entradaInformacoes(Pessoa p) throws HeadlessException, NumberFormatException {
        p.setIdade( Integer.parseInt(
                JOptionPane.showInputDialog("Informe a sua idade")
        ));
        
        p.setPeso( Integer.parseInt(
                JOptionPane.showInputDialog("Informe o seu peso")
        ));
        
        p.setAltura( Double.parseDouble(
                JOptionPane.showInputDialog("Informe a sua altura")
        ));
        
        p.setCorOlhos(JOptionPane.showInputDialog(
                "Informe a cor dos seus olhos:\n" +
                        "A - azul\n" +
                        "P - preto\n" +
                        "V - verde\n" +
                        "C - castanho"
        ));
        
        p.setCorCabelos( JOptionPane.showInputDialog(
                "Informe a cor dos seus cabelos:\n" +
                        "P- preto\n"
                        + "C- castanho\n"
                        + "L -louro\n"
                        + "R - ruivo"
        ));
    }
    
}
