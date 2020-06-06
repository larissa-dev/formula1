package br.com.formula1.service;

import br.com.formula1.dao.FuncionarioDao;
import br.com.formula1.domain.Funcionario;
import java.util.List;

public class FuncionarioService {
     private FuncionarioDao funcionarioDao = new FuncionarioDao();
    
    public List<Funcionario> listar(){
        return funcionarioDao.listar();
    }
    
    public Funcionario consultar(Integer id){
        return funcionarioDao.consultar(id);
    }
    
    public boolean inserir(Funcionario gp){
        return funcionarioDao.inserir(gp);
    }
    
    public boolean alterar(Funcionario gp){
        return funcionarioDao.alterar(gp);
    }
    
    public boolean excluir(Funcionario gp){
        return funcionarioDao.excluir(gp);
    }
    
}
