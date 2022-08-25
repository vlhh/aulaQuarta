/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoNota1;

/**
 *
 * @author vitor
 */
public class Conta {
    
    private String titular;
    private int numConta;
    private double saldoConta;
    private double limitCheque;

    public Conta(String titular, int numConta, double saldoConta, double limitCheque) {
        this.titular = titular;
        this.numConta = numConta;
        this.saldoConta = saldoConta;
        this.limitCheque = limitCheque;
    }
    
    public Conta() {
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public double getLimitCheque() {
        return limitCheque;
    }

    public void setLimitCheque(double limitCheque) {
        this.limitCheque = limitCheque;
    }

    @Override
    public String toString() {
        return "Cliente{" + "titular=" + titular + ", numConta=" + numConta + ", saldoConta=" + saldoConta + ", limitCheque=" + limitCheque + '}';
    }
    
    public void depositar(double valor){
        this.saldoConta +=valor;
    }
    
    public boolean sacar(double valor){
        if(this.saldoConta>=valor){
            this.saldoConta -=valor;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean transferir(double valorTranferencia, Conta objContaDestino){
        if(this.sacar(valorTranferencia)){
            objContaDestino.depositar(valorTranferencia);
            return true;
        }else{
            return false;
        }
        
    }
    
}
