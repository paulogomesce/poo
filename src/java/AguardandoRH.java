import entities.annotations.EntityDescriptor;
import java.util.Objects;
import javax.persistence.Entity;

@EntityDescriptor(hidden = true)
@Entity
public class AguardandoRH extends Status {

    public AguardandoRH() {
        this.codigo = 3L;
    }

    @Override
    public void solicitar() {
        throw new IllegalStateException("Aguardando RH não pode solicitar.");
    }

    @Override
    public void aprovar() {
        this.solicitacao.setStatus(new Aprovada());
    }

    @Override
    public void recusar() {
        this.solicitacao.setStatus(new Recusada());
    }

    @Override
    public void retornar() {
        this.solicitacao.setStatus(new AguardandoChefia());
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
        final AguardandoRH other = (AguardandoRH) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aguardando RH";
    }
}
