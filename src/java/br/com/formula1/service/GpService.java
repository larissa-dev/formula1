package br.com.formula1.service;

import br.com.formula1.dao.GpDao;
import br.com.formula1.domain.Gp;
import java.util.List;

public class GpService {
    
    private GpDao gpDao = new GpDao();
    
    public List<Gp> listar(){
        return gpDao.listar();
    }
    
    
    public Gp consultar(Integer id){
        return gpDao.consultar(id);
    }
    
    public boolean inserir(Gp gp){
        return gpDao.inserir(gp);
    }
    
    public boolean alterar(Gp gp){
        return gpDao.alterar(gp);
    }
    
    public boolean excluir(Gp gp){
        return gpDao.excluir(gp);
    }
}
