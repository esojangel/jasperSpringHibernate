package com.dem.service;

import java.util.List;
import com.dem.model.Sistemas;
public interface SistemaSrv {
	public List<Sistemas> getAll(); 
	public Sistemas getSistemaById(int id);
}
