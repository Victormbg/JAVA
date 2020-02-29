package br.com.adv.curso.model.dao;
import br.com.adv.curso.model.entidade.curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CursoDAO extends conexao{
    public void incluir(curso c){
       try{
        String sql = "insert into Cursojava(nome,descricao)"+"values(?,?)";     
       PreparedStatement ps = getConexao().prepareStatement(sql);
       ps.setString(1, c.getNome());
       ps.setString(2, c.getDescricao());
       ps.execute();
       ps.close();
       }catch(SQLException e){
           e.printStackTrace();
       }finally{
           fecharConexao();
       }
  
    }
    public List<curso> listar(String nomePesquisa){
       List<curso> lista = new ArrayList<curso>();
        try{
           String sql = "select * from Cursojava"+" where nome like ?";
           PreparedStatement ps = getConexao().prepareStatement(sql);
           ps.setString(1,"%"+nomePesquisa+"%");
           ResultSet rs = ps.executeQuery();
           curso c;
           while(rs.next()){
              c = new curso();
              c.setId(rs.getLong("id"));
              c.setNome(rs.getString("nome"));
              c.setDescricao(rs.getString("descricao"));
              
              lista.add(c);
           }
           
       }catch(SQLException e){
           e.printStackTrace();
       }finally{
           fecharConexao();
       }
        return lista;
    }
    public void alterar(curso c){
        try {
            String sql = "update pessoa set "
                    + " nome = ?, "
                    + " endereco = ? "
                    + " where id = ?";

            PreparedStatement ps = getConexao()
                    .prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getDescricao());
            ps.setLong(3, c.getId());
            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }   
    }
    
    public curso buscar(long id) {
        curso c = new curso ();
        
        try {
            String sql = "SELECT * FROM cursojava al"
                         + " where p.id = ?";
            PreparedStatement ps = getConexao()
                    .prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
               c.setId(rs.getLong("id"));
               c.setNome(rs.getString("nome"));
               c.setDescricao(rs.getString("descricao"));
            }
       
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        
        return c;
    }
    
    public void excluir(long id){
    try{
        String sql = "delete from cursojava where id = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
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
