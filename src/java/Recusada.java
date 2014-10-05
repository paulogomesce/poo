

import entities.annotations.EntityDescriptor;
import java.util.Objects;
import javax.persistence.Entity;

@EntityDescriptor(hidden = true)
@Entity
public class Recusada extends Status {
    
    public Recusada(){
        this.codigo = 5L;
    }

    @Override
    public void solicitar() {
        throw new IllegalStateException("não pode solicitar uma solicitação recusada.");
    }

    @Override
    public void aprovar() {
        throw new IllegalStateException("não pode provar uma solicitação recusada.");
    }

    @Override
    public void recusar() {
        throw new IllegalStateException("A solicitação já está recusada.");
    }

    @Override
    public void retornar() {
        throw new IllegalStateException("Não pode retornar uma solicitação recusada.");
    }
    
    @Override
    public void cancelar() {
        this.solicitacao.setStatus(new Cancelada());
    }   

    @Override
    public void estornarAprovacao() {
        throw new IllegalStateException("É permitido estornar apenas solicitações aprovadas pelo RH.");
    }    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.codigo);
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
        final Recusada other = (Recusada) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Recusada";
    }
}
