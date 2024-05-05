package com.arara.contabil.service;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arara.contabil.repository.EscolaDadosCadastraisRepository;

@Service
public class ExportExcelFileService {

	Logger logger = LoggerFactory.getLogger(EscolaDadosCadastraisService.class);

	@Autowired
	private EscolaDadosCadastraisRepository escolaDadosCadastraisRepository;

	public String generateXlsxFile(Long organizationId) {

		Workbook workbook = new XSSFWorkbook();

		Sheet sheet = workbook.createSheet("Persons");
		sheet.setColumnWidth(0, 6000);
		sheet.setColumnWidth(1, 4000);

		Row header = sheet.createRow(0);

		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		XSSFFont font = ((XSSFWorkbook) workbook).createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 16);
		font.setBold(true);
		headerStyle.setFont(font);

		Cell headerCell = header.createCell(0);
		headerCell.setCellValue("Name");
		headerCell.setCellStyle(headerStyle);

		headerCell = header.createCell(1);
		headerCell.setCellValue("Age");
		headerCell.setCellStyle(headerStyle);

		CellStyle style = workbook.createCellStyle();
		style.setWrapText(true);

		Row row = sheet.createRow(2);
		Cell cell = row.createCell(0);
		cell.setCellValue("John Smith");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue(20);
		cell.setCellStyle(style);

		File currDir = new File(getDirRelativePath(organizationId));
		File currFile = new File(currDir, sanitizeFilenameString("temp.xlsx"));

		try {
			currDir.mkdirs();
			currFile.createNewFile();
			FileOutputStream outputStream = new FileOutputStream(currFile);
			workbook.write(outputStream);
			workbook.close();

		} catch (Exception e) {
			logger.error("Erro ao escrever arquivo excel xlsx.", e);
		}

		return currFile.getName();

	}
	
	public String getDirRelativePath(Long organizationId) {
		return "files/" + organizationId + "/";
	}
	
	public String sanitizeFilenameString(String filename) {
		return filename.replaceAll("[^a-zA-Z0-9-_\\.\\(\\)]", "_");
	}
	

}
