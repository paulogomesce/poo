import entities.annotations.EntityDescriptor;
import javax.persistence.Entity;

@EntityDescriptor(hidden = true)
@Entity
public class AguardandoChefia extends Status {

    public AguardandoChefia() {
        this.codigo = 2L;
    }

    @Override
    public void solicitar() {
        throw new IllegalStateException("Solicitação já solicitada.");
    }

    @Override
    public void aprovar() {
        this.solicitacao.setStatus(new AguardandoRH());
    }

    @Override
    public void recusar() {
        this.solicitacao.setStatus(new Recusada());
    }

    @Override
    public void retornar() {
        throw new IllegalStateException("Chefia não pode retornar solicitação.");
    }

    @Override
    public void cancelar() {
        this.solicitacao.setStatus(new Cancelada());
    }

    @Override
    public void estornarAprovacao() {
        throw new IllegalStateException("É permitido estornar apenas solicitações já aprovadas pelo RH.");
    }    
    
    /*Métodos HashCode, equals e toString*/
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
        final AguardandoChefia other = (AguardandoChefia) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aguardando Chefia";
    }
}
