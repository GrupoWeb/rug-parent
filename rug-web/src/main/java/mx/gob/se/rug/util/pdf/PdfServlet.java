package mx.gob.se.rug.util.pdf;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import mx.gob.se.rug.boleta.dao.BoletaDAO;
import mx.gob.se.rug.constants.Constants;
import mx.gob.se.rug.to.UsuarioTO;
import mx.gob.se.rug.util.MyLogger;
import mx.gob.se.rug.util.pdf.to.PdfTO;

//import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import com.itextpdf.barcodes.BarcodeQRCode;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.text.BadElementException;
//import com.itextpdf.text.Image;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.property.HorizontalAlignment;
//import com.itextpdf.text.pdf.BarcodeQRCode;
import com.lowagie.text.DocumentException;

import gt.gob.rgm.captcha.utils.Random;
import gt.gob.rgm.security.domain.SignatureInfo;
import gt.gob.rgm.security.service.DigitalSignatureServiceImp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Set;

import mx.gob.se.rug.util.pdf.CreateSignature;

public class PdfServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    //public static final String BASEURI = "src/main/resources/html/";
    
    
    

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        generatePdf(req, resp);

    }

    private void generatePdf(HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session = req.getSession(false);

        byte file[] = null;
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        
        if (session.getAttribute("Consulta") != null && (Integer) session.getAttribute("Consulta") == 1) {
            PdfTO pdfTO = (PdfTO) session.getAttribute("pdfTO");

            
            PdfWriter writer = new PdfWriter(os);
            PdfDocument pdf = new PdfDocument(writer);
            try {
                Document doc = HtmlConverter.convertToDocument(pdfTO.getHtml(), pdf, null);
                doc.close();
                file = os.toByteArray();

                pdfTO.setFile(file);

                showPdf(pdfTO, resp);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            

            Integer idTramite = (Integer) session.getAttribute(Constants.ID_TRAMITE_NUEVO);
            System.out.println("IDTramite Nuevo" + idTramite);
            UsuarioTO usuario = (UsuarioTO) session.getAttribute(Constants.USUARIO);
            PdfTO pdfTO = (PdfTO) session.getAttribute("pdfTO");
            try {
                if (pdfTO != null) {
                    if (pdfTO.getIdTramite() == null) {
                        pdfTO.setIdTramite(idTramite);
                    }
                    pdfTO.setKey("" + pdfTO.getIdTramite() + Random.generateRandom(100000));
                    //System.out.println("Tramite = " + pdfTO.getTypeValue());
                    // MyLogger.Logger.log(Level.INFO,"pdf.idTramite " + pdfTO.getIdTramite());
                    // MyLogger.Logger.log(Level.INFO,"idTramite " + idTramite);

                    

                    /*if(pdfTO.getSave()!=null && pdfTO.getSave().equalsIgnoreCase("1")) {
						MyLogger.Logger.log(Level.INFO,"pdf " + pdfTO.getFile());
					} else {*/
                    
                    
                    
                    //DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    //Document doc;
                    //ByteArrayInputStream inputStream = new ByteArrayInputStream(pdfTO.getHtml().getBytes("ISO-8859-1"));
                    //doc = builder.parse(inputStream);
                    //String url = "http://localhost:9090/" + req.getContextPath()+"/resources/pdf/";
                    PdfWriter writer = new PdfWriter(os);
                    //PdfWriter writer = new PdfWriter(url + pdfTO.getPathRoot());	
                    //ConverterProperties properties = new ConverterProperties();
                    //properties.setBaseUri(url);
                    ConverterProperties converterProperties = new ConverterProperties();
                    //converterProperties.setTagWorkerFactory(new QRCodeTagWorkerFactory());

                    PdfDocument pdf = new PdfDocument(writer);
                    PageXofY footerHandler = new PageXofY(pdfTO.getKey());
                    pdf.addEventHandler(PdfDocumentEvent.START_PAGE, footerHandler);
                    Document doc = HtmlConverter.convertToDocument(pdfTO.getHtml(), pdf, converterProperties);
                    

                    //BarcodeQRCode barcodeQRCode = new BarcodeQRCode("https://www.rgm.gob.gt/app/", 1000, 1000, null);
                    /*BarcodeQRCode qrCode;
						qrCode = new BarcodeQRCode("placeholder");
						Constants constants = new Constants();
						String server = constants.getParamValue(Constants.URL_SERVER);
						qrCode.setCode(server + "/Rug/rs/home/validar?token=" + pdfTO.getKey());
						
						Image qrCodeAsImage = new Image(qrCode.createFormXObject(pdf));
						qrCodeAsImage.scaleAbsolute(100, 100);
						qrCodeAsImage.setHorizontalAlignment(HorizontalAlignment.CENTER);*/
 /*codeQrImage = null;
						try {
							codeQrImage = barcodeQRCode.getImage();
						} catch (BadElementException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				        codeQrImage.scaleAbsolute(100, 100);*/
                    //qrCodeAsImage.getXObject().getPdfObject()
                    //doc.add(qrCodeAsImage);
                    //pdfTO.setHtml("[*qr*]", codeQrImage.getRawData());			        
                    //doc.
                    //ITextRenderer renderer = new ITextRenderer();
                    //String url=getUrl(req.getContextPath()+"/resources/pdf/");
                    //MyLogger.Logger.log(Level.INFO,url);
                    //renderer.setDocument(doc, url + pdfTO.getPathRoot());
                    //renderer.layout();					
                    //renderer.createPDF(os);					
                    if (idTramite != null) {
                        pdfTO.setIdTramite(idTramite);
                    }
                    
                    if(pdfTO.getTypeValue() == null){
                        
                    }
                    //os.close();
                    doc.close();
                    file = os.toByteArray();
                    
                    String signEnabled = Constants.getParamValue(Constants.SIGN_ENABLED);
                    //MyLogger.Logger.log(Level.INFO, " SIGN ENABLED mio " + signEnabled );
                    
                    /*Implement New Method*/
                    
                    
                    //System.out.println("session = " + session);
                    if (Boolean.valueOf(signEnabled)) {

                        // firmar el documento
                        //Constants c = new Constants();
                        String signText = Constants.getParamValue(Constants.SIGN_TEXT);
                        String signImage = Constants.getParamValue(Constants.SIGN_IMAGE);
                        String signFile = Constants.getParamValue(Constants.SIGN_FILE);
                        String signPassword = Constants.getParamValue(Constants.SIGN_PASSWORD);
                        String signLocation = Constants.getParamValue(Constants.SIGN_LOCATION);
                        String signLlx = Constants.getParamValue(Constants.SIGN_LLX);
                        String signLly = Constants.getParamValue(Constants.SIGN_LLY);
                        String signUrx = Constants.getParamValue(Constants.SIGN_URX);
                        String signUry = Constants.getParamValue(Constants.SIGN_URY);
                        String signPage = Constants.getParamValue(Constants.SIGN_PAGE);
                        String signFieldname = Constants.getParamValue(Constants.SIGN_FIELDNAME);

                        
                       
                        
                        //MyLogger.Logger.log(Level.INFO, " URL FILE ...." + signFile);
                        DigitalSignatureServiceImp digitalSignatureSvc = new DigitalSignatureServiceImp();
                        SignatureInfo info = new SignatureInfo();
                        info.setSignText(signText);
                        info.setGraphicSignature(signImage);
                        info.setKeyFile(signFile);
                        info.setKeyPassword(signPassword);
                        info.setLocation(signLocation);
                        info.setLlx(Integer.valueOf(signLlx));
                        info.setLly(Integer.valueOf(signLly));
                        info.setUrx(Integer.valueOf(signUrx));
                        info.setUry(Integer.valueOf(signUry));
                        info.setSignPage(Integer.valueOf(signPage));
                        info.setFieldName(signFieldname);
                        if(pdfTO.getTypeValue() == null){
                            info.setTypeDocument("Consulta");
                        }else{
                            info.setTypeDocument(pdfTO.getTypeValue());
                        }
                        info.setReason("Tramite #");
                        //info.setReason("Tramite #" + pdfTO.getIdTramite());
                        info.setDocument(file);
                        
                        try {
                            ByteArrayOutputStream signedOs = digitalSignatureSvc.signDocument(info);
                            file = signedOs.toByteArray();
                           // MyLogger.Logger.log(Level.INFO, " no tiene parametros dentro....." + signedOs.toByteArray());
                        } catch (GeneralSecurityException | com.itextpdf.text.DocumentException e) {
                            MyLogger.Logger.log(Level.INFO, " no tiene parametros....." + e);
                            // error al firmar documento
                            // si no se pudo firmar el documento se guardara sin firma
                        }
                    } 

                    // inserta al pdf
                    pdfTO.setFile(file);
                    //System.out.println("Set File = " + pdfTO.getFile().toString());

                    /**
                     * guarda la boleta *
                     */
                    //if(pdfTO.getSave()==null || pdfTO.getSave().equalsIgnoreCase("0")) {
                    // Boletas mio
                    BoletaDAO boleta = new BoletaDAO();
                    boleta.insertBoletaPdf(pdfTO, usuario);
                    //}
                    //}	

                    // Manda Boleta browser
                    showPdf(pdfTO, resp);
                } 

                /*} catch (ParserConfigurationException e) {
					MyLogger.Logger.log(Level.WARNING,"HTML_NO_PARSE::::::"+pdfTO.getHtml());
					e.printStackTrace();
				} catch (SAXException e) {
					MyLogger.Logger.log(Level.WARNING,"HTML_NO_PARSE::::::"+pdfTO.getHtml());
					e.printStackTrace();
				} catch (DocumentException e) {
					MyLogger.Logger.log(Level.WARNING,"HTML_NO_PARSE::::::"+pdfTO.getHtml());
					e.printStackTrace();*/
            } catch (IOException e) {
                MyLogger.Logger.log(Level.WARNING, "HTML_NO_PARSE::::::" + pdfTO.getHtml());
                e.printStackTrace();

            }
        }

    }

    public String getUrl(String url) {
        String urlBase = System.getProperty(Constants.URL_WEB_SERVICE_FRIMA_TRAMITE);
        String uri[] = urlBase.split("/");
        StringBuffer sb = new StringBuffer();
        sb.append(uri[0]);
        sb.append("//");
        //sb.append(uri[1]);
        sb.append(uri[2]);
        return sb.toString() + url;

    }

    private void showPdf(PdfTO pdfTO, HttpServletResponse resp) {
        //MyLogger.Logger.log(Level.INFO, "--ShowPDF--" + pdfTO.getFile());
        try {
            resp.setContentType("application/pdf");
            resp.setCharacterEncoding("UTF-8");
            resp.setHeader("Content-Disposition", "attachment; filename=\"Boleta.pdf\"");
            OutputStream os = resp.getOutputStream();
            os.write(pdfTO.getFile());
            os.close();
            
            
                     
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

}
