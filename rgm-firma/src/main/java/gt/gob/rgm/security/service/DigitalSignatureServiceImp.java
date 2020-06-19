package gt.gob.rgm.security.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.security.BouncyCastleDigest;
import com.itextpdf.text.pdf.security.DigestAlgorithms;
import com.itextpdf.text.pdf.security.ExternalDigest;
import com.itextpdf.text.pdf.security.ExternalSignature;
import com.itextpdf.text.pdf.security.MakeSignature;
import com.itextpdf.text.pdf.security.MakeSignature.CryptoStandard;
import com.itextpdf.text.pdf.security.PrivateKeySignature;

import gt.gob.rgm.security.domain.SignatureInfo;

import com.itextpdf.text.pdf.PdfSignatureAppearance.RenderingMode;

public class DigitalSignatureServiceImp {
	public ByteArrayOutputStream signDocument(SignatureInfo info) throws GeneralSecurityException, IOException, DocumentException {
		BouncyCastleProvider provider = new BouncyCastleProvider();
		Security.addProvider(provider);
		KeyStore ks = KeyStore.getInstance("pkcs12", provider.getName());
		ks.load(new FileInputStream(info.getKeyFile()), info.getKeyPassword().toCharArray());
		String alias = (String) ks.aliases().nextElement();
		PrivateKey pk = (PrivateKey) ks.getKey(alias, info.getKeyPassword().toCharArray());
		Certificate[] chain = ks.getCertificateChain(alias);
		
		PdfReader reader = new PdfReader(new ByteArrayInputStream(info.getDocument()));
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PdfStamper stamper = PdfStamper.createSignature(reader, os, '\0');
		PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
		appearance.setReason(info.getReason());
		appearance.setLocation(info.getLocation());
		int signingPage = info.getSignPage() == 0 ? reader.getNumberOfPages() : info.getSignPage();
		appearance.setVisibleSignature(new Rectangle(info.getLlx(), info.getLly(), info.getUrx(), info.getUry()), signingPage, info.getFieldName());
		appearance.setLayer2Text(info.getSignText());
		appearance.setLayer2Font(new Font(FontFamily.TIMES_ROMAN, 14));
		appearance.setSignatureGraphic(Image.getInstance(info.getGraphicSignature()));
		appearance.setRenderingMode(RenderingMode.GRAPHIC_AND_DESCRIPTION);
		appearance.setCertificationLevel(PdfSignatureAppearance.CERTIFIED_NO_CHANGES_ALLOWED);
		ExternalDigest digest = new BouncyCastleDigest();
		ExternalSignature signature = new PrivateKeySignature(pk, DigestAlgorithms.RIPEMD160, provider.getName());
		MakeSignature.signDetached(appearance, digest, signature, chain, null, null, null, 0, CryptoStandard.CADES);
		// ocscpClient
		// tsaClient
		// estimatedSize
		
		return os;
	}
	
	
}
