package boletim;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Boletim {
 //private static List<Aluno> alunos = new ArrayList<Aluno>();
      public static void main(String[] args) {
          
       /* Primeira Versão
        List<Aluno> alunos = new ArrayList<Aluno>();
        Aluno a;
        for(int i =0; i < 5; i++){
            a = new Aluno();
            entradaInformacoes(a);
            alunos.add(a);
        }
    saida(alunos);
    */
      Tela t = new Tela();
      t.setVisible(true);
      
      }      
    private static void entradaInformacoes(Aluno a) {
       a.setNome(JOptionPane.showInputDialog("Informe o seu nome: "));
       a.setMatricula(JOptionPane.showInputDialog("Informe a sua matrricula: "));
       a.setNota1(Double.parseDouble(JOptionPane.showInputDialog("Informe a primeira nota: ")));
       a.setNota2(Double.parseDouble(JOptionPane.showInputDialog("Informe a segunda nota: ")));
       a.setNota3(Double.parseDouble(JOptionPane.showInputDialog("Informe a terceira nota: ")));
       
    }
    
    private static void saida(List<Aluno> lista){
      String mensagem = "";
        for(Aluno al : lista){
          mensagem = mensagem + al.getNome() + " - " + al.calcularMedia();
          if(al.calcularMedia() > 6){
              mensagem = mensagem+ " - Aprovado\n";
          }else{
              mensagem = mensagem+ "- Reprovado\n";
          }
      }
        JOptionPane.showMessageDialog(null, mensagem);
    
    }
}