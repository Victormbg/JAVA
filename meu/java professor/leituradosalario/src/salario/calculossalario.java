package salario;
import javax.swing.JOptionPane;
public class calculossalario {

    public static void main(String[] args) {
      double salario = Double.parseDouble(
              JOptionPane.showInputDialog("Informe o salário:"));
      double salarioReajustado = 0.00;
      
      if(salario <1500){
            salarioReajustado = salario * 0.15; 
      } else if (salario >=1500 && salario <= 1750){
            salarioReajustado = salario * 0.12;
      } else if (salario >=1750 && salario <= 2000 ){
            salarioReajustado = salario * 0.10;
      } else if (salario > 2000 && salario <= 3000) {
                salarioReajustado = salario * 0.07;
      } else if (salario > 3000) {
                salarioReajustado = salario * 0.05;
      }
            
      JOptionPane.showMessageDialog(null, "O seu salário foi reajustado para " 
              + salarioReajustado);
          
    }
}
