/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleidade;

/**
 *
 * @author 391151520171
 */
public class Relatorio {
    
      int numero;
      private  int numeroPessoasMaiores50 = 0;
      private int somaIdadeAltura150 = 0;
      private  int numeroPessoasMenores150 = 0;
      private  int numeroPessoasOlhosAzuis = 0;
      private  int numeroRuivosSemOlhosAzuis = 0;

    public int getNumeroPessoasMaiores50() {
        return numeroPessoasMaiores50;
    }

    public void setNumeroPessoasMaiores50(int numeroPessoasMaiores50) {
        this.numeroPessoasMaiores50 = numeroPessoasMaiores50;
    }

    public int getSomaIdadeAltura150() {
        return somaIdadeAltura150;
    }

    public void setSomaIdadeAltura150(int somaIdadeAltura150) {
        this.somaIdadeAltura150 = somaIdadeAltura150;
    }

    public int getNumeroPessoasMenores150() {
        return numeroPessoasMenores150;
    }

    public void setNumeroPessoasMenores150(int numeroPessoasMenores150) {
        this.numeroPessoasMenores150 = numeroPessoasMenores150;
    }

    public int getNumeroPessoasOlhosAzuis() {
        return numeroPessoasOlhosAzuis;
    }

    public void setNumeroPessoasOlhosAzuis(int numeroPessoasOlhosAzuis) {
        this.numeroPessoasOlhosAzuis = numeroPessoasOlhosAzuis;
    }

    public int getNumeroRuivosSemOlhosAzuis() {
        return numeroRuivosSemOlhosAzuis;
    }

    public void setNumeroRuivosSemOlhosAzuis(int numeroRuivosSemOlhosAzuis) {
        this.numeroRuivosSemOlhosAzuis = numeroRuivosSemOlhosAzuis;
    }

    
    public void adicionarPessoasMaiores50(){
        this.numeroPessoasMaiores50 ++;
    }
    
    public void acumularIdadePessoasAltura150(int idade ){
        this.somaIdadeAltura150 += idade;
        this.numeroPessoasMenores150 ++;
    }
    
    public void acumularPessoasOlhosAzuis(){
        this.numeroPessoasOlhosAzuis ++;
    }
    
    public void acumularPessoasRuivasSemOlhosAzuis(){
        this.numeroRuivosSemOlhosAzuis ++;
    }
}
