package gt.gob.rgm.adm.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gt.gob.rgm.adm.model.RugBoletaPdf;

public class RugBoletaServlet extends HttpServlet {
	@Inject
	RugBoletaPdfService boletaService;
	
	@Inject
	BoletaPdfService boletaPdfService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/*String strId = req.getRequestURI().substring(req.getContextPath().length()).replaceAll("/rugboletap/", "");
		Long idTramite = Long.valueOf(strId);*/
		Long idTramite = Long.valueOf(req.getParameter("tramite"));
		Long idGarantia = Long.valueOf(req.getParameter("garantia"));
		Boolean generar = Boolean.valueOf(req.getParameter("generar") != null ? req.getParameter("generar") : "false");
		//RugBoletaPdf boleta = boletaService.getBoleta(id);
		List<RugBoletaPdf> boletas = boletaService.getBoletasByTramite(idTramite);
		
                
		byte[] archivo;
		if(boletas != null && !boletas.isEmpty() && !generar) {
                        System.out.println("nulo");
			archivo = boletas.get(boletas.size() - 1).getArchivo();
                        
		} else {
                        System.out.println("estoy en el else");
			archivo = boletaPdfService.getBoletaPdf(idTramite, idGarantia);
		}
                
                System.out.println("afuera");
		ByteArrayInputStream in = new ByteArrayInputStream(archivo);
		OutputStream out = res.getOutputStream();
		
		byte[] buf = new byte[1024];
		int count = 0;
		while((count = in.read(buf)) >= 0) {
			out.write(buf, 0, count);
		}
		out.flush();
		out.close();
	}
}
