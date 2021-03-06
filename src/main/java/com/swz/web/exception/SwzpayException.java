package com.swz.web.exception;

import java.util.HashMap;
import java.util.Map;

public class SwzpayException {

	private static Map<?, ?> ERROR_MSG_MAP = initErrorMap();

	private static Map<String, String> initErrorMap() {
		Map<String, String> errMap = new HashMap<String, String>();

		errMap.put("9001", "用户或密码不能为空！");
		errMap.put("9002", "用户或密码错误！");

		errMap.put("9003", "订单维护失败！");
		errMap.put("9004", "验证码输入错误！");

		return errMap;

	}

	public static String getErrMsg(String errCode) {
		if (ERROR_MSG_MAP.containsKey(errCode)) {
			return (String) ERROR_MSG_MAP.get(errCode);
		} else {
			return "未注册此错误码！";
		}
	}

}
