$(function(){
	$("#searchBox").focus(function(){
		if($("#searchBox")[0].value == "请输入您要输入的关键字"){
			$(this)[0].value = "";
			$(this)[0].style.color = "#333";
		}
	});
	$("#searchBox").blur(function(){
		if($("#searchBox")[0].value == ""){
			$(this)[0].value = "请输入您要输入的关键字";
			$(this)[0].style.color = "#999";
		}
	});
	$("#zxsearchBox").focus(function(){
		if($("#zxsearchBox")[0].value == "请输入您要咨询的事项名称或关键字，并选择自动匹配的事项。"){
			$(this)[0].value = "";
			$(this)[0].style.color = "#333";
		}
	});
	$("#zxsearchBox").blur(function(){
		if($("#zxsearchBox")[0].value == ""){
			$(this)[0].value = "请输入您要咨询的事项名称或关键字，并选择自动匹配的事项。";
			$(this)[0].style.color = "#999";
		}
	});
	/*内页左侧*/
	$(".bslistHead").click(function(){
		var idName = $(this).attr("id") + "C";
		$(".bsCont").css("display","none");
		$(".ywCont").css("display","none");
		$("#"+idName).css("display","block");
	});
	$(".inforHeaderLi").click(function(){
		var idName = $(this).attr("id") + "C";
		$(".inforHeaderLi").removeClass("inforHeaderLis");
		$(this).addClass("inforHeaderLis");
		$(".inforCont").css("display","none");
		$("#"+idName).css("display","block");
	});
	$(".ywzx_form_input_2").click(function(){
		$("#upload")[0].click();
	});
	$(".borwse").click(function(){
		$("#upload")[0].click();
	});
	$(".inforNavLi").click(function(){
		var inforIdName = $(this).attr("id") + "C";
		$(".inforNavLi").removeClass("inforNavLiS")
		$(this).addClass("inforNavLiS");
		$(".inforListCont").css("display","none");
		$("#"+inforIdName).css("display","block");
	});
})
