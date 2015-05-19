package com.dem.controller;

import net.sf.jasperreports.data.jdbc.JdbcDataAdapterImpl;
import net.sf.jasperreports.engine.JRException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dem.dao.SistemaDaoImpl;
import com.dem.model.Sistemas;
import com.dem.service.ResporteSrvImpl;
import com.dem.service.SistemaSrv;
import com.dem.util.DataSourseBD;
import java.sql.Connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.String;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class MainController{
	
	private static final Logger logger = LoggerFactory.getLogger(SistemaDaoImpl.class);
	private ResporteSrvImpl reporteSrv = new ResporteSrvImpl();

	private SistemaSrv sistemaSrv;
	private JdbcDataAdapterImpl con;
  
    @Autowired(required=true)
    @Qualifier(value="sistemaSrv")
    public void setSistemaSrv(SistemaSrv ss){
        this.sistemaSrv = ss;
    }
	
	@RequestMapping
	public String getHomePage(Model model){
		HashMap<String,List<Sistemas>> map = new HashMap<String,List<Sistemas>>();
		map.put("sistemas", sistemaSrv.getAll());
		model.addAttribute("sistemas",sistemaSrv.getAll());
		
		return "index";
	}
	@RequestMapping("/welcome")
	public String welcome(){
		
		return "welcome";	
	}

	@RequestMapping(value = "/pdf/{idSistema}/{reporte}", method = RequestMethod.GET)
	public void descargar(
			HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("idSistema") String idSistema,
			@PathVariable("reporte") String reporte) throws JRException, IOException, SQLException, ClassNotFoundException {
		//para los parametros
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("saludo", "Hola mundo");
		
		Sistemas sys = this.sistemaSrv.getSistemaById(new Integer(idSistema));
		//para la conexion
		DataSourseBD db = new DataSourseBD();
		Connection con = db.getConexion(sys);
		reporteSrv.descargar(request,response, params,reporte,con);
	}
}
