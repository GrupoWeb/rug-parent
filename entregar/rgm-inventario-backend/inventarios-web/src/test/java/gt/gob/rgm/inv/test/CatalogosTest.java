package gt.gob.rgm.inv.test;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import gt.gob.rgm.inv.dao.ArticuloRepository;
import gt.gob.rgm.inv.dao.DetalleIngresoRepository;
import gt.gob.rgm.inv.dao.DetalleRequisicionRepository;
import gt.gob.rgm.inv.dao.IngresoRepository;
import gt.gob.rgm.inv.dao.KardexRepository;
import gt.gob.rgm.inv.dao.MarcaRepository;
import gt.gob.rgm.inv.dao.ParametroConfRepository;
import gt.gob.rgm.inv.dao.ProveedorRepository;
import gt.gob.rgm.inv.dao.RequisicionRepository;
import gt.gob.rgm.inv.dao.SerieRepository;
import gt.gob.rgm.inv.dao.TipoArticuloRepository;
import gt.gob.rgm.inv.dao.TipoIngresoRepository;
import gt.gob.rgm.inv.dao.UnidadMedidaRepository;
import gt.gob.rgm.inv.dao.UsuarioRepository;
import gt.gob.rgm.inv.model.Articulo;
import gt.gob.rgm.inv.model.DetalleIngreso;
import gt.gob.rgm.inv.model.DetalleRequisicion;
import gt.gob.rgm.inv.model.Ingreso;
import gt.gob.rgm.inv.model.Kardex;
import gt.gob.rgm.inv.model.Marca;
import gt.gob.rgm.inv.model.Proveedor;
import gt.gob.rgm.inv.model.Requisicion;
import gt.gob.rgm.inv.model.Serie;
import gt.gob.rgm.inv.model.TipoArticulo;
import gt.gob.rgm.inv.model.TipoIngreso;
import gt.gob.rgm.inv.model.UnidadMedida;
import gt.gob.rgm.inv.model.Usuario;
import gt.gob.rgm.inv.service.ArticuloService;
import gt.gob.rgm.inv.service.ArticuloServiceImp;
import gt.gob.rgm.inv.service.DetalleIngresoService;
import gt.gob.rgm.inv.service.DetalleIngresoServiceImp;
import gt.gob.rgm.inv.service.DetalleRequisicionService;
import gt.gob.rgm.inv.service.DetalleRequisicionServiceImp;
import gt.gob.rgm.inv.service.IngresoService;
import gt.gob.rgm.inv.service.IngresoServiceImp;
import gt.gob.rgm.inv.service.KardexService;
import gt.gob.rgm.inv.service.KardexServiceImp;
import gt.gob.rgm.inv.service.MarcaService;
import gt.gob.rgm.inv.service.MarcaServiceImp;
import gt.gob.rgm.inv.service.ProveedorService;
import gt.gob.rgm.inv.service.ProveedorServiceImp;
import gt.gob.rgm.inv.service.RequisicionService;
import gt.gob.rgm.inv.service.RequisicionServiceImp;
import gt.gob.rgm.inv.service.SerieService;
import gt.gob.rgm.inv.service.SerieServiceImp;
import gt.gob.rgm.inv.service.TipoArticuloService;
import gt.gob.rgm.inv.service.TipoArticuloServiceImp;
import gt.gob.rgm.inv.service.TipoIngresoService;
import gt.gob.rgm.inv.service.TipoIngresoServiceImp;
import gt.gob.rgm.inv.service.UnidadMedidaService;
import gt.gob.rgm.inv.service.UnidadMedidaServiceImp;
import gt.gob.rgm.inv.service.UsuarioService;
import gt.gob.rgm.inv.service.UsuarioServiceImp;
import gt.gob.rgm.inv.util.ResponseRs;

@RunWith(Arquillian.class)
public class CatalogosTest {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class).addClasses(
				ParametroConfRepository.class,
				Kardex.class,
				KardexRepository.class,
				KardexService.class,
				KardexServiceImp.class,
				DetalleRequisicionRepository.class,
				DetalleRequisicionService.class,
				DetalleRequisicionServiceImp.class,
				DetalleRequisicion.class,
				RequisicionService.class,
				RequisicionServiceImp.class,
				RequisicionRepository.class,
				Requisicion.class,
				UsuarioServiceImp.class,
				UsuarioService.class,
				UsuarioRepository.class,
				Usuario.class,
				SerieServiceImp.class,
				SerieService.class,
				SerieRepository.class,
				Serie.class,
				DetalleIngresoService.class,
				DetalleIngresoServiceImp.class,
				DetalleIngresoRepository.class,				
				DetalleIngreso.class,
				TipoIngreso.class,
				TipoIngresoService.class,
				TipoIngresoServiceImp.class,
				TipoIngresoRepository.class,
				IngresoService.class,
				IngresoServiceImp.class,
				IngresoRepository.class,
				Ingreso.class,
				ArticuloService.class,
				ArticuloServiceImp.class,
				ArticuloRepository.class,
				Articulo.class,
				TipoArticuloService.class,
				TipoArticuloServiceImp.class,
				TipoArticuloRepository.class,
				TipoArticulo.class,
				UnidadMedidaService.class,
				UnidadMedidaServiceImp.class,
				UnidadMedidaRepository.class,
				UnidadMedida.class,
				ProveedorServiceImp.class,
				ProveedorService.class,
				ProveedorRepository.class,
				Proveedor.class,
				MarcaServiceImp.class,
				MarcaService.class,
				MarcaRepository.class,
				Marca.class).addAsResource("META-INF/persistence.xml").
				addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@EJB
	MarcaService marcaService;
	
	@EJB
	ProveedorService proveedorService;
	
	@EJB
	UnidadMedidaService unidadMedidaService;
	
	@EJB
	TipoArticuloService tipoArticuloService;
	
	@EJB
	ArticuloService articuloService;
	
	@EJB
	IngresoService ingresoService;
	
	@EJB
	DetalleIngresoService detalleIngresoService;
	
	@EJB
	RequisicionService requisicionService;
	
	@EJB
	UsuarioService usuarioService;
	
	@EJB
	SerieService serieService;
	
	@EJB
	KardexService kardexService;
	
	@Inject
	private KardexRepository kardexDao;
	
	//@Test
	public void testDetalleIngreso() {
		DetalleIngreso _detalleIngreso = new DetalleIngreso();
		_detalleIngreso.setCodigoArticulo("101-P");
		_detalleIngreso.setIngresoId(BigDecimal.valueOf(2));
		_detalleIngreso.setCantidad(BigDecimal.valueOf(2));
		_detalleIngreso.setPrecio(BigDecimal.valueOf(0.00));
		
		ResponseRs result = detalleIngresoService.addDetalleIngreso(_detalleIngreso);
		
		System.out.println(result.getReason());
		
		assertNotNull(result);
	}
	
	
	//@Test
	public void testIngreso() {
		
		Ingreso _ingreso = new Ingreso();
		//_ingreso.setCorrelativo("ING-1-2017");
		Date date= new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		_ingreso.setFecha(ts);
		_ingreso.setObservaciones("INVENTARIO INICIAL");
		_ingreso.setReferencia("INVENTARIO INICIAL");
		_ingreso.setTipoIngresoId(BigDecimal.valueOf(14));
		_ingreso.setUsuarioId(BigDecimal.valueOf(1));
		
		ResponseRs result = ingresoService.addIngreso(_ingreso);
		
		System.out.println(result);
		
		/*List<Ingreso> ingresos = (List<Ingreso>) ingresoService.listIngresos().getValue();
		for(Ingreso ingreso:ingresos) {
			System.out.println(ingreso.getCorrelativo());
		}*/
		
		assertNotNull(result);
	}
	
	//@Test
	public void testArticuloPDF() {
		//byte[] pdf = articuloService.getInventarioGeneralPdf(1L, "Administrador");
		//byte[] pdf = usuarioService.getReportePdf("Administrador");
		//byte[] pdf = proveedorService.getReporteGeneralPdf("Administrador");
		
		
		Serie vSerie = new Serie();
		vSerie.setSerieId(4L);
		//vSerie.setArchivo(pdf);
		serieService.addSerie(vSerie);
		//assertNotNull(pdf);
	}
	
	//@Test
	public void TestKardexQuery() {
		Map<String, Object> params = new HashMap<String, Object>();		
		params.put("codigoArticulo", "100-P");		
		
		try {
			Long result = kardexDao.findValueByParams(params, "inicial");
			System.out.println(result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//@Test
	public void testRequisicionPDF() {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("usuario", "Administrador");
		params.put("tipoArticulo", "13");
		params.put("codigoArticulo", "100-P");
		params.put("idRequisicion", 244L);
		params.put("fechaInicio", "2017-08-01");
		params.put("fechaFin", "2018-12-01");
		params.put("id", 1065L);
		params.put("page", null);
		params.put("size", null);		
		
		//byte[] pdf = requisicionService.getReporteGeneralPdf(params);
		//byte[] pdf = ingresoService.getReporteGeneralPdf(params);
		byte[] pdf = articuloService.getInventarioGeneralPdf(params);
		//byte[] pdf = articuloService.getReporteMinimos(params);
		//byte[] pdf = kardexService.getReporteGeneralPdf(params);
		//byte[] pdf = usuarioService.getReporteGeneralPdf(params);
		//byte[] pdf = requisicionService.getReporteRequisicionPdf(params);
		//byte[] pdf = ingresoService.getReporteIngresoPdf(params);
		
		Serie vSerie = new Serie();
		vSerie.setSerieId(5L);
		vSerie.setArchivo(pdf);
		serieService.addSerie(vSerie);
		assertNotNull(pdf);
	}
	
	//@Test
	public void testIngresos() {
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("estado", "A");
		params.put("fechaInicio", "2017-08-01");
		params.put("fechaFin", "2018-12-01");
		
		List<Ingreso> articulos = (List<Ingreso>) 
				ingresoService.listIngresos(params,null,null).getValue();
		for(Ingreso articulo:articulos) {
			System.out.println(articulo.getCorrelativo());
		}
	}
	
	//@Test
	public void testArticulo() {
		
		/*Articulo _articulo = new Articulo();
		_articulo.setCodigo("100-P");
		
		ResponseRs tipo = tipoArticuloService.getTipoArticulo(1L);
		_articulo.setTipoArticulo((TipoArticulo)tipo.getValue());
		
		ResponseRs marca = marcaService.getMarca(1L);
		_articulo.setMarca((Marca)marca.getValue());
		
		ResponseRs proveedor = proveedorService.getProveedor(2L);
		_articulo.setProveedor((Proveedor)proveedor.getValue());
		
		ResponseRs unidad = unidadMedidaService.getUnidadMedida(2L);
		_articulo.setUnidadMedida((UnidadMedida)unidad.getValue());
		
		_articulo.setDescripcion("LÁPIZ CORRECTOR LIQUIDO");
		_articulo.setMinimoExistencia(6);
		_articulo.setCodigoBarras("0");
		_articulo.setStock(28L);
		_articulo.setCorrelativo(201L);
		_articulo.setPredecedero(false);
		_articulo.setValor(BigDecimal.valueOf(0));
		
		ResponseRs result = articuloService.addArticulo(_articulo);
		
		System.out.println(result);*/
		
		Map<String,Object> articuloFilter = new HashMap<String,Object>();
		articuloFilter.put("marcaId", 1);
		articuloFilter.put("fechaInicio", "2017-08-01");
		articuloFilter.put("fechaFin", "2018-12-01");
		/*articuloFilter.put("correlativo", correlativo);
		articuloFilter.put("stock", stock);
		articuloFilter.put("fechaVencimiento", fechaVencimiento);
		articuloFilter.put("minimoExistencia", minimoExistencia);
		articuloFilter.put("predecedero", predecedero);
		articuloFilter.put("valor", valor);
		articuloFilter.put("marcaId", marcaId);
		articuloFilter.put("proveedorId", proveedorId);
		articuloFilter.put("tipoArticuloId", tipoArticuloId);
		articuloFilter.put("unidadMediadId", unidadMediadId);*/
		
		List<Articulo> articulos = (List<Articulo>) 
				articuloService.listArticulos(articuloFilter,null,null).getValue();
		for(Articulo articulo:articulos) {
			System.out.println(articulo.getCodigo());
		}
		
		//assertNotNull(result);
	}
	
	//@Test
	public void testTipoArticulo() {
		
		TipoArticulo _tipoArticulo = new TipoArticulo();
		_tipoArticulo.setNombre("UTILES DE OFICINA");
		
		ResponseRs result = tipoArticuloService.addTipoArticulo(_tipoArticulo);
		
		System.out.println(result.toString());
		
		List<TipoArticulo> tiposArticulos = (List<TipoArticulo>) tipoArticuloService.listTiposArticulo().getValue();		
		for(TipoArticulo tipoArticulo:tiposArticulos) {
			System.out.println(tipoArticulo.getNombre());
		}
		
		assertNotNull(result);
	}
	
	//@Test
	public void testUnidadMedida() {
		
		UnidadMedida _unidad = new UnidadMedida();
		_unidad.setNombre("FRASCO DE 20 ONZAS");
		
		ResponseRs result = unidadMedidaService.addUnidadMedida(_unidad);
		
		System.out.println(result.toString());
		
		List<UnidadMedida> unidades = (List<UnidadMedida>) unidadMedidaService.listUnidadesMedida(null,null).getValue();
		for(UnidadMedida unidad:unidades) {
			System.out.println(unidad.getNombre());
		}
		
		assertNotNull(result);
	}
	
	//@Test
	public void testProveedores() {
		
		Proveedor _proveedor = new Proveedor();
		_proveedor.setNombre("S/N");
		_proveedor.setDireccion("S/N");
		_proveedor.setNit("S/N");		
		
		ResponseRs result = proveedorService.addProveedor(_proveedor);
		
		System.out.println(result.toString());
		
		List<Proveedor> proveedores = (List<Proveedor>) proveedorService.listProveedores().getValue();
		for(Proveedor proveedor:proveedores) {
			System.out.println(proveedor.getNombre());
		}
		
		assertNotNull(result);
		
	}
	
	@Test
	public void testHello() {
		System.out.println("Hello World!!!!!!!!!");
	}
	
	//@Test
	public void testMarcas() {
		
		Marca _marca = new Marca();
		_marca.setNombre("S/N");
		
		ResponseRs result = marcaService.addMarca(_marca);
		
		System.out.println(result.toString());
		
		List<Marca> marcas = (List<Marca>) marcaService.listMarcas(null,null).getValue();
		for(Marca marca:marcas) {
			System.out.println(marca.getNombre());
		}
		
		assertNotNull(result);
	}
}
