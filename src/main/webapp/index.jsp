<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="initial-scale=1.0,maximum-scale=4.0,minimum-scale=1.0,user-scalable=no">
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=1.5&ak=58hCpbP5s5Ghoi7dN7cTxd2j"></script>
<!--<link rel="stylesheet" href="jquery/jquery-ui.min.css" />-->
<link rel="stylesheet" href="jquery/jquery.mobile-1.4.3.min.css" />
<script type="text/javascript" src="jquery/jquery-1.11.1.min.js"></script>
<!--<script type="text/javascript" src="jquery/jquery-ui.min.js"></script>-->
<script src="jquery/jquery.mobile-1.4.3.min.js"></script>
<link rel="stylesheet" href="jquery/mobiscroll.custom-2.5.0.min.css" />
<script src="jquery/mobiscroll.custom-2.5.0.min.js"></script>
<script src="jqueryFunc/baseMessage.js"></script>
<title>车辆轨迹回放</title>
</head>
<body>
	<div data-role="page" id="pageSeletDate">
		<div>
			<input name="startDate" id="startDate" class="seletDate"
				data-clear-btn="true" placeholder="选择日期">
		</div>
		<a id="query" data-role="button" href="#showLocation" data-mini="true"
			data-transition="slide">开始查询</a>
	</div>
	<!-- end pageSeletDate -->
	<div data-role="page" id="showLocation">
		<div data-fullscreen="true" data-role="header" data-position="fixed"
			style="opacity: 0.8" data-theme="b" style="position:absolute">
			<h1>粤JSP882</h1>
		</div>
		<div id="baidumap"></div>
		<div data-role="footer" data-fullscreen="true" data-position="fixed"
			style="opacity: 0.8" data-theme="b">
			<div style="opacity: 1.0">
				<div align="center">
					<span style="float: left">00:00</span><a id="prevDay"
						style="float: left">快退</a> <a id="currDate">2014-11-22
						12:00:00</a> <span style="float: right">23:59</span> <a id="nextDay"
						style="float: right">快进</a>
				</div>
				<input id="slider-s" data-theme="a" data-role="none" max="86400"
					data-highlight="true" value="43200" min="0" />
			</div>
		</div>
	</div>
	</div>
	<!-- end showLocation -->
</body>
<script type="text/javascript">
	//点击滚动条
	var selectSroll;
	var time = new Date();
	var speed = 0;
	$(function() {
		//显示地图位置
		$("#prevDay").click(function() {
			speed--;
			if (speed < -16)
				speed = -16;
			showmessagebox("快退 << ×" + speed);
		});
		$("#nextDay").click(function() {
			speed++;
			if (speed > 16)
				speed = 16;
			showmessagebox("快进 >> ×" + speed);
		});
		$("#currDate").click(function() {
			showmessagebox("播放暂停中...");
		});
		$('#query').click(function() {
			showloading();
		});
		$("#change").click(function() {
			$('#slider-s').val(25);
			$('#slider-s').change();
			changesSliderValue();
		});
		var changesSliderValue = function() {
			console.log($('#slider-s').val());
			var temp = new Date(time);
			temp.setSeconds(temp.getSeconds() + $('#slider-s').val());
			$('#currDate').html(temp.Format("yyyy-MM-dd hh:mm:ss"));
			console.log(temp.getSeconds());
		}
		$("#slider-s").slider({
			create : function(event, ui) {
				$('.ui-slider-track').css("margin", 0);
				$("#slider-s").css("display", "none");
			},
			stop : changesSliderValue
		});
		changesSliderValue();
	});
</script>
<script>
	$(function() {
		var Vehiclenum, Vehicleid;
		Vehicleid = 100024;
		Vehiclenum = '粤JSP882';
		$('#baidumap').css('height', $('body').height() + "px");
		// 创建地图转换数组 
		var map = new BMap.Map("baidumap");
		var point = new BMap.Point(116.433304, 39.8444445);
		//	map.centerAndZoom(point, 15);
		map.addControl(new BMap.NavigationControl());
		map.addControl(new BMap.NavigationControl());
		map.addControl(new BMap.MapTypeControl());
		var myGeo = new BMap.Geocoder();
		// 根据坐标得到地址描述
		// JsonData.length 长度
		//	var GPSTime = new Array();
		//	var Direct = new Array();
		//	var Mileage = new Array();
		//	var Speed = new Array();
		var directVal = foolFunc(232);

		var Baidutips = function(result) {
			if (result) {
				CurAddr = result.address;
				getAttr();
			}
		};
		myGeo.getLocation(point, Baidutips);
		//	// 百度地图API功能
		var point2 = point; // 终点
		var myIcon = new BMap.Icon("Image/" + directVal + ".gif",
				new BMap.Size(27, 22), { // 小车图片
					anchor : new BMap.Size(13, 11),
				}); // 改变车辆标注位置和图片
		var carMk = new BMap.Marker(point, {
			icon : myIcon
		});
		map.addOverlay(carMk);// 增加车辆  
		var getAttr = function() {
			var p = carMk.getPosition(); // 获取marker的位置 
			var infoWindow = new BMap.InfoWindow("车速：KM(公里)<br/>位置：" + CurAddr,
					{
						enableMessage : false
					}); // 创建信息窗口对象
			//	infoWindow.setContent("");
			map.openInfoWindow(infoWindow, p);
		}
		carMk.addEventListener("click", function() {
			getAttr();
		});
		map.centerAndZoom(point, 15);

	});
</script>
</html>