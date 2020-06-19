package gt.gob.rgm.adm.test;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import gt.gob.rgm.adm.dao.RugParametroConfRepository;
import gt.gob.rgm.adm.dao.VTramitesMailVigenciaRepository;
import gt.gob.rgm.adm.model.RugParametroConf;
import gt.gob.rgm.adm.model.VTramitesMailVigencia;
import gt.gob.rgm.adm.service.VigenciaCronServiceImp;

@RunWith(Arquillian.class)
public class VigenciaTest {

	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class).addClasses(VigenciaCronServiceImp.class,
        													   VTramitesMailVigenciaRepository.class,
        													   VTramitesMailVigencia.class,
        													   RugParametroConfRepository.class,
        													   RugParametroConf.class
        													   ).addAsResource("META-INF/persistence.xml").addAsManifestResource(EmptyAsset.INSTANCE,
                "beans.xml");
    }
	
	@EJB
	VigenciaCronServiceImp vigenciaService;
	
	@Test
	public void testVigencia() {
		//vigenciaService.caducidadTramites();
		//vigenciaService.caducidadTramitesInc();
		//vigenciaService.enviarAvisoVencimiento();
	}
}
