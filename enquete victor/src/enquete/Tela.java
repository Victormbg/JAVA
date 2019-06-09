package enquete;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class Tela extends javax.swing.JFrame {

    public Tela() {
        initComponents();
    }

    private static List<Enquete> lista = 
             new ArrayList<Enquete>();

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        txtOpniao = new javax.swing.JTextField();
        txtBotao1 = new javax.swing.JButton();
        txtBotaoR = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Informe a idade:");

        jLabel2.setText("O que achou do filme ? ");

        txtIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdadeActionPerformed(evt);
            }
        });

        txtBotao1.setText("Cadastrar");
        txtBotao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBotao1ActionPerformed(evt);
            }
        });

        txtBotaoR.setText("Ver Resultado");
        txtBotaoR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBotaoRActionPerformed(evt);
            }
        });

        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(txtBotao1)
                        .addGap(53, 53, 53)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(txtBotaoR)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtOpniao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdade)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtOpniao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBotao1)
                    .addComponent(txtBotaoR)
                    .addComponent(jButton1))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents




    private void txtBotaoRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBotaoRActionPerformed
        lista = new ArrayList<Enquete>();
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enquete","root","");
            String sql = "select idade,opniao"+" from cliente";
        
        PreparedStatement stman = con.prepareStatement(sql);
        ResultSet rs = stman.executeQuery();
        Enquete a;
        while(rs.next()){
            a = new Enquete();
            a.setIdade(rs.getInt(1));
            a.setOpniao(rs.getInt(2));
            lista.add(a);
        }
        stman.close();
        con.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(this,"Erro Cmdo Sql");
        }catch(ClassNotFoundException ex){
             JOptionPane.showMessageDialog(this,"Driver nao encontrado");
        }
        
        
        
        
         int soma = 0;
        int quantidadeOtimo = 0;
        int quantidadeRegular = 0;
        int quantidadeTotal = 0;
      
        String mensagem = "";
        for(Enquete al : lista){
         switch (al.getOpniao()){
             case 4:
                 soma= soma + al.getIdade();
                 quantidadeOtimo++;
                 break;
             case 2:
                 quantidadeRegular++;
                 break;
         };
        }
      
         double media = soma / quantidadeOtimo;
        
        mensagem ="A média das idades das pesssoas que "
                + "acharam o filme ótimo foi "+ media
                + "\n A quantidade das pessoas acharam "
                +"o filme regular foi " +quantidadeRegular
                +"\n O total de pessoas que respoderam a "
                +"pesquisa foi " +lista.size();
               
        
        
        JOptionPane.showMessageDialog(null, mensagem);

    }//GEN-LAST:event_txtBotaoRActionPerformed

    
    private void txtBotao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBotao1ActionPerformed
        String mensagem ="";
        Enquete a = new Enquete();
        
        if(!txtIdade.getText().equals("")){
            a.setIdade(Integer.parseInt(txtIdade.getText()));
        }else{
             mensagem +="O campo \'Idade\' é obrigatório \n";
        }
        
        if(!txtOpniao.getText().equals("")){
        a.setOpniao(Integer.parseInt(txtOpniao.getText()));
        }else{
             mensagem+= "O campo \'Opniao\' é obrigatório \n";
        }
        
        if (mensagem.equals("")){
            try {
                //lista.add(a);

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enquete","root","");
                           
            String sql = "insert into cliente"
               + "(idade,opniao)"
               + "values (? ,?)";
            
            PreparedStatement stman = con.prepareStatement(sql);
            stman.setInt(1, a.getIdade());
            stman.setInt(2, a.getOpniao());
                
            stman.execute();
            stman.close();
            
            con.close();
            
            
            JOptionPane.showMessageDialog(null,
              "O Registro foi adicionado com sucesso.");
            limpar();
            
            } catch (SQLException ex){
                JOptionPane.showMessageDialog(this, "Erro Cmdo SQL" + ex.getMessage() );
              
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Driver não Encontrado " + ex.getMessage() );
            }
            
        JOptionPane.showMessageDialog(null,
                "O Registro foi acionado com sucesso");
         limpar();

        
        }else {
             JOptionPane.showMessageDialog(null, mensagem);
        }
      
    }//GEN-LAST:event_txtBotao1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdadeActionPerformed

    private void limpar() {
        // TODO add your handling code here:
        txtIdade.setText("");
        txtOpniao.setText("");
    }

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton txtBotao1;
    private javax.swing.JButton txtBotaoR;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtOpniao;
    // End of variables declaration//GEN-END:variables
}
