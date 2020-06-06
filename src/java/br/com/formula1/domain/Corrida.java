package br.com.formula1.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="corrida")
public class Corrida implements Serializable{
    
    @EmbeddedId
    private CorridaPk corridapk = new CorridaPk();
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(name="data")
    private Date dataHora;
    
    @Column(name="local")
    private String local;
    
    @Column(name="posicaoPiloto")
    private Integer posicaoPiloto;
     
    @ManyToOne
    @JoinColumn(name="idPiloto", referencedColumnName="id")
    private Piloto piloto;
    
     @ManyToOne
    @JoinColumn(name="idGp", referencedColumnName="id")
    private Gp gp;
    

    public Corrida() {
    }
    
    
    
    
}