package br.com.formula1.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "corrida")
public class Corrida implements Serializable {

    @EmbeddedId
    protected CorridaPk corridaPk;
    
    @NotNull
    @Column(name = "posicao")
    private int posicao;
    
    @NotNull
    @Column(name = "pontos")
    private int pontos;
    
    
    @JoinColumn(name = "idGp", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Gp gp;
    
    @JoinColumn(name = "idPiloto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Piloto piloto;

    public Corrida() {
    }

    public Corrida (CorridaPk corridaPk) {
        this.corridaPk = corridaPk;
    }

    public Corrida(CorridaPk corridaPk, int posicao, int pontos) {
        this.corridaPk = corridaPk;
        this.posicao = posicao;
        this.pontos = pontos;
    }
   
    public Corrida(int idPiloto, int idGp) {
        this.corridaPk = new CorridaPk(idPiloto, idGp);
    }

    public CorridaPk getCorridaPk() {
        return corridaPk;
    }

    public void setCorridaPk(CorridaPk corridaPk) {
        this.corridaPk = corridaPk;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public Gp getGp() {
        return gp;
    }

    public void setGp(Gp gp) {
        this.gp = gp;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (corridaPk != null ? corridaPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Corrida)) {
            return false;
        }
        Corrida other = (Corrida) object;
        if ((this.corridaPk == null && other.corridaPk != null) || (this.corridaPk != null && !this.corridaPk.equals(other.corridaPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Corrida{" + "corridaPk=" + corridaPk + ", posicao=" + posicao + ", pontos=" + pontos + ", gp=" + gp + ", piloto=" + piloto + '}';
    }   
}