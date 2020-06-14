package br.com.formula1.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class CorridaPk implements Serializable {

    
    @NotNull
    @Column(name = "idPiloto")
    private int idPiloto;
    
    @NotNull
    @Column(name = "idGp")
    private int idGp;

    public CorridaPk() {
    }

    public CorridaPk(int idPiloto, int idGp) {
        this.idPiloto = idPiloto;
        this.idGp = idGp;
    }

    public int getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(int idPiloto) {
        this.idPiloto = idPiloto;
    }

    public int getIdGp() {
        return idGp;
    }

    public void setIdGp(int idGp) {
        this.idGp = idGp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idPiloto;
        hash = 67 * hash + this.idGp;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CorridaPk other = (CorridaPk) obj;
        if (this.idPiloto != other.idPiloto) {
            return false;
        }
        if (this.idGp != other.idGp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CorridaPk{" + "idPiloto=" + idPiloto + ", idGp=" + idGp + '}';
    }
}