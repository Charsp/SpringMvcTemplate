var showmessagebox, closeWindow,showloading,foolFunc;
//计算一下拐角函数，返回0-7八个角度
	//最先执行
	(function($) {
		//函数实现部分 
		closeWindow = function(errMsg) {
			showmessagebox(errMsg);
			setTimeout("WeixinJSBridge.call('closeWindow');", 1800);
		}
		showmessagebox = function(strInfo) {
			$.mobile.loading('show', {
				text : strInfo,
				textVisible : true,
				textonly : true,
				theme : 'b'
			});
			setTimeout("$.mobile.loading('hide');", 1900);
		}
		showloading = function(){
			$.mobile.loading('show', { 
				textVisible : false,
				theme : 'b'
			});
			setTimeout("$.mobile.loading('hide');", 1900);
			} 
			//数学函数-求车辆位置
		foolFunc = function(direct){  
			switch( Math.floor(direct / 22.5)){
				case 0:
				case 15: 
				return 0; 
				case 1:
				case 2:
				return 1; 
				case 3:
				case 4:
				return 2; 
				case 5:
				case 6:
				return 3; 
				case 7:
				case 8:
				return 4; 
				case 9:
				case 10:
				return 5; 
				case 11:
				case 12:
				return 6; 
				case 13: 
				case 14: 
				return 7; 
				}
			};	
		Date.prototype.Format = function(fmt) { //author: meizz 
			var o = {
				"M+" : this.getMonth() + 1, //月份 
				"d+" : this.getDate(), //日 
				"h+" : this.getHours(), //小时 
				"m+" : this.getMinutes(), //分 
				"s+" : this.getSeconds(), //秒 
				"q+" : Math.floor((this.getMonth() + 3) / 3), //季度 
				"S" : this.getMilliseconds()
			//毫秒 
			};
			if (/(y+)/.test(fmt))
				fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
						.substr(4 - RegExp.$1.length));
			for ( var k in o)
				if (new RegExp("(" + k + ")").test(fmt))
					fmt = fmt.replace(RegExp.$1,
							(RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
									.substr(("" + o[k]).length)));
			return fmt;
		} 
	})(jQuery);
	//最后执行
$(function(){
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
	};
	$('.seletDate').mobiscroll(opt); 
	}); 