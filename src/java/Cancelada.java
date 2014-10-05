
import entities.annotations.EntityDescriptor;
import javax.persistence.Entity;

@EntityDescriptor(hidden = true)
@Entity
public class Cancelada extends Status{

    public Cancelada() {
        this.codigo = 6L;
    }

    @Override
    public void solicitar() {
        throw new IllegalStateException("A solicitação encontra-se cancelada");
    }

    @Override
    public void aprovar() {
        throw new IllegalStateException("Não é permitido aprovar uma solicitação cancelada");
    }

    @Override
    public void recusar() {
        throw new IllegalStateException("Não é permitido recusar uma solicitação cancelada");
    }

    @Override
    public void retornar() {
        throw new IllegalStateException("Não é permitido retornar uma solicitação cancelada");
    }

    @Override
    public void cancelar() {
        throw new IllegalStateException("A solicitação já encontra-se cancelada");
    }
    
    @Override
    public void estornarAprovacao() {
        throw new IllegalStateException("É permitido estornar apenas solicitações já aprovadas pelo RH.");
    }    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.codigo ^ (this.codigo >>> 32));
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
        final Cancelada other = (Cancelada) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cancelada";
    }
    
    
}
