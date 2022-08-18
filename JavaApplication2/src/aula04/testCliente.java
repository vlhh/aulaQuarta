package aula04;

/**
 *
 * @author vitoria.schneider
 */
public class testCliente {
    
    public static void main(String[] args) {
        
        Pessoa objetoPessoa = new Pessoa("Vitoria","teutonia",18,true);        
        System.out.println(objetoPessoa.toString());
        
        Pessoa objetoPessoa2 = new Pessoa("Vitoria2","Lajeado",26,true);        
        System.out.println(objetoPessoa2.toString());
        
        
        if(objetoPessoa.getIdade()>objetoPessoa2.getIdade()){
            System.out.println( objetoPessoa.getNome()+" é o mais novo");
        }else if(objetoPessoa.getIdade()<objetoPessoa2.getIdade()){
            System.out.println( objetoPessoa2.getNome()+" é o mais novo");
        }else{
            System.out.println("os dois tem a mesma idade");
        }
        
    }
    
}
