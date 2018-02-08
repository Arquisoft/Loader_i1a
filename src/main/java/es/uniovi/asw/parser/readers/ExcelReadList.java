package es.uniovi.asw.parser.readers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;

import es.uniovi.asw.agents.Agent;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.parser.lettergenerators.LetterGenerator;

/**
 * @author Oriol. Excel parser.
 */
public class ExcelReadList extends AbstractReadList {

	public ExcelReadList() {
		super();
	}

	public ExcelReadList(LetterGenerator letterGenerator) {
		super(letterGenerator);
	}

	@Override
	public void doParse(String ruta) {

		XSSFWorkbook wb = null;
		XSSFSheet sheet;
		XSSFRow row;

		try {
			FileInputStream file = new FileInputStream(ruta);

			wb = new XSSFWorkbook(OPCPackage.open(file));
			sheet = wb.getSheetAt(0);
			census = new HashSet<Agent>();

			int rows = sheet.getPhysicalNumberOfRows();

			int cols = 5; // Name/location/Email/Id/Kind

			for (int r = 1; r < rows; r++) {
				row = sheet.getRow(r);

				String[] data = parseRow(row, cols);

				Agent cit = null;

				if (data != null) {

					if (data[0].equals("")) {
						wReport.report("Null name on row number " + r, ruta);
					} else if (data[2].equals("")) {
						wReport.report("Null email on row number " + r, ruta);
					} else if (data[3].equals("")) {
						wReport.report("Null ID on row number " + r, ruta);
					} else if (data[4].equals("")) {
						wReport.report("Null kind on row number " + r, ruta);
					} else {
						Double kind = Double.parseDouble(data[4]);
						cit = new Agent(data[0], data[1], data[2], data[3], kind.intValue());
						if (census.contains(cit)) {
							wReport.report("Duplicated citizen on row number " + r, ruta);
						} else {
							census.add(cit);
						}

					}
				} else {
					wReport.report("Empty row nº" + r, ruta);
				}

			}

			wb.close();
		} catch (FileNotFoundException e) {
			wReport.report(e, "No se ha encontrado el archivo solicitado");
		}

		catch (Exception ioe) {
			ioe.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	private String[] parseRow(XSSFRow row, int cols) throws ParseException {
		XSSFCell cell;
		String[] data = new String[cols];

		if (row != null) {
			for (int c = 0; c < cols; c++) {
				cell = row.getCell((short) c);
				if (cell != null && !cell.toString().equals("")) {
					if (cell.getCellTypeEnum() == CellType.NUMERIC 
							&& DateUtil.isCellDateFormatted(cell)) {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						data[c] = sdf.format(cell.getDateCellValue());
					} else {
						data[c] = cell.toString();
					}
				}
			}
			return data;
		}
		return null;
	}

}
