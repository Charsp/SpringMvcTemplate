<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib
	prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>您已注册车辆的信息</title>
</head>
<body>
	<div align="center">
		<h1>用户注册车辆的信息</h1>
		<table border=1>
			<tr bgcolor="#8E8E8E">
				<th>车辆id</th>
				<th>操作日期</th>
				<th>车辆car_info的id号码</th>
				<th>启动信息</th>
				<th>历程统计</th>
				<th>当前车速</th>
				<th colspan="2">当前坐标位置</th>
			</tr>
			<c:forEach items="${username}" var="user">
				<tr>
					<td align="center">${user.id}</td>
					<td align="center"><fmt:formatDate pattern="yyyy-MM-dd"
							value="${user.datetime}" /></td>
					<td align="center">${user.car_object_id}</td>
					<td align="center">${user.io_acc}</td>
					<td align="center">${user.runmile}</td>
					<td align="center">${user.velocity}</td>
					<td align="center">${user.x}</td>
					<td align="center">${user.y}</td>
					<!-- 自定义标签 -->
				</tr>
			</c:forEach>
		</table>
		<table border=1>
			<tr bgcolor="#8E8E8E">
				<th>用户名称</th>
				<th>用户id号</th>
				<th>车辆list</th>
				<th colspan="2">车牌list</th>
			</tr>
			<c:forEach items="${userinfo.car_object_id},${userinfo.car_no}"
				var="car_object_id">
				<tr>
					<td align="center">${userinfo.username}</td>
					<td align="center">${userinfo.password}</td>
					<td align="center">${car_object_id}</td>
					<td align="center">${car_object_id}</td>
					<!-- 自定义标签 -->
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>