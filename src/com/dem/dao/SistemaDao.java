package com.dem.dao;

import java.util.List;

//import com.dem.domain.System;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//public interface SystemReporitory extends CrudRepository<System, String> {
//	
//	@Query("select * from system")
//	List<System> findAll();
//	
//}
import com.dem.model.Sistemas;

public interface SistemaDao{
	public List<Sistemas> listSistemas();
	public Sistemas getById(int id);
}