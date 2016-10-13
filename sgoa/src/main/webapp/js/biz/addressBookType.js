/**
 * 添加通讯录目录页面用JS
 */
$(document).ready(function() {

	/**
	 * 目录行复制按钮点击事件,复制该行数据至最底部
	 */
	$("#addBtn").click(function() {

		// 取得该行ID,复制至最底部
		var index = getNewInTrIndex(); // 增加行数
		var newTr = $('#typeTr1').clone(true);
		setNewInTrAttribute(newTr, index);
		newTr.appendTo($("#boundTb"));
		// 设置焦点至新增行的条形码输入框
		$('#sortingId' + index).focus();
		clearInTrValue($('#typeTr' + index),index);
	});
});

/**
 * 目录设置新增行的属性
 */
function setNewInTrAttribute(newTr, i) {

	// 设置新增行的ID(i为当前除标题行外的总行数+1)
	newTr[0].id = "typeTr" + i;
	// 设置删除,复制按钮的ID
	newTr.find("a[class=act-btn save]").attr("id", 'saveTrBtn' + i); // 保存按钮
	newTr.find("a[class=act-btn del]").attr("id", 'delTrBtn' + i); // 删除按钮
	newTr.find("a[class=act-btn save]").attr("alt", i); // 保存按钮

	// 设置下拉框及输入框的ID
	newTr.find("input[name=id]").attr("id", 'typeId' + i); // ID输入框
	newTr.find("input[name=sorting]").attr("id", 'sortingId' + i); // 品名输入框
	newTr.find("input[name=typeName]").attr("id", 'typeNameId' + i); // 品名输入框
}

/**
 * 目录清除行中所有表单的值
 */
function clearInTrValue(tr,i) {
//	$('#typeId' + i).val(0); // ID输入框
//	alert($('#typeId' + i).val());
	tr.find("input[name=id]").val(""); 
	tr.find("input[name=sorting]").val(""); // ID输入框
	tr.find("input[name=typeName]").val(""); // 品名输入框
}

/**
 * 目录取得最大行的索引号
 */
function getNewInTrIndex() {
	var trCount = $("#boundTb tr").size() - 1; // 表格总行数
	var lastTr = $("#boundTb tr:eq(" + trCount + ")"); // 取得表格最后一行
	// 每次添加记录为在最后一行之后添加
	// 取得最后一行记录的ID,将ID索引+1即为新增行的索引
	var index = lastTr.attr("id").substring("6"); // 行号,例typeTr2
	// JQuery对字符加法处理不好,*1后可转为int
	return index * 1 + 1;

}