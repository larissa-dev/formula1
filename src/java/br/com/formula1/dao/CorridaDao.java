package br.com.formula1.dao;

import br.com.formula1.domain.Corrida;
import br.com.formula1.domain.Gp;
import br.com.formula1.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class CorridaDao {
    public List<Corrida> listar(Gp gp){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            List<Corrida> corridas = session.createQuery("from Corrida where idGp = "+gp.getId()+" order by posicao").list();
            session.getTransaction().commit();
            return corridas;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }
    
    public boolean inserir(Corrida corrida){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.save(corrida);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }   
    
    public boolean alterar(Corrida corrida){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            session.update(corrida);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    } 
     
    public boolean excluir(Gp gp){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery("delete Corrida where idGp = :idGp");
            query.setParameter("idGp", gp.getId());
            query.executeUpdate();
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }    
}