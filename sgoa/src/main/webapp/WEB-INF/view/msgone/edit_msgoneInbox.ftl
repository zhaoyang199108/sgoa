<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>文稿拟订转发</title>  
	<link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/volatile.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/xheditor/xheditor-1.1.11-zh-cn.min.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/eWebOffice/eWebOffice.js"></script>
	<script type="text/javascript">
		$(document).ready( function() {
		
			//初始化xhEditor编辑器插件
			$("#ct").xheditor({
				tools:'full',
				skin:'default',
				upMultiple:false,
				upImgUrl: "${homeDomain}/upload_image.htm?dir=msgone",
				upImgExt: "jpg,jpeg,gif,bmp,png"
			});
			$(".act-down").click(function(){
				$("#srcFileName").val($(this).attr("alt"));
				$('form').attr("action","${appDomain}/msgone/download_file.htm");
				$('form').submit();
			});			
		      /**
                 * 收件人选择按钮事件,弹出对话框选择收件人
                 */
                $("#receiverSelect").click(function(){
                    var url = "${appDomain}/common/choose_one_user.htm" + "?ids=" + $("#receiverIds").val() + "&r=" + Math.random();
                    var param = 'dialogWidth=780px;dialogHeight=420px;status=no;center=yes;scroll=no';
                    var value = window.showModalDialog(url, '', param);
                    if(value==undefined)
			        	{
			        		  return false;
			     	    }
                    if (value.length > 0) {
                        $("#receiver").val(value[1]);
                        $("#receiverIds").val(value[0]);
                    }
                });
                
			$("#saveBtn").click( function() {
				$("input[name=msgStatus]").val("Y");
				if ($("#isSendMsg").attr("checked")==true) {
		         $.ajax({
		            type: 'GET',
		            contentType: 'application/json',
		            url: '/common/send_msgone.htm',
		            dataType: 'json',
		            data: 'userLoginId=' + $("#nextOptId").val() + '&memo=' + encodeURI(encodeURI("您有新的物资申领需要审批！")) + '&r=' + Math.random(),
		            success: function(data){
		             // 成功
		            },
		            error: function(){
		             // 失败
		            }
		        });
		        }
				if(DoCheckSubmit())
                {
                	$('form').submit();
                } 
		   
			});
			$("#draftBtn").click( function() {
				$("input[name=msgStatus]").val("N");
				if(DoCheckSubmitForNg())
                {
                	$('form').submit();
                } 
			});
		});
	</script>
		<script type="text/javascript">
		function DoCheckSubmit(){
		  try{    	
		  	eWebOffice1.WebSaveVersion("版本描述", false)
		    return eWebOffice1.WebSave();
		}catch(e){
		    alert("请选安装eWebOffice控件，再操作！");
		    return false;
		}
		}
	
		function DoCheckSubmitForNg(){
		  try{    	
		    return eWebOffice1.WebSave();
		}catch(e){
		    alert("请选安装eWebOffice控件，再操作！");
		    return false;
		}
		}
	</script>
<script type="text/javascript" for="eWebOffice1" event="OnInit()">
    eWebOffice1.QuickBarCommentVisible = false;
</script>
<script type="text/javascript" for="eWebOffice1" event="OnLoad()">
	eWebOffice1.WebUrl = "${jsDomain}/js/eWebOffice/eWebMsgOneAction.jsp";
	eWebOffice1.RecordID = "${msgoneInbox.dRecordid}";
	eWebOffice1.SetTitleIcon ("${appDomain}/images/rr.gif");
	eWebOffice1.TitleCaption="四川省新闻出版广电局政务系统";
	eWebOffice1.WebOpen();
</script>
</head>
<body>	
	<div id="main">
	<div class="main_nav">
		<div id="content">
			<h3 class="title"><font size="3"><strong>文稿拟订转发</strong></font></h3>
			<form class="f0" action="${appDomain}/msgone/update_add.htm" method="POST">
			<input type="hidden" id="dRecordid" name="dRecordid" value="${msgoneInbox.dRecordid}" />
				<table class="ftb">
					<tr>
						<th>收件人:</th>
						<td>
		                 <input type="hidden" id="receiverIds" name="receiverIds" value="${msgoneInbox.senderId}" />
		                 <input class="txt title" id="receiver" name="receiver" type="text" value="${msgoneInbox.senderName}"  readonly="readonly" />
		                 <input id="receiverSelect" type="button" class="btn" value="选择" />
		                 </td>
					</tr>
					<tr>
						<th>标题:</th>
						<td>
						<input class="text" type="hidden" name="msgStatus"/>
						<input class="txt title" type="text" id="title" name="title" value="${msgoneInbox.title}" maxlength="50"/>
						</td>
					</tr>
					<tr>
						<th>附件名:</th>
						<input type="hidden" id="srcFileName" name="srcFileName" value="${msgoneInbox.srcFileName}"/>
						<td><a class="act-down" href="#" alt="${msgoneInbox.srcFileName}">${msgoneInbox.srcFileName}</a>
						</td>
					</tr>									
					<#if loginId=="ybgs">
					<tr>					 
						<th>短信通知:</th>
						<td>
						<input class="txt" type="text" id="phoneText" name="phoneText"  value="${msgoneInbox.phoneText}"maxlength="70"/>
						<input class="check" type="checkbox" id="isSendMsg" checked="true" />是否发送短信
						</td>
					</tr>
					</#if>	
					<tr class="act">
					  <td colspan="6">
						<input type="button" id="saveBtn" class="btn" value="发送"/>
						<input type="button" id="draftBtn" class="btn" value="存草稿箱"/>						
						<input type="button" value="取 消" class="btn" onclick="window.close();"/>
						</td>
					</tr>
				</table>
			</form>
			<!--创建eWebOffice实例-->
			<script type="text/javascript">
			eWebOfficeJS.Create("eWebOffice1", "85%", "700px");
			</script>
		</div>
		</div>
	</div>
</body>
</html>
