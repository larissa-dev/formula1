
package br.com.formula1.service;

import br.com.formula1.dao.PilotoDao;
import br.com.formula1.domain.Piloto;
import java.util.List;


public class PilotoService {
     private PilotoDao pilotoDao = new PilotoDao();
    
    public List<Piloto> listar(){
        return pilotoDao.listar();
    }
    
    public Piloto consultar(Integer id){
        return pilotoDao.consultar(id);
    }
    
    public boolean inserir(Piloto gp){
        return pilotoDao.inserir(gp);
    }
    
    public boolean alterar(Piloto gp){
        return pilotoDao.alterar(gp);
    }
    
    public boolean excluir(Piloto gp){
        return pilotoDao.excluir(gp);
    }
    
}
