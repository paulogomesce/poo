

import static entities.RepositoryAtomic.save;
import entities.annotations.EntityDescriptor;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

//@EntityDescriptor(hidden = true)
@Entity
public abstract class Status implements Serializable {

    @Transient
    protected Solicitacao solicitacao;
    
    @Id
    protected Long codigo;

    protected void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    abstract public void solicitar();

    abstract public void aprovar();

    abstract public void recusar();

    abstract public void retornar();
    
    abstract public void cancelar();
    
    abstract public void estornarAprovacao();

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Status other = (Status) obj;
        if (!Objects.equals(this.solicitacao, other.solicitacao)) {
            return false;
        }
        return true;
    }

}
