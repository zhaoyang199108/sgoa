/**
 * 添加报损单页面用JS
 */
$(document).ready(function() {

	// 设置默认焦点
	$("#oldNum").focus();
	// 设置日期默认值
	$("#createDate").val(getToday());
	/**
	 * 入院行删除按钮点击事件,删除该行数据
	 */
	$(".del-in-tr-btn").click(function() {
		if ($("#boundInTb tr").size() == 3) {
			alert("至少要保留一行");
			return false;
		}
		// 取得删除行的ID
		var trIndex = $(this).attr("id").substring(10);
		$('#inTr' + trIndex).remove();
	});

	/**
	 * 入院行复制按钮点击事件,复制该行数据至最底部
	 */
	$(".copy-in-tr-btn").click(function() {

		// 取得该行ID,复制至最底部
		var trIndex = $(this).attr("id").substring(11);
		var newTr = $('#inTr' + trIndex).clone(true);
		var index = getNewInTrIndex(); // 增加行数
		setNewInTrAttribute(newTr, index);
		newTr.appendTo($("#boundInTb"));
		// 设置焦点至新增行的条形码输入框
		$('#inName' + index).focus();
		clearInTrValue($('#inTr' + index));
	});
	
	/**
	 * 入院人数处理
	 */
	$("#countBtn").click(function() {
		
		// 设置原有人数
		$.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: '/report/date_change.htm',
            dataType: 'json',
            data: 'peoId='+$("#peoId").val()+'&releaseDate='+$("#releaseDate").val()+'&r=' + Math.random(),
            success: function(data){
            	if (data.newNumStr != "") {
            		$("#oldNum").val(data.newNumStr);
            	}
            	// 设置入院人数
        		var indexIn = getNewInTrIndex()-1; // 增加行数
        		// 取得输入的行数
        		var indexInCount = 0;
        		for (var i = 1; i <= indexIn; i++) {
        			if ($('#inName' + i).val() != "") {
        				indexInCount += 1;
        			}
        		}
        		$("#intoNum").val(indexInCount == 0 ? "" : indexInCount);
        		
        		// 设置出院人数
        		var indexOut = getNewoutTrIndex()-1; // 增加行数
        		
        		// 取得治 愈人数
        		var indexOutCount1 = 0;
        	    // 取得好 转人数
        		var indexOutCount2 = 0;
        	    // 取得未 愈人数
        		var indexOutCount3 = 0;
        	    // 取得转 院人数
        		var indexOutCount4 = 0;
        	    // 取得死 亡人数
        		var indexOutCount5 = 0;
        	    // 取得其他人数
        		var indexOutCount6 = 0;
        		// 设置出院总天数
        		var indexOutDay = 0;
        		for (var i = 1; i <= indexOut; i++) {
        			// 设置疗效数
        			if ($('#efficacy' + i).val() == "治愈") {
        				indexOutCount1++;
        			} else if ($('#efficacy' + i).val() == "好转") {
        				indexOutCount2++;
        			} else if ($('#efficacy' + i).val() == "未愈") {
        				indexOutCount3++;
        			} else if ($('#efficacy' + i).val() == "转院") {
        				indexOutCount4++;
        			} else if ($('#efficacy' + i).val() == "死亡") {
        				indexOutCount5++;
        			} else if ($('#efficacy' + i).val() == "其他") {
        				indexOutCount6++;
        			}
        			// 设置出院总天数
        			indexOutDay += Number($('#hospitalTime' + i).val());
        		}
        		// 设置治 愈人数
        		$("#cure").val(indexOutCount1 == 0 ? "" : indexOutCount1);
        	    // 设置好 转人数
        		$("#better").val(indexOutCount2 == 0 ? "" : indexOutCount2);
        	    // 设置未 愈人数
        		$("#healed").val(indexOutCount3 == 0 ? "" : indexOutCount3);
        	    // 设置转 院人数
        		$("#turn").val(indexOutCount4 == 0 ? "" : indexOutCount4);
        	    // 设置死 亡人数
        		$("#doom").val(indexOutCount5 == 0 ? "" : indexOutCount5);
        	    // 设置其他人数
        		$("#outNum").val(indexOutCount6 == 0 ? "" : indexOutCount6);
        		// 设置出院总人数
        		var indexOutCount = indexOutCount1 + indexOutCount2 + indexOutCount3 + indexOutCount4 + indexOutCount5 + indexOutCount6; 
        		$("#admission").val(indexOutCount == 0 ? "" : indexOutCount);
        		// 设置住院总天数
        		$("#outDays").val(indexOutDay == 0 ? "" : indexOutDay);
        		
        		// 设置现有人数
        		$("#newNum").val(parseInt($("#oldNum").val()==""?0:$("#oldNum").val())+parseInt($("#intoNum").val()==""?0:$("#intoNum").val())-parseInt($("#admission").val()==""?0:$("#admission").val()));
            },
            error: function(){
            	return false;
            }
        });
	});

	/**
	 * 入院行清空按钮点击事件,清空该行数据
	 */
	$(".clear-in-tr-btn").click(function() {
		// 取得删除行的ID
		var trIndex = $(this).attr("id").substring(12);
		clearInTrValue($('#inTr' + trIndex));
	});
	/**
	 * 抢救行删除按钮点击事件,删除该行数据
	 */
	$(".del-save-tr-btn").click(function() {
		if ($("#boundSaveTb tr").size() == 3) {
			alert("至少要保留一行");
			return false;
		}
		// 取得删除行的ID
		var trIndex = $(this).attr("id").substring(12);
		$('#saveTr' + trIndex).remove();
	});

	/**
	 * 抢救行复制按钮点击事件,复制该行数据至最底部
	 */
	$(".copy-save-tr-btn").click(function() {

		// 取得该行ID,复制至最底部
		var trIndex = $(this).attr("id").substring(13);
		var newTr = $('#saveTr' + trIndex).clone(true);
		var index = getNewSaveTrIndex(); // 增加行数
		setNewSaveTrAttribute(newTr, index);
		newTr.appendTo($("#boundSaveTb"));
		// 设置焦点至新增行的条形码输入框
		$('#saveName' + index).focus();
		// 清空当前行数据
		clearSaveTrValue($('#saveTr' + index));
	});

	/**
	 * 抢救行清空按钮点击事件,清空该行数据
	 */
	$(".clear-save-tr-btn").click(function() {
		// 取得删除行的ID
		var trIndex = $(this).attr("id").substring(14);
		clearSaveTrValue($('#saveTr' + trIndex));
	});
	/**
	 * 出院行删除按钮点击事件,删除该行数据
	 */
	$(".del-out-tr-btn").click(function() {
		if ($("#boundOutTb tr").size() == 3) {
			alert("至少要保留一行");
			return false;
		}
		// 取得删除行的ID
		var trIndex = $(this).attr("id").substring(11);
		$('#outTr' + trIndex).remove();
	});

	/**
	 * 出院行复制按钮点击事件,复制该行数据至最底部
	 */
	$(".copy-out-tr-btn").click(function() {

		// 取得该行ID,复制至最底部
		var trIndex = $(this).attr("id").substring(12);
		var newTr = $('#outTr' + trIndex).clone(true);
		var index = getNewoutTrIndex(); // 增加行数
		setNewoutTrAttribute(newTr, index);
		newTr.appendTo($("#boundOutTb"));
		// 设置焦点至新增行的条形码输入框
		$('#outName' + index).focus();
		// 清空当前行数据
		clearoutTrValue($('#outTr' + index));
	});

	/**
	 * 出院行清空按钮点击事件,清空该行数据
	 */
	$(".clear-out-tr-btn").click(function() {
		// 取得删除行的ID
		var trIndex = $(this).attr("id").substring(13);
		clearoutTrValue($('#outTr' + trIndex));
	});

});

/**
 * 入院设置新增行的属性
 */
function setNewInTrAttribute(newTr, i) {

	// 设置新增行的ID(i为当前除标题行外的总行数+1)
	newTr[0].id = "inTr" + i;
	// 设置删除,复制按钮的ID
	newTr.find("a[class=tr-btn copy-in-tr-btn]").attr("id", 'copyInTrBtn' + i); // 复制按钮
	newTr.find("a[class=tr-btn del-in-tr-btn]").attr("id", 'delInTrBtn' + i); // 删除按钮
	newTr.find("a[class=tr-btn clear-in-tr-btn]")
			.attr("id", 'clearInTrBtn' + i); // 清除按钮

	// 设置下拉框及输入框的ID
	newTr.find("input[name=inNames]").attr("id", 'inName' + i); // ID输入框
	newTr.find("input[name=diagnoses]").attr("id", 'diagnose' + i); // 品名输入框
}

/**
 * 入院清除行中所有表单的值
 */
function clearInTrValue(tr) {
	tr.find("input[name=inNames]").val(""); // ID输入框
	tr.find("input[name=diagnoses]").val(""); // 品名输入框
}

/**
 * 入院取得最大行的索引号
 */
function getNewInTrIndex() {
	var trCount = $("#boundInTb tr").size() - 2; // 表格总行数
	var lastTr = $("#boundInTb tr:eq(" + trCount + ")"); // 取得表格最后一行
	// 每次添加记录为在最后一行之后添加
	// 取得最后一行记录的ID,将ID索引+1即为新增行的索引
	var index = lastTr.attr("id").substring("4"); // 行号,例goodsTr2
	// JQuery对字符加法处理不好,*1后可转为int
	return index * 1 + 2;

}

/**
 * 抢救设置新增行的属性
 */
function setNewSaveTrAttribute(newTr, i) {

	// 设置新增行的ID(i为当前除标题行外的总行数+1)
	newTr[0].id = "saveTr" + i;
	// 设置删除,复制按钮的ID
	newTr.find("a[class=tr-btn copy-save-tr-btn]").attr("id",
			'copySaveTrBtn' + i); // 复制按钮
	newTr.find("a[class=tr-btn del-save-tr-btn]")
			.attr("id", 'delSaveTrBtn' + i); // 删除按钮
	newTr.find("a[class=tr-btn clear-save-tr-btn]").attr("id",
			'clearSaveTrBtn' + i); // 清除按钮

	// 设置下拉框及输入框的ID
	newTr.find("input[name=saveNames]").attr("id", 'saveName' + i); // ID输入框
	newTr.find("input[name=saveTypes]").attr("id", 'saveType' + i); // 品名输入框
}

/**
 * 抢救 清除行中所有表单的值
 */
function clearSaveTrValue(tr) {
	tr.find("input[name=saveNames]").val(""); // ID输入框
	tr.find("select[name=saveTypes]").val("Y"); // 品名输入框
}

/**
 * 抢救取得最大行的索引号
 */
function getNewSaveTrIndex() {
	var trCount = $("#boundSaveTb tr").size() - 2; // 表格总行数
	var lastTr = $("#boundSaveTb tr:eq(" + trCount + ")"); // 取得表格最后一行
	// 每次添加记录为在最后一行之后添加
	// 取得最后一行记录的ID,将ID索引+1即为新增行的索引
	var index = lastTr.attr("id").substring("6"); // 行号,例goodsTr2
	// JQuery对字符加法处理不好,*1后可转为int
	return index * 1 + 2;
}

/**
 * 出院设置新增行的属性
 */
function setNewoutTrAttribute(newTr, i) {
	// 设置新增行的ID(i为当前除标题行外的总行数+1)
	newTr[0].id = "outTr" + i;
	// 设置删除,复制按钮的ID
	newTr.find("a[class=tr-btn copy-out-tr-btn]")
			.attr("id", 'copyoutTrBtn' + i); // 复制按钮
	newTr.find("a[class=tr-btn del-out-tr-btn]").attr("id", 'deloutTrBtn' + i); // 删除按钮
	newTr.find("a[class=tr-btn clear-out-tr-btn]").attr("id",
			'clearoutTrBtn' + i); // 清除按钮

	// 设置下拉框及输入框的ID
	newTr.find("input[name=outNames]").attr("id", 'outName' + i); // 住院人姓名
	newTr.find("input[name=sexs]").attr("id", 'sex' + i); // 性别
	newTr.find("input[name=ages]").attr("id", 'age' + i); // 年龄
	newTr.find("input[name=outWorks]").attr("id", 'outWork' + i); // 职务
	newTr.find("input[name=inDianoses]").attr("id", 'inDianose' + i); // 入院诊断
	newTr.find("input[name=outDianoses]").attr("id", 'outDianose' + i); // 出院诊断
	newTr.find("input[name=inTimes]").attr("id", 'inTime' + i); // 确诊距住院时间
	newTr.find("input[name=opsTimes]").attr("id", 'opsTime' + i); // 术前住院时间
	newTr.find("input[name=fees]").attr("id", 'fee' + i); // 公私费(Y表示私费N表示公费)
	newTr.find("input[name=reasons]").attr("id", 'reason' + i); // 中毒及外伤原因
	newTr.find("select[name=efficacys]").attr("id", 'efficacy' + i); // 疗效
	newTr.find("input[name=hospitalTimes]").attr("id", 'hospitalTime' + i); // 住院天数
}

/**
 * 出院清除行中所有表单的值
 */
function clearoutTrValue(tr) {
	tr.find("input[name=outNames]").val(""); // // 住院人姓名
	tr.find("select[name=sexs]").val("Y"); // 性别
	tr.find("input[name=ages]").val(""); // 年龄
	tr.find("input[name=outWorks]").val("");// 职务
	tr.find("input[name=inDianoses]").val(""); // 入院诊断
	tr.find("input[name=outDianoses]").val(""); // 出院诊断
	tr.find("input[name=inTimes]").val(""); // 确诊距住院时间
	tr.find("input[name=opsTimes]").val("");// 术前住院时间
	tr.find("select[name=fees]").val("Y");// 公私费(Y表示私费N表示公费)
	tr.find("input[name=reasons]").val(""); // 中毒及外伤原因
	tr.find("select[name='efficacys']").val(""); // 疗效
	tr.find("input[name=hospitalTimes]").val(""); // 住院天数
}

/**
 * 出院取得最大行的索引号
 */
function getNewoutTrIndex() {
	var trCount = $("#boundOutTb tr").size() - 2; // 表格总行数
	var lastTr = $("#boundOutTb tr:eq(" + trCount + ")"); // 取得表格最后一行
	// 每次添加记录为在最后一行之后添加
	// 取得最后一行记录的ID,将ID索引+1即为新增行的索引
	var index = lastTr.attr("id").substring("5"); // 行号,例goodsTr2
	// JQuery对字符加法处理不好,*1后可转为int
	return index * 1 + 2;

}
