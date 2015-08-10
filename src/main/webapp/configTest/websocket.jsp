<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WEBSOCKET TEST</title>
<jsp:include page="jslib.jsp">
	<jsp:param name="mobile" value='<%=request.getParameter("mobile")%>' /></jsp:include>
<script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
<script type="text/javascript" src="../tsjs/websocket.js">
	
</script>
</head>
<body>
	<jsp:include page="swzheader.htm"></jsp:include>
	<div>
		<span>点击测试：</span><input id="btn_websocket" type="button"
			value="WEBSOCKET TEST">
	</div>
	<div id="valueLabel"></div>
	<jsp:include page="swzfooter.htm"></jsp:include>
</body>
</html>