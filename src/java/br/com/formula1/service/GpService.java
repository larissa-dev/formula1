package br.com.formula1.service;

import br.com.formula1.dao.CorridaDao;
import br.com.formula1.dao.GpDao;
import br.com.formula1.domain.Corrida;
import br.com.formula1.domain.CorridaPk;
import br.com.formula1.domain.Gp;
import br.com.formula1.domain.Piloto;
import java.util.List;

public class GpService {
    
    private GpDao gpDao = new GpDao();
    private CorridaDao corridaDao = new CorridaDao();
    
    public List<Gp> listar(){
        return gpDao.listar();
    }
    
    public Gp consultar(Integer id){
        return gpDao.consultar(id);
    }
    
    public boolean inserir(Gp gp, List<Corrida> corridas){
        Integer id=gpDao.inserir(gp);
        gp=gpDao.consultar(id);
        int cont=0;
        for (Corrida gpPosicao:corridas){
            CorridaPk gpPosicaoPk=new CorridaPk();
            gpPosicaoPk.setIdGp(gp.getId());
            gpPosicaoPk.setIdPiloto(corridas.get(cont).getPiloto().getId());
            gpPosicao.setCorridaPk(gpPosicaoPk);
            corridaDao.inserir(gpPosicao);
            cont++;
        }
        return true;
    }
    
    public boolean alterar(Gp gp,List<Corrida> corridas){
        corridaDao.excluir(gp);
        int cont=0;
        for (Corrida gpPosicao:corridas){
            CorridaPk gpPosicaoPk=new CorridaPk();
            gpPosicaoPk.setIdGp(gp.getId());
            gpPosicaoPk.setIdPiloto(corridas.get(cont).getPiloto().getId());
            gpPosicao.setCorridaPk(gpPosicaoPk);
            corridaDao.inserir(gpPosicao);
            cont++;
        }
        return true;
    }
    
    public boolean excluir(Gp gp){
        return gpDao.excluir(gp);
    }
    
    public List<Corrida> listarItens(Gp gp){
        return corridaDao.listar(gp);
    }
}