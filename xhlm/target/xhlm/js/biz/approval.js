/**
 * 添加报损单页面用JS
 */
$(document).ready(function() {

	// 设置默认焦点
	$("#oldNum").focus();
	// 设置日期默认值
	$("#createDate").val(getToday());
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
		$('#detailName' + index).focus();
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

});

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
	newTr.find("input[name=detailNames]").attr("id", 'detailName' + i); // ID输入框
	newTr.find("input[name=stepss]").attr("id", 'steps' + i); // 步骤
	newTr.find("input[name=draftsNames]").attr("id", 'draftsName' + i); // 审批人
	newTr.find("input[name=draftsNames]").attr("alt", i); // id顺序
	newTr.find("input[name=loginIds]").attr("id", 'loginId' + i); // 审批人
	newTr.find("select[name=statuss]").attr("id", 'loginId' + i); // 是否有权限
}

/**
 * 抢救 清除行中所有表单的值
 */
function clearSaveTrValue(tr) {
	tr.find("input[name=detailNames]").val(""); // ID输入框
	tr.find("input[name=stepss]").val(""); // 步骤
	tr.find("input[name=loginIds]").val(""); // 审批人
	tr.find("select[name=statuss]").val("Y"); // 是否有权限
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
