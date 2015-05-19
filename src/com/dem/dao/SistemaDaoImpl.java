package com.dem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.dem.model.Sistemas;

@Repository
public class SistemaDaoImpl implements SistemaDao{
	private static final Logger logger = LoggerFactory.getLogger(SistemaDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public List<Sistemas> listSistemas() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Sistemas> sistemasList = session.createQuery("from Sistemas").list();
        for(Sistemas p : sistemasList){
            logger.debug("Person List::"+p.toString());
        }
        return sistemasList;
	}
	@Override
	public Sistemas getById(int id){
		Session session = this.sessionFactory.getCurrentSession();
//		Sistemas sys = (Sistemas)session.load(Sistemas.class,new Integer(id));
		Sistemas sys = (Sistemas)session.createQuery("from Sistemas where id="+id).list().get(0);
		return sys;
	}
}
