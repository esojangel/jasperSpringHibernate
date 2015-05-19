package com.dem.service;

import java.util.List;

import com.dem.dao.SistemaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dem.model.Sistemas;
@Service
public class SistemaSrvImpl implements SistemaSrv {
	
	private SistemaDao sistemaDao;
	
	public void setSistemaDao(SistemaDao sistemaDao) {
        this.sistemaDao = sistemaDao;
    }
	@Override
    @Transactional
	public List<Sistemas> getAll(){
		return sistemaDao.listSistemas();
	}
	@Override
	@Transactional
	public Sistemas getSistemaById(int id){
		return this.sistemaDao.getById(id);
	}
}
