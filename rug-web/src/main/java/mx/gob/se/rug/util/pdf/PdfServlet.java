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
import com.itextpdf.kernel.utils.PdfMerger;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.text.BadElementException;
//import com.itextpdf.text.Image;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.HorizontalAlignment;
//import com.itextpdf.text.pdf.BarcodeQRCode;
import com.lowagie.text.DocumentException;

import gt.gob.rgm.captcha.utils.Random;
import gt.gob.rgm.security.domain.SignatureInfo;
import gt.gob.rgm.security.service.DigitalSignatureServiceImp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import mx.gob.se.rug.util.pdf.CreateSignature;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

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

    private void generatePdf(HttpServletRequest req, HttpServletResponse resp)  {

        // Variables Firma
        String signText = "";
        String signImage = "";
        String signFile = "";
        String signPassword = "";
        String signLocation = "";
        String signLlx = "";
        String signLly = "";
        String signUrx = "";
        String signUry = "";
        String signPage = "";
        String signFieldname = "";

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
                e.printStackTrace();
            }
        } else {
            Integer idTramite = (Integer) session.getAttribute(Constants.ID_TRAMITE_NUEVO);
            //System.out.println("IDTramite Nuevo" + idTramite);
            UsuarioTO usuario = (UsuarioTO) session.getAttribute(Constants.USUARIO);
            PdfTO pdfTO = (PdfTO) session.getAttribute("pdfTO");
            System.out.println("pdfTO = " + pdfTO.getMassive());
            try {
                if (pdfTO != null) {
                    System.out.println("pdfTO dentro");
                    if (pdfTO.getMassive() != "False") {
                        DigitalSignatureServiceImp digitalSignatureSvc = new DigitalSignatureServiceImp();
                        SignatureInfo info = new SignatureInfo();
                        if (pdfTO.getIdTramite() == null) {
                            pdfTO.setIdTramite(idTramite);
                        }
                        if (idTramite != null) {
                            pdfTO.setIdTramite(idTramite);
                        }

                        String signEnabled = Constants.getParamValue(Constants.SIGN_ENABLED);
                        String signDev = Constants.getParamValue(Constants.SIGN_LOCAL);
                        if (Boolean.valueOf(signEnabled)) {
                            //System.out.println("valor: " + Constants.getParamValue(Constants.SIGN_LOCAL) );
                            if (Boolean.valueOf(signDev)) {
                                signText = Constants.getParamValue(Constants.SIGN_TEXT);
                                signImage = Constants.getParamValue(Constants.SIGN_IMAGE_LOCAL);
                                signFile = Constants.getParamValue(Constants.SIGN_FILE_LOCAL);
                                signPassword = Constants.getParamValue(Constants.SIGN_PASSWORD);
                                signLocation = Constants.getParamValue(Constants.SIGN_LOCATION);
                                signLlx = Constants.getParamValue(Constants.SIGN_LLX);
                                signLly = Constants.getParamValue(Constants.SIGN_LLY);
                                signUrx = Constants.getParamValue(Constants.SIGN_URX);
                                signUry = Constants.getParamValue(Constants.SIGN_URY);
                                signPage = Constants.getParamValue(Constants.SIGN_PAGE);
                                signFieldname = Constants.getParamValue(Constants.SIGN_FIELDNAME);
                            } else {
                                signText = Constants.getParamValue(Constants.SIGN_TEXT);
                                signImage = Constants.getParamValue(Constants.SIGN_IMAGE);
                                signFile = Constants.getParamValue(Constants.SIGN_FILE);
                                signPassword = Constants.getParamValue(Constants.SIGN_PASSWORD);
                                signLocation = Constants.getParamValue(Constants.SIGN_LOCATION);
                                signLlx = Constants.getParamValue(Constants.SIGN_LLX);
                                signLly = Constants.getParamValue(Constants.SIGN_LLY);
                                signUrx = Constants.getParamValue(Constants.SIGN_URX);
                                signUry = Constants.getParamValue(Constants.SIGN_URY);
                                signPage = Constants.getParamValue(Constants.SIGN_PAGE);
                                signFieldname = Constants.getParamValue(Constants.SIGN_FIELDNAME);
                            }

                        }
                        String filePathToBeServed = Constants.getParamValue(Constants.SIGN_ZIP_URL);
                        Date date = new Date();
                        DateFormat datePDF = new SimpleDateFormat("dd-MM-yyyy");
                        DateFormat timePDF = new SimpleDateFormat("HH_mm_ss");
                        
                        String PDFIndex = datePDF.format(date);
                        String PDFtime = timePDF.format(date);
                        File directory = new File(filePathToBeServed);
//                        File test = new File("C:\\certificado_RGM\\pdf"+PDFIndex);
//                        test.mkdir();
//                        
                        
                        directory.mkdir();
                        
                        System.out.println("Valore de carpeta " + filePathToBeServed);
                        recursiveDelete(new File(filePathToBeServed));
                        recursiveDelete(new File(filePathToBeServed +"/boleta_zip/"));
                        
                        //recursiveDelete(new File(filePathToBeServed+"\\"+PDFIndex+PDFtime));
//                        recursiveDelete(new File("C:\\certificado_RGM\\pdf"+PDFIndex));
//                        recursiveDelete(new File("/opt/firma/pdf"));
                        for (int iteracionB = 0; iteracionB < pdfTO.getHtmlList().size(); iteracionB++) {
                            byte filepdf[] = null;
                            ByteArrayOutputStream ospdf = new ByteArrayOutputStream();

                            pdfTO.setKey("" + pdfTO.getIdTramite() + Random.generateRandom(100000));
                            PdfWriter writer = new PdfWriter(ospdf);
                            ConverterProperties converterProperties = new ConverterProperties();
                            PdfDocument pdf = new PdfDocument(writer);
                            PageXofY footerHandler = new PageXofY(pdfTO.getKey());
                            pdf.addEventHandler(PdfDocumentEvent.START_PAGE, footerHandler);
                            Document doc = HtmlConverter.convertToDocument(pdfTO.getHtmlList().get(iteracionB), pdf, converterProperties);
                            doc.close();
                            System.out.println("doc = " + doc);

                            filepdf = ospdf.toByteArray();
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
                            if (pdfTO.getTypeValue() == null) {
                                info.setTypeDocument("Consulta");
                            } else {
                                info.setTypeDocument(pdfTO.getTypeValue());
                            }
                            info.setReason("Tramite #");
                            info.setDocument(filepdf);

                            try {
                                ByteArrayOutputStream signedOs = digitalSignatureSvc.signDocument(info);
                                filepdf = signedOs.toByteArray();
                            } catch (GeneralSecurityException | com.itextpdf.text.DocumentException e) {
                                //MyLogger.Logger.log(Level.INFO, " no tiene parametros....." + e);
                                e.printStackTrace();
                            }

                            try {
                                /* CREATE PDF AND SAVE */
                                String fileName = "Boleta_" + iteracionB + "_" + PDFtime + ".pdf";
                                //String filePathToBeServed = "C:\\certificado_RGM\\pdf\\";
                                
                                
                                
                                String path = filePathToBeServed+"/" + fileName;
                                System.out.println("path = " + path);
                                FileOutputStream FOS = new FileOutputStream(path);
                                FOS.write(filepdf);
                                FOS.close();

//                                        File fileToDownload = new File(filePathToBeServed+fileName);
//                                        
//                                        FileOutputStream pdfFileout = new FileOutputStream(fileToDownload);
                                //InputStream inputStream = new FileInputStream(fileToDownload);
                                //resp.resetBuffer();
//                                        ospdf.writeTo(FOS);
//                                        
//                                        resp.setContentType("application/pdf");
//                                        resp.setCharacterEncoding("UTF-8");
//                                        resp.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
//                                        resp.setHeader("Content-Disposition", "attachment; filename=\"Boleta\"" + iteracionB + ".pdf\"");
//                                        OutputStream os2 = resp.getOutputStream();
//                                        ospdf.writeTo(os2);
//                                        os2.flush();
//                                        os2.close();
                                //resp.setHeader("Content-Disposition", "attachment; filename=\"Boleta\"" + iteracionB + ".pdf\"");
//                                        
//                                        os2.write(filepdf);
//                                        System.out.println("file pdf " + filepdf);
//                                        os2.flush();
//                                        os2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            //pdfTO.setFile(file);
                            //showPdf(pdfTO, resp);
                            //System.out.println("file : " + pdfTO.getFile());
                            //System.out.println("iteracion: " + iteracionB);

                        }

                        //String filePathToBeServedURL = Constants.getParamValue(Constants.SIGN_PDF_URL);
                        String pathOutputZip = Constants.getParamValue(Constants.SIGN_PDF_URL);
                        System.out.println("pathOutputZip = " + pathOutputZip);
                        System.out.println("filePathToBeServed = " + filePathToBeServed);
                        /* CREATE ZIP AND DOWNLOAD */
                        try {
                            zipFolder(filePathToBeServed, pathOutputZip+"/boleta_zip/"+PDFIndex+"_"+PDFtime+".zip");
                        } catch (Exception ex) {
                            System.out.println("Error = " + ex);
                        }
                        
                        File zipFile = new File(pathOutputZip+"/boleta_zip/"+PDFIndex+"_"+PDFtime+".zip");
                        resp.setContentType("application/zip");
                        resp.addHeader("Content-Disposition", "attachment; filename=" + ("pdf_"+PDFIndex+"_"+PDFtime+".zip"));
                        resp.setContentLength((int) zipFile.length());
                        try {

                            FileInputStream fileInputStream = new FileInputStream(zipFile);
                            OutputStream responseOutputStream = resp.getOutputStream();
                            int bytes;
                            while ((bytes = fileInputStream.read()) != -1) {
                                responseOutputStream.write(bytes);
                            }
                           
                        } catch (IOException e) {
                            System.out.println("err = " + e);
                        }
                        
                        
                        
                        
                        //recursiveDelete(new File("C:\\certificado_RGM\\pdf.zip"));
                        
                        //zipFile.delete();
                        
                        
                                
                        
                        //test.delete();
                        
//                        FileOutputStream fout = new FileOutputStream(pathOutputZip);
//                        CheckedOutputStream checksum = new CheckedOutputStream(fout, new Adler32());
//                        ZipOutputStream zout = new ZipOutputStream(checksum);
//
//                        FileInputStream fin = new FileInputStream(filePathToBeServedURL+"Boleta01.pdf");
//                        ZipEntry zipEntry = new ZipEntry(filePathToBeServedURL+"Boleta0.pdf");
//                        zout.putNextEntry(zipEntry);
//                        int length;
//                        byte[] buffer = new byte[1024];
//                        while ((length = fin.read(buffer)) > 0) {
//                            zout.write(buffer, 0, length);
//                        }
//
//                        zout.closeEntry();
//                        zout.finish();
//                        fin.close();
//                        zout.close();
//                                File carpetaComprimir = new File(filePathToBeServedURL);
//                                if (carpetaComprimir.exists()) {
//                                    File[] ficheros = carpetaComprimir.listFiles();
//                                    for (int i = 0; i < ficheros.length; i++) {
//                                        System.out.println("Nombre del fichero: " + ficheros[i].getName());
//                                        String extension = "";
//
//                                        for (int j = 0; j < ficheros[i].getName().length(); j++) {
//                                            //obtiene la extensión del archivo
//                                            if (ficheros[i].getName().charAt(j) == '.') {
//                                                extension = ficheros[i].getName().substring(j, (int) ficheros[i].getName().length());
//                                            }
//                                        }
//                                        try {
//                                            // crea un buffer temporal para ir poniendo los archivos a comprimir
//                                            ZipOutputStream zous = new ZipOutputStream(new FileOutputStream(filePathToBeServedURL + ficheros[i].getName().replace(extension, ".zip")));
//
//                                            //nombre con el que se va guardar el archivo dentro del zip
//                                            ZipEntry entrada = new ZipEntry(ficheros[i].getName());
//                                            zous.putNextEntry(entrada);
//
//                                            //System.out.println("Nombre del Archivo: " + entrada.getName());
//                                            System.out.println("Comprimiendo.....");
//                                            //obtiene el archivo para irlo comprimiendo
//                                            FileInputStream fis = new FileInputStream(filePathToBeServedURL + entrada.getName());
//                                            int leer;
//                                            byte[] buffer = new byte[1024];
//                                            while (0 < (leer = fis.read(buffer))) {
//                                                zous.write(buffer, 0, leer);
//                                            }
//                                            fis.close();
//                                            zous.closeEntry();
//                                            zous.close();
//                                        } catch (FileNotFoundException e) {
//                                            e.printStackTrace();
//                                        } catch (IOException e) {
//                                            e.printStackTrace();
//                                        }
//                                    }
//                                    System.out.println("Directorio de salida: " + filePathToBeServedURL);
//                                }else {
//                                    System.out.println("No se encontró el directorio..");
//                                }
                        BoletaDAO boleta = new BoletaDAO();
                        boleta.insertBoletaPdf(pdfTO, usuario);
                    } else {
                        if (pdfTO.getIdTramite() == null) {
                            pdfTO.setIdTramite(idTramite);
                        }
                        pdfTO.setKey("" + pdfTO.getIdTramite() + Random.generateRandom(100000));
                        PdfWriter writer = new PdfWriter(os);
                        ConverterProperties converterProperties = new ConverterProperties();
                        PdfDocument pdf = new PdfDocument(writer);
                        PageXofY footerHandler = new PageXofY(pdfTO.getKey());
                        pdf.addEventHandler(PdfDocumentEvent.START_PAGE, footerHandler);
                        //Document doc = HtmlConverter.convertToDocument(pdfTO.getHtml(), pdf, converterProperties);	
                        Document doc = HtmlConverter.convertToDocument(pdfTO.getHtml(), pdf, converterProperties);
                        if (idTramite != null) {
                            pdfTO.setIdTramite(idTramite);
                        }

                        doc.close();
                        file = os.toByteArray();
                        String signEnabled = Constants.getParamValue(Constants.SIGN_ENABLED);
                        String signDev = Constants.getParamValue(Constants.SIGN_LOCAL);

                        /* verificaciï¿½n de firma masiva */
                        
                        /**
                         * *****************************
                         */

                        /*Implement New Method*/
                        if (Boolean.valueOf(signEnabled)) {
                            //System.out.println("valor: " + Constants.getParamValue(Constants.SIGN_LOCAL) );
                            if (Boolean.valueOf(signDev)) {
                                signText = Constants.getParamValue(Constants.SIGN_TEXT);
                                signImage = Constants.getParamValue(Constants.SIGN_IMAGE_LOCAL);
                                signFile = Constants.getParamValue(Constants.SIGN_FILE_LOCAL);
                                signPassword = Constants.getParamValue(Constants.SIGN_PASSWORD);
                                signLocation = Constants.getParamValue(Constants.SIGN_LOCATION);
                                signLlx = Constants.getParamValue(Constants.SIGN_LLX);
                                signLly = Constants.getParamValue(Constants.SIGN_LLY);
                                signUrx = Constants.getParamValue(Constants.SIGN_URX);
                                signUry = Constants.getParamValue(Constants.SIGN_URY);
                                signPage = Constants.getParamValue(Constants.SIGN_PAGE);
                                signFieldname = Constants.getParamValue(Constants.SIGN_FIELDNAME);
                            } else {
                                signText = Constants.getParamValue(Constants.SIGN_TEXT);
                                signImage = Constants.getParamValue(Constants.SIGN_IMAGE);
                                signFile = Constants.getParamValue(Constants.SIGN_FILE);
                                signPassword = Constants.getParamValue(Constants.SIGN_PASSWORD);
                                signLocation = Constants.getParamValue(Constants.SIGN_LOCATION);
                                signLlx = Constants.getParamValue(Constants.SIGN_LLX);
                                signLly = Constants.getParamValue(Constants.SIGN_LLY);
                                signUrx = Constants.getParamValue(Constants.SIGN_URX);
                                signUry = Constants.getParamValue(Constants.SIGN_URY);
                                signPage = Constants.getParamValue(Constants.SIGN_PAGE);
                                signFieldname = Constants.getParamValue(Constants.SIGN_FIELDNAME);
                            }

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
                            if (pdfTO.getTypeValue() == null) {
                                info.setTypeDocument("Consulta");
                            } else {
                                info.setTypeDocument(pdfTO.getTypeValue());
                            }
                            info.setReason("Tramite #");
                            info.setDocument(file);

                            try {
                                ByteArrayOutputStream signedOs = digitalSignatureSvc.signDocument(info);
                                file = signedOs.toByteArray();
                            } catch (GeneralSecurityException | com.itextpdf.text.DocumentException e) {
                                MyLogger.Logger.log(Level.INFO, " no tiene parametros....." + e);
                                e.printStackTrace();
                            }
                        }

                        // inserta al pdf
                        pdfTO.setFile(file);
                        BoletaDAO boleta = new BoletaDAO();
                        boleta.insertBoletaPdf(pdfTO, usuario);
                        showPdf(pdfTO, resp);
                    }
                }
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
        try {
            resp.setContentType("application/pdf");
            resp.setCharacterEncoding("UTF-8");
            resp.setHeader("Content-Disposition", "attachment; filename=\"Boleta.pdf\"");
            OutputStream os = resp.getOutputStream();
            os.write(pdfTO.getFile());
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public void zipFolder(String srcFolder, String destZipFile) throws Exception {
        ZipOutputStream zip = null;
        FileOutputStream fileWriter = null;
        fileWriter = new FileOutputStream(destZipFile);
        zip = new ZipOutputStream(fileWriter);
        addFolderToZip("", srcFolder, zip);
        zip.flush();
        zip.close();
    }

    static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
            throws Exception {
        File folder = new File(srcFile);
        if (folder.isDirectory()) {
            addFolderToZip(path, srcFile, zip);
        } else {
            byte[] buf = new byte[1024];
            int len;
            FileInputStream in = new FileInputStream(srcFile);
            zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
            while ((len = in.read(buf)) > 0) {
                zip.write(buf, 0, len);
            }
        }
    }

    static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
            throws Exception {
        File folder = new File(srcFolder);

        for (String fileName : folder.list()) {
            if (path.equals("")) {
                addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
            } else {
                addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
            }
        }
    }
    
    public static void recursiveDelete(File file) {
        String[] myFiles;    
          if(file.isDirectory()){
              myFiles = file.list();
              for (int i=0; i<myFiles.length; i++) {
                  File myFile = new File(file, myFiles[i]); 
                  myFile.delete();
                  System.out.println("Deleted " + myFile);
              }
           }
          //System.out.println("Deleted " + file);
//        System.out.println("entre delete ");
//        //to end the recursive loop
//        if (!file.exists())
//            return;
//        
//        //if directory, go inside and call recursively
//        if (file.isDirectory()) {
//            System.out.println("entro a directorop");
//            for (File f : file.listFiles()) {
//                //call recursively
//                recursiveDelete(f);
//                System.out.println("archivo" + f);
//            }
//        }
//        //call delete to delete files and empty directory
//        file.delete();
//        System.out.println("Deleted file/folder: "+file.getAbsolutePath());
    }

}
