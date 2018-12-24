$(function () {

    //首页banner
    $(".ind-baner").each(function (e) {
        $(this).addClass("swiper2" + e);
        var $th = $(this);
        var mySwiper4 = new Swiper('.swiper2' + e + ' .swiper-container', {
            calculateHeight: true,
            paginationClickable: true,
            loop: true,
            slidesPerView: 1,
            autoplay: 5000,
            speed: 800,
            pagination: '.ind-ban-page',
            onSlideChangeStart: function (swiper, index) {

            }
        });
    });

    //集团荣誉切换
    $(".honor-list-tab").each(function (e) {
        $(this).addClass("swiper2" + e);
        var $th = $(this);

        var nm3 = 9;
        if ($(window).width() < 1100) {
            nm3 = 6;
        }
        if ($(window).width() <= 750) {
            nm3 = 3;
        }
        var itemlength = $(this).find(".swiper-slide").length
        var mySwiper4 = new Swiper('.swiper2' + e + ' .swiper-container', {
            calculateHeight: true,
            paginationClickable: true,
            loop: false,
            slidesPerView: nm3,
            onSlideChangeStart: function (swiper, index) {
                //$th.find(".s1").text(mySwiper4.activeIndex + 1)
                //$th.find(".s2").text(itemlength);
                $('.swiper2' + e + ' .arrow-left').removeClass("over");
                $('.swiper2' + e + ' .arrow-right').removeClass("over");
                if (mySwiper4.activeIndex == 0) {
                    $('.swiper2' + e + ' .arrow-left').addClass("over")
                }
                if (mySwiper4.activeIndex == (itemlength - nm3)) {
                    $('.swiper2' + e + ' .arrow-right').addClass("over")
                }
            }
        });
        $('.swiper2' + e + ' .arrow-left').on('click', function (e) {
            e.preventDefault()
            mySwiper4.swipePrev()
        })
        $('.swiper2' + e + ' .arrow-right').on('click', function (e) {
            e.preventDefault()
            mySwiper4.swipeNext()
        });
        $(".honor-list-tab .swiper-slide a").on("click", function () {
            $(this).addClass("on").parent().siblings().find("a").removeClass("on");
        });
    })


    //切换
    $(".tooth-3").each(function (e) {
        $(this).addClass("swiper2" + e);
        var $th = $(this);

        var nm3 = 5;
        if ($(window).width() < 1100) {
            nm3 = 3;
        }
        if ($(window).width() <= 750) {
            nm3 = 2;
        }
        var itemlength = $(this).find(".swiper-slide").length
        var mySwiper4 = new Swiper('.swiper2' + e + ' .swiper-container', {
            calculateHeight: true,
            paginationClickable: true,
            loop: false,
            slidesPerView: nm3,
            onSlideChangeStart: function (swiper, index) {
                //$th.find(".s1").text(mySwiper4.activeIndex + 1)
                //$th.find(".s2").text(itemlength);
                $('.swiper2' + e + ' .arrow-left').removeClass("over");
                $('.swiper2' + e + ' .arrow-right').removeClass("over");
                if (mySwiper4.activeIndex == 0) {
                    $('.swiper2' + e + ' .arrow-left').addClass("over")
                }
                if (mySwiper4.activeIndex == (itemlength - nm3)) {
                    $('.swiper2' + e + ' .arrow-right').addClass("over")
                }
            }
        });
        $('.swiper2' + e + ' .arrow-left').on('click', function (e) {
            e.preventDefault()
            mySwiper4.swipePrev()
        })
        $('.swiper2' + e + ' .arrow-right').on('click', function (e) {
            e.preventDefault()
            mySwiper4.swipeNext()
        })

    })



    //发展历程
    $(".brand-list").each(function (e) {
        $(this).addClass("swiper3" + e);
        var $th = $(this);

        var nm3 = 8;
        if ($(window).width() < 1100) {
            nm3 = 6;
        }
        if ($(window).width() <= 750) {
            nm3 = 5;
        }
        var nIndex = 0;
        var itemlength = $(this).find(".swiper-slide").length
        var mySwiper4 = new Swiper('.swiper3' + e + ' .swiper-container', {
            calculateHeight: true,
            paginationClickable: true,
            loop: false,
            slidesPerView: nm3,
            onSlideChangeStart: function (swiper, index) {
                //$th.find(".s1").text(mySwiper4.activeIndex + 1)
                //$th.find(".s2").text(itemlength);

            }
        });
        $('.swiper3' + e + ' .back').on('click', function (eee) {
            nIndex--;
            nIndex < 0 ? nIndex = 0 : 0;
            $('.licheng-box .content-box ul li').eq(nIndex).click();
            $('.swiper3' + e + ' .next').removeClass("over");
            if (nIndex == 0)
            {
                $('.swiper3' + e + ' .back').addClass("over")
            }
            eee.preventDefault()
            mySwiper4.swipePrev()
        })
        $('.swiper3' + e + ' .next').on('click', function (eee) {
            nIndex++;
            nIndex > itemlength - 1 ? nIndex = itemlength - 1 : 0;
            if (nIndex == itemlength - 1) {
                $('.swiper3' + e + ' .next').addClass("over")
            }
            $('.swiper3' + e + ' .back').removeClass("over");
            $('.licheng-box .content-box ul li').eq(nIndex).click();
            eee.preventDefault()
            mySwiper4.swipeNext()
        })
        


        $('.licheng-box .content-box ul li').on('click', function (eee) {
            nIndex = $(this).index();
            $('.swiper3' + e + ' .back').removeClass("over");
            $('.swiper3' + e + ' .next').removeClass("over");
            if (nIndex == 0) {
                $('.swiper3' + e + ' .back').addClass("over")
            }
            if (nIndex == itemlength - 1) {
                $('.swiper3' + e + ' .next').addClass("over")
            }
            $(".licheng-content .item").eq(nIndex).show().siblings().hide();

            $(this).addClass("on").siblings().removeClass("on");
        })

        

    })


  
    
    $(window).resize(function () {
        if ($(".tooth-2").is(":visible")) {
            $(".tooth-2  .item .w").height("auto")
            var h = 10;
            var t1 = $(".tooth-2 .left .item1 .w").outerHeight(),
                t2 = $(".tooth-2 .left .item2 .w").outerHeight(),
                t3 = $(".tooth-2 .left .item3 .w").outerHeight(),
                t4 = $(".tooth-2 .left .item4 .w").outerHeight() ,
                t5 = $(".tooth-2 .right .item1 .w").outerHeight(),
                t6 = $(".tooth-2 .right .item2 .w").outerHeight(),
                t7 = $(".tooth-2 .right .item3 .w").outerHeight(),
                t8 = $(".tooth-2 .right .item4 .w").outerHeight(),
            j1 = $(".tooth-2 .left .item1 .w"),
            j2 = $(".tooth-2 .left .item2 .w"),
            j3 = $(".tooth-2 .left .item3 .w"),
            j4 = $(".tooth-2 .left .item4 .w"),
            j5 = $(".tooth-2 .right .item1 .w"),
            j6 = $(".tooth-2 .right .item2 .w"),
            j7 = $(".tooth-2 .right .item3 .w"),
            j8 = $(".tooth-2 .right .item4 .w"),
            winw = $(window).width();


            if (winw>767)
            { 
                if (t1 < t2 + t3) {
                    j1.outerHeight(t2 + t3 + h)
                } else {
                    j3.outerHeight(t1 - t2 - h)
                }

                console.log(t6)
                console.log(t7 + t8)
                if (t6 < t7 + t8) {
                    j6.outerHeight(t7 + t8 + h)
                } else {
                    j8.outerHeight(t6 - t7 - h)
                }
                if (winw > 1100) {
                    var f_l = $(".tooth-2 .left").outerHeight();
                    var f_r = $(".tooth-2 .right").outerHeight();

                    if (f_l < f_r) {
                        j4.outerHeight(t4 + (f_l - f_r) )
                    } else {
                        j5.outerHeight(t5 + (f_l - f_r) )
                    }
                }
            }
        }
    })
    $(window).resize();


})