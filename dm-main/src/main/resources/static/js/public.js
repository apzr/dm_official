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
			$(".item-top").show();
		} else {
			$(".item-top").hide();
		}
	});
	$(".item-top").on("click", function() {
		$("body, html").animate({
			scrollTop : 0
		}, 500);
	});
});
