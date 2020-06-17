package br.com.formula1.controller;

import br.com.formula1.domain.Corrida;
import br.com.formula1.domain.Gp;
import br.com.formula1.domain.Piloto;
import br.com.formula1.service.CorridaService;
import br.com.formula1.service.GpService;
import br.com.formula1.service.PilotoService;
import br.com.formula1.util.UtilMensagens;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="gpMB")
@SessionScoped
public class GpController implements Serializable{
    private Gp gp = new Gp();
    private List<Gp> gps;
    private GpService gpService = new GpService();
    private Corrida corrida = new Corrida();
    private Piloto piloto = new Piloto();
    private List<Corrida> corridas;
    private List<Piloto> pilotos;
    private CorridaService corridaService = new CorridaService();
    private PilotoService pilotoService = new PilotoService();
    
    public GpController(){
        listar();
    }
    
    public void listar(){
        gps = gpService.listar();
    }
    
     public String novo(){
        gp = new Gp();
        pilotos = new ArrayList<>();
        piloto = new Piloto();
        corridas = new ArrayList<>();
        corrida = new Corrida();
        return "new.xhtml?faces-redirect=true";
    }
    
     public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String buscaDados(Gp gp){
        corrida = new Corrida();
        this.gp = gp;
        this.corridas=gpService.listarItens(gp);
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        if(gpService.inserir(gp,corridas)){
            UtilMensagens.mensagemSucesso("Sucesso", "Gp salvo com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar o gp!");
        return null;
    }
    
    public String alterar(){
        if(gpService.alterar(gp,corridas)){
            UtilMensagens.mensagemSucesso("Sucesso", "Gp alterado com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar o gp!");
        return null;
    }
    
    public String excluir(Gp gp){
        if(gpService.excluir(gp)){
            UtilMensagens.mensagemSucesso("Sucesso", "Gp excluido com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir o gp!");
        return null;
    }

    public void addPiloto(){
        if(corrida.getPiloto()==null||corrida.getPosicao()<=0){
            UtilMensagens.mensagemErro("Erro","Informe o piloto e a posição");
        }else{
            Boolean condicao=true;
            for(Corrida gpp:corridas){
                if((gpp.getPosicao()==corrida.getPosicao())||(gpp.getPiloto().equals(corrida.getPiloto()))){
                    condicao=false;
                    break;
                }
            }
            if(condicao){
                switch(corrida.getPosicao()){
                    case 1:{
                        corrida.setPontos(25);
                        break;
                    }
                    case 2:{
                        corrida.setPontos(18);
                        break;
                    }
                    case 3:{
                        corrida.setPontos(15);
                        break;
                    }
                    case 4:{
                        corrida.setPontos(12);
                        break;
                    }
                    case 5:{
                        corrida.setPontos(10);
                        break;
                    }
                    case 6:{
                        corrida.setPontos(8);
                        break;
                    }
                    case 7:{
                        corrida.setPontos(6);
                        break;
                    }
                    case 8:{
                        corrida.setPontos(4);
                        break;
                    }
                    case 9:{
                        corrida.setPontos(2);
                        break;
                    }
                    case 10:{
                        corrida.setPontos(1);
                        break;
                    }
                    default:{
                        corrida.setPontos(0);
                        break;
                    }
                }
                corridas.add(corrida);
                corrida=new Corrida();
            }else{
                UtilMensagens.mensagemErro("Erro","Posicao e/ou Piloto ja foi inserido");
            }
        }
    }
    
    public void removePiloto(Corrida corrida){
        corridas.remove(corrida);
    }
    
    public String imprimirGP(Gp gp){
        corrida = new Corrida();
        this.gp = gp;
        this.corridas=gpService.listarItens(gp);
        return "print.xhtml?faces-redirect=true";
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

    public Corrida getCorrida() {
        return corrida;
    }

    public void setCorrida(Corrida corrida) {
        this.corrida = corrida;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public List<Corrida> getCorridas() {
        return corridas;
    }

    public void setCorridas(List<Corrida> corridas) {
        this.corridas = corridas;
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }
    
    
    
    
}
