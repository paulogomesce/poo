

import entities.annotations.EntityDescriptor;
import java.util.Objects;
import javax.persistence.Entity;

@EntityDescriptor(hidden = true)
@Entity
public class NovaSolicitacao extends Status {
    
    public NovaSolicitacao(){
        this.codigo = 1L;
    }
    
    @Override
    public void solicitar() {
        this.solicitacao.setStatus(this.solicitacao.getTipoSolicitacao().atrbuirStatus());
    }

    @Override
    public void aprovar() {
        throw new IllegalStateException("Nova solicitação não pode ser aprovada.");
    }

    @Override
    public void recusar() {
        throw new IllegalStateException("Nova solicitação não pode ser recusada.");
    }

    @Override
    public void retornar() {
        throw new IllegalStateException("Nova solicitação não pode ser retornada.");
    } 
    
    @Override
    public void cancelar() {
        throw new IllegalStateException("Uma nova solicitação não pode ser cancelada. Solicite à sua chefia o cancelamento.");
    }

    @Override
    public void estornarAprovacao() {
        throw new IllegalStateException("É permitido estornar apenas solicitações já aprovadas pelo RH.");
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
        final NovaSolicitacao other = (NovaSolicitacao) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nova Solicitacao";
    }   
    
}
