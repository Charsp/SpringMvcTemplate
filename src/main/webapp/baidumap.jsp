
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="content-type" content="no-cache, must-revalidate" />
<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57 GMT" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="initial-scale=1.0,maximum-scale=4.0,minimum-scale=1.0,user-scalable=no">
<title>侍卫长卫星应用安全公司</title>
<!-- <link href="AllCss/carLocation.css" rel="stylesheet" type="text/css" /> -->
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=1.5&ak=58hCpbP5s5Ghoi7dN7cTxd2j"></script>
</head>
<body>
	<div id="baidumap"></div>
</body>
<script type="text/javascript" src="jquery/jquery-1.11.1.min.js"></script>
<!-- <script type="text/javascript" src="jquery/dateTime.js"></script> -->
<script type="text/javascript">
	var longitude, latitude, GPSTime, Speed, Mileage, Direct, VehicleNum, VehicleId, RcvTime;
<%//得到车牌号码 和objectid
			//单辆车用户信息解析
			// 			JSONObject paramPersonal = (JSONObject) session
			// 					.getAttribute("paramPersonal");
			String vehiclenum = request.getParameter("carNum");
			String objectid = request.getParameter("objectid");
			if (vehiclenum != null && objectid != null) {
				out.write("VehicleNum='" + vehiclenum + "';");
				out.write("VehicleId=" + objectid + ";");
			} else {
				//	response.sendRedirect("error.jsp?errcode=errCarInfo");
				// 				return;
			}%>
			(function ($){   
			
			})(jQuery);
	// 强制初始化车辆位置
	var getserviceDatas = function() {
		var result = false;
		$.ajax({
			type : "Post",
			url : "carLocation.do",
			data : {
				effect : "carLocation",
				vehiclenum : VehicleNum,
				vehicleid : VehicleId
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
				alert('车辆数据错误！');
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
					result = true;
				} else {
// 					alert('错误：' + datas.errcode + '  消息：' + datas.msg);
				}
				// 				if (datas.errcode != "0") {
				// 					 	window.location.href = 'error.jsp?errcode=noCar';
				// 				}
			}
		});
		return result;
		//GPSTime = new Date().format("yyyy-MM-dd hh:mm:ss");
	}
	if(getserviceDatas()){
		//添加车辆信息
		alert('OK');
	}else{
		alert('wrong');
	}
	// 设置车辆位置
	var TimerCount = 0;
	var map = new BMap.Map("baidumap");
	var point = new BMap.Point(longitude, latitude);
	map.centerAndZoom(point, 15);
	var myGeo = new BMap.Geocoder();
	// 根据坐标得到地址描述
	var CurAddr;
	myGeo.getLocation(point, function(result) {
		if (result) {
			CurAddr = result.address; // 强制提示车辆状态信息
			var opts = {
				width : 80, // 信息窗口宽度
				height : 156, // 信息窗口高度
				title : VehicleNum
			// 信息窗口标题
			}
			var infoWindow = new BMap.InfoWindow("车速：" + Speed + " KM/H"
					+ "<br />定位时间" + GPSTime + "<br />接收时间" + RcvTime
					+ "<br/>行驶里程：" + Mileage + "(米)<br/>位置：" + CurAddr, opts); // 创建信息窗口对象
			map.openInfoWindow(infoWindow, point);
		}
	});
	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.MapTypeControl());

	// 编写自定义函数，创建标注
	var marker;
	function delMarker() {
		map.removeOverlay(marker);
		// markera.dispose();
	}
	function addMarker(point) { // 创建图标对象
		var myIcon = new BMap.Icon("Image/0.gif", new BMap.Size(27, 22), {
			anchor : new BMap.Size(13, 11),
		});

		// // 创建标注对象并添加到地图
		marker = new BMap.Marker(point, {
			icon : myIcon
		});
		map.addOverlay(marker);
	}
	addMarker(point);

	function ZoomControl() {
		// 设置默认停靠位置和偏移量
		this.defaultAnchor = BMAP_ANCHOR_TOP_LEFT;
		this.defaultOffset = new BMap.Size(15, 10);
	}
	// 通过JavaScript的prototype属性继承于BMap.Control
	ZoomControl.prototype = new BMap.Control();
	// 自定义控件必须实现initialize方法，并且将控件的DOM元素返回
	// 在本方法中创建个div元素作为控件的容器，并将其添加到地图容器中
	ZoomControl.prototype.initialize = function(map) {
		// 创建一个DOM元素
		var div = document.createElement("div");
		// 添加文字说明
		div.appendChild(document.createTextNode("回到中点"));
		// 设置样式
		div.style.cursor = "pointer";
		div.style.color = "white";
		div.style.border = "2px solid blue";
		div.style.backgroundColor = "black";
		// 绑定事件，点击一次放大两级
		div.onclick = function(e) {
			map.setCenter(point);
			// map.zoomTo(map.getZoom() + 2);
		}
		// 添加DOM元素到地图中
		map.getContainer().appendChild(div);
		// 将DOM元素返回
		return div;
	}
	var myZoomCtrl = new ZoomControl();
	map.addControl(myZoomCtrl);

	var int = self.setInterval("clock()", 5000);
	function clock() {
		var opts = {
			width : 80, // 信息窗口宽度
			height : 156, // 信息窗口高度
			title : VehicleNum
		// 信息窗口标题
		}
		TimerCount++;
		if (TimerCount > 7) {
			TimerCount = 0;
			// 获取位置数据
			getserviceDatas();

			point = new BMap.Point(longitude, latitude);
			map.setCenter(point);
		}

		var infoWindow = new BMap.InfoWindow("车速：" + Speed + " KM/H"
				+ "<br />定位时间" + GPSTime + "<br />接收时间" + RcvTime
				+ "<br/>行驶里程：" + Mileage + "(米)<br/>位置：" + CurAddr, opts); // 创建信息窗口对象
		map.openInfoWindow(infoWindow, point);
		delMarker();
		addMarker(point);
	}
</script>
</html>