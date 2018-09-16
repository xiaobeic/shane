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