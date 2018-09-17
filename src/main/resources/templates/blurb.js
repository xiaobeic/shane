/*登陆注册弹出框*/
$(function() {
	$("#my-login").click(function() {
		$('#login_a1').click();
	});
	$("#my-register").click(function() {
		$('#login_a2').click();
	});
})

/*
 * 右下角回到顶部
 */
$(function() {
	var speed = 800;
	var h = document.body.clientHeight;
	$("#toTop").click(function() {
		$('html,body').animate({
			scrollTop : '0px'
		}, speed);
	});
});

function getTop() {
	if ($(document).scrollTop() > 600) {
		$("#getTop").css({
			'display' : 'block',
		});
	} else {
		$("#getTop").css('display', 'none');
	}
	setTimeout(getTop);
}


/* 商品点赞 */
$(function() {
	$(".oneblurb_click_a").click(function() {
		/*操作之前判断用户是否登入*/
		if($(".sessionText").attr('id')=="null"){
			window.location.href="../view/login.jsp";
		}
		var click=$(this);
		var url = $(this).attr("href");
		var args = {};
		$.get(url, args, function(data) {
			//请求成功，改变对应的节点的样式
			if(data=="clickSucc"){
				$(click).children('i').css("color","#337AB7");
				if($(click).hasClass('click_up')){
					$(click).parent().next().remove();
				}else{
					$(click).parent().prev().remove();
				}
			}
		});
		return false;
	});
});


/* 收藏商店 */
$(function() {
	$(".collShop").click(function() {
		/*操作之前判断用户是否登入*/
		if($(".sessionText").attr('id')=="null"){
			window.location.href="../view/login.jsp";
		}
		var coll=$(this);
		var shopsId=$(this).prev().attr('id');
		var url = $(this).attr("href");
		var args = {};
		$.get(url, args, function(data) {
			//请求成功，改变对应的节点的样式
			if(data=="deleteCollSucc"){
				$(coll).attr("href","../shopsCollection/shopsCollAdd.do?shopId="+shopsId);
				$(coll).html("收藏店铺");
			}
			if(data!="0"&&data!="deleteCollSucc"){
				$(coll).attr("href","../shopsCollection/shopsCollDelete.do?shopsCollId="+data);
				$(coll).html("取消收藏");
			}
		});
		return false;
	});
});






/* 点击留言获取准备信息 */
$(function() {
	$(".respone_Blua").click(function(){
		/*操作之前判断用户是否登入*/
		if($(".sessionText").attr('id')=="null"){
			window.location.href="../view/login.jsp";
		}
		//获取对方用户id
		var userId=$(this).attr('id');
		//插入到提交表单中
		$("#resUserid").val(userId);
		$.ajax({
			type : 'post',
			url : '../shopsMessage/selectByIdshopsMess.do',
			data : 'userid=' + userId,
			dataType : "json",
			success : function(data) {
				if(data.length!=0){
					//留言记录不为空，动态添加信息
					$("#respone_mess").empty();
					$.each(data,function(i, n) {
						var mytime = new Date(data[i].publishtime);
						var textTime = mytime.getFullYear()+"-"+(mytime.getMonth()+1)+"-"+mytime.getDate()+" "+mytime.getHours()+":"+mytime.getMinutes()+":"+mytime.getSeconds();
						$("#respone_mess").append(
							"<div style='margin-bottom: 45px;'>"
							+"<img src='/path/"+data[i].headimg+"' width='35' height='35' style='float: left;'/>"
							+"<span  style='float: left;margin-left:10px;color:#aaa'>"+textTime+"</span>"
							+"<span style='float: left;width: 580px;margin:0px 10px'>"+data[i].message+"</span>"
							+"</div>"	
						);
					});
				}
			},
		});
	});
});



//留言发表
$(function() {
	//把发表的文章上传到数据库
	$('#texta').click(function() {
		/*操作之前判断用户是否登入*/
		if($(".sessionText").attr('id')=="null"){
			window.location.href="../view/login.jsp";
		}
		var editMess = $("#textMess").val();
		var Headimg=$(".userHeadimg").attr('id');
		$.ajax({
			type : 'post',
			url : '../shopsMessage/shopsMessInsert.do',
			data:$('#resFrom').serialize(),
			success : function(data) {
				if(data=="insertSucc"){
					//插入成功，动态添加信息
					var mytime = new Date();
					var textTime = mytime.getFullYear()+"-"+(mytime.getMonth()+1)+"-"+mytime.getDate()+" "+mytime.getHours()+":"+mytime.getMinutes()+":"+mytime.getSeconds();
					$("#respone_mess").append(
						"<div style='margin-bottom: 45px;'>"
						+"<img src='/path/"+Headimg+"' width='35' height='35' style='float: left;'/>"
						+"<span  style='float: left;margin-left:10px;color:#aaa'>"+textTime+"</span>"
						+"<span style='float: left;width: 580px;margin:0px 10px'>"+editMess+"</span>" 
						+"</div>"
					);
					//将滚动条滚动至最低端
					$('#respone_mess').scrollTop( $('#respone_mess')[0].scrollHeight );
					//插入成功，清楚编辑框的信息和提示信息
					$("#textMess").val('');
					$("#resMessSpan").html('');
					//插入信息后，屏蔽‘还没有留言’
					$("#respone_none").css('display','none');
				}
				else if(data=="insertOverlen"){
					$("#resMessSpan").html('长度不能超过50');
				}
				else if(data=="insertEmpty"){
					$("#resMessSpan").html('留言不能为空');
				}
			},
		});
		return false;
	});
});

/* 物品评论点赞 */
//物品评论提交
$(function(){
	var goodsMeClick = function() {
		/*操作之前判断用户是否登入*/
		if($(".sessionText").attr('id')=="null"){
			window.location.href="../view/login.jsp";
		}
		var thisSpan=$(this);
		var gdMesClick=$(this).children('span');
		var url = $(this).parent().attr("href");
		var args = {};
		$.get(url, args, function(data) {
			//请求成功，改变对应的节点的样式
			if(data=="gdMesClickSucc"){
				$(gdMesClick).html(Number($(gdMesClick).html())+1);
				$(thisSpan).attr('title','已赞');
			}
		});
		return false;
	};
	$(".goodMeClick").each(function() {
		$(this).bind('click', goodsMeClick);
	});
	$('#goodMess_a').click(function(){
		$.ajax({
			type:'post',
			url:'../goodsMessage/goodsMesInsert.do',
			data:$('#goodMessFrom').serialize(),
			success:function(data){
				if(data=="insertEmpty"){
					$("#goodMessSpan").html('评论不能为空');
				}
				else if(data=="insertOverlen"){
					$("#goodMessSpan").html('长度不能超过100');
				}
				else{
					//获得插入的数据
					var headimg=$(".userHeadimg").attr("id");
					var username=$(".user_name").attr("id");
					var textMess=$("#textgoodMess").val();
					var mytime = new Date();
					var textTime = mytime.getFullYear()+"-"+(mytime.getMonth()+1)+"-"+mytime.getDate()+" "+mytime.getHours()+":"+mytime.getMinutes()+":"+mytime.getSeconds();
					//清空编辑器
					$("#textgoodMess").val('');
					$("#goodMessSpan").html('');
					$("#goodsMessmiss").click();
					//页面动态插入一条信息
					$("#goodsMessageText").prepend(
							"<hr class='post_hr' />"
							+"<div class='row col-lg-12 post_div7'>"
							+"<div class='col-lg-3' align='center'>"
							+"<img src='/path/"+headimg+"' class='post_img1' />"
							+"<p class='post_p1'>"
							+"<a href=''>"+username+"</a>"
							+"</p>"
							+"</div>"
							+"<div class='col-lg-8 post_div8'>"+textMess+"</div>"
							+"<div class='col-lg-12'>"
							+"<div class='post_div3'>"
							+"<span>"+textTime+"</span>&nbsp;&nbsp;"
							+"<span><a href='../goodMesClick/goodMesClickInsert.do?gdMessId="+data+"'"
							+"		class='post_spana' style='text-decoration: none;outline: none'>"
							+"<span id='gooMeClick' class='icon-thumbs-up icon-large'>&nbsp;(<span>0</span>)</span>"
							+"</a>"
							+"</span>"
							+"</div>"
							+"</div>"
							+"</div>"
					);
					//绑定点赞事件
					$("#gooMeClick").bind('click', goodsMeClick);
				}
			},
		});
		return false;
	});
});



/* 点击收藏物品颜色转换 */
$(function() {
	var changeSys = function() {
		/*操作之前判断用户是否登入*/
		if($(".sessionText").attr('id')=="null"){
			window.location.href="../view/login.jsp";
		}
		var spn=$(this);
		if ($(this).hasClass('blurb_span2')) {
			var url = $(this).prev().attr("href");
			var args = {};
			$.get(url, args, function(data) {
				//验证返回值是否为正整数
				var s =  /^[0-9]*[1-9][0-9]*$/;
				if(s.test(data)){
					//请求成功，改变对应的节点的样式
					$(spn).removeClass('blurb_span2');
					$(spn).addClass("blurb_span3");
					//改变url中的物品收藏id
					$(spn).prev().prev().attr("href","../goodsCollection/goodsCollDelete.do?goodsCollId="+data);
				}
			});
		} else {
			var url = $(this).prev().prev().attr("href");
			var args = {};
			$.get(url, args, function(data) {
				//请求成功，改变对应的节点的样式
				if(data=="deleteSucc"){
					$(spn).removeClass('blurb_span3');
					$(spn).addClass("blurb_span2");
				}
			});
		}
	};
	$(".lurb_click").each(function() {
		$(this).bind('click', changeSys);
	});
});


/**
 * 搜索框
 */
$(function() {
	$(".searchbodys p").not(":first").hide();
	$(".searchbox ul li").mouseover(function() {
		var index = $(this).index();
		if (index == 0) {
			$(this).find("a").addClass("style1");
			$(".searchbox ul li").eq(1).find("a").removeClass("style1");
			$("#searchGoods_input").val("");
		}
		if (index == 1) {
			$(this).find("a").addClass("style1");
			$(".searchbox ul li").eq(0).find("a").removeClass("style1");
			$("#searchShops_input").val("");
		}
		var index = $(this).index();
		$(".searchbodys p").eq(index).show().siblings('p').hide();
	});
});

// 图片轮播图
(function($) {
	$.fn.ckSlide = function(opts) {
		// .extend() 扩展jQuery类，添加ckSlide方法，参数是对象类型{}
		opts = $.extend({}, $.fn.ckSlide.opts, opts);
		this.each(function() {
			var slidewrap = $(this).find('.oneblurb1');// 轮播元素父对象
			var slide = slidewrap.find('li');// 获取<li>对象集
			var count = slide.length;// 计算对象集长度
			var that = this;// 存放父对象
			var index = 0;// 起始位置
			var time = null;
			$(this).data('opts', opts);// 给轮播对象添加参数 数据
			// next
			$(this).find('.oneblurb_2').on('click', function() {
				if (opts['isAnimate'] == true) {
					return;
				}

				var old = index;
				if (index >= count - 1) {
					index = 0;
				} else {
					index++;
				}
				change.call(that, index, old);// 调用图片切换方法，.call()
												// 每个JS函数都包含的一个非继承而来的方法，主要用来指定函数的作用域
												// that
												// ，通常不严谨写法是change()，有可能会函数冲突。
			});
			// prev
			$(this).find('.oneblurb_1').on('click', function() {
				if (opts['isAnimate'] == true) {
					return;
				}

				var old = index;
				if (index <= 0) {
					index = count - 1;
				} else {
					index--;
				}
				change.call(that, index, old);
			});
			// 点击切换相应序号的图片
			$(this).find('.oneblurb2 li').each(function(cindex) {
				$(this).on('click.slidebox', function() {
					change.call(that, cindex, index);
					index = cindex;
				});
			});
			// 自己添加——鼠标移入小圆点切换轮播图片
			$(this).find('.oneblurb2 li').each(function(cindex) {
				$(this).on('mouseover.slidebox', function() {
					change.call(that, cindex, index);
					index = cindex;
				});
			});

			// 鼠标悬停停止自动播放，显示左右切换按钮
			$(this).on('mouseover', function() {
				if (opts.autoPlay) {
					clearInterval(time);
				}
				$(this).find('.ctrl-blurb').css({
					opacity : 0.6
				});
			});
			// 鼠标离开轮播界面，开始自动播放，同时隐藏按钮
			$(this).on('mouseleave', function() {
				if (opts.autoPlay) {
					startAtuoPlay(opts.interval);
				}
				$(this).find('.ctrl-blurb').css({
					opacity : 0.1
				});
			});
			startAtuoPlay(opts.interval);
			// 自动滚动播放
			function startAtuoPlay(inum) {
				if (opts.autoPlay) {
					time = setInterval(function() {
						var old = index;
						if (index >= count - 1) {
							index = 0;
						} else {
							index++;
						}
						change.call(that, index, old);
					}, inum);// 2秒
				}
			}
			// 修正box 标记居中
			var box = $(this).find('.oneblurb2');
			box.css({
				'margin-left' : -(box.width() / 2)
			})
			// dir 移动方向参数
			switch (opts.dir) {
			case "x":
				opts['width'] = $(this).width();
				slidewrap.css({
					'width' : count * opts['width']
				});
				slide.css({
					'float' : 'left',
					'position' : 'relative',
					'margin-left' : '0px'
				});
				// .wrap()包裹页面已经定义的.ck-slide-wrapper以及子元素
				slidewrap.wrap('<div class="ck-slide-dir"></div>');
				slide.show();
				break;
			case "y": // 添加垂直移动参数
				opts['height'] = $(this).height();
				slidewrap.css({
					'height' : count * opts['height']
				});
				slide.css({
					'float' : 'left',
					'position' : 'relative',
					'margin-top' : '0px'
				});
				slidewrap.wrap('<div class="ck-slide-dir"></div>');
				slide.show();
				break;
			}
		});
	};
	function change(show, hide) {
		// 获取之前设置在ckSlide对象上的参数 数据
		var opts = $(this).data('opts');
		// 水平移动
		if (opts.dir == 'x') {
			var x = show * opts['width'];
			// animate() 与css()执行结果相同，但是过程不同，前者有渐变动画效果
			$(this).find('.oneblurb1').stop().animate({
				'margin-left' : -x
			}, function() {
				opts['isAnimate'] = false;
			});
			opts['isAnimate'] = true;// 图片在移动过程中设置按钮点击不可用，确保每一次轮播视觉上执行完成，
		} else if (opts.dir == 'y') {// 垂直移动——自己添加
			var y = show * opts['height'];
			$(this).find('.oneblurb1').stop().animate({
				'margin-top' : -y
			}, function() {
				opts['isAnimate'] = false;
			});
			opts['isAnimate'] = true;
		} else {
			// 默认的淡隐淡出效果
			$(this).find('.oneblurb1 li').eq(hide).stop().animate({
				opacity : 0
			});
			$(this).find('.oneblurb1 li').eq(show).show().css({
				opacity : 0
			}).stop().animate({
				opacity : 1
			});
		}
		// 切换对应标记的颜色
		$(this).find('.oneblurb2 li').removeClass('current');
		$(this).find('.oneblurb2 li').eq(show).addClass('current');
	}
	$.fn.ckSlide.opts = {
		autoPlay : false,// 默认不自动播放
		dir : null,// 默认淡隐淡出效果
		isAnimate : false,// 默认按钮可用
		interval : 2000
	// 默认自动2秒切换
	};
})(jQuery);