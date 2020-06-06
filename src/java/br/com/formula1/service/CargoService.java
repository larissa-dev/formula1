
package br.com.formula1.service;

import br.com.formula1.dao.CargoDao;
import br.com.formula1.domain.Cargo;
import java.util.List;

public class CargoService {
     private CargoDao cargoDao = new CargoDao();
    
    public List<Cargo> listar(){
        return cargoDao.listar();
    }
    
    public Cargo consultar(Integer id){
        return cargoDao.consultar(id);
    }
    
    public boolean inserir(Cargo gp){
        return cargoDao.inserir(gp);
    }
    
    public boolean alterar(Cargo gp){
        return cargoDao.alterar(gp);
    }
    
    public boolean excluir(Cargo gp){
        return cargoDao.excluir(gp);
    }
}
