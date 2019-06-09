/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleidade;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
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
        
       /*
               String resposta = "";
        
        
        ControleIdade controle = new ControleIdade();
        //Pessoa[] pessoas = new Pessoa[10];
        
        List<Pessoa> pessoas = new ArrayList<Pessoa>(); 
        
       
        
        do {
            Pessoa p = new Pessoa();
            //controle.entradaInformacoes(p);
            entradaInformacoes(p);
           
            pessoas.add(p);
            
            resposta = JOptionPane.showInputDialog("Deseja continuar? S/N");
        } while (resposta.equalsIgnoreCase("sim") ||
                resposta.equalsIgnoreCase("s"));

        Relatorio info = processarPesquisa(pessoas);
        
        double media = info.getSomaIdadeAltura150() / info.getNumeroPessoasMenores150();
        String mensagem = "A quantidade de pessoas com idade superior a 50 anos = " + info.getNumeroPessoasMaiores50()    
                        + "\nA média das idades das pessoas com altura inferior a 1.50 = " + media
                        + "\nO número de pessoas com olhos azuis = " + info.getNumeroPessoasOlhosAzuis()
                        + "\nA quantidade de pessoas ruivas e que não possuem olhos azuis = " 
                + info.getNumeroRuivosSemOlhosAzuis();
        
        JOptionPane.showMessageDialog(null, mensagem);
        */
 tela t = new tela();
        t.setVisible(true);

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
    
    public static Relatorio processarPesquisa(List<Pessoa> lista){
        Relatorio relatorio = new Relatorio();
        for(Pessoa p : lista ){
            if (p.getIdade() > 50){
                relatorio.adicionarPessoasMaiores50();
            }
            
            if (p.getAltura() < 1.50){
                //controle.somaIdadeAltura150 += p.getIdade();
                //controle.numeroPessoasMenores150 ++;
                
                relatorio.acumularIdadePessoasAltura150(p.getIdade());
            }
            
            if (p.getCorOlhos().equalsIgnoreCase("A")) {
                //controle.numeroPessoasOlhosAzuis ++;
                relatorio.acumularPessoasOlhosAzuis();
            }
        
            if (p.getCorCabelos().equalsIgnoreCase("R") && !p.getCorOlhos().equalsIgnoreCase("A")){
                //controle.numeroRuivosSemOlhosAzuis ++;
                
                relatorio.acumularPessoasRuivasSemOlhosAzuis();
            }
            
        }
        
        return relatorio;
    }
}
