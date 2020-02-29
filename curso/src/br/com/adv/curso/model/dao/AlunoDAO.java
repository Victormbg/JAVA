package br.com.adv.curso.model.dao;
import br.com.adv.curso.model.entidade.aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class AlunoDAO extends conexao{
    public List<aluno> listar(String nomePesquisa){
       List<aluno> lista = new ArrayList<aluno>();
       
       try{
           String sql = "SELECT * FROM aluno al"+
                   " inner join pessoa p"+
                   " on al.id = p.id"+
                   " where p.nome like ?";
           PreparedStatement ps = getConexao().prepareStatement(sql);
           ps.setString(1,"%"+nomePesquisa+"%");
           ResultSet rs = ps.executeQuery();
           aluno a;
           while(rs.next()){
              a = new aluno();
              a.setId(rs.getLong("id"));
              a.setMatricula(rs.getString("matricula"));
              a.setNome(rs.getString("nome"));
              a.setEndereco(rs.getString("endereco"));
              
              lista.add(a);
           }
           
       }catch(SQLException e){
           e.printStackTrace();
       }finally{
           fecharConexao();
       }
       
       
       return lista;
  }
        public void incluir(aluno a){
       try{
       String sql = "insert pessoa (nome, endereco)"+ "values (?, ?)";
       PreparedStatement ps = getConexao().prepareStatement(sql);
       ps.setString(1, a.getNome());
       ps.setString(2, a.getEndereco());
       ps.execute();
       ps.close();
       
       String sql2 = "select max(id) from pessoa";
       ps = getConexao().prepareStatement(sql2);
       ResultSet rs = ps.executeQuery();
       rs.first();
       long id = rs.getLong(1);
       ps.close();
       String sql3 = "insert into aluno (id,matricula)"+"values(?,?)";
       ps = getConexao().prepareStatement(sql3);
       ps.setLong(1, a.getId());
       ps.setString(2, a.getMatricula());
       ps.execute();
       ps.close();
       }catch(SQLException ex){
          ex.printStackTrace();
       }finally{
           fecharConexao();
       }
   }
   
    public aluno buscar(long id) {
        aluno a = new aluno ();
        
        try {
            String sql = "SELECT * FROM aluno al"
                         + " inner join pessoa p"
                         + " on al.id = p.id"
                         + " where p.id = ?";
            PreparedStatement ps = getConexao()
                    .prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
               a.setId(rs.getLong("id"));
               a.setNome(rs.getString("nome"));
               a.setEndereco(rs.getString("endereco"));
               a.setMatricula(rs.getString("matricula"));
            }
       
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        
        return a;
    }
    
    public void alterar(aluno a){
     try {
            String sql = "update pessoa set "
                    + " nome = ?, "
                    + " endereco = ? "
                    + " where id = ?";

            PreparedStatement ps = getConexao()
                    .prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getEndereco());
            ps.setLong(3, a.getId());
            ps.execute();
            ps.close();
            
            sql = "update aluno set "
                    + " matricula = ? "
                    + " where id = ?";
            
            ps = getConexao().prepareStatement(sql);
            ps.setString(1, a.getMatricula());
            ps.setLong(2, a.getId());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }   
    }
    public void excluir(long id){
    try{
        String sql = "delete from pessoa where id = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
        ps.close();
        
        sql = "delete from aluno where id =?";
        ps = getConexao().prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
        ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }     
    }
}
