<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%
		String ntype = null;
		int pagenum = 1;
		if (request.getParameter("pagecurrent") != null) {
			pagenum = Integer.parseInt(request.getParameter("pagecurrent"));
		}
	%>
	<div align="center">
		<h1>系统日志信息</h1>
		<table border=1>
			<tr bgcolor="#8E8E8E">
				<th>id</th>
				<th>操作日期</th>
				<th>信息</th>
				<th>类型</th>
				<th>操作人</th>
			</tr>
			<c:forEach items="${username}" var="user">
				<tr>
					<td align="center">${user.id}</td>
					<td align="center">${user.op_date}</td>
					<td align="center">${user.op_message}</td>
					<td align="center">${user.op_type}</td>
					<td align="center">${user.operator}</td>
					<!-- 自定义标签 -->
				</tr>
			</c:forEach>
		</table>
		<br> <a href="servlet/ShowAllNews?page=1&type=<%=ntype%>">首页</a> 
		<a href="servlet/ShowAllNews?page=<%=pagenum - 1%>&type=<%=ntype%>">上一页</a> 
		<a href="servlet/ShowAllNews?page=<%=pagenum + 1%>&type=<%=ntype%>">下一页</a> 
		<a href="servlet/ShowNewsEndPage?type=<%=ntype%>">尾页</a>
	</div>
</body>
</html>