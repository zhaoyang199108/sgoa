package com.bcqsoft.sgoa.common.util;

import java.math.BigDecimal;

/**
 * 金额相关工具类
 */
public class MoneyUtil {

	/**
	 * 小数点后尾数:2位
	 */
	public static final Integer DIGIT_SIZE_2 = 2;

	/**
	 * 计算总金额(四舍五入保留2位小数)
	 * 
	 * @param price
	 *            单价(BigDecimal)
	 * @param count
	 *            数量(Long)
	 * @return 总价(单价*数量)
	 * 
	 * @Author zbq
	 * @Date 2011-9-15
	 */
	public static BigDecimal calTotal(BigDecimal price, Long count) {
		BigDecimal bgCount = new BigDecimal(count);
		return price.multiply(bgCount).setScale(DIGIT_SIZE_2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 计算总金额(四舍五入保留2位小数)
	 * 
	 * @param price
	 *            单价(BigDecimal)
	 * @param count
	 *            数量(Integer)
	 * @return 总价(单价*数量)
	 * 
	 * @Author zbq
	 * @Date 2011-9-15
	 */
	public static BigDecimal calTotal(BigDecimal price, Integer count) {
		BigDecimal bgCount = new BigDecimal(count);
		return price.multiply(bgCount).setScale(DIGIT_SIZE_2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 计算平均金额(四舍五入保留2位小数)
	 * 
	 * @param total
	 *            总价(BigDecimal)
	 * @param count
	 *            数量(Integer)
	 * @return 总价(总价/数量)
	 * 
	 * @Author zbq
	 * @Date 2011-9-15
	 */
	public static BigDecimal calAvg(BigDecimal total, Integer count) {
		BigDecimal bgCount = new BigDecimal(count);
		return total.divide(bgCount, DIGIT_SIZE_2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 计算平均金额(四舍五入保留2位小数)
	 * 
	 * @param total
	 *            总价(BigDecimal)
	 * @param count
	 *            数量(Long)
	 * @return 总价(总价*数量)
	 * 
	 * @Author zbq
	 * @Date 2011-9-15
	 */
	public static BigDecimal calAvg(BigDecimal total, Long count) {
		BigDecimal bgCount = new BigDecimal(count);
		return total.divide(bgCount, DIGIT_SIZE_2, BigDecimal.ROUND_HALF_UP);
	}
}
