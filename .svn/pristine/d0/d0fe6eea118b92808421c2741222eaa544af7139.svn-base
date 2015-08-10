<%@page import="com.swz.service.web.LoggerServer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript"
	src="jquery/jquery-1.11.1.min.js"></script>
<title>侍卫长车辆实时动态信息查询</title>
</head>
<body>
	<div align="center">
		<h1>侍卫长车辆实时动态信息查询</h1>
		<span>您的车辆信息为：</span> <span id="carName"></span>
		<table>
			<tr>
				<th>测试项目</th>
				<th>参数值</th>
				<th>测试结果</th>
			</tr>
			<tr>
				<td>由objectid查询车辆位置及信息</td>
				<td><input id="txt_id" type="text" title="请输入车辆objectid"></td>
				<td><input id="btn_id" type="button" value="测试"></td>
		</table>
	</div>
	<a></a>
</body>

<script type="text/javascript">
	(function($) {
		console.log('1');
	})(jQuery)
	$(document).ready(function() {
		console.log('2');
		$('#btn_id').click(function() {
			$.ajax({
				type : "post",
				dataType : 'json',
				url : "carLocation.do",
				data : {
					vehicleid : $('#txt_id').val(),
					vehiclenum : 12321
				},
				error : function() {

				},
				success : function(result) {
					alert(result.car_no);
				}
			});
		});
	});
</script>
</html>