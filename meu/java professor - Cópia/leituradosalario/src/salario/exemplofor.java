
package salario;

import javax.swing.JOptionPane;

public class exemplofor {
    
    public static void main(String[] args) {
        int numero = Integer.parseInt(
                JOptionPane.showInputDialog("Informe o número:"));
        int fatorial = 1;
        
        for(int b = 1; b <= numero;b++){
            fatorial *= b;
        }
        JOptionPane.showMessageDialog(null,"O fatorial é " +fatorial);
        
 }
}