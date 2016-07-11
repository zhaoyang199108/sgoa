/**
 * 分页Javascript
 */
$(document).ready(function(){

    // 下一页按钮点击事件
    $("a[name=nplink]").click(function(){
        var current = $("input[name=crtpage]").val();
        $("#cp").val(parseInt(current) + 1);
        $('form').submit();
    });
    
    // 上一页按钮点击事件
    $("a[name=pplink]").click(function(){
        var current = $("input[name=crtpage]").val();
        $("#cp").val(parseInt(current) - 1);
        $('form').submit();
    });
    
    // 首页按钮点击事件
    $("a[name=fplink]").click(function(){
        $("#cp").val(1);
        $('form').submit();
    });
    
    // 尾页按钮点击事件
    $("a[name=lplink]").click(function(){
        $("#cp").val($("input[name=totalpage]").val());
        $('form').submit();
    });
    
    // 跳转按钮点击事件
    $("#goPage").click(function(){
        var numRegex = /^\d+(\.\d+)?$/;
        
        var goPage = $("#cp").val();
        if (!numRegex.test(goPage)) {
            alert("请输入数字");
            return;
        }
        
        var totalPage = $("input[name=totalpage]").val();
        if (goPage > totalPage) {
            $("#cp").val(goPage);
        }
        $('form').submit();
    });
    
});
