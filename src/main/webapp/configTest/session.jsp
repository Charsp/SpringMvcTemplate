<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Jquery JS mini -->
<link rel="stylesheet" href="../jquery/jquery.mobile-1.3.2.min.css" />
<script type="text/javascript" src="../jquery/jquery-1.11.1.min.js"></script>
<script src="../jquery/jquery.mobile-1.3.2.min.js"></script>
<title>系统Session管理页面</title>
</head>
<body>
	<div align="center">
		<h1>系统Session管理页面</h1>
		<table>
			<caption>Seesion数据测试</caption>
			<thead>
				<tr>
					<th>测试项目</th>
					<th>测试内容</th>
					<th>操作</th>
					<th>测试结果</th>
				</tr>
				<tr>
					<td>添加Session</td>
					<td><input type="text" id="parameter" title="输入参数"></td>
					<td><input type="text" id="parameterVal" title="输入值"></td>
					<td><input type="button" id="sessionAdd" value="添加"></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>测试项目</th>
					<th>测试内容</th>
					<th>操作</th>
					<th>测试结果</th>
				</tr>

			</tbody>

		</table>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		var sessionAdd = function() {
			$.ajax({
				type : "get",
				url : "../Confirm",
				data : {
					effect : 'session',
					param : $('#parameter').val(),
					paramVal : $('#parameterVal').val()
				},
				async : false,
				dateType : "json",
				error : function() {
					showmessagebox('网络错误，无数据返回！');
					playing = false;
				},
				success : function(redata) {

					//格式化数据结构
					// 					redata = JSON.parse(redata);
					showmessagebox('添加成功！' + redata)
				}
			});
		}
		$('#sessionAdd').click(function() {
			sessionAdd();
		});

		function showmessagebox(strInfo) {
			$.mobile.showPageLoadingMsg("a", strInfo, true);
			setTimeout("$.mobile.hidePageLoadingMsg();", 1900);
		}
	});
</script>
</html>