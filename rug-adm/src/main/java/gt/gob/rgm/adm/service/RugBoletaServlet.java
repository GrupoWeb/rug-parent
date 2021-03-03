package gt.gob.rgm.adm.service;

import gt.gob.rgm.adm.constants.ConstantsCv;
//import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gt.gob.rgm.adm.model.RugBoletaPdf;
//import gt.gob.rgm.security.domain.SignatureInfo;
//import gt.gob.rgm.security.service.DigitalSignatureServiceImp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.GeneralSecurityException;

public class RugBoletaServlet extends HttpServlet {
	@Inject
	RugBoletaPdfService boletaService;
	
	@Inject
	BoletaPdfService boletaPdfService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            
//                DigitalSignatureServiceImp digitalSignatureSvc = new DigitalSignatureServiceImp();
//		SignatureInfo info = new SignatureInfo();
                
//                String signText = "";
//		String signImage = "";
//		String signFile = "";
//		String signPassword = "";
//		String signLocation = "";
//		String signLlx = "";
//		String signLly = "";
//		String signUrx = "";
//		String signUry = "";
//		String signPage = "";
//		String signFieldname = "";
                
		/*String strId = req.getRequestURI().substring(req.getContextPath().length()).replaceAll("/rugboletap/", "");
		Long idTramite = Long.valueOf(strId);*/
		Long idTramite = Long.valueOf(req.getParameter("tramite"));
		Long idGarantia = Long.valueOf(req.getParameter("garantia"));
		Boolean generar = Boolean.valueOf(req.getParameter("generar") != null ? req.getParameter("generar") : "false");
		//RugBoletaPdf boleta = boletaService.getBoleta(id);
		List<RugBoletaPdf> boletas = boletaService.getBoletasByTramite(idTramite);
		
                
                		// parametros firma

//		signText = ConstantsCv.getParamValue(ConstantsCv.SIGN_TEXT);
//		//signImage = ConstantsCv.getParamValue(ConstantsCv.SIGN_IMAGE);
//                signImage = "C:/certificado_RGM/firma.png";
//		//signFile = ConstantsCv.getParamValue(ConstantsCv.SIGN_FILE);
//                signFile = "C:/certificado_RGM/rgm.p12";
//		signPassword = ConstantsCv.getParamValue(ConstantsCv.SIGN_PASSWORD);
//		signLocation = ConstantsCv.getParamValue(ConstantsCv.SIGN_LOCATION);
//		signLlx = ConstantsCv.getParamValue(ConstantsCv.SIGN_LLX);
//		signLly = ConstantsCv.getParamValue(ConstantsCv.SIGN_LLY);
//		signUrx = ConstantsCv.getParamValue(ConstantsCv.SIGN_URX);
//		signUry = ConstantsCv.getParamValue(ConstantsCv.SIGN_URY);
//		signPage = ConstantsCv.getParamValue(ConstantsCv.SIGN_PAGE);
//		signFieldname = ConstantsCv.getParamValue(ConstantsCv.SIGN_FIELDNAME);
//                
//                info.setSignText(signText);
//                info.setGraphicSignature(signImage);
//                info.setKeyFile(signFile);
//                info.setKeyPassword(signPassword);
//                info.setLocation(signLocation);
//                info.setLlx(Integer.valueOf(signLlx));
//                info.setLly(Integer.valueOf(signLly));
//                info.setUrx(Integer.valueOf(signUrx));
//                info.setUry(Integer.valueOf(signUry));
//                info.setSignPage(Integer.valueOf(signPage));
//                info.setFieldName(signFieldname);
//                info.setTypeDocument("Consulta");
//                info.setReason("Tramite #");
//
//                // firma digital
                


		byte[] archivo;
		if(boletas != null && !boletas.isEmpty() && !generar) {
                        System.out.println("nulo");
//			archivo = boletas.get(boletas.size() - 1).getArchivo();
                    try{ 
                        res.setContentType("application/pdf");
                        res.setCharacterEncoding("UTF-8");
                        res.setHeader("Content-Disposition", "attachment; filename=\"Boleta.pdf\"");
                        OutputStream os = res.getOutputStream();
                        os.write(boletas.get(boletas.size() - 1).getArchivo());
                        os.close();
                    }catch(IOException e) {
                        e.printStackTrace();
                    }
                        
		} else {
//                        System.out.println("estoy en el else");
                    try{ 
                        res.setContentType("application/pdf");
                        res.setCharacterEncoding("UTF-8");
                        res.setHeader("Content-Disposition", "attachment; filename=\"Boleta.pdf\"");
                        OutputStream os = res.getOutputStream();
                        os.write(boletaPdfService.getBoletaPdf(idTramite, idGarantia));
                        os.close();
                    }catch(IOException e) {
                        e.printStackTrace();
                    }
		
//			archivo = boletaPdfService.getBoletaPdf(idTramite, idGarantia);
		}
                
//                System.out.println("afuera" + archivo);
//                info.setDocument(archivo);
                
//                try{
//                    System.out.println("Generar PDF 5");
//                    System.out.println("Nombre" + info.getFieldName() + " texto " + info.getSignText());
//                    System.out.println("Imagen" + info.getGraphicSignature() + " Key " + info.getKeyFile());
//                    System.out.println("Location " + info.getLocation() + " page " + info.getSignPage());
//                    System.out.println("Documento " + info.getDocument());
//                    ByteArrayOutputStream  signedOs = digitalSignatureSvc.signDocument(info);
//
//                    archivo = signedOs.toByteArray();
//
//                }catch(GeneralSecurityException | com.itextpdf.text.DocumentException e){
//                //	System.out.println("Errir de firma" + e);
//                }
//                ByteArrayInputStream in = new ByteArrayInputStream(archivo);
//		OutputStream out = res.getOutputStream();

		
                
//		byte[] buf = new byte[1024];
//		int count = 0;
//		while((count = in.read(buf)) >= 0) {
//			out.write(buf, 0, count);
//		}
//		out.flush();
//		out.close();
	}
}
