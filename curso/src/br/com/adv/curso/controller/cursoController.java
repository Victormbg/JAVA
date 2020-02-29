package br.com.adv.curso.controller;
import br.com.adv.curso.model.dao.CursoDAO;
import br.com.adv.curso.model.entidade.curso;
import java.util.List;
public class cursoController {
    public String validarDados (curso c){
        String mensagem="";
        if(c.getNome().equalsIgnoreCase("")){
            mensagem+="O campo \'Nome\' é obrigatório.\n";
        }
        if(c.getDescricao().equalsIgnoreCase("")){
            mensagem+="O campo \'Descricao\' é obrigatório.\n";
        }
        return mensagem;
       }
   public void incluirCurso(curso c){
      CursoDAO cursoDAO = new CursoDAO();
      cursoDAO.incluir(c);
    }
   public List<curso> listarCursos(String nome){
       CursoDAO cursoDAO = new CursoDAO();
       return cursoDAO.listar(nome);
   }
   
   public void excluirCurso(long id) {
        CursoDAO dao = new CursoDAO();
        dao.excluir(id);
   }
   
   public void alterarCurso(curso c) {
        CursoDAO dao = new CursoDAO();
        dao.alterar(c);
    }
   
   public curso buscarCurso(long id) {
        CursoDAO dao = new CursoDAO();
        return dao.buscar(id);
    }
   
   
   
   
   
}