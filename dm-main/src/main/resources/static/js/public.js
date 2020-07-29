// JavaScript Document

$(function() {

	$(".tuisong-box .btn-close").on("click", function() {
		$(this).parents(".tuisong-box").hide();
	});

	$(".switch-box").on("click", function() {
		$("body").toggleClass("switch-open");
	});

	// 手机导航
	$(document).on("click", ".menu-bon,.ph-mask", function() {
		$("body").toggleClass("menu-open");

		if ($("body").hasClass("menu-open")) {
			$(".body-box").height($(window).height())
		} else {
			$(".body-box").height("auto")
		}
	});

	// 手机导航展开
	$(".other-header .nav li .h").click(function() {
		$(this).parent().toggleClass("open").siblings().removeClass("open");
	});

	getSize();

});

/**
 * 初始字号
 * 
 * @returns
 */
function getSize() {
	var deviceWidth = "", d = document.documentElement;
	window.onresize = setFont;
	setFont();
	function setFont() {
		if (window.innerWidth <= 750) {
			deviceWidth = Math.min(750, window.innerWidth, d.clientWidth);
			d.style.fontSize = (deviceWidth / 750 * 100) + "px";
		} else if (window.innerWidth > 750 && window.innerWidth <= 1010) {
			d.style.fontSize = "100px";
		} else {
			d.style.fontSize = "62.5%";
		}

	}
	;
}

$(function() {
	var isSupportTouch = !!('ontouchend' in document)
			|| navigator.userAgent.indexOf('Windows Phone') > 0;
	//
	$(document).on(
			"click",
			".tab-box .tab-a",
			function(e) {
				e.preventDefault();
				$(this).addClass("on").siblings().removeClass("on");
				var ii = $(this).index();
				$(this).parents(".tab-box").find(".tab-b").eq(ii).show()
						.siblings().not('.order-item-title').hide();
			})
	//
	$(".tab-box").each(function(i) {
		$(this).find(".tab-a:eq(0)").click();
		if ($(window).width() <= 1024 & isSupportTouch) {
			$(this).find(".tab-a a").attr({
				"href" : "javascript:;"
			})
		}
	});
});

/**
 * 返回顶部
 * 
 * @returns
 */
$(function() {
	$(window).scroll(function() {
		var scroll_top = $(window).scrollTop();
		if (scroll_top > 500) {
			$(".tools-top").fadeIn(100);
		} else {
			$(".tools-top").fadeOut(100);
		}
	});
	$(".tools-top").on("click", function() {
		$("body, html").animate({
			scrollTop : 0
		}, 500);
	});
});

/**
 * 留言咨询
 * 
 * @returns
 */
$(function() {
	//显示弹框
	$('.item-msg').click(function() {
		showType = $(this).attr('show-type');
		$('#dialogBg').fadeIn(200);
		$('#dialog').attr('show-type', showType);
		$('#dialog').removeAttr('class').addClass('animated '+showType+'').fadeIn();
	});
	
	//关闭弹窗
	$('.closeDialogButton').click(function(){
		$('#dialogBg').fadeOut(100,function(){
			$('#dialog').addClass(	$('#dialog').attr('show-type')	).fadeOut(100);
		});
	});
	
	//提交留言
	$('.submitFormButton').click(function(){
		
		$.ajax({
			
			dataType 	: "json",
			contentType :　"application/json",
			type 	: 	"POST",
			url 	: 	"../../counsel",
			data	:	JSON.stringify({ 
							name	: $('#msgForm #name').val(),
							tel		: $('#msgForm #tel').val(),
							mail	: $('#msgForm #mail').val(),
							detail	: $('#msgForm #detail').val()
						}),
			
			success : function(data) {
				console.log(data);
			}
		
		});
		
		$('#dialogBg').fadeOut(100,function(){
			$('#dialog').addClass(	$('#dialog').attr('show-type')	).fadeOut(100);
		});
		
	});
	
});

/**
 * 百度地图
 * 
 * @returns
 */
$(function(){
	
	var map = new BMap.Map("baiduMap"); // 创建Map实例
	var point = new BMap.Point(113.930914,35.302669);
	map.centerAndZoom(point, 14);

	map.setCurrentCity("河南"); // 设置地图显示的城市 此项是必须设置的
	map.enableScrollWheelZoom(true); // 开启鼠标滚轮缩放

	var marker = new BMap.Marker(point); // 创建标注
	map.addOverlay(marker); // 将标注添加到地图中

	var sContent = "<p style='font-size: 10px;'>河南省 新乡市 红旗区 <br/>金穗大道新二街靖业公元国际1607</p>";
	var opts = {
		width : 280, // 信息窗口宽度
		height : 55, // 信息窗口高度
		title : "<FONT color='#3CC2FF'>河南钉铆知识产权代理有限公司</FONT>", // 信息窗口标题
		enableMessage : false,// 设置允许信息窗发送短息
		message : ""
	}
	var infoWindow = new BMap.InfoWindow(sContent, opts); // 创建信息窗口对象
	map.openInfoWindow(infoWindow, point); // 开启信息窗口

	marker.addEventListener("click", function() {
		map.openInfoWindow(infoWindow, point); // 开启信息窗口
	});
	
})
