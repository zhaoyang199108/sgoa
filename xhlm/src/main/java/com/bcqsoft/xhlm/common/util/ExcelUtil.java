package com.bcqsoft.xhlm.common.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.web.multipart.MultipartFile;

/**
 * Excel操作工具类
 */
public class ExcelUtil {

	/**
	 * Excel文件后缀名(.xls)
	 */
	public static final String SUFFIX_XLS = ".xls";
	/**
	 * Excel上传最大限制字节(204800)
	 */
	public static final Integer MAX_SIZE = 2048000;

	/**
	 * 检验文件是否是允许上传的Excel文件
	 * 
	 * <li>大小校验</li><br>
	 * <li>格式校验</li>
	 * 
	 * @param file
	 * @return True:是 Flase:否
	 */
	public static boolean isAllowedExcel(MultipartFile file) {
		return isExcel(file) && (!isOverMax(file));

	}

	/**
	 * 验证上传文件大小是否超过允限制(最大)
	 * 
	 * @author zbq
	 * @date 2010-07-24
	 * @param file
	 * @return true:超过 false:未超过
	 */
	public static boolean isOverMax(MultipartFile file) {
		return file.getSize() > MAX_SIZE;
	}

	/**
	 * 判断文件是否是Excel文件<br>
	 * <li>后缀名为".xls"</li><br>
	 * <li>格式为Excel文件</li>
	 * 
	 * @param file
	 * @return True:是 Flase:否
	 */
	public static boolean isExcel(MultipartFile file) {
		return isExcelSuffix(file) && isExcelType(file);
	}

	/**
	 * 判断文件是否是Excel格式(.xls)
	 * 
	 * @param file
	 * @return True:是 Flase:否
	 */
	public static boolean isExcelSuffix(String file) {
		String suffix = FileUtil.getFileSuffix(file);
		return SUFFIX_XLS.equalsIgnoreCase(suffix);
	}

	/**
	 * 判断文件名称是否是Excel格式(.xls)
	 * 
	 * @param file
	 * @return True:是 Flase:否
	 */
	public static boolean isExcelSuffix(MultipartFile file) {
		String suffix = FileUtil.getFileSuffix(file.getOriginalFilename());
		return SUFFIX_XLS.equalsIgnoreCase(suffix);
	}

	/**
	 * 是否是Excel文件类型
	 * 
	 * @return
	 */
	public static boolean isExcelType(MultipartFile file) {
		// 读取如果文件过程中抛出异常,则该文件不是Excel文件
		// 将一个非Excel文件(zip等)后缀名改为xls, 此处会抛异常
		try {
			getExcelWorkbook(file.getInputStream());
		}
		catch (IOException e) {
			return false;
		}
		return true;
	}

	/**
	 * 获取Excel文件流
	 * 
	 * @param MultipartFile
	 * @return HSSFWorkbook
	 */
	public static HSSFWorkbook getExcel(MultipartFile file) {
		return getExcelByFile(file);
	}

	/**
	 * 通过文件流获取Excel数据流
	 * 
	 * @param InputStream
	 * @return HSSFWorkbook
	 */
	public static HSSFWorkbook getExcel(InputStream input) {
		return getExcelByStream(input);
	}

	/**
	 * 取一个Excel单元格的值
	 * 
	 * @param cell
	 * @return String
	 */
	public static String getCellValue(HSSFRow row, int cellIndex) {
		return getCellValue(row.getCell(cellIndex));
	}

	/**
	 * 根据行及列所在位置取得Excel单元格中的数字类型值<br>
	 * 如果不是数值类型默认为0
	 * 
	 * @param HSSFRow
	 * @param cellIndex
	 * @return int
	 */
	public static Integer getCellInteger(HSSFRow row, int cellIndex) {
		String value = getCellValue(row.getCell(cellIndex));
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		return NumberUtils.toInt(value);
	}

	/**
	 * 根据行及列所在位置取得Excel单元格中的数字类型值<br>
	 * 如果不是数值类型默认为0
	 * 
	 * @param HSSFRow
	 * @param cellIndex
	 * @return int
	 */
	public static int getCellInt(HSSFRow row, int cellIndex) {
		return getCellInt(row.getCell(cellIndex));
	}

	/**
	 * 取得Excel单元格中的数字类型值<br>
	 * 如果不是数据默认为0
	 * 
	 * @param HSSFCell
	 * @param cellIndex
	 * @return int
	 */
	public static int getCellInt(HSSFCell cell) {
		return NumberUtils.toInt(getCellValue(cell));
	}

	/**
	 * 生成Excel表格POI需要的文字样式
	 * 
	 * @param value
	 * @return
	 */
	public static HSSFRichTextString toHSSFText(String value) {
		return new HSSFRichTextString(value);
	}

	/**
	 * 生成表格题头样式
	 * 
	 * @param workbook
	 * @return HSSFCellStyle
	 */
	public static HSSFCellStyle createHeaderStyle(HSSFWorkbook workbook) {
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		return cellStyle;
	}

	/**
	 * 取一个excel单元格的值
	 * 
	 * @param cell
	 * @return String
	 */
	public static String getCellValue(HSSFCell cell) {

		if (cell == null) {
			return StringUtils.EMPTY;
		}

		String cellValue = null;
		switch (cell.getCellType()) {

		case HSSFCell.CELL_TYPE_STRING:
			cellValue = cell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			int number = (int) (Math.floor(cell.getNumericCellValue()));
			cellValue = String.valueOf(number);
			break;
		case HSSFCell.CELL_TYPE_FORMULA:
			// 取得Excel中的公式, 目前暂时用不到
			// cellValue = cell.getCellFormula();
			int number_f = (int) (Math.floor(cell.getNumericCellValue()));
			cellValue = String.valueOf(number_f);
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			cellValue = String.valueOf(cell.getErrorCellValue());
			break;

		default:
			cellValue = cell.getStringCellValue();
			break;
		}

		return cellValue;
	}

	/**
	 * 判断某列是否是空值
	 * 
	 * @param row
	 * @param cellIndex
	 * @return True:是 Flase:否
	 */
	public static boolean isEmptyCell(HSSFRow row, int cellIndex) {
		return isEmptyCell(row.getCell(cellIndex));
	}

	/**
	 * 判断某列是否是空值
	 * 
	 * @param cell
	 * @return True:是 Flase:否
	 */
	public static boolean isEmptyCell(HSSFCell cell) {
		String value = getCellValue(cell);
		return StringUtils.isEmpty(value);
	}

	/**
	 * 通过文件获取Excel数据流
	 * 
	 * @param file
	 * @return HSSFWorkbook
	 */
	private static HSSFWorkbook getExcelByFile(MultipartFile file) {

		HSSFWorkbook workbook = null;

		try {
			workbook = getExcelByStream(file.getInputStream());
		}
		catch (IOException e) {
		}
		return workbook;
	}

	/**
	 * 将文件流转换为Excel数据流
	 * 
	 * @param file
	 * @return HSSFWorkbook
	 */
	private static HSSFWorkbook getExcelByStream(InputStream input) {
		HSSFWorkbook workbook = null;
		try {
			workbook = getExcelWorkbook(input);
		}
		catch (IOException e) {
		}
		return workbook;
	}

	/**
	 * 读取Excel文件, 如果抛出异常则证明该文件不是Excel格式
	 * 
	 * @param input
	 * @return
	 * @throws IOException
	 */
	private static HSSFWorkbook getExcelWorkbook(InputStream input) throws IOException {

		HSSFWorkbook workbook = null;
		try {
			workbook = new HSSFWorkbook(new POIFSFileSystem(input));
		}
		finally {
		}
		return workbook;
	}

}
