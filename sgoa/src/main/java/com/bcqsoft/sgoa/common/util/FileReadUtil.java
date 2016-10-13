package com.bcqsoft.sgoa.common.util;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

public class FileReadUtil {

	/**
	 * 
	 * 从ftp取得要打开的pdf文件
	 * 
	 * @param bis
	 *            服务器上的文件
	 * @return String 下载文件的内容
	 * 
	 */
	public String pdfRead(BufferedInputStream bis) {

		PDDocument pdfdocument = null;
		String ts = "";
		try {
			PDFTextStripper stripper = new PDFTextStripper();
			pdfdocument = PDDocument.load(bis);
			StringWriter writer = new StringWriter();
			stripper.writeText(pdfdocument, writer);
			ts = writer.getBuffer().toString();
			pdfdocument.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return ts;
	}

	/**
	 * 
	 * 从ftp取得要打开的word文件
	 * 
	 * @param bis
	 *            服务器上的文件
	 * @return String 下载文件的内容
	 * 
	 */
	public String wordRead(BufferedInputStream bis) {

		String bodyText = "";
		WordExtractor ex = null;
		try {
			ex = new WordExtractor(bis);
			bodyText = ex.getText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bodyText;
	}

	/**
	 * 
	 * 从ftp取得要打开的excel文件
	 * 
	 * @param bis
	 *            服务器上的文件
	 * @return String 下载文件的内容
	 * 
	 */
	public String excelRead(BufferedInputStream bis) {

		StringBuffer content = new StringBuffer();
		HSSFWorkbook workbook = null;
		try {
			workbook = new HSSFWorkbook(bis);
			for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {
				HSSFSheet aSheet = workbook.getSheetAt(numSheets);// 获得一个sheet
				content.append("/n");
				if (null == aSheet) {
					continue;
				}
				for (int rowNum = 0; rowNum <= aSheet.getLastRowNum(); rowNum++) {
					content.append("/n");
					HSSFRow aRow = aSheet.getRow(rowNum);
					if (null == aRow) {
						continue;
					}
					for (short cellNum = 0; cellNum <= aRow.getLastCellNum(); cellNum++) {
						HSSFCell aCell = aRow.getCell(cellNum);
						if (null == aCell) {
							continue;
						}
						if (aCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							content.append(aCell.getRichStringCellValue()
									.getString());
						} else if (aCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
							boolean b = HSSFDateUtil.isCellDateFormatted(aCell);
							if (b) {
								Date date = aCell.getDateCellValue();
								SimpleDateFormat df = new SimpleDateFormat(
										"yyyy-MM-dd");
								content.append(df.format(date));
							}
						}
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content.toString();
	}

	/**
	 * 
	 * 从ftp取得要打开的word文件
	 * 
	 * @param bis
	 *            服务器上的文件
	 * @return String 下载文件的内容
	 * 
	 */
	public String txtRead(BufferedInputStream bis) {

		byte[] buffer = new byte[1024];
		String chunk = "";
		try {
			int bytesRead = 0;
			// 从文件中按字节读取内容，到文件尾部时read方法将返回-1
			while ((bytesRead = bis.read(buffer)) != -1) {

				// 将读取的字节转为字符串对象
				chunk = new String(buffer, 0, bytesRead);
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			// 关闭 BufferedInputStream
			try {
				if (bis != null)
					bis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return chunk;
	}
}
