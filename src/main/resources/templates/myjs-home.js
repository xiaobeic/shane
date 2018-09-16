/*登陆注册弹出框*/
$(function() {
	$("#my-login").click(function() {
		$('#login_a1').click();
	});
	$("#my-register").click(function() {
		$('#login_a2').click();
	});
});


/*index:分类标签获得焦点改变颜色*/
/*$(function() {
	$("#class_ul").children("li").each(function() {
		$(this).mouseenter(function() {
			$(this).css('background-position','40px -18px');
		});
		$(this).mouseleave(function() {
			$(this).css('background-position','40px 11px');
		});
	});
});*/




/*
 * 右下角回到顶部
 */
$(function() {
	var speed = 800;
	var h = document.body.clientHeight;
	$("#toTop").click(function() {
		$('html,body').animate({
				scrollTop: '0px'
			},
			speed);
	});
});
function getTop() {
	if ($(document).scrollTop() > 300) {
		$("#getTop").css({
			'display': 'block',
		});
	} else {
		$("#getTop").css('display', 'none');
	}
	setTimeout(getTop);
}


/**
 * order:删除按钮获得焦点隐藏显示
 */
$(function() {
	$(".body_info").each(function() {
		$(this).mouseenter(function() {
			$(this).children().last().children().css("display","block");
		});
		$(this).mouseleave(function() {
			$(this).children().last().children().css("display","none");
		});
	});
});

//order：点击删除按钮，删除对应的菜品
$(function() {
	$(".body_del").each(function() {
		$(this).click(function() {
			var thisTr=$(this).parent('td').parent('tr');
			var foodId=thisTr.attr('id');
			var angileVal=$(this).parent().prev().children().text();
			$.ajax({
				type:'post',
				url:'../carts/deleteFoodOfCarts.do',
				data: 'foodId='+foodId,
				success : function(data) {
					if(data=="success"){
						//删除节点之前先把总价进行相应的操作
						$('.totalVal').text(Math.round(($('.totalVal').text() - angileVal)*Math.pow(10,2))/Math.pow(10,2));
						thisTr.remove();
						//删除节点后，判断是否还有菜品，没有的话添加提示信息
						if($("#table_cart").find("tr").length==1){
							$("#table_cart").append("<tr class='body_tr_null'><td colspan='5'>"
								+"<span>没有菜品了！返回<a style='color: #2580DF;' href='../foods/selcteAllFoods.do'>继续订购</a></span>"
								+"</td></tr>");
							//没有菜品，“确认下单”按钮需要取消点击事件，防止无数据提交
							$("#submitBtn").attr("disabled", true); 
						}
					}
				}
			});
		});
	});
});


/*order:单点加减菜品*/
$(function() {
	var changeOrderMin = function() {
		var thisId=$(this);
		var num = thisId.next('span').text();
		var foodId=thisId.parent('td').parent('tr').attr('id');
		var parentTr=thisId.parent('td').parent('tr');
		if (num > 0) {
			$.ajax({
				type:'post',
				url:'../carts/changeOrderMin.do',
				data: 'foodId='+foodId,
				success : function(data) {
					var angileVal = thisId.parent('td').prev('td').children('span').text();
					if(data=="success"){
						thisId.next('span').text(--num);
						thisId.parent('td').next('td').children('span').text(Math.round((parseFloat((num--) * angileVal))*Math.pow(10,2))/Math.pow(10,2));
					}
					if(data=="dalete"){  //如果数量为0，删除该行信息
						parentTr.remove();
						//删除节点后，判断是否还有菜品，没有的话添加提示信息
						if($("#table_cart").find("tr").length==1){
							$("#table_cart").append("<tr class='body_tr_null'><td colspan='5'>"
								+"<span>没有菜品了！返回<a style='color: #2580DF;' href='../foods/selcteAllFoods.do'>继续订购</a></span>"
								+"</td></tr>");
							//没有菜品，确认下单按钮需要取消点击事件，防止无数据提交
							$("#submitBtn").attr("disabled", true); 
						}
					}
					//总价进行相应操作
					$('.totalVal').text(Math.round(($('.totalVal').text() - angileVal)*Math.pow(10,2))/Math.pow(10,2));
				}
			});
		}
	};
	var changeOrderPlus = function() {
		var thisId=$(this);
		var num =thisId.prev('span').text();
		var foodId=thisId.parent('td').parent('tr').attr('id');
		if (num < 10) {
			$.ajax({
				type:'post',
				url:'../carts/changeOrderPlus.do',
				data: 'foodId='+foodId,
				success : function(data) {
					if(data=="success"){
						var angileVal = thisId.parent('td').prev('td').children('span').text();
						var totalVal = $('.totalVal').text();
						thisId.prev('span').text(++num);
						thisId.parent('td').next('td').children('span').text(Math.round((parseFloat((num++) * angileVal))*Math.pow(10,2))/Math.pow(10,2));
						$('.totalVal').text(Math.round((parseFloat(totalVal) + parseFloat(angileVal))*Math.pow(10,2))/Math.pow(10,2));
					}
				}
			});
			
		}
	};
	$(".minus_span").each(
		function() {
			$(this).bind('click', changeOrderMin);
		});
	$(".plus_span").each(
		function() {
			$(this).bind('click', changeOrderPlus);
		});
});
