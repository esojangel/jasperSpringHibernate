package com.dem.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;


import org.springframework.stereotype.Service;

import java.sql.Connection;


@Service
public class ResporteSrvImpl implements ResporteSrv {
	JasperReport jasperReport;
//	DriverManagerDataSource dataSource;
	
	
    public void descargar(HttpServletRequest request,HttpServletResponse response,Map<String, Object> parametros,String reporte,Connection con) throws JRException, IOException, SQLException {
    	String path = request.getSession().getServletContext().getRealPath("/resources/jasper/");
		File fichero = new File(path + "/"+reporte+".jrxml");
        jasperReport = JasperCompileManager.compileReport(fichero.toString());	
    	byte[] reporteStream = null;
//    	reporteStream = JasperRunManager.runReportToPdf(jasperReport, parametros,new JREmptyDataSource());
    	reporteStream = JasperRunManager.runReportToPdf(jasperReport, parametros,con);
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "inline; filename=dem.pdf");
        response.setHeader("Pragma", "No-cache");
        response.setDateHeader("Expires", 0);
        response.setContentLength(reporteStream.length);
        ServletOutputStream out = response.getOutputStream();
        out.write(reporteStream, 0, reporteStream.length);
        out.flush();
        out.close();
        return;
    }

}
