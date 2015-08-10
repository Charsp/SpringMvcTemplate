package org.web.aftertech.html5;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * 浏览器的实时通信 官方网址 http://tomcat.apache.org/tomcat-7.0-doc/web-socket-howto.html
 * 
 * @author Charsp
 *
 * @date 2014年12月15日
 */
public class WebSocket extends TextWebSocketHandler {

	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception { 
		super.handleTextMessage(session, message);
		TextMessage returnMessage = new TextMessage(message.getPayload()
				+ " received at server 汉字一句啊啊 ");
		session.sendMessage(returnMessage);
	}

	// private static final long serialVersionUID = -7178893327801338294L;
	//
	// @Override
	// protected StreamInbound createWebSocketInbound(String arg0) {
	// System.out.println("##########");
	// return new MyMessageInbound();
	// }
	//
	// @Override
	// protected StreamInbound createWebSocketInbound(String arg0,
	// HttpServletRequest arg1) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}