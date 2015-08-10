<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	history.forward(-1);
</script>
<%
	String path = request.getContextPath();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登录</title>
<%-- <link href="<%=path%>/jquery/jquery.mobile-1.3.2.min.css" --%>
<!-- 	rel="stylesheet" type="text/css"> -->
<script type="text/javascript"
	src="<%=path%>/jquery/jquery-1.11.1.min.js"></script>
<!-- <script type="text/javascript" -->
<%-- 	src="<%=path%>/jquery/jquery.mobile-1.3.2.min.js"></script> --%>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	margin: auto;
}
</style>

</head>
<body>
	<div id="loaderc"
		style="background-color: white; width: 200px; -moz-box-shadow: -3px -3px 3px #999 inset; -webkit-box-shadow: -3px -3px 3px #999 inset; box-shadow: -3px -3px 3px #999 inset; position: fixed; vertical-align: middle;"
		align="center">
		<img alt="程序正在加载..." src="Image/loaderc.gif">
		<p id="loaderc_tile">程序正在加载...</p>
		<br>
	</div>
	<script type="text/javascript">
		function login() {
			$('#loaderc').show();
			setTimeout("$('#loaderc').hide();", 460);
			Login();
		}
		var loginSucess = function(datas) {
			datas = JSON.parse(datas);
			if (datas.errcode == 0) {
				//有此用户,判断密码正确性
				$.ajax({});
			}
			$.ajax({
				type : "Post",
				url : "login.do",
				data : {
					password : $('#password').val(),
					code : $('#code').val()
				},
				async : false,
				dateType : "json",
				error : function() {
					//也返回错误信息，不能更新数据
					latitude = '网络错误，位置信息获取失败';
					longitude = 0;
					Speed = 0;
					Direct = 0;
					Mileage = 0;
					alert('服务器内部cuow！');
					// $('#loaderc').hide();
				},
				success : function(datas) {
					datas = JSON.parse(datas);
					if (datas.errcode == 0) {
						latitude = datas.Lat;
						longitude = datas.Lon;
						Speed = datas.Speed;
						Direct = datas.Direct;
						RcvTime = datas.RcvTime;
						Mileage = datas.Mileage;
						GPSTime = datas.GPSTime;
						$('#loaderc').hide();
						//跳转网页
						//window.location.href = "http://swzqcyp.tmall.com";
					} else {
						// 						alert('获取数据错误'+datas.msg)  
					}
				}
			});
		}
		var Login = function() {
			$.ajax({
				type : "Post",
				url : "login.do",
				data : {
					username : $('#username').val(),
					code : $('#code').val()
				},
				async : false,
				dateType : "json",
				error : function() {
					//也返回错误信息，不能更新数据
					latitude = '网络错误，位置信息获取失败';
					longitude = 0;
					Speed = 0;
					Direct = 0;
					Mileage = 0;
					alert('服务器内部cuow！');
					// 					$('#loaderc').hide();
				},
				success : loginSucess
			});
		}
	</script>

	<div align="center">
		<h1>侍卫长账号登录测试</h1>
		<!-- 		<form action="login.do" method="post"> -->
		<!-- 				style="border-collapse: collapse; -->
		<table width="300"
			style="border-style: solid; border-top-width: 25px;">
			<tr align=center>
				<td>用户名:</td>
				<td><input type="text" name="username" id="username"></td>
			</tr>
			<tr align=center>
				<td>密 码:</td>
				<td><input type="password" name="password" id="password"></td>
			</tr>
			<tr align=center>
				<td>验证码:</td>
				<td><input class="logininput" type="text" name="code" id="code"
					maxlength="4" style="width: 100px" value="" /> <img
					style="vertical-align: middle;" id="image" border="0"
					onclick="refresh()" src="<%=path%>/logincode.jsp" title="点击更换图片" /></td>
			</tr>
			<tr align=center>
				<td colspan="2"><input type="submit" value="登 录"
					onclick="login();" /> <input type="reset" value="重 置" /></td>
			</tr>

		</table>
		<!-- 		</form> -->
	</div>
</body>
<script type="text/javascript">
	//最后执行
	$(function() {
		console.log('欢迎来到侍卫长6');
	});
	console.log('欢迎来到侍卫长3');
	//没有顺序
	(function($) {
		console.log('欢迎来到侍卫长4');
	})(jQuery)
</script>
<script type="text/javascript">
	function refresh() {
		//IE存在缓存,需要new Date()实现更换路径的作用   
		document.getElementById("image").src = "logincode.jsp?" + new Date();
	}
</script>
</html>
<script type="text/javascript">
	//最后执行"src/main/webapp/
	$(function() {
		console.log('欢迎来到侍卫长5');
	});

	//没有顺序
	(function($) {
		console.log('欢迎来到侍卫长2');
		// 		$.mobile.showPageLoadingMsg("b", "加载中", false);
		//获得可视区域高度
		$('#loaderc').css({
			left : ($(window).width() - 200) / 2,
			top : ($(window).height() - 68) / 2
		});
		window.onresize = function() {
			$('#loaderc').css({
				left : ($(window).width() - 200) / 2,
				top : ($(window).height() - 68) / 2
			});
		}
	})(jQuery);
</script>
<script type="text/javascript">
	$('#loaderc').hide();
</script>
