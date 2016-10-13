/**
 * 添加报损单页面用JS
 */
$(document).ready(function() {

	// 设置默认焦点
	$("#goodsNameShow1").focus();
	// 设置日期默认值
	$("#createDate").val(getToday());

	/**
	 * 增加按钮点击事件 Copy最底部的一行并添加新增行值表格最底部
	 */
	$("#addBtn").click(function() {
		var trCount = $("#boundTb tr").size() - 1; // 报损总行数
		var newTr = $("#boundTb tr:eq(" + trCount + ")").clone(true); // 复制最后一行
		var index = getNewTrIndex(); // 增加行数
		// 设置新增行的ID
		setNewTrAttribute(newTr, index);
		clearGoodsTrValue(newTr);
		newTr.appendTo($("#boundTb"));
		// 计算报损总记录数
		calculateGoodsTotalCount();
		// 设置焦点至新增行的条形码输入框
		$('#goodsNameShow' + index).focus();
	});

	/**
	 * 行删除按钮点击事件,删除该行数据
	 */
	$(".del-tr-btn").click(function() {
		if ($("#boundTb tr").size() == 2) {
			alert("至少要保留一行");
			return false;
		}
		// 取得删除行的ID
		var trIndex = $(this).attr("id").substring(8);
		$('#goodsTr' + trIndex).remove();
		// 计算报损总记录数
		calculateGoodsTotalCount();
	});

	/**
	 * 行复制按钮点击事件,复制该行数据至最底部
	 */
	$(".copy-tr-btn").click(function() {
		// 取得该行ID,复制至最底部
		var trIndex = $(this).attr("id").substring(9);
		var newTr = $('#goodsTr' + trIndex).clone(true);
		var index = getNewTrIndex(); // 增加行数
		setNewTrAttribute(newTr, index);
		newTr.appendTo($("#boundTb"));
		// 计算报损总记录数
		calculateGoodsTotalCount();
		// 设置焦点至新增行的条形码输入框
		$('#goodsNameShow' + index).focus();
	});

	/**
	 * 行清空按钮点击事件,清空该行数据
	 */
	$(".clear-tr-btn").click(function() {
		// 取得删除行的ID
		var trIndex = $(this).attr("id").substring(10);
		clearGoodsTrValue($('#goodsTr' + trIndex));
	});

	/**
	 * 批量删除按钮点击事件,删除选中行
	 */
	$("#delBatchBtn").click(function() {
		var item = $("input[name=chkItem]:checked");
		// 选择框必须选中才能进行批量操作
		if (item.length == 0) {
			alert("请至少选择一条记录进行操作");
			return false;
		}
		// 批量删除时,至少保留一行数据
		if (item.length == $("#boundTb tr").size() - 1) {
			alert("至少要保留一行");
			return false;
		}

		if (confirm("确定删除所选仓库")) {
			// 遍历所选的行,逐行删除
			item.each(function() {
				var trId = $(this).val();
				$('#goodsTr' + trId).remove();
			});
		}
		// 计算报损总记录数
		calculateGoodsTotalCount();
		// 设置焦点为最后一行的条形码输入框
		var index = $("#boundTb tr").size() - 1;
		$('#goodsNameShow' + index).focus();
	});

	/**
	 * 批量复制按钮点击事件,复制选中行
	 */
	$("#copyBtn").click(function() {
		var item = $("input[name=chkItem]:checked");
		// 选择框必须选中才能进行批量操作
		if (item.length == 0) {
			alert("请至少选择一条记录进行操作");
			return false;
		}
		// 遍历所选的行,复制所选行
		item.each(function() {
			var trId = $(this).val();
			var newTr = $('#goodsTr' + trId).clone(true);
			setNewTrAttribute(newTr, getNewTrIndex());
			newTr.appendTo($("#boundTb"));
		});
		// 计算报损总记录数
		calculateGoodsTotalCount();
		// 设置焦点为最后一行的条形码输入框
		var index = $("#boundTb tr").size() - 1;
		$('#goodsNameShow' + index).focus();

	});

	/**
	 * 批量清除按钮点击事件,清除选中行
	 */
	$("#clearBatchBtn").click(function() {
		var item = $("input[name=chkItem]:checked");
		// 选择框必须选中才能进行批量操作
		if (item.length == 0) {
			alert("请至少选择一条记录进行操作");
			return false;
		}
		// 遍历所选的行,清空所选行的表单值
		if (confirm("确定清除所选数据?")) {
			item.each(function() {
				var trId = $(this).val();
				clearGoodsTrValue($('#goodsTr' + trId));
			});
		}
	});

	/**
	 * 报损数量变化时 如果价格已经输入,计算总价及已付货款
	 */
	$("input[name=quantitys]").blur(function() {
		var index = $(this).attr("id").substring(8); // 行数
		// 如果数量为空时,清除总价及已付货款
		if ($(this).val() == "") {
			$('#money' + index).html("-");
			$('#ibPaidPrice' + index).val("");
			return false;
		}
		// 必须为数字
		if (!isNum($(this), "报损数量必须为数字！")) {
			return false;
		}

		// 如果报损金额存在,计算出总价
		var unitPrice = $('#unitPrice' + index).val();
		if (unitPrice != "") {
			var money = formatMoney(unitPrice * $(this).val());// 计算总价
			$('#money' + index).html(money + "元"); // 设置总价
			$('#ibPaidPrice' + index).val(money); // 设置已付金额
		}
		
	
	    
// *************************************追加开始*********************************
		// 循环取得所有行
		var trCount = $("#boundTb tr").size(); // 报损总行数
		var moneyCountTemp = 0;
		for (var i=1;i<trCount;i++) {
			// 取得每一行数量
			var quantity = $('#quantity' + i).val();
			// 取得每一行单价
			var unitPrice = $('#unitPrice' + i).val();
			// 计算每一行金额
			var moneyTemp = quantity * unitPrice;
			// 将每一行金额汇总
			moneyCountTemp += moneyTemp;
		}
		// 设置总价
		var totMoney=parseFloat(moneyCountTemp);
		$("#totalMoney").val(totMoney);
// *************************************追加结束*********************************
	});
    
	/**
	 * 报损金额变化时 如果报损数量已经输入,计算总价及已付货款
	 */
	$("input[name=unitPrices]").blur(function() {
		var index = $(this).attr("id").substring(9); // 行数
		var unitPrice = $(this).val(); // 所输入的单价
		// 如果数量为空时,清除总价及已付货款
		if (unitPrice == "") {
			$('#money' + index).html("-"); // 清空总价
			$('#ibPaidPrice' + index).val(""); // 清空已付金额
			return false;
		}
		// 校验单价格式(例:12.02,12)
		if (!isMoney($(this), "金额格式填写不正确,例:12.20,56.1！")) {
			return false;
		}

		// 转换金钱格式
		var price = formatMoney(unitPrice);
		$(this).val(price);
		// 如果报损数量存在,计算出总价
		var quantity = $('#quantity' + index).val();

		if (quantity != "") {
			var money = formatMoney(quantity * unitPrice);
			$('#money' + index).html(money + "元"); // 设置总价
			$('#ibPaidPrice' + index).val(money); // 设置已付货款
		}
// *************************************追加开始*********************************
		// 循环取得所有行
		var trCount = $("#boundTb tr").size(); // 报损总行数
		var moneyCountTemp = 0;
		for (var i=1;i<trCount;i++) {
			// 取得每一行数量
			var quantity = $('#quantity' + i).val();
			// 取得每一行单价
			var unitPrice = $('#unitPrice' + i).val();
			// 计算每一行金额
			var moneyTemp = quantity * unitPrice;
			// 将每一行金额汇总
			moneyCountTemp += moneyTemp;
		}
		// 设置总价
		var totMoney=parseFloat(moneyCountTemp);
		$("#totalMoney").val(totMoney);
// *************************************追加结束*********************************
	});

	
	
	$("#noBtn").click(function(){
		// 提示用户确认提交
		$("#doAction").val(2);
		$("#currentStatus").val(3);
	    if(!confirm("确定否决申请?")){
	    	return false;
	    }
		// 添加校验
		$('form').submit();
	});
	//同意提交
	$("#submitBtn").click(function(){
       	      
	        $("#currentStatus").val(5);
	        $("#doAction").val(3);
	        if(!confirm("是否确定提交?")){
	        	return false;
	        }
	    	$('form').submit();
        });
       $("#submitBut").click(function(){
	         if(!confirm("请选择审批人!")){
				return false;
	        }
	        // 添加校验
	        // 选择提交审核人
            var url = "/common/choose_approval_user.htm?step="+$("#step").val()+"&approvalId=" + $("#approvalId").val()+"&r=" + Math.random();
	        var param = 'dialogWidth=380px;dialogHeight=380px;status=no;center=yes;scroll=yes';
	        
	        var value = window.showModalDialog(url, '', param);
	        if(value==undefined)
        	{
        		  return false;
     	    }
	        if (value.length == 0) {
	            alert("未选择提交人,请重新提交!是否现在选择审批人?");
	            return false;
	        }
	        if(value[0].indexOf(",") > -1){
	        	alert("提交审核人只能选择一个!");
	            return false;
	        }
	        $("#nextOptId").val(value[0]);
	        $("#currentStatus").val(1);
	         $("#doAction").val(4);
	        if(!confirm("是否确定提交?")){
	        	return false;
	        }
        	$('form').submit();
        });
         $("#submitBnt").click(function(){
	         if(!confirm("请选择审批人!")){
				return false;
	        }
	        // 添加校验
	        // 选择提交审核人
	        var url = "/common/choose_user.htm?level=24" + "&r=" + Math.random();
	        var param = 'dialogWidth=380px;dialogHeight=380px;status=no;center=yes;scroll=yes';
	        
	        var value = window.showModalDialog(url, '', param);
	        if(value==undefined)
        	{
        		  return false;
     	    }
	        if (value.length == 0) {
	            alert("未选择提交人,请重新提交!是否现在选择审批人?");
	            return false;
	        }
	        if(value[0].indexOf(",") > -1){
	        	alert("提交审核人只能选择一个!");
	            return false;
	        }
	        $("#nextOptId").val(value[0]);
	        $("#currentStatus").val(5);
	         $("#doAction").val(5);
	        if(!confirm("是否确定提交?")){
	        	return false;
	        }
        	$('form').submit();
        });
     

});



/**
 * 设置新增行的属性
 */
function setNewTrAttribute(newTr, i) {

	// 设置新增行的ID(i为当前除标题行外的总行数+1)
	newTr[0].id = "goodsTr" + i;
	// 设置删除,复制按钮的ID
	newTr.find("a[class=tr-btn del-tr-btn]").attr("id", 'delTrBtn' + i); // 删除按钮
	newTr.find("a[class=tr-btn copy-tr-btn]").attr("id", 'copyTrBtn' + i); // 复制按钮
	newTr.find("a[class=tr-btn clear-tr-btn]").attr("id", 'clearTrBtn' + i); // 清除按钮

	// 设置单选框的ID,默认单选框不选中
	var chkbox = newTr.find("input[name=chkItem]");
	chkbox.attr("value", i);
	chkbox.attr("checked", false);
	// 设置下拉框及输入框的ID
	newTr.find("input[name=ids]").attr("id", 'id' + i); // ID输入框
	newTr.find("input[name=goodsNames]").attr("id", 'goodsName' + i); // 品名输入框
	newTr.find("input[name=goodsNameShows]").attr("id", 'goodsNameShow' + i); // 品名输入框
	newTr.find("input[name=models]").attr("id", 'model' + i); // 规格型号输入框
	newTr.find("input[name=addresss]").attr("id", 'address' + i); // 产地输入框
	newTr.find("input[name=units]").attr("id", 'unit' + i); // 单位输入框
	newTr.find("input[name=quantitys]").attr("id", 'quantity' + i); // 数量输入框
	newTr.find("input[name=unitPrices]").attr("id", 'unitPrice' + i); // 价格输入框
	newTr.find("span[class=moneys]").attr("id", 'money' + i); // 金额
	newTr.find("input[name=remarks]").attr("id", 'remark' + i); // 备注输入框
	// 设置默认焦点为条形码
	newTr.find("input[name=goodsNameShows]").attr("id", 'goodsNameShow' + i);
}

/**
 * 清除行中所有表单的值
 */
function clearGoodsTrValue(tr) {
	tr.find("input[name=chkItem]").attr("checked", false); // 选择框
	tr.find("input[name=ids]").val(""); // ID输入框
	tr.find("input[name=goodsNames]").val(""); // 品名输入框
	tr.find("input[name=goodsNameShows]").val(""); // 品名输入框
	tr.find("input[name=models]").val(""); // 规格型号输入框
	tr.find("input[name=addresss]").val(""); // 产地输入框
	tr.find("input[name=units]").val(""); // 单位输入框
	tr.find("input[name=quantitys]").val(""); // 数量输入框
	tr.find("input[name=unitPrices]").val(""); // 单价输入框
	tr.find("span[class=moneys]").html("-"); // 金额
	tr.find("input[name=remarks]").val(""); // 备注输入框
}

/**
 * 计算报损总记录数
 */
function calculateGoodsTotalCount() {
	// 取得页面中总行数
	var goodsCount = $("#boundTb tr").size() - 1;
	$(".goods-count").find("span").html(goodsCount);
	$("#goodsCount").val(goodsCount);
}

/**
 * 取得最大行的索引号
 */
function getNewTrIndex() {
	var trCount = $("#boundTb tr").size() - 1; // 表格总行数
	var lastTr = $("#boundTb tr:eq(" + trCount + ")"); // 取得表格最后一行
	// 每次添加记录为在最后一行之后添加
	// 取得最后一行记录的ID,将ID索引+1即为新增行的索引
	var index = lastTr.attr("id").substring("7"); // 行号,例goodsTr2
	// JQuery对字符加法处理不好,*1后可转为int
	return index * 1 + 1;

}
