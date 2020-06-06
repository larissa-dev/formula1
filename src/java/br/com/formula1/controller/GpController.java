package br.com.formula1.controller;

import br.com.formula1.domain.Gp;
import br.com.formula1.service.GpService;
import br.com.formula1.util.UtilMensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="gpMB")
@SessionScoped
public class GpController implements Serializable{
    private Gp gp = new Gp();
    private List<Gp> gps;
    private GpService gpService = new GpService();
    
    public GpController(){
        listar();
    }
    
    public void listar(){
        gps = gpService.listar();
    }
    
    public String novo(){
        gp = new Gp();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String buscaDados(Gp gp){
        this.gp = gp;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        if (gpService.inserir(gp)){
            UtilMensagens.mensagemSucesso("Sucesso", "Gp salvo com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar o gp!");
        return null;
    }
    
    public String alterar(){
        if (gpService.alterar(gp)){
            UtilMensagens.mensagemSucesso("Sucesso", "Gp alterado com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar o gp");
        return null;
    }
    
    public String excluir(Gp gp){
        if (gpService.excluir(gp)){
            UtilMensagens.mensagemSucesso("Sucesso", "Gp excluído com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir o gp");
        return null;
    }

    public Gp getGp() {
        return gp;
    }

    public void setGp(Gp gp) {
        this.gp = gp;
    }

    public List<Gp> getGps() {
        return gps;
    }

    public void setGps(List<Gp> gps) {
        this.gps = gps;
    }

    public GpService getGpService() {
        return gpService;
    }

    public void setGpService(GpService gpService) {
        this.gpService = gpService;
    }
}
