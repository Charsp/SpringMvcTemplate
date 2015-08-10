package org.swz.mongo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.system.comm.serialbus.SerialModel;
import org.system.comm.serialbus.SerialReader;

@Controller
public class SerialBusController extends AbstractController {
	// 注入端口控制
	private SerialReader serialReader;

	public void setSerialReader(SerialReader serialReader) {
		this.serialReader = serialReader;
	}

	@RequestMapping(value = "/portsetting.do")
	public void setPortConfig(HttpServletResponse response, SerialModel model) {
		// 获取端口等信息，并修改其值

		// 获得端口设置参数
		Map<String, String> map = serialReader.tryOpenPort(model);
		returnAjaxResponse(response, JSONObject.fromObject(map).toString());
	}
}
