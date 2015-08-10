<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
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
		//List list = null;
		// 		if (session.getAttribute(Data.ALLNEWSLIST) != null) {
		// 			list = (List) session.getAttribute(Data.ALLNEWSLIST);
		//int l = list.size();
		int l = 1;
	%>
	<table border=1 width="100%">
		<tr bgcolor="#8E8E8E">
			<td>第二章</td>
		</tr>
	</table>
	<table>
		<%
			for (int i = 0; i < l; i++) {
				// 				News news = (News) list.get(i);
				// 				ntype = news.getNtype();
		%>
		<tr bgcolor="#93FF93">
			<%-- 			<td bgcolor="#6C6C6C"><%=news.getNid()%></td> --%>
			<!-- 			<td bgcolor="#ADADAD"><a -->
			<%-- 				href="servlet/ShowDetailNews?nid=<%=news.getNid()%>"><%=news.getNtitle()%></a></td> --%>

		</tr>
		<%
			}
		%>

	</table>
	<br>
	<a href="servlet/ShowAllNews?page=1&type=<%=ntype%>">首页</a> 
	<a href="servlet/ShowAllNews?page=<%=pagenum - 1%>&type=<%=ntype%>">上一页</a> 
	<a href="servlet/ShowAllNews?page=<%=pagenum + 1%>&type=<%=ntype%>">下一页</a> 
	<a href="servlet/ShowNewsEndPage?type=<%=ntype%>">尾页</a>

	<%
		// 		}
	%>

</body>
</html>