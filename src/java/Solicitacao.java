

import static entities.RepositoryAtomic.save;
import entities.annotations.EntityDescriptor;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@EntityDescriptor(template = "@TABLE_CRUDE")
@Entity
public class Solicitacao implements Serializable {

    @Id @GeneratedValue
    @Column(length = 10)
    private Long codigo;
    
    @OneToOne
    private Funcionario funcionario;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date inicio;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date termino;
    
    @Lob
    private String motivo;
    
    @Lob
    private String observacao;
    
    @Enumerated(EnumType.ORDINAL)
    private EnumTipoSolicitacao tipoSolicitacao;    
    
    @OneToOne
    private Status status = new NovaSolicitacao();

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long matricula) {
        this.codigo = matricula;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    protected void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
    
    public EnumTipoSolicitacao getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public void setTipoSolicitacao(EnumTipoSolicitacao tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
    }
    
    /*Declaração dos métodos*/
    public void solicitar() {
        this.status.setSolicitacao(this);
        this.status.solicitar();
        save(this);
    }

    public void aprovar() {
        this.status.setSolicitacao(this);
        this.status.aprovar();
        save(this);
    }

    public void recusar() {
        this.status.setSolicitacao(this);
        this.status.recusar();
        save(this);
    }

    public void retornar() {
        this.status.setSolicitacao(this);
        this.status.retornar();
        save(this);
    }
    
    public void cancelar(){
        this.status.setSolicitacao(this);
        this.status.cancelar();
        save(this);
    }
    
    public void estornarAprovacao(){
        this.status.setSolicitacao(this);
        this.status.estornarAprovacao();
        save(this);        
    }   
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + Objects.hashCode(this.funcionario);
        hash = 19 * hash + Objects.hashCode(this.inicio);
        hash = 19 * hash + Objects.hashCode(this.termino);
        hash = 19 * hash + Objects.hashCode(this.status);
        hash = 19 * hash + Objects.hashCode(this.tipoSolicitacao);
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
        final Solicitacao other = (Solicitacao) obj;
        if (this.codigo != other.codigo && (this.codigo == null || !this.codigo.equals(other.codigo))) {
            return false;
        }
        if (this.funcionario != other.funcionario && (this.funcionario == null || !this.funcionario.equals(other.funcionario))) {
            return false;
        }
        if (this.inicio != other.inicio && (this.inicio == null || !this.inicio.equals(other.inicio))) {
            return false;
        }
        if (this.termino != other.termino && (this.termino == null || !this.termino.equals(other.termino))) {
            return false;
        }
        if (this.tipoSolicitacao != other.tipoSolicitacao) {
            return false;
        }
        if (this.status != other.status && (this.status == null || !this.status.equals(other.status))) {
            return false;
        }
        return true;
    }
}
