package com.swz.dependent.config;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.swz.vo.model.SysParam;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class SysParams {
	private static Logger logger = LoggerFactory.getLogger(SysParams.class);

	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	// public static String partner = "2088000000000000";
	// 商户的私钥
	// public static String key = "abcdefghijklmnopqrstuvwxyz123456";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	// 签名方式 不需修改
	public static String sign_type = "MD5";

	public static String form_method = "post";

	/*
	 * 参数初始化静态MAP
	 */
	@SuppressWarnings("rawtypes")
	private static Map PARAM_MAP = null;

	@SuppressWarnings("rawtypes")
	private static void initParams() {

		logger.info("开始初始化参数");
		if (PARAM_MAP != null && !PARAM_MAP.isEmpty()) {
			logger.info("不需要初始化参数");
			return;
		}

		PARAM_MAP = new HashMap();
		SysParam example = new SysParam();
		example.setPrSt("1");
	}

	@SuppressWarnings("rawtypes")
	public static String getParamValue(String parParamCode, String paramCode) {

		if (PARAM_MAP == null) {
			initParams();
		}

		logger.debug("ParCode = " + parParamCode + ", ParCode = " + paramCode);
		String parValue = paramCode;
		if (PARAM_MAP.containsKey(parParamCode)) {

			Map chdParMap = (Map) PARAM_MAP.get(parParamCode);

			if (chdParMap.containsKey(paramCode)) {
				parValue = (String) chdParMap.get(paramCode);
			}

		}
		return parValue;
	}

}
