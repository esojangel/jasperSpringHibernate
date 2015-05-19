package com.dem.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;

import net.sf.jasperreports.engine.JRException;

public interface ResporteSrv {
	void descargar(HttpServletRequest request,HttpServletResponse response,Map<String, Object> parametros,String reporte,Connection con) throws JRException, IOException, SQLException;
}
