package gt.gob.rgm.util;

import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import mx.gob.se.rug.to.AccionTO;

public class ExcelCreator {
	public XSSFWorkbook createTramitesWorkbook(List<AccionTO> tramites) throws Exception {
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Tramites");

		int i = 1;
		if(tramites != null) {
			XSSFRow row = sheet.createRow(0);
			XSSFCell cell = row.createCell(0);
			cell.setCellValue("Número de Garantía");
			cell = row.createCell(1);
			cell.setCellValue("Trámite");
			cell = row.createCell(2);
			cell.setCellValue("Fecha");
			cell = row.createCell(3);
			cell.setCellValue("Valor");
			cell = row.createCell(4);
			cell.setCellValue("Usuario");
			
			for(AccionTO tramite : tramites) {
				row = sheet.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue(tramite.getGarantia().getIdgarantia());
				cell = row.createCell(1);
				cell.setCellValue(tramite.getGarantia().getDescripcion());
				CellStyle cellStyle = wb.createCellStyle();
				CreationHelper createHelper = wb.getCreationHelper();
				cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy hh:mm:ss"));
				cell = row.createCell(2);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(tramite.getFecha());
				cell = row.createCell(3);
				cell.setCellValue(tramite.getImporte());
				cell = row.createCell(4);
				cell.setCellValue(tramite.getUsuario().getNombre());
				i++;
			}
		}
		
		return wb;
	}
}
