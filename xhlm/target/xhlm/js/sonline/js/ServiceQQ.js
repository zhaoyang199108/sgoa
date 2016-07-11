document.writeln("<div id=\"divSerWin\" class=\"service\">");
document.writeln("<div id=\"divMySer\" class=\"service-close\">");
document.writeln("<div class=\"service-button\" onclick='ClickSer();'></div>");
document.writeln("<div class=\"service-inside\">");
document.writeln("<dl>");
document.writeln("<dt>咨询工作时间</dt>");
document.writeln("<dd class=\"esp_4\">周一至周五</dd>");
document.writeln("<dd class=\"esp_4\">9:00 - 12:00</dd>");
document.writeln("<dt>康慈咨询团队</dt>");
document.writeln("<dd><a href=\"tencent://message/?uin=563239423\">在线客服</a></dd>");
document.writeln("<dd><a href=\"tencent://message/?uin=564818656\">在线客服</a></dd>");
document.writeln("<dd><a href=\"tencent://message/?uin=5947421\">在线客服</a></dd>");
document.writeln("<dd class=\"esp_1\"><a href=\"tencent://message/?uin=563239423\">投诉建议</a></dd>");
document.writeln("<dt>联系电话</dt>");
document.writeln("<dd class=\"esp_3\" title=\"24小时热线电话\">0312-2397331</dd>");
document.writeln("</dl>");
document.writeln("</div>");
document.writeln("</div>");
document.writeln("</div>");

$(document).ready(function(){
    var destDiv = $("#divSerWin");
    var startPos = destDiv.position().top;
    var divHeight = destDiv.outerHeight();
    
    $(window).scroll(function (){
        scrTop = $(window).scrollTop();
        if( startPos < scrTop){
            topPos = startPos+(scrTop - startPos)+10;
            $("#divSerWin").css("position", "absolute").css("top", topPos +"px").css('zIndex', '500');
        }
    });
});

function ClickSer(){
    var obj=$("#divMySer")
    if( obj.attr("class") == "service-open" )
        $("#divMySer").removeClass("service-open").addClass("service-close");
    else
        $("#divMySer").removeClass("service-close").addClass("service-open");
}