/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoNota1;

/**
 *
 * @author vitor
 */
public class TesteConta {
    public static void main(String[] args) {
        
        Conta objetoConta = new Conta("Viória",13123123,2000,213123);        
        System.out.println("saldo na conta: " +objetoConta.getSaldoConta());
        
        Conta objetoConta2 = new Conta("Viória2",82347234,800,234234);        
        System.out.println("saldo na conta: "+ objetoConta2.getSaldoConta());
        
        
        //-------------Depositar 100 reias na conta1-------------
        
        objetoConta.depositar(100);
        //double novoSaldo = objetoConta.getSaldoConta()+100;
        //objetoConta.setSaldoConta(novoSaldo);
        
        System.out.println("saldo na conta: " +objetoConta.getSaldoConta());
        System.out.println("saldo na conta2: "+ objetoConta2.getSaldoConta());
        
        //---------------Sacar 400 da conta2------------------
        
        objetoConta2.sacar(400);
        //double novoSaldo = objetoConta2.getSaldoConta()-400;
        //objetoConta2.setSaldoConta(novoSaldo);
        
        System.out.println("saldo na conta: " +objetoConta.getSaldoConta());
        System.out.println("saldo na conta2: "+ objetoConta2.getSaldoConta());
        
        
        //----------------Transferir 100 -----------------------
        
        //double novoSaldoConta = objetoConta.getSaldoConta()-100;
        //double novoSaldoConta2 = objetoConta2.getSaldoConta()+100;
        //objetoConta.setSaldoConta(novoSaldoConta);
        //objetoConta2.setSaldoConta(novoSaldoConta2);
        objetoConta.transferir(1000, objetoConta2);
        
        //if(objetoConta.Sacar(1000)){
        //    objetoConta2.Depositar(1000);
        //}
        
        System.out.println("saldo na conta: " +objetoConta.getSaldoConta());
        System.out.println("saldo na conta2: "+ objetoConta2.getSaldoConta());
    }
    
}
