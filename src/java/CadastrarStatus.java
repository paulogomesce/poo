
import static entities.RepositoryAtomic.save;
import java.awt.event.ActionEvent;
import java.io.Serializable;

public class CadastrarStatus implements Serializable{

    public CadastrarStatus() {
    }    
    
    public String popularStatus(ActionEvent e){
        save(new NovaSolicitacao());
        save(new AguardandoChefia());
        save(new AguardandoRH());
        save(new Aprovada());
        save(new Recusada());
        save(new Cancelada());
        
        return null;
    }    
    
}
