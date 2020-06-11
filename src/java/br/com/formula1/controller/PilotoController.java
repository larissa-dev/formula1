package br.com.formula1.controller;


import br.com.formula1.domain.Piloto;
import br.com.formula1.service.PilotoService;
import br.com.formula1.util.UtilMensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="pilotoMB")
@SessionScoped
public class PilotoController implements Serializable{
    
    private Piloto piloto = new Piloto();
    private List<Piloto> pilotos;
    private PilotoService pilotoService = new PilotoService();
    
    public PilotoController(){
        listar();
    }
    
    public void listar(){
        pilotos = pilotoService.listar();
    }
    
    public String novo(){
        piloto = new Piloto();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String buscaDados(Piloto piloto){
        this.piloto = piloto;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        if (verificaPiloto()){
            if (pilotoService.inserir(piloto)){
                UtilMensagens.mensagemSucesso("Sucesso", "Piloto salvo com sucesso!");
                this.listar();
                return "list.xhtml?faces-redirect=true";
            }
            UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar o piloto"); 
        }
        UtilMensagens.mensagemErro("Erro", "Equipe esta completa!"); 
        return null;
    }
    
    public String alterar(){
        if (verificaPiloto()){
            if (pilotoService.alterar(piloto)){
                UtilMensagens.mensagemSucesso("Sucesso", "Piloto alterado com sucesso!");
                this.listar();
                return "list.xhtml?faces-redirect=true";
            }
            UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar o piloto");
        }
        UtilMensagens.mensagemErro("Erro", "Equipe esta completa!"); 
        return null;
    }
    
    public String excluir(Piloto piloto){
        if (pilotoService.excluir(piloto)){
            UtilMensagens.mensagemSucesso("Sucesso", "Piloto excluído com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir o piloto");
        return null;
    }
    
    public Boolean verificaPiloto(){
        int quantEquipe = 0;
        List<Piloto> pilotosEquipe;
        pilotosEquipe = pilotoService.listarEquipePiloto(piloto.getEquipe().getId());
        for (Piloto p: pilotosEquipe){
                quantEquipe++;
        }
        if (quantEquipe < 2){
            return true;
        }
        return false;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }   
}