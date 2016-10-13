<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>编写文稿拟订</title>  
    <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
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
			   var title=$('#title').val();
				// 标题非空校验
				if(!isEmpty($("input[name=receiverIds]"),"收件人不能为空！")){
					return;
				}
				if(!isEmpty($("input[name=title]"),"标题不能为空！")){
					return;
				}	
				if(!isEmpty($("textarea[name=msgoneText]"),"内容不能为空！")){
					return;
				}				
				$("input[name=msgStatus]").val("Y");		
				 if(!confirm("确定发送?")){
                    	return false;
                  }
   	 			if($("#isSendMsg").is(":checked")) {
		         $.ajax({
		            type: 'GET',
		            contentType: 'application/json',
		            url: '/common/send_msgone.htm',
		            dataType: 'json',
		            data: 'userLoginId=' + $("#receiverIds").val() + '&memo=' + encodeURI(encodeURI($("#phoneText").val())) + '&r=' + Math.random(),
		            success: function(data){
		             // 成功
		            },
		            error: function(){
		             // 失败
		            }
		        });
		        }
				$('form').attr("action", "${appDomain}/msgone/write_review.htm");
				if(DoCheckSubmit())
                {
                	$('form').submit();
                } 	   
			});
			
			$("#draftBtn").click( function() {
				var title=$('#title').val();
				// 标题非空校验
				if(!isEmpty($("input[name=receiverIds]"),"收件人不能为空！")){
					return;
				}
				if(!isEmpty($("input[name=title]"),"标题不能为空！")){
					return;
				}	
				$("input[name=msgStatus]").val("N");
				if(!confirm("确定保存为草稿?")){
                    	return false;
                  }
                $('form').attr("action", "${appDomain}/msgone/draft_review.htm");
				if(DoCheckSubmitForNg())
                {
                	$('form').submit();
                } 			
			});
				
		    $("#cancelBtn").click( function() {
                $('form').attr("action", "${appDomain}/msgone/msgoneInbox_list.htm");
				$('form').submit();				
				});
		});
	</script>
		<script type="text/javascript">
		function DoCheckSubmit(){
			try{    	
			    eWebOffice1.RecordID = $("#dRecordid").val();
			  	eWebOffice1.WebSaveVersion("版本描述", false)
			  	eWebOffice1.RecordID = $("#d_templateid").val();
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
	//控件初始化事件
	eWebOffice1.QuickBarCommentVisible = true;
	//标题栏、快捷工具栏、边框等界面相关设置可以在此事件中作，使得界面上不会有转变过程显现
	//如：隐藏快捷工具栏。当访问此网页时，如在OnLoad中设，则会先显示出工具栏，再看到工具栏没了。如在OnInit中设，直接打开就看不到。没有这个变化过程。
	eWebOfficeJS.SetWorkModeOnInit("eWebOffice1", "comment");
</script>

<script type="text/javascript" for="eWebOffice1" event="OnDocumentAfterOpen()">
	//文档打开后触发此事件
	//在此事件中设置初始Office菜单、工具栏、痕迹、保护等。
	eWebOfficeJS.SetWorkModeOnOpen("eWebOffice1", "comment");
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
	 <#include "msgone/menu.ftl">
		<div id="content">
		<h3 class="title"><font size="3"><strong>文稿拟订回复</strong></font></h3>
			<form class="f0" action="${appDomain}/msgone/replay_msgoneInbox.htm" enctype="multipart/form-data" method="POST">
			<input type="hidden" id="d_templateid" name="d_templateid" value="${msgoneInbox.dRecordid}" />   
			<input type="hidden" id="dRecordid" name="dRecordid" value="${d_recordId}" />
			<input type="hidden" id="textId" name="textId" value="${msgoneInbox.textId}" />
				<div class="ct">
				<table class="ftb">
					<tr>					    
						 <th>收件人:</th>
						 <td>
		                 <input class="txt title" type="hidden" id="receiverIds" name="receiverIds" value="${msgoneInbox.senderId}" />
		                 <input class="txt title" id="receiver" name="receiver" type="text" value="${msgoneInbox.senderName}" readonly="readonly" />
		                 <input id="receiverSelect" type="button" class="btn" value="选择" />
		                 <input class="text" type="hidden" name="msgStatus"/>
		                 </td>
					</tr>
					<tr>					 
						<th>标题:</th>
						<td>
						<input class="txt title" type="text" id="title" name="title" value="回复:${msgoneInbox.title}" maxlength="50"/>
						</td>
					</tr>
					
					<tr>					 
						<th>附件:</th>
						<td>
						<input type="file" class="txt title" name="srcUploadFile" id="srcUploadFile">
						</td>
					</tr>							
					<#if loginId=="ybgs">
					<tr>					 
						<th>短信通知:</th>
						<td>
						<input class="txt title" type="text" id="phoneText" name="phoneText" maxlength="70"/>
						<input type="checkbox" id="isSendMsg" checked="true" />是否发送短信
						</td>
					</tr>
					</#if>	
					<tr class="act">
				       <td colspan="2">	
				       
						<input type="button" id="saveBtn" class="btn" value="发送"/>
						<input type="button" id="draftBtn" class="btn" value="保存草稿"/>						
						<input type="reset" id="cancelBtn" class="btn" value="取 消" />
						</td>
					</tr>
					</table>
				</div>
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
