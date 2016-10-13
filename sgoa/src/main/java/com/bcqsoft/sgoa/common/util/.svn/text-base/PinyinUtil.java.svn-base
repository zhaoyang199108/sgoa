package com.bcqsoft.sgoa.common.util;

import static org.apache.commons.lang.StringUtils.EMPTY;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

/**
 * 拼音工具类
 */
public class PinyinUtil {

	/**
	 * 大写
	 */
	public static final Integer ALL_UPPER = 1;

	/**
	 * 小写
	 */
	public static final Integer ALL_LOWER = 2;

	/**
	 * 首字母大写
	 */
	public static final Integer FIRST_LETTER_UPPER = 3;

	/**
	 * 将汉字转换成拼音(小写,不包括英文)
	 * 
	 * <pre>
	 * 诚启Soft => chengqiSoft
	 * </pre>
	 * 
	 * @param 汉字
	 * @return 小写拼音
	 */
	public static String toPinyin(String src) {
		return stringToPinyin(src, false, ALL_LOWER);
	}

	/**
	 * 将汉字转换成拼音(小写,包括英文)
	 * 
	 * <pre>
	 * 诚启Soft => chengqisoft
	 * </pre>
	 * 
	 * @param hanzi
	 * @param separator
	 * @return 小写拼音
	 */
	public static String toPinyins(String src) {
		return stringToPinyin(src, false, ALL_LOWER, true);
	}

	/**
	 * 将汉字转换成拼音(大写,不包括英文)
	 * 
	 * <pre>
	 * 诚启软件 => CHENGQISoft
	 * </pre>
	 * 
	 * @param 汉字
	 * @param separator
	 * @return 大写拼音
	 */
	public static String toUppPinyin(String src) {
		return stringToPinyin(src, false, ALL_UPPER);
	}

	/**
	 * 将汉字转换成拼音(大写,包括英文)
	 * 
	 * <pre>
	 * 诚启Soft => CHENGQISOFT
	 * </pre>
	 * 
	 * @param 汉字
	 * @param separator
	 * @return 大写拼音
	 */
	public static String toUppPinyins(String src) {
		return stringToPinyin(src, false, ALL_UPPER, true);
	}

	/**
	 * 将汉字转换成拼音(首字母大写,不包括英文)
	 * 
	 * <pre>
	 * 诚启Soft => ChengQiSoft
	 * </pre>
	 * 
	 * @param src 汉字
	 * @return 首字母大写拼音
	 * 
	 * @Author zbq
	 * @Date 2011-9-19
	 */
	public static String toFirstUppPinyin(String src) {
		return stringToPinyin(src, false, FIRST_LETTER_UPPER);
	}

	/**
	 * 将汉字转换成拼音(大写缩写,不包括英文)
	 * 
	 * <pre>
	 * 诚启Soft => CQSoft
	 * </pre>
	 * 
	 * @param src 汉字
	 * @return 大写缩写拼音
	 * 
	 * @Author zbq
	 * @Date 2011-9-19
	 */
	public static String toAbbUppPinyin(String src) {
		return stringToPinyin(src, true, ALL_UPPER);
	}

	/**
	 * 将汉字转换成拼音(大写缩写,包括英文)
	 * 
	 * <pre>
	 * 诚启Soft => CQSOFT
	 * </pre>
	 * 
	 * @param src 汉字
	 * @return 大写缩写拼音
	 * 
	 * @Author zbq
	 * @Date 2011-9-19
	 */
	public static String toAbbUppPinyins(String src) {
		return stringToPinyin(src, true, ALL_UPPER, true);
	}

	/**
	 * 将汉字转换成拼音(小写缩写,不包括英文)
	 * 
	 * <pre>
	 * 诚启Soft=> cqSoft
	 * </pre>
	 * 
	 * @param src 汉字
	 * @return 小写缩写拼音
	 * 
	 * @Author zbq
	 * @Date 2011-9-19
	 */
	public static String toAbbLowPinyin(String src) {
		return stringToPinyin(src, true, ALL_LOWER);
	}

	/**
	 * 将汉字转换成拼音(小写缩写,包括英文)
	 * 
	 * <pre>
	 * 诚启Soft => cqsoft
	 * </pre>
	 * 
	 * @param src 汉字
	 * @return 小写缩写拼音
	 * 
	 * @Author zbq
	 * @Date 2011-9-19
	 */
	public static String toAbbLowPinyins(String src) {
		return stringToPinyin(src, true, ALL_LOWER, true);
	}

	/**
	 * 汉字转换为拼音
	 * 
	 * @param src 需要转换的文字
	 * @param isAbb 是否缩写(True:缩写)
	 * @param caseKey (大小写转换)
	 * @return 转换后的拼音
	 * 
	 * @Author zbq
	 * @Date 2011-9-19
	 */
	private static String stringToPinyin(String src, boolean isAbb, Integer caseKey) {
		String pinyin = EMPTY;
		if (StringUtils.isBlank(src)) {
			return pinyin;
		}
		
		try {
			pinyin = convertToPinyin(src, isAbb, caseKey, false);
		}
		catch (BadHanyuPinyinOutputFormatCombination e) {
		}
		return pinyin;
	}

	/**
	 * 汉字转换为拼音(不包括英文大小写转换)
	 * 
	 * @param src 需要转换的文字
	 * @param isAbb 是否缩写(True:缩写)
	 * @param caseKey (大小写转换)
	 * @param isAll 是否全部转换(True:是)
	 * @return 转换后的拼音
	 * 
	 * @Author zbq
	 * @Date 2011-9-19
	 */
	private static String stringToPinyin(String src, boolean isAbb, Integer caseKey, boolean isAll) {
		String pinyin = EMPTY;
		try {
			pinyin = convertToPinyin(src, isAbb, caseKey, isAll);
		}
		catch (BadHanyuPinyinOutputFormatCombination e) {
		}
		return pinyin;
	}

	/**
	 * 汉字转换为拼音
	 * 
	 * @param src 需要转换的文字
	 * @param isAbb 是否缩写(True:缩写)
	 * @param caseKey 大小写转换
	 * @param isAll 是否全部转换(True:是)
	 * @return 转换后的拼音
	 * 
	 * @Author zbq
	 * @Date 2011-9-19
	 */
	private static String convertToPinyin(String src, boolean isAbb, Integer caseKey, boolean isAll)
			throws BadHanyuPinyinOutputFormatCombination {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < src.length(); i++) {
			char chars = src.charAt(i);
			// 如果不是中文不进行转换
			if (chars <= 128) {

				buf.append(convertOther(chars, caseKey, isAll));
				continue;
			}

			// 中文转换为拼音,多音字取第一个拼音
			String[] array = PinyinHelper.toHanyuPinyinStringArray(src.charAt(i), getDefaultFomat());
			if (ArrayUtils.isEmpty(array)) {
				continue;
			}
			// 判断是否是缩写及大小写格式
			String abbPy = isAbb ? array[0].substring(0, 1) : array[0];
			String pinyin = convertCase(abbPy, caseKey);
			// 添加转换的拼音
			buf.append(pinyin);
		}
		return buf.toString();
	}

	/**
	 * 处理拼音大小写<br>
	 * <li>ALL_UPPER:1 -全部大写</li><br>
	 * <li>ALL_LOWER:2-全部小写</li> <br>
	 * <li>FIRST_LETTER_UPPER:3 -首字母大写</li>
	 * 
	 * @param value 汉字
	 * @param caseKey 大小写格式
	 * @return 转换后的拼音
	 * 
	 * @Author zbq
	 * @Date 2011-9-19
	 */
	private static String convertCase(String pinyin, Integer caseKey) {
		String result = pinyin;
		if (caseKey == ALL_UPPER) {
			result = StringUtils.upperCase(pinyin); // 全部大写
		}
		else if (caseKey == ALL_LOWER) {
			result = StringUtils.lowerCase(pinyin); // 全部小写
		}
		else if (caseKey == FIRST_LETTER_UPPER) {
			result = WordUtils.capitalize(pinyin); // 首字母大写
		}
		return result;

	}

	/**
	 * 处理英文字母(汉字以外的)大小写<br>
	 * <li>ALL_UPPER:1 -全部大写</li><br>
	 * <li>ALL_LOWER:2-全部小写</li> <br>
	 * <li>FIRST_LETTER_UPPER:3 -首字母大写</li>
	 * 
	 * @param isAll 是否全部转换(True:是)
	 * @return 转换后的字母
	 * 
	 * @Author zbq
	 * @Date 2011-9-19
	 */
	private static String convertOther(char c, Integer caseKey, boolean isAll) {
		String pinyin = String.valueOf(c);
		return isAll ? convertCase(pinyin, caseKey) : pinyin;
	}

	/**
	 * 取得默认拼音转换格式<br>
	 * <li>小写</li><br>
	 * <li>音标:不标声调</li> <br>
	 * <li>u:的声母替换为v</li>
	 * 
	 * @return
	 * 
	 * @Author zbq
	 * @Date 2011-9-19
	 */
	private static HanyuPinyinOutputFormat getDefaultFomat() {
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 小写
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE); // 音标:不标声调
		defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);// u:的声母替换为v
		return defaultFormat;
	}

}
