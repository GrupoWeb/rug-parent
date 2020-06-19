package gt.gob.rgm.adm.test;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import gt.gob.rgm.adm.dao.RugBoletaPdfRepository;
import gt.gob.rgm.adm.dao.RugCatTextoFormRepository;
import gt.gob.rgm.adm.dao.RugGarantiasBienesHRepository;
import gt.gob.rgm.adm.dao.RugParametroConfRepository;
import gt.gob.rgm.adm.dao.TramitesRepository;
import gt.gob.rgm.adm.dao.VDetalleBoletaNuevoRepository;
import gt.gob.rgm.adm.dao.VDetalleBoletaPartesRepository;
import gt.gob.rgm.adm.model.RugBoletaPdf;
import gt.gob.rgm.adm.model.RugCatTextoForm;
import gt.gob.rgm.adm.model.RugGarantiasBienesH;
import gt.gob.rgm.adm.model.RugParametroConf;
import gt.gob.rgm.adm.model.Tramites;
import gt.gob.rgm.adm.model.VDetalleBoletaNuevo;
import gt.gob.rgm.adm.model.VDetalleBoletaPartes;
import gt.gob.rgm.adm.service.BoletaPdfService;
import gt.gob.rgm.adm.service.BoletaPdfServiceImp;

@RunWith(Arquillian.class)
public class PdfTest {

	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class).addClasses(BoletaPdfService.class,
        		                                               BoletaPdfServiceImp.class,
        		                                               RugParametroConfRepository.class,
        		                                               RugGarantiasBienesHRepository.class,
        		                                               RugCatTextoFormRepository.class,
        		                                               RugCatTextoForm.class,
        		                                               VDetalleBoletaPartesRepository.class,
        		                                               VDetalleBoletaNuevoRepository.class,
        		                                               TramitesRepository.class,
        		                                               RugBoletaPdfRepository.class,
        		                                               VDetalleBoletaNuevo.class,
        		                                               RugParametroConf.class,
        		                                               RugBoletaPdf.class,
        		                                               Tramites.class,
        		                                               RugGarantiasBienesH.class,
        		                                               VDetalleBoletaPartes.class).addAsResource("META-INF/persistence.xml").addAsManifestResource(EmptyAsset.INSTANCE,
                "beans.xml");
    }
	
	@EJB
	BoletaPdfService pdfService;

    @Test
    public void testPdfs() {
        
        // Do your tests
        byte[] pdf = pdfService.getBoletaPdf(55152L, 39712L);
		assertNotNull(pdf);
    }

}
