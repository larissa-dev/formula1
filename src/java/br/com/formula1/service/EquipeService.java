
package br.com.formula1.service;

import br.com.formula1.dao.EquipeDao;
import br.com.formula1.domain.Equipe;
import java.util.List;

public class EquipeService {
     private EquipeDao equipeDao = new EquipeDao();
    
    public List<Equipe> listar(){
        return equipeDao.listar();
    }
    
    public Equipe consultar(Integer id){
        return equipeDao.consultar(id);
    }
    
    public boolean inserir(Equipe gp){
        return equipeDao.inserir(gp);
    }
    
    public boolean alterar(Equipe gp){
        return equipeDao.alterar(gp);
    }
    
    public boolean excluir(Equipe gp){
        return equipeDao.excluir(gp);
    }
}
