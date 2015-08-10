package org.swz.mongo.controller;

import java.security.interfaces.RSAPublicKey;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.swz.dependent.config.RSACoder;
import com.swz.mongo.dao.impl.UserRepositoryImpl;
import com.swz.mongo.model.Gps_data;
import com.swz.mysql.gps.model.Vehicle;
import com.swz.service.web.FindVehicleLocation;
import com.swz.service.web.LoggerServer;
import com.swz.vo.model.Log4jInfo;
import com.swz.vo.model.UserInfo;

@Controller
public class LoginController extends AbstractController {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	private ModelAndView mv = new ModelAndView();
	private UserRepositoryImpl userRepositoryImpl;
	private LoggerServer loggerServer;
	private FindVehicleLocation findVehicleLocation;

	public FindVehicleLocation getFindVehicleLocation() {
		return findVehicleLocation;
	}

	@Resource
	public void setFindVehicleLocation(FindVehicleLocation findVehicleLocation) {
		this.findVehicleLocation = findVehicleLocation;
	}

	public LoggerServer getLoggerServer() {
		return loggerServer;
	}

	@Resource
	public void setLoggerServer(LoggerServer loggerServer) {
		this.loggerServer = loggerServer;
	}

	@Resource
	public void setUserRepositoryImpl(UserRepositoryImpl userRepositoryImpl) {
		this.userRepositoryImpl = userRepositoryImpl;
	}

	@RequestMapping(value = "/queryMys")
	public ModelAndView queryAll(HttpServletRequest request, Log4jInfo log4j) {
		logger.info("获得id号为" + log4j.getId());
		logger.info("request is：" + request.getParameter("ddd"));
		mv.setViewName("/index/error");
		mv.getModelMap().put("username", loggerServer.getLog4j());
		return mv;
	}

	@RequestMapping(value = "/ts_login.do")
	public void RSA(HttpServletResponse response, HttpServletRequest request) {
		String result = request.getParameter("result");
		try {
			logger.info(new String(RSACoder.decryptPwd(result)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("测试登录异常" + e.getMessage(), e);
		}
	}

	@RequestMapping(value = "/loginaction.do")
	public ModelAndView login(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		RSAPublicKey rsap = (RSAPublicKey) RSACoder.getKeyPair().getPublic();
		String module = rsap.getModulus().toString(16);
		String empoent = rsap.getPublicExponent().toString(16);
		request.setAttribute("m", module);
		request.setAttribute("e", empoent);
		logger.info("程序请求登录页面！");
		return mv;
	}

	@RequestMapping(value = "/carLocation.do")
	public ModelAndView queryCarLocation(HttpServletResponse response,
			HttpServletRequest request) {
		Integer vehicleid = null;
		String carName = null;
		Gps_data gps_data = null;
		JSONObject jsonObject = getResultJsonObject();
		// 得到车辆vehicleID
		try {
			vehicleid = Integer.valueOf(request.getParameter("vehicleid"));
			// 得到车辆车牌号码
			carName = loggerServer.findVehcleName(vehicleid);
			gps_data = findVehicleLocation.findLocation(vehicleid);
			logger.info("车辆查询完成");

		} catch (Exception e) {
			logger.error("车牌id获取失败！");
			jsonObject.put("errcode", "4000");
		}
		if (carName != null) {
			jsonObject.put("car_no", carName);
			if (gps_data != null) {
				jsonObject.put("Lat", gps_data.getX());
				jsonObject.put("Lon", gps_data.getY());
			} else {
				logger.error("车辆位置获取失败");
				jsonObject.put("errcode", "0001");
			}
		} else {
			jsonObject.put("msg", "无效的车辆id号！");
		}
		returnAjaxResponse(response, jsonObject.toString());
		return mv;
	}

	@RequestMapping(value = "/test.do")
	public ModelAndView queryValue(HttpServletResponse response,
			HttpServletRequest request) {
		// 得到车辆vehicleID
		logger.info("获得数据为" + request.getParameter("vehicleid"));
		returnAjaxResponse(response, getResultJsonObject().toString());
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/queryGps")
	public ModelAndView query(HttpServletRequest request, Log4jInfo log4j) {

		Gps_data gps_data = findVehicleLocation.findLocation(111885);
		mv.setViewName("/index/index");
		mv.getModelMap().put("username", gps_data);
		return mv;
	}

	/**
	 * 说明解析MAP文件 vehicleList
	 * 
	 * @param response
	 * @param request
	 * @param userInfo
	 */
	@SuppressWarnings({ "unused", "rawtypes" })
	@RequestMapping(value = "/login.do")
	public void login(HttpServletResponse response, HttpServletRequest request,
			UserInfo userInfo) {
		String result = "{\"errcode\":9,\"msg\":\"用户名或密码错误，信息验证失败\"}";
		List<Vehicle> vehicles = null;
		JSONObject jsonObject = getResultJsonObject();

		try {
			if (request.getParameter("code").equalsIgnoreCase(
					request.getSession(false).getAttribute("code").toString())) {
				// 验证码正确
				// logger.info("密码为：" + userInfo.getPassword() + "  用户名为："
				// + userInfo.getUsername());
				// 登录成功
				if (loggerServer.checkLogin(userInfo)) {
					logger.info("登录成功");
					// ///////////////// 获得车辆(分组)id列表///////////////////
					Map<String, List<Map>> map = loggerServer
							.getGroupVehicles(userInfo);

					// ///////////////// 获得车辆(未分组)id列表///////////////////
					List<Map> vehicleList = loggerServer
							.getNogroupVehicles(userInfo);
					if (vehicleList.size() > 0)
						map.put("未分组车辆", vehicleList);
					// ////////////////添加未分组车辆/////////////////////////////

					logger.info("map size is " + map.size()
							+ " but vehicles is " + vehicleList.size());
					if (map.size() > 0) {
						// 标志为多组车辆
						// 单辆车用户
						Iterator iterator = map.keySet().iterator();
						while (iterator.hasNext()) {
							// 数组名
							String key = (String) iterator.next();
							logger.info("--------------------");
							System.out.println(key + ":");
							// 车辆列表
							List<Map> list = map.get(key);
							for (int i = 0; i < list.size(); i++) {
								System.out.println("车牌:" + list.get(i).get("1")
										+ "  id:" + list.get(i).get("0"));
							}
						}
						logger.info("--------------------");
					}
					// 只有用户名，没有车辆信息
					else {
						jsonObject.put("errcode", "3001");
						jsonObject.put("warning", "您的账号异常，请联系我司工作人员！");
					}

					// 展现用户登录后的网页
					jsonObject.put("msg", "登录成功");
					jsonObject.put("newPage", "跳转页面");
					mv.setViewName("/index/vehicleList");
					// mv.getModelMap().put("username", gps_data);
					// mv.getModelMap().put("userinfo", userinfo);
					return;
				} else {
					// 账号不存在
					jsonObject.put("errcode", "4001");
					jsonObject.put("msg", "用户名或密码输入错误!");
				}
			} else {
				jsonObject.put("errcode", "2001");
				jsonObject.put("msg", "验证码输入错误!");
			}
		} catch (Exception e) {
			jsonObject.put("errcode", "1001");
			jsonObject.put("msg", "验证码失效,请重新刷新网页！");
		}
		returnAjaxResponse(response, jsonObject.toString());
	}

	public ModelAndView getMv() {
		return mv;
	}

	public void setMv(ModelAndView mv) {
		this.mv = mv;
	}

	public UserRepositoryImpl getUserRepositoryImpl() {
		return userRepositoryImpl;
	}
}