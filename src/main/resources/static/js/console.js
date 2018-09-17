$(function(){
    $(".progress_bg").each(function() {
        var left = 0,bgleft = 0;
        $(this).click(function(e) {
            bgleft = $(this).offset().left;
            left = e.pageX - bgleft;
            if (left <= 0) {
                left = 0;
            }else if (left > $(this).width()) {
                left = $(this).width();
            }
            $(this).children('div').animate({width:left},$(this).width());
            $(this).children('input').val(parseInt((left/$(this).width())*100));

            if ($(this).children('input').val() <= 20) {
                $(this).parent().parent().next().html('了解');
            } else if ($(this).children('input').val() <= 40) {
                $(this).parent().parent().next().html('熟悉');
            } else if ($(this).children('input').val() <= 60) {
                $(this).parent().parent().next().html('掌握');
            } else if ($(this).children('input').val() <= 80) {
                $(this).parent().parent().next().html('精通');
            } else {
                $(this).parent().parent().next().html('专家');
            }
        });
    });
});


$(function() {
    $("#base_btn").click(function() {
        $.ajax({
            type:'post',
            url:'../resume/save_base_info',
            data: $('#base_info_form').serialize(),
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            success : function(data) {
                if(data.errorCode==0){
                    $("#title_content").html("操作成功");
                } else {
                    $("#title_content").html("操作失败：" + data.errorMsg);
                }
                $("#title_a").click();
            }
        });
    });
});


$(function() {
    $("#desc_btn").click(function() {
        $.ajax({
            type:'post',
            url:'../resume/save_desc_info',
            data: $('#desc_info_form').serialize(),
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            success : function(data) {
                if(data.errorCode==0){
                    $("#title_content").html("操作成功");
                } else {
                    $("#title_content").html("操作失败：" + data.errorMsg);
                }
                $("#title_a").click();
            }
        });
    });
});

$(function() {
    var saveWorkEvent = function() {
        $.ajax({
            type:'post',
            url:'../resume/save_work_info',
            data: $(this).parent().parent().serialize(),
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            success : function(data) {
                if(data.errorCode==0){
                    $("#title_content").html("操作成功");
                } else {
                    $("#title_content").html("操作失败：" + data.errorMsg);
                }
                $("#title_a").click();
            }
        });
    };

    var deleteWorkEvent = function() {
        var $workForm = $(this).closest('form');
        $.ajax({
            type:'post',
            url:'../resume/delete_work_info',
            data: 'id='+ $workForm.find("input[name='id']").val(),
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            success : function(data) {
                if(data.errorCode==0){
                    $("#title_content").html("操作成功");
                    $workForm.remove();
                } else {
                    $("#title_content").html("操作失败：" + data.errorMsg);
                }
                $("#title_a").click();
            }
        });
    };

    $(".work_btn").each(function() {
        $(this).bind('click', saveWorkEvent);
    });

    $(".work_del_btn").each(function() {
        $(this).bind('click', deleteWorkEvent);
    });

    $("#work_add_btn").click(function() {
        $.ajax({
            type:'post',
            url:'../resume/save_work_info',
            data: $('#work_add_form').serialize(),
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            success : function(data) {
                if(data.errorCode==0){
                    $("#title_content").html("操作成功");


                    $("#work_form").append($("#work_template").html());
                    var parent = $("#work_form").children('form').last();
                    parent.find("input[name='id']").val(data.result.id);
                    parent.find("input[name='company']").val(data.result.company);
                    parent.find("input[name='job']").val(data.result.job);

                    if (data.result.startDate != null) {
                        parent.find("input[name='startDate']").val(data.result.startDate.substring(0,10));
                    }
                    if (data.result.endDate != null) {
                        parent.find("input[name='endDate']").val(data.result.endDate.substring(0,10));
                    }

                    parent.find("textarea[name='workContent']").val(data.result.workContent);
                    parent.find(".work_btn").bind('click', saveWorkEvent);
                    parent.find(".work_del_btn").bind('click', deleteWorkEvent);
                } else {
                    $("#title_content").html("操作失败：" + data.errorMsg);
                }
                $("#work_add_btn").prev().click();
                $("#title_a").click();
            }
        });
    });
});