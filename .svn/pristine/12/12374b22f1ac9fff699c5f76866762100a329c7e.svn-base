<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("mystring", "dd");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="body.css">
<link rel="stylesheet" href="../jquery/jquery.mobile-1.3.2.min.css" />
<!-- Jquery JS mini -->
<script type="text/javascript" src="../jquery/jquery-1.11.1.min.js"></script>
<!-- Baidu Map AK -->
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=1.5&ak=58hCpbP5s5Ghoi7dN7cTxd2j"></script>
<script src="../jquery/jquery.mobile-1.3.2.min.js"></script>
<link href="../jquery/mobiscroll.custom-2.5.0.min.css" rel="stylesheet"
	type="text/css">
<script src="../jquery/mobiscroll.custom-2.5.0.min.js"></script>
<script type="text/javascript"
	src="http://developer.baidu.com/map/jsdemo/demo/convertor.js"></script>
<title>百度地图测试代码</title>
<style type="text/css">
.subDiv {
	width: 20px;
	height: 20px;
	float: left;
}
</style>
<body>
	<!-- 和（代码中）位置无关的div显示,可以不再body中显示 -->
	<div align="center"
		style="background-color: red; width: 60px; position: fixed; top: 10px; right: 20px;">
		top:0，right:0
		<div align="center"
			style="background-color: black; color: white; overflow: hidden; width: 50px;">
			<p>absolute,fixed跳出父层div</p>
			<div class="subDiv" style="background-color: blue;">A</div>
			<div class="subDiv" style="background-color: gray;">B</div>
		</div>
	</div>
	<!-- 	<div align="center" style="position: relative;"> -->
	<!-- 		<div class="subDiv">align="left"</div> -->
	<!-- 		<div class="subDiv">align="left"</div> -->
	<!-- 	</div> -->
	<div align="center">
		<h1>百度地图、坐标转换测试页面</h1>

		<!-- 百度地图层 -->
		<div id="baidumap" style="height: 250px; z-index: -1;"></div>
		<div>
			<br>
			<!-- 测试百度功能区域 -->
			<hr>
			<p>
				<strong>百度功能测试</strong>
			</p>
			<hr>
			<table>
				<thead align="center">
					<tr bgcolor="green">
						<th>测试功能</th>
						<th colspan="2">附加条件</th>
						<th>测试结果</th>
					</tr>
					<tr>
						<td>百度GPS地址转换百度地址代码</td>
						<td colspan="2">程序模块</td>
						<td><input id="btn_Gps" type="button" value="测试"></td>
					</tr>
					<tr>
						<td>历史轨迹播放</td>
						<td><input name="start" id="startTime" data-role="datebox"
							class="scrollertime" type="text" title="start时间"></td>
						<td><input name="end" id="endTime" data-role="datebox"
							class="scrollertime" type="text" title="end时间"></td>
						<td><input id="btn_play" type="button" value="测试"></td>
					</tr>
					<tr>
						<td>当前位置动态显示</td>
						<td colspan="2">程序模块</td>
						<td><input id="btn_Location" type="button" value="测试"></td>
					</tr>
				</thead>
			</table>
			<!-- 测试车辆基本信息 -->
			<hr>
			<p>
				<strong>基本参数</strong>
			</p>
			<hr>
			<table>
				<thead align="center">
					<tr bgcolor="green">
						<th>测试内容</th>
						<th colspan="2">测试参数</th>
						<th>结果返回</th>
					</tr>
					<tr>
						<td rowspan="3">车辆基本信息</td>
						<td><label for="carno">车牌号码:</label></td>
						<td><input name="carno" type="text" title="车牌号码"></td>
						<td><input type="button" value="提交数据" id="subdata"></td>
					</tr>
					<tr>
						<td><label for="speed">车辆速度:</label></td>
						<td><input name="speed" type="text" title="车辆速度"></td>
						<td><input type="button" value="提交数据" id="subtran"></td>
					</tr>
					<tr>
						<td><label for="gpsTime">Gps时间:</label></td>
						<td><input name="gpsTime" data-role="datebox"
							class="scroller" type="text" title="Gps时间"></td>
						<td><input type="button" value="提交数据" id="submit"></td>
					</tr>
					<tr>
						<td>Gps物理地址地图显示</td>
						<td><input id="carX" type="text" title="车辆X/Lat(经度)"></td>
						<td><input id="carY" type="text" title="车辆Y/Lon(维度)"></td>
						<td><input type="button" value="提交数据" id="submit"></td>
					</tr>
					<tr>
						<td>我的位置地图显示</td>
						<td><input id="myX" type="text" title="手机X/Lat(经度)"></td>
						<td><input id="myY" type="text" title="手机Y/Lon(维度)"></td>
						<td><input type="button" value="提交数据" id="submit"></td>
					</tr>
				</thead>
			</table>

		</div>
	</div>
</body>
<script type="text/javascript">
	//全局变量
	var pagesize = 3;

	$(function() {

		//内部私有变量
		var sleepVal = 1000;
		var currpage = 0;
		var longitude = 110.84845994471;
		var latitude = 21.645773973117;
		var VehicleNum = '粤JSp882';
		var VehicleId = 123213;
		var point; //全局车辆当前点位置
		var playing = false; //位置播放中
		var currdatas;//当前数据量 
		var marker; //图标对象(车辆图标)
		var startTime;
		var endTime;

		//定义map全局对象
		var map = new BMap.Map("baidumap");
		var point = new BMap.Point(longitude, latitude);

		// 编写自定义函数，创建标注
		function delMarker() {
			map.removeOverlay(marker);
			// markera.dispose();
		}
		function addMarker(point) { // 创建图标对象
			var myIcon = new BMap.Icon("../Image/0.gif", new BMap.Size(27, 22),
					{
						anchor : new BMap.Size(13, 11),
					});

			// // 创建标注对象并添加到地图
			marker = new BMap.Marker(point, {
				icon : myIcon
			});
			map.addOverlay(marker);
		}

		var initMap = function() {

			map.centerAndZoom(point, 15);
			var myGeo = new BMap.Geocoder();
			// 根据坐标得到地址描述
			var CurAddr;
			myGeo.getLocation(point, function(result) {
				if (result) {
					CurAddr = result.address; // 强制提示车辆状态信息
					var opts = {
						width : 60, // 信息窗口宽度
						height : 120, // 信息窗口高度
						title : VehicleNum
					// 信息窗口标题
					}
					var infoWindow = new BMap.InfoWindow("车速：" + 123 + " KM/H"
							+ "<br />车辆状态：良好" + "<br />GPS信号： 优" + "<br />"
							+ "时间：" + 11 + "<br/>位置：" + CurAddr, opts); // 创建信息窗口对象
					map.openInfoWindow(infoWindow, point);
				}
			});
			map.addControl(new BMap.NavigationControl());
			map.addControl(new BMap.NavigationControl());
			map.addControl(new BMap.MapTypeControl());

			addMarker(point);
		}
		//按位置移动
		i = 0;
		function resetMkPoint(i) {
			//可以在这里地图(GPS <----->百度地图)
			var newPoint = new BMap.Point(currdatas[i].Lon, currdatas[i].Lat);
			marker.setPosition(newPoint);

			// 增加折线
			map.centerAndZoom(newPoint, 12);
			var polyline = new BMap.Polyline([ point, newPoint ], {
				strokeColor : "red",
				strokeWeight : 3,
				strokeOpacity : 0.8
			}); // 创建折线
			point = newPoint;
			map.addOverlay(polyline); // 增加折线

			if (i < currdatas.length - 1) {
				setTimeout(function() {
					i++;
					resetMkPoint(i);
				}, sleepVal);
			} else {
				//继续GET数据并执行轨迹回放
				if (currpage < pagesize) {
					console.log('进入第' + currpage + '页');
					getServer(VehicleId, $('#startTime').val(), $('#endTime')
							.val());

				} else {
					currpage = 0;
					pagesize = 0;
					playing = false;
					showmessagebox('播放完毕！');
				}
			}
		}
		//改变车辆位置函数
		//创建100个point变量(数组)
		var rollPlayer = function() {
			//播放现有数据
			//从0开始，到最后一页数据,每页100个数据(使用each)
			for (i = 0; i < pagesize; i++) {
				//获取页面数据 

				//异步播放数据
				for (j = 0; j < currdatas.length; j++) {
					//延时函数
					playing = true;
					//输出，并改变车辆位置
					var newPoint = new BMap.Point(currdatas[j].Lon,
							currdatas[j].Lat);
					//让图标移动到此位置 
				}
			}
			//从新获取数据到现有数据中
			//判断播放完
		}

		//初始化地图网页
		initMap();
		//点击之后开始播放程序代码  
		//请求数据
		var getServer = function(carid, start, end) {
			$.ajax({
				type : "get",
				url : "../Confirm",
				data : {
					effect : 'carLocation',
					type : 'array',
					currpage : 1,
					carid : carid,
					start : start,
					end : end
				},
				async : false,
				dateType : "json",
				error : function() {
					showmessagebox('网络错误，无数据返回！');
					playing = false;
				},
				success : function(redata) {

					//格式化数据结构
					redata = JSON.parse(redata);
					//获得数据 100个
					//增加一页数据currpage
					currpage++;
					currdatas = redata.gps;
					//播放轨迹位置
					setTimeout(function() {
						resetMkPoint(0);
					}, sleepVal);
				}
			});
		}
		showmessagebox('正在加载中...');
		//绑定事件
		$('#btn_play').click(
				function() {
					//获取总页数()
					if (playing) {
						showmessagebox('轨迹正在播放，请稍等...');
						return;
					}
					playing = true;
					//重新初始化地图网页
					//initMap();
					//开始播放历史轨迹
					try {
						getServer(VehicleId, $('#startTime').val(), $(
								'#endTime').val());
					} catch (e) {
						playing = false;
					}

				});
		//点击实现地址翻译
		//坐标转换完之后的回调函数
		translateCallback = function(point) {
			var marker = new BMap.Marker(point);
			map.addOverlay(marker);
			var label = new BMap.Label("我是百度标注哦", {
				offset : new BMap.Size(20, -10)
			});
			marker.setLabel(label); //添加百度label
			map.setCenter(point);
			showmessagebox('转换后:' + point.lng + "," + point.lat);
		}

		$('#btn_Gps').click(function() {
			//获取地址longitude, latitude 
			BMap.Convertor.translate(point, 0, translateCallback);
		})
		function showmessagebox(strInfo) {
			$.mobile.showPageLoadingMsg("a", strInfo, true);
			setTimeout("$.mobile.hidePageLoadingMsg();", 1900);
		}
	});

	//第三者访问 
	(function($) {
		var opt = {
			preset : 'date', // 日期
			theme : 'sense-ui', // 皮肤样式
			display : 'modal', // 显示方式
			mode : 'scroller', // 日期选择模式
			// dateFormat : 'yy-mm-dd DD ', // 日期格式
			dateFormat : 'yy-mm-dd ', // 日期格式
			setText : '确定', // 确认按钮名称
			cancelText : '取消',// 取消按钮名籍我
			dateOrder : 'yymmdd', // 面板中日期排列格式
			// dayNames:['日曜日', '月曜日', '火曜日', '水曜日', '木曜日', '金曜日', '土曜日'],
			// dayNames : [ '星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六' ],
			hourText : '时',
			dayText : '日',
			monthText : '月',
			yearText : '年', // 面板中年月日文字
			endYear : 3000
		// 结束年份
		}, opttime = {
			preset : 'time', // 日期
			theme : 'sense-ui', // 皮肤样式
			display : 'modal', // 显示方式
			mode : 'scroller', // 日期选择模式
			setText : '确定', // 确认按钮名称
			cancelText : '取消',// 取消按钮名籍我
			timeFormat : 'HH:ii:ss',
			timeWheels : 'HH:ii:ss',
			secText : '秒',
			minuteText : '分',
			hourText : '时',
		// 结束年份
		};
		$('.scroller').mobiscroll(opt);
		$('.scrollertime').mobiscroll(opttime);
		/////////		注意			//////////
		////////此处除下面几种情况外，都属于私有成员变量，不可外部访问
		/////////其实可以绑定事件在此处//////////
		// 		$('#subdata').click(function(){
		// 			alert('');
		// 		});
		// 		//第一种 $('slectort').func
		// 		$.fn.MyJquery = function() {
		// 			alert('我是谁？');
		// 		};
		// 		//第二种
		// 	
		// 	jQuery.extend({
		// 			// 设置 apDiv
		// 			MyJquery : function() {
		// 				alert('我是谁？');
		// 			}
		// 		});
		//第三种
		// 		$.MyJquery = function() {
		// 			alert('我是谁？');
		// 		}
	})(jQuery);
</script>
</html>