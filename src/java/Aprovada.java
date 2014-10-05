

import entities.annotations.EntityDescriptor;
import java.util.Objects;
import javax.persistence.Entity;

@EntityDescriptor(hidden = true)
@Entity
public class Aprovada extends Status {

    public Aprovada() {
        this.codigo = 4L;
    }

    @Override
    public void solicitar() {
        throw new IllegalStateException("Não pode solicitar uma solicitação já aprovada.");
    }

    @Override
    public void aprovar() {
        throw new IllegalStateException("A solicitação já está aprovada.");
    }

    @Override
    public void recusar() {
        throw new IllegalStateException("Não pode recusar uma solicitação já aprovada.");
    }

    @Override
    public void retornar() {
        throw new IllegalStateException("Não pode retornar um solicitação já aprovada.");
    }
    
    @Override
    public void cancelar() {
        this.solicitacao.setStatus(new Cancelada());
    }    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.codigo);
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
        final Aprovada other = (Aprovada) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aprovada";
    }
    

}
