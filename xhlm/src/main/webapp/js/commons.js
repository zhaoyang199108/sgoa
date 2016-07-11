/**
 * 页面通用JS函数
 */
$(document).ready(function() {
    /*
     * 页面全选反选框时间
     * 全选框:id=allBtn
     * 反选框:id=oppBtn
     * 选择框:name=chkItem
     */
    // 全选按钮点击事件
    $("#allBtn").click(function(){
        if ($(this).attr("checked")) {
            $("input[name='chkItem']").each(function(){
                $(this).attr("checked", true);
            });
        }
        else {
            $("input[name='chkItem']").each(function(){
                $(this).attr("checked", false);
            });
        }
        $("#oppBtn").attr("checked", false);
    });
    
    // 反选框点击事件
    $("#oppBtn").click(function(){
        $("input[name='chkItem']").each(function(){
            $(this).attr("checked", !$(this).attr("checked"));
        });
        // 反选后,根据Checkbox选中情况确定全选框是否需要被选中
        var checkedSize = $("input[name=chkItem]:checked").length; // 选中数量说
        var allSize = $("input[name=chkItem]").length; // 全部数量
        $("#allBtn").attr("checked", checkedSize == allSize);
    });
    
    // Checkbox点击事件
    // 如果全部选择时,全选框需要被选中
    $("input[name='chkItem']").click(function(){
        var checkedSize = $("input[name=chkItem]:checked").length; // 选中数量说
        var allSize = $("input[name=chkItem]").length; // 全部数量
        $("#allBtn").attr("checked", checkedSize == allSize); //全选框
        $("#oppBtn").attr("checked", false); //反选框
    });
    
	
	/**
	 * 列表鼠标移动样式
	 */
	$("table.list tr:not(:first)").mouseover(function() {
		$(this).css("background-color", "#A4DEF6");
	});
	$("table.list tr:not(:first)").mouseout(function() {
		$(this).css("background-color", "#CDEDFA");
	});
});

/**
 * 取得当天日期
 */
function getToday() {
	var date = new Date();
	var year = date.getFullYear(); // 年
	var month = date.getMonth() + 1; // 月
	var day = date.getDate(); // 日
	return year + "-" + fullDate(month) + "-" + fullDate(day);
}

/**
 * 日期前补0
 */
function fullDate(d) {
	if (d.toString().length == 1) {
		d = "0" + d;
	}
	return d;
}
