/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formula1.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="piloto")
public class Piloto implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(name="nome")
    private String nome;
    
    @NotNull
    @Column(name="pontuacao")
    private Integer pontuacao;
    
    @ManyToOne
    @JoinColumn(name="idEquipePiloto", referencedColumnName="id")
    private Equipe equipe;
    
    //@OneToMany(mappedBy="id")
    //private List<Corrida> corridas;

    public Piloto() {
    }

    public Piloto(Integer id, String nome, Integer pontuacao, Equipe equipe) {
        this.id = id;
        this.nome = nome;
        this.pontuacao = pontuacao;
        this.equipe = equipe;
        //this.corridas = corridas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    //public List<Corrida> getCorridas() {
      //  return corridas;
    //}

    //public void setCorridas(List<Corrida> corridas) {
      //  this.corridas = corridas;
    //}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Piloto other = (Piloto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Piloto{" + "id=" + id + ", nome=" + nome + ", pontuacao=" + pontuacao + ", equipe=" + equipe + '}';
    }
    
}