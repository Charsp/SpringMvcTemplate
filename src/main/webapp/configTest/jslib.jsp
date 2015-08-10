<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<!-- 全局必须JS，CSS框架 .默认添加jQuery的基础框架移动端得手动配置 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery/jquery-1.11.1.min.js"></script>
<c:if test="${param.mobile == '1'}">
	<!-- 手机屏幕适应 -->
	<meta name="viewport"
		content="initial-scale=1.0,maximum-scale=4.0,minimum-scale=1.0,user-scalable=no">
	<!-- jquery手机框架库 -->
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/jquery/jquery.mobile-1.4.3.min.css" />
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jquery/jquery.mobile-1.4.3.min.js"></script>
</c:if>
</html>