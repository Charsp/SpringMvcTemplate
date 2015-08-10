package org.swz.mongo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import com.swz.dependent.config.SysParams;
import com.swz.vo.model.UserInfo;
import com.swz.web.exception.SwzpayException;
import com.swz.web.util.Utils;

public abstract class AbstractController {
	private static Logger logger = LoggerFactory.getLogger(AbstractController.class);

	/**
	 * 根据错误码返回错误信息
	 * 
	 * @param errCode
	 * @return
	 */
	protected String getErrMsg(String errCode) {
		return SwzpayException.getErrMsg(errCode);
	}

	/**
	 * 获取影响JSON初始化对象
	 * 
	 * @return
	 */
	protected JSONObject getResultJsonObject() {
		return JSONObject.fromObject("{\"errcode\":\"0\",\"msg\":\"\"}");
	}

	protected ModelAndView returnSuccessModelAndView(
			HttpServletRequest request, String viewName) {

		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(false);

		if (Utils.isNull(viewName)) {
			viewName = "error";
		}

		String pageCD = Base64.encodeBase64String(String.valueOf(
				System.currentTimeMillis() + "-" + viewName).getBytes());
		request.setAttribute("pageCD", pageCD);
		// 记录SESSION中该CD为未提交状态
		session.setAttribute(pageCD, false);

		modelAndView.setViewName(viewName);
		return modelAndView;
	}

	protected ModelAndView returnFailedModelAndView(HttpServletRequest request,
			String errMsg) {
		ModelAndView modelAndView = new ModelAndView();
		String viewName = "error";
		request.setAttribute("msg", errMsg);
		modelAndView.setViewName(viewName);
		return modelAndView;
	}

	/**
	 * 检查 是否为重复提交表单
	 * 
	 * @param session
	 * @param pageCD
	 * @return
	 */
	protected boolean canReceiveSubmitForm(HttpSession session, String pageCD) {
		logger.debug("检查表单是否为重复提交表单：");
		if (session.getAttribute(pageCD) != null
				&& !(Boolean) session.getAttribute(pageCD)) {
			logger.debug("未提交表单，可以接受提交！");
			return true;
		}
		logger.debug("已提交过的表单，属于重复提交！");
		return false;
	}

	/**
	 * 设置为表单已经提交状态
	 * 
	 * @param session
	 * @param pageCD
	 */
	protected void setSubmitedForm(HttpSession session, String pageCD) {
		if (session.getAttribute(pageCD) != null
				&& !(Boolean) session.getAttribute(pageCD)) {
			logger.debug("设置表单已经提交成功 ！");
			session.setAttribute(pageCD, true);
		}
	}

	/**
	 * 向客户端写JSON串
	 * 
	 * @param response
	 * @param resultjson
	 */
	protected void returnAjaxResponse(HttpServletResponse response,
			String resultjson) {
		if (response == null || resultjson == null) {
			return;
		}

		PrintWriter out = null;
		try {

			response.setCharacterEncoding(SysParams.input_charset);
			response.setContentType("text/html;charset=UTF-8");

			out = response.getWriter();
			out.write(resultjson);
			// out.flush();

			logger.debug("响应JSON串 ：" + resultjson.toString());

		} catch (IOException e) {
			logger.error("响应JSON串时异常:", e);
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}

	protected int getParameterPageIndex(HttpServletRequest request) {
		int pageIndex = 1;
		try {

			String pageIndexPar = request.getParameter("pageIndex");

			if (Utils.isNotNul(pageIndexPar)) {
				pageIndex = Integer.valueOf(pageIndexPar);
			}

		} catch (Exception e) {
			logger.error("查询参数异常：", e);
		}
		return pageIndex;

	}

	protected int getParameterPageSize(HttpServletRequest request) {
		int pageSize = 10;
		try {
			String pageSizePar = request.getParameter("pageSize");

			if (Utils.isNotNul(pageSizePar)) {
				pageSize = Integer.valueOf(pageSizePar);
			}

		} catch (Exception e) {
			logger.error("查询参数异常：", e);
		}
		return pageSize;

	}

	/*
	 * <div class="pages"> <a href="/search/下一步/3.html">&lt;&nbsp;上一页</a> <a
	 * href="/search/下一步/1.html">1</a>...&nbsp; <a
	 * href="/search/下一步/2.html">2</a> <a href="/search/下一步/3.html">3</a> <span
	 * class="current" >4</span> <a href="/search/下一步/5.html">5</a> <a
	 * href="/search/下一步/6.html">6</a> ... <a href="/search/下一步/26.html">26</a>
	 * <a href="/search/下一步/5.html">下一页&nbsp;&gt;</a> </div>
	 */
	protected String getPagingBtn(int pageCount, int pageIndex) {
		int n = 3;// 显示当前页前后共3个快捷按钮

		StringBuffer buff = new StringBuffer("<div class=\"pages\">");
		if (pageIndex > 1 && pageIndex <= pageCount) {
			buff.append(" <a href=\"javascript:go(" + (pageIndex - 1)
					+ ");\">&lt;&nbsp;上一页</a> ");
		} else {
			buff.append(" <span class=\"disabled\">&lt;&nbsp;上一页</span>");
		}

		if (pageCount > n + 2) {
			int preN = pageIndex > 1 ? pageIndex - 1 : 1;
			int nextN = pageIndex < pageCount ? pageIndex + 1 : pageCount;

			if (preN > 1) {
				buff.append("<a href=\"javascript:go(" + 1 + ")\">" + 1
						+ "</a> ");
				if (preN > 2) {
					buff.append("...");
				}

			}
			for (int i = preN; i <= nextN; i++) {
				if (i == pageIndex) {
					buff.append(" <span class=\"current\" >" + i + "</span> ");
				} else {
					buff.append(" <a href=\"javascript:go(" + i + ")\">" + i
							+ "</a> ");
				}
			}
			if (pageCount > nextN) {
				if (pageCount > nextN + 1) {
					buff.append("...");
				}
				buff.append("<a href=\"javascript:go(" + pageCount + ")\">"
						+ pageCount + "</a> ");
			}

		} else {
			for (int i = 1; i <= pageCount; i++) {
				if (i == pageIndex) {
					buff.append(" <span class=\"current\" >" + i + "</span> ");
				} else {
					buff.append(" <a href=\"javascript:go(" + i + ")\">" + i
							+ "</a> ");
				}
			}
		}

		if (pageIndex < pageCount) {
			buff.append(" <a href=\"javascript:go(" + (pageIndex + 1)
					+ ");\">下一页&nbsp;&gt;</a> ");
		} else {
			buff.append(" <span class=\"disabled\">下一页&nbsp;&gt;</span>");
		}
		buff.append("</div>");
		return buff.toString();
	}

	public String getBrowserType(HttpServletRequest request) {
		@SuppressWarnings("rawtypes")
		Enumeration agent = request.getHeaders("User-Agent");
		StringBuffer buff = new StringBuffer("");

		while (agent.hasMoreElements()) {
			buff.append(agent.nextElement());
		}
		return buff.toString();
	}

	public String getIpAddr(HttpServletRequest request) {
		logger.info("request.getRemoteAddr() : \n" + request.getRemoteAddr());
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public UserInfo getUserInfo(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		UserInfo user = (UserInfo) session.getAttribute("user");
		return user;
	}

	protected void sysLogger(HttpServletRequest request, String optType,
			String optCont) {
		// SysLog log = new SysLog();
		// log.setOptCont(optCont);
		// log.setOptType(optType);
		// log.setBrowserType(this.getBrowserType(request));
		// log.setUserIP(this.getIpAddr(request)); 
		// this.commService.createSysLog(log);
	}

}
