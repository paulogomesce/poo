

import static entities.RepositoryAtomic.save;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    
    public static void main(String args[]){
        
        save(new NovaSolicitacao());
        save(new AguardandoChefia());
        save(new AguardandoRH());
        save(new Aprovada());
        save(new Recusada());
        
        /*
        Funcionario fun;
        fun = new Funcionario();
        fun.setNome("Paulo Gomes");
        
        persist(fun);
        
        Solicitacao sol = new Solicitacao();
        
        sol.setFuncionario(fun);
        sol.setInicio(new Date());
        sol.setMotivo("Fui fazer prova da Faculdade.");
        sol.setTermino(new Date());
        
        persist(sol);
        */
    }

}
