package com.swz.web.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Utils {

	private static DecimalFormat df_view = new DecimalFormat("#,##0.00");
//	private static DecimalFormat df_database = new DecimalFormat("###0.00");

	public static boolean isNull(String str) {
		return (str == null || str.trim().equals(""));
	}

	public static boolean isNotNul(String str) {
		return (str != null && !str.trim().equals(""));
	}

	public static String nvl(Object o, String s) {
		if (o == null || String.valueOf(o).equals("")
				|| String.valueOf(o).equals("null")) {
			return s;
		}
		return String.valueOf(o);
	}

	public static String formatAmt2View(String amt) {
		return df_view.format(new BigDecimal(amt));
	}

	public static String formatAmt2View(BigDecimal amt) {
		return df_view.format(amt);
	}

	public static void main(String[] args) {
		String s = formatAmt2View("1230.01");
		System.out.println(s);

	}
}
