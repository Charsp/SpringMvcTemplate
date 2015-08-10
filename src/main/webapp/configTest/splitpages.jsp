<%@page import="java.awt.geom.Point2D;"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>滚动到页面顶部加载</title>
<script src="../jquery/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="../jquery/endlesspage.js" type="text/javascript"></script>
<style type="text/css">
.mainDiv {
	width: 800px;
	border: solid 1px #f00;
	padding: 10px;
}

.item {
	width: 600px;
	height: 150px;
	border: solid 1px #00ff90;
	font-size: 12px;
	margin: 10px;
}
</style>
</head>
<body>
	<h1>滚动测试</h1>
	<div class="item">
		<div class="title">标题</div>
		<div class="content">content content content content
			contentontent content content content contentontent content content
			content contentontent content content content contentontent content
			content content contentontent content content content contentontent
			content content content content content content</div>
		<div>
			<h1>继续加载按钮</h1>
		</div>
	</div>
	<div class="mainDiv"></div>

</body>
</html>