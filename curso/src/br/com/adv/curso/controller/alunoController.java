package br.com.adv.curso.controller;
import br.com.adv.curso.model.dao.AlunoDAO;
import br.com.adv.curso.model.entidade.aluno;
import java.util.List;
public class alunoController {
   public String validarDados (aluno a){
        String mensagem="";
        if(a.getNome().equalsIgnoreCase("")){
            mensagem+="O campo \'Nome\' é obrigatório.\n";
        }
        if(a.getMatricula().equalsIgnoreCase("")){
            mensagem+="O campo \'Matricula\' é obrigatório.\n";
        }
        if(a.getEndereco().equalsIgnoreCase("")){
            mensagem+="O campo \'Endereco\' é obrigatório.\n";
        }
        return mensagem;
       } 
  
   public void incluirAluno(aluno a){
      AlunoDAO dao = new AlunoDAO();
      dao.incluir(a);
   }
   
   public List<aluno> listarAlunos(String nome){
        AlunoDAO dao = new AlunoDAO();
      return dao.listar(nome);
     
   }

    public aluno buscarAluno(long id) {
        AlunoDAO dao = new AlunoDAO();
        return dao.buscar(id);
    }
    public void alterarAluno(aluno a) {
        AlunoDAO dao = new AlunoDAO();
        dao.alterar(a);
    }
    public void excluirAluno(long id) {
        AlunoDAO dao = new AlunoDAO();
        dao.excluir(id);
        
    }
}