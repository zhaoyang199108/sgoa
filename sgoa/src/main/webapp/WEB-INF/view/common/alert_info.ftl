<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>消息提醒</title>
		<base target="_self">
        <link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
		<link href="${jsDomain}/js/message/common.css" type="text/css" rel="stylesheet"/>
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery-1.4.4.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
		<script type="text/javascript">
		
		    $(document).ready(function(){
		    
		    	
		        /**
		         * 人员选择完成后, 点击确认按钮返回父页面
		         */
		        $(".noc_iterm_content").click(function(){
					
		            // 设置返回值数组,用户ID和用户姓名
		            var rtValue = new Array();
		            rtValue[0] = $(this).attr("alt");
		            window.opener = null;
		            window.open('', '_self');
		            window.returnValue = rtValue;
		            window.close();
		        });
		        
		        // 批量删除按钮点击事件
			    $("#zbtxBtn").click(function(){
			        // 被选中的单选框
			        var item = $("input[name=chkItem]:checked");
			        // 校验是否至少选择了一个单选框
			        if (item.length == 0) {
			            alert("请至少选择一条记录进行操作");
			            return false;
			        }
			        
			        if (confirm("确定标记为暂不提醒?")) {
			            // 将所选Checkbox值转换为字符串
			            var value = "";
			            item.each(function(i){
			                if (i > 0) {value += ",";}
			                value += $(this).val();
			            });
						
			            var url = "${appDomain}/common/alert_info_zbtx.htm?r="+ Math.random();
			            $.get(url, {
			                idArray: value
			            }, function(result){
			                alert("操作成功");
			                window.close();
			            });
			        }
			    });
			    
			    // 批量删除按钮点击事件
			    $("#btxBtn").click(function(){
			        // 被选中的单选框
			        var item = $("input[name=chkItem]:checked");
			        // 校验是否至少选择了一个单选框
			        if (item.length == 0) {
			            alert("请至少选择一条记录进行操作");
			            return false;
			        }
			        
			        if (confirm("确定标记为不提醒?")) {
			            // 将所选Checkbox值转换为字符串
			            var value = "";
			            item.each(function(i){
			                if (i > 0) {value += ",";}
			                value += $(this).val();
			            });
						
			            var url = "${appDomain}/common/alert_info_btx.htm?r="+ Math.random();
			            $.get(url, {
			                idArray: value
			            }, function(result){
			                alert("操作成功");
			                window.close();
			            });
			        }
			    });
			    
			    // 批量删除按钮点击事件
			    $("#hftxBtn").click(function(){
			        // 被选中的单选框
			        var item = $("input[name=chkItem]:checked");
			        // 校验是否至少选择了一个单选框
			        if (item.length == 0) {
			            alert("请至少选择一条记录进行操作");
			            return false;
			        }
			        
			        if (confirm("确定标记为不提醒?")) {
			            // 将所选Checkbox值转换为字符串
			            var value = "";
			            item.each(function(i){
			                if (i > 0) {value += ",";}
			                value += $(this).val();
			            });
						
			            var url = "${appDomain}/common/alert_info_hftx.htm?r="+ Math.random();
			            $.get(url, {
			                idArray: value
			            }, function(result){
			                alert("操作成功");
			                window.close();
			            });
			        }
			    });
			        
		    });
		</script>
    </head>
    <body>
	     <div class="new_noc_list">
	     <a class="noc_iterm_content" href="#" alt="${appDomain}/remind/remind_list.htm">
	     <div class="topwo">
	     </div>
	     </a>
	     	<ul class="noc_iterm_data">
		 		<li><input type="checkbox" name="chkItem" value="1" />通知：
		 			<a class="noc_iterm_content" href="#" alt="${appDomain}/message/message_review_list.htm?sort=1">您有待办事项<span>${amInfoMessage}</span>个</a>
		 		</li>
		 		<li><input type="checkbox" name="chkItem" value="2" />公告：
		 			<a class="noc_iterm_content" href="#" alt="${appDomain}/notice/notice_review_list.htm?sort=2">您有待办事项<span>${amInfoNotice}</span>个</a>
		 		</li>
		 		<li><input type="checkbox" name="chkItem" value="3" />发文：
		 			<a class="noc_iterm_content" href="#" alt="${appDomain}/docout/docout_review_list.htm">您有待办事项<span>${amInfoDocout}</span>个</a>
		 		</li>
		 		<li><input type="checkbox" name="chkItem" value="4" />收文：
		 			<a class="noc_iterm_content" href="#" alt="${appDomain}/docin/docin_review_list.htm">您有待办事项<span>${amInfoDocin}</span>个</a>
		 		</li>
		 		<li><input type="checkbox" name="chkItem" value="8" />站内信：
		 			<a class="noc_iterm_content" href="#" alt="${appDomain}/msg/msgInbox_list.htm">您有站内信<span>${amInfoMsg}</span>个</a>
		 		</li>
		 		<li><input type="checkbox" name="chkItem" value="7" />会议预约：
		 			<a class="noc_iterm_content" href="#" alt="${appDomain}/meetingYy/meetingYy_review_list.htm">您有待办事项<span>${amInfoMeeting}</span>个</a>
		 		</li>
		 		<li><input type="checkbox" name="chkItem" value="6" />个人日程：
		 			<a class="noc_iterm_content" href="#" alt="${appDomain}/scheduler/scheduler.htm">您有个人日程提醒<span>${amInfoScheduler}</span>个</a>
		 		</li>
		 		<li><input type="checkbox" name="chkItem" value="5" />工作日程：
		 			<a class="noc_iterm_content" href="#" alt="${appDomain}/workscheduler/work_scheduler.htm">您有工作日程提醒<span>${amInfoWorkScheduler}</span>个</a>
		 		</li>
		 		<li><input type="checkbox" name="chkItem" value="9" />局领导重大活动：
		 			<a class="noc_iterm_content" href="#" alt="${appDomain}/leaderscheduler/leader_scheduler_check.htm">局领导重大活动提醒<span>${amInfoLeaderScheduler}</span>个</a>
		 		</li>
		 		<li><input type="checkbox" name="chkItem" value="10" />文稿拟定：
		 			<a class="noc_iterm_content" href="#" alt="${appDomain}/msgone/msgoneInbox_list.htm">您有文稿拟定提醒<span>${amInfoMsgOne}</span>个</a>
		 		</li>
		 		<li><input type="checkbox" name="chkItem" value="12" />每日要情：
		 			<a class="noc_iterm_content" href="#" alt="${appDomain}/news/news_review_list.htm?sort=1">您有每日要情提醒<span>${amInfoNews}</span>个</a>
		 		</li>
		 		<li><input type="checkbox" name="chkItem" value="13" />简报：
		 			<a class="noc_iterm_content" href="#" alt="${appDomain}/brief/brief_review_list.htm?sort=2">您有简报提醒<span>${amInfoBrief}</span>个</a>
		 		</li>
		 		<li>备忘录：
		 			<a class="noc_iterm_content" href="#" alt="${appDomain}/alert/alert_list.htm">您有备忘提醒<span>${amInfoAlert}</span>个</a>
		 		</li>
		 	</ul>
		 	<div style="margin-top:10px; width:440px; padding:3px; border-top:2px solid #FF0000; background:#FFF;">
                <input style="margin-right:5px;" type="checkbox" id="allBtn" name="allBtn" value="" />全选
                <input type="button" class="but" id="zbtxBtn" name="zbtxBtn" value="暂不提醒" />
                <input type="button" class="but" id="hftxBtn" name="hftxBtn" value="恢复提醒" />
                <input type="button" class="but" id="btxBtn" name="btxBtn" value="不提醒" />
	        </div>
		 </div>
    </body>
</html>