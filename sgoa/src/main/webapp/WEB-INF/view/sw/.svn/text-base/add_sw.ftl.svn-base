<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Untitled Document</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
        <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/validator.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js" defer="defer"></script>
       	<script type="text/javascript" src="${jsDomain}/js/eWebOffice/eWebOffice.js"></script>
       	<script type="text/javascript" src="${jsDomain}/js/upload/ajaxfileupload.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
            // 设置日期默认值
			$("#textTime").val(getToday());
			// 日期控件
			$("input[name=textTime]").click(function(){
				WdatePicker();
			});
			$("#receiverTime").val(getToday());
			// 日期控件
			$("input[name=receiverTime]").click(function(){
				WdatePicker();
			});
			
			 /**
                 * 收件人选择按钮事件,弹出对话框选择收件人
                 */
                $("#receiverSelect").click(function(){
                    var url = "${appDomain}/common/choose_all_user.htm" + "?ids=" + $("#receiverId").val() + "&r=" + Math.random();
                    var param = 'dialogWidth=780px;dialogHeight=420px;status=no;center=yes;scroll=no';
                    var value = window.showModalDialog(url, '', param);
                    if(value==undefined)
			        	{
			        		  return false;
			     	    }
                    if (value.length > 0) {
                        $("#receiverIds").val(value[1]);
                        $("#receiverId").val(value[0]);
                    }
                });
                
                $("#draftBtn").click(function(){
                	// 提示用户确认信息
                    if(!confirm("确定保存为草稿?")){
                    	return false;
                    }
                	// 添加校验
                	$('form').attr("action", "${appDomain}/sw/draft_sw.htm");
                    	$('form').submit();
                });
                
                $("#submitBtn").click(function(){
	                 // 标题非空校验
					if(!isEmpty($("input[name=title]"),"标题不允许为空！")){
						return;
					}
					 // 收件人非空校验
					if(!isEmpty($("input[name=receiverIds]"),"收件人不允许为空！")){
						return;
					}
					$("#status").val(1);
                    if(!confirm("是否确定提交?")){
                    	return false;
                    }
                   $('form').submit();
		    	
			    });
			    
			    // 加密文件提示
			    $("#security").change(function(){
                	// 提示用户确认信息
                    if($(this).val() == 2){
                    	alert("本系统禁止上传涉密文件！");
                    	$(this).val(1);
                    }
                });
			});
			
		// 文件上传控件
		function ajaxFileUpload() {
			$("#loading").ajaxStart(function(){
				$(this).show();
			})//开始上传文件时显示一个图片
			.ajaxComplete(function(){
				$(this).hide();
			});//文件上传完成将图片隐藏起来
			$.ajaxFileUpload
			(
				{
					url:'${appDomain}/common/file_upload.htm',//用于文件上传的服务器端请求地址
					secureuri:false,//一般设置为false
					fileElementId:'srcUploadFile',//文件上传空间的id属性  <input type="file" id="file" name="file" />
					dataType: 'json',//返回值类型 一般设置为json
					success: function (data, status)  //服务器成功响应处理函数
					{
						if (data.fileDir != "undefined" && data.fileDir != undefined){
							var htmlUrl = "<span id=\"div"+ data.fileDir +"\">";
							htmlUrl = htmlUrl + data.message;
							htmlUrl = htmlUrl + "<input type=\"hidden\" name=\"srcFileName\" value=\"" + data.fileDir + "\" />";
							htmlUrl = htmlUrl + "<input type=\"hidden\" name=\"fileDir\" value=\"" + data.message + "\" />";
							htmlUrl = htmlUrl + "<a href=\"#\" class=\"cancel\" onclick=\"removeOldFile(event,'" + data.fileDir + "')\"></a>";
							htmlUrl = htmlUrl + "</span>";
							$('#fileDirDiv').html(htmlUrl);
						}
					},
					error: function (data, status, e)//服务器响应失败处理函数
					{
						alert(e);
					}
				}
			)
			return false;
		}
		
        </script>
    </head>
    <body>
		<div id="main">
          <div class="main_nav">
            <#include "sw/menu.ftl">
            <div id="content">
           <div class="pstty"><h4>文件处理单</h4>
		        <form class="f0" action="${appDomain}/sw/add_sw.htm" enctype="multipart/form-data" method="POST">
		        	<input type="hidden" id="currentOptId" name="currentOptId" value="" />
		        	<input type="hidden" id="nextOptId" name="nextOptId" value="" />
		        	<input type="hidden" id="status" name="status" value="" />
		        	<input class="text" type="hidden" id="step"  name="step" value="1"  />
		            <table class="stty">
		            <tr class="yty">
					    <td colspan="3" class="rre"><B>全宗号：</B>
					      <input type="text" name="fondsNum" value=""/>
					      </td>
					  <td colspan="3" class="rre">
					       <B>全宗名称：</B>
					      <input type="text" name="fondsName" value=""/>
					      </td>
					    </tr>
					  <tr>
					    <th width="9%">来文单位：</th>
					    <td>
					     <input type="text" name="fileDept" value=""/>
					     </td>
					     <th width="9%">文件编号：</th>
					    <td>
					     <input type="text" name="fileNum" value=""/>
					     </td>
					     <th width="9%">缓急程度：</th>
					    <td>
					      <select name="urgent">
                					 	<option value= 1>正常</option>
                                      	<option value= 2>加急</option>
                                      	<option value= 3>特急</option>
                                      	<option value= 4>紧急</option>
                                      	<option value= 5>特提</option>
                         </select>
					     </td>
					  </tr>
					  <tr>
					   <!-- <th width="9%">成文时间：</th>
					    <td>
					     <input type="text" name="textTime" id="textTime" value=""/>
					     </td>-->
					     <th width="9%">收文时间：</th>
					    <td>
					     <input type="text" name="receiverTime" id="receiverTime" value=""/>
					     </td>
					     <th width="9%">登记号：</th>
					    <td>
					     <input type="text" name="registerNum" value=""/>
					     </td>
					     <th width="9%">密　　级：</th>
					    <td>
					      <select name="security" id="security">
                					 	<option value= 1>普通</option>
                                      	<option value= 2>加密</option>
                         </select>
					     </td>
					    </tr>
					  <tr>
		                    <th>督　　办：</th>
					    	<td colspan="7"><input type="checkbox" name="supervise" checked="true" value="1" style="width:auto;" />是否列为督办</td>
		                </tr>
					  <tr>
					    <th>文件标题：</th>
					    <td colspan="7"><input type="text" name="title" class="wid" value=""/></td>
					    </tr>
					    <tr>
					    <th>收件人：</th>
					    <td colspan="7">
					     <input type="hidden" id="receiverId" name="receiverId" value="" />
		                 <input id="receiverIds" name="receiverIds" type="text" value="" readonly="readonly" />
		                 <input id="receiverSelect" type="button" class="btn" value="选择" />
					    </tr>
					  <tr>
					    <th rowspan="2">附　　件：</th>
					    <td colspan="7">
					    <input type="file" class=" " name="srcUploadFile" id="srcUploadFile">
                    	<input type="button" id="uploadBtn" class="btn" onclick="return ajaxFileUpload();" value="上传"/>
                    	<img src="${jsDomain}/js/upload/loading.gif" id="loading" style="display: none;">
					    </td>
					    </tr>
					    <tr>
						<td colspan="7">
	                    	<div id="fileDirDiv" style="height:30px;border: 2px solid green;overflow-y:scroll;overflow-x:hidden; width:95%;"></div>
	                    </td>
					  </tr>	
		             <tr class="act">
		                    <td colspan="8">
		                        <input id="draftBtn" class="btn" name="draftBtn" type="button" value="保存登记" />
		                        <input id="cancelBtn" class="btn" name="draftBtn" type="reset" value="取消按钮" />
		                    </td>
		                </tr>
		            </table>
		        </form>
			</div>
		   </div>
		   </div>
		</div>	
    </body>
</html>