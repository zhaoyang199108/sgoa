<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Untitled Document</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
        <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/suggest.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/validator.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js" defer="defer"></script>
       	<script type="text/javascript" src="${jsDomain}/js/eWebOffice/eWebOffice.js"></script>
       	<script type="text/javascript" src="${jsDomain}/js/upload/ajaxfileupload.js"></script>
       	<script type="text/javascript" src="${jsDomain}/js/search/c.diseases.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
             $("#fileNum").diseases({attachObject:'#diseases',url:'${appDomain}/common/docin_fileNum_list.htm'});
            
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
			$("input[name=blqx]").click(function(){
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
                	$('form').attr("action", "${appDomain}/docin/draft_docin.htm");
                    	$('form').submit();
                });
                
                $("#submitBtn").click(function(){
	                 // 标题非空校验
					if(!isEmpty($("input[name=title]"),"标题不允许为空！")){
						return;
					}
					
					//如果登录人是机要员，直接提交主任
					var userzwjyy = document.getElementById("userzwjyy").value; 
					var loginIdbgszr = document.getElementById("loginIdbgszr").value; 
					if(userzwjyy == 15){
						$("#nextOptId").val(loginIdbgszr);
					}
					else{
                    if(!confirm("请选择审批人!")){
                    	return false;
                    }
                    // 添加校验
                    // 选择提交审核人
                    var url = "${appDomain}/common/choose_approval_user_all.htm?step="+$("#step").val()+"&approvalId=" + $("#approvalId").val()+"&r=" + Math.random();
                    var param = 'dialogWidth=380px;dialogHeight=380px;status=no;center=yes;scroll=no';
                    
                    var value = window.showModalDialog(url, '', param);
                    if(value==undefined)
		        	{
		        		  return false;
		     	    }
                    if (value.length == 0) {
                        alert("未选择提交人,请重新提交!是否现在选择审批人?");
                        return false;
                    }
                    $("#nextOptId").val(value[0]);
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
							htmlUrl = htmlUrl + "<a href=\"#\" class=\"cancel\" onclick=\"removeOldFile(event,'" + data.fileDir + "')\"></a>";
							htmlUrl = htmlUrl + "</span>";
							if($('#fileDirDiv').html() != "" && $('#srcFileName').val() != "" && $('#fileDir').val() !=""){
								$("#fileDirDiv").html($("#fileDirDiv").html()+','+htmlUrl);
								$("#srcFileName").val($("#srcFileName").val()+','+data.fileDir);
		            			$("#fileDir").val($("#fileDir").val()+','+data.message);
							}
							else{
								$('#fileDirDiv').html(htmlUrl);
								$('#srcFileName').val(data.fileDir);
		            			$('#fileDir').val(data.message);
							}
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
		function removeOldFile(evt, id){
		
			$.ajax({
	            type: 'GET',
	            contentType: 'application/json',
	            url: '/common/file_delete.htm',
	            dataType: 'json',
	            data: 'fileNameDel=' + encodeURI(id) + '&r=' + Math.random(),
	            success: function(data){
	            },
	            error: function(){
		            // 失败
		            return false;
	            }
	        });
	        // 成功
         	var el = evt.target == null ? evt.srcElement : evt.target;
		    var div = el.parentNode;
		    var cont = document.getElementById('fileDirDiv');    
		    if(cont.removeChild(div) == null){
		        return false;
		    }
		    return true;
		}
		
		// 文件类型
		function wjlx(cs) {
		    var d = new Date();
		    var year = d.getFullYear();
		    var month = d.getMonth() + 1;
		    var date = d.getDate();
		    var day = d.getDay();
		    var curDateTime = year;
		    if (month > 9){
		    curDateTime = curDateTime + month;}
		    else{
		    curDateTime = curDateTime + "0" + month;}
		    if (date > 9){
		    curDateTime = curDateTime + date;}
		    else{
		    curDateTime = curDateTime + "0" + date;}
			if(cs ==1)
        	{
        		$.ajax({
	            type: 'GET',
	            contentType: 'application/json',
	            url: '/docin/max_docin.htm',
	            dataType: 'json',
				data: 'reNum='+curDateTime+'&r=' + Math.random(),
				success: function(data){
					// 从Controller里取得对象
	            	var docinObj = data.docinStr;
	            	if(docinObj==undefined){
	            		var abc='B_'+''+curDateTime+''+'001';
        				$('#registerNum').val(abc);
        				$('#approvalId').val(26);
        				$('#approvalName').val("收文流程");
	            	}
	            	else{
	            		var str = docinObj;
	            	    str++;
						if(str.toString().length == 1){
							str = "00" + str;
							var abc='B_'+''+curDateTime+''+str;
        					$('#registerNum').val(abc);
        					$('#approvalId').val(26);
        					$('#approvalName').val("收文流程");
						}
						else if(str.toString().length == 2){
							str = "0" + str;
							var abc='B_'+''+curDateTime+''+str;
        					$('#registerNum').val(abc);
        					$('#approvalId').val(26);
        					$('#approvalName').val("收文流程");
						}
						else{
							var abc='B_'+''+curDateTime+''+str;
        					$('#registerNum').val(abc);
        					$('#approvalId').val(26);
        					$('#approvalName').val("收文流程");
						}
	            	}
	            }
	        	});
        		
     	    }
     	    if(cs==2)
        	{
        		$.ajax({
	            type: 'GET',
	            contentType: 'application/json',
	            url: '/docin/max_docin.htm',
	            dataType: 'json',
				data: 'reNum='+curDateTime+'&r=' + Math.random(),
				success: function(data){
					// 从Controller里取得对象
	            	var docinObj = data.docinStr;
	            	if(docinObj==undefined){
	            		var abc='C_'+''+curDateTime+''+'001';
        				$('#registerNum').val(abc);
        				$('#approvalId').val(26);
        				$('#approvalName').val("收文流程");
	            	}
	            	else{
	            		var str = docinObj;
	            	    str++;
						if(str.toString().length == 1){
							str = "00" + str;
							var abc='C_'+''+curDateTime+''+str;
        					$('#registerNum').val(abc);
        					$('#approvalId').val(26);
        					$('#approvalName').val("收文流程");
						}
						else if(str.toString().length == 2){
							str = "0" + str;
							var abc='C_'+''+curDateTime+''+str;
        					$('#registerNum').val(abc);
        					$('#approvalId').val(26);
        					$('#approvalName').val("收文流程");
						}
						else{
							var abc='C_'+''+curDateTime+''+str;
        					$('#registerNum').val(abc);
        					$('#approvalId').val(26);
        					$('#approvalName').val("收文流程");
						}
	            	}
	            }
	        	});
     	    }
     	    if(cs==3)
        	{
        		$.ajax({
	            type: 'GET',
	            contentType: 'application/json',
	            url: '/docin/max_docin.htm',
	            dataType: 'json',
				data: 'reNum='+curDateTime+'&r=' + Math.random(),
				success: function(data){
					// 从Controller里取得对象
	            	var docinObj = data.docinStr;
	            	if(docinObj==undefined){
	            		var abc='T_'+''+curDateTime+''+'001';
        				$('#registerNum').val(abc);
        				$('#approvalId').val(34);
        				$('#approvalName').val("收文(特办件)");
	            	}
	            	else{
	            		var str = docinObj;
	            	    str++;
						if(str.toString().length == 1){
							str = "00" + str;
							var abc='T_'+''+curDateTime+''+str;
        					$('#registerNum').val(abc);
        					$('#approvalId').val(34);
        					$('#approvalName').val("收文(特办件)");
						}
						else if(str.toString().length == 2){
							str = "0" + str;
							var abc='T_'+''+curDateTime+''+str;
        					$('#registerNum').val(abc);
        					$('#approvalId').val(34);
        					$('#approvalName').val("收文(特办件)");
						}
						else{
							var abc='T_'+''+curDateTime+''+str;
        					$('#registerNum').val(abc);
        					$('#approvalId').val(34);
        					$('#approvalName').val("收文(特办件)");
						}
	            	}
	            }
	        	});
     	    }
			
		}
        </script>
    </head>
    <body>
		<div id="main">
          <div class="main_nav">
            <#include "docin/menu.ftl">
            <div id="content">
           <div class="pstty"><h4>文件处理单</h4>
		        <form class="f0" action="${appDomain}/docin/add_docin.htm" enctype="multipart/form-data" method="POST">
		        	<input type="hidden" id="currentOptId" name="currentOptId" value="" />
		        	<input type="hidden" id="nextOptId" name="nextOptId" value="" />
		        	<input type="hidden" id="status" name="status" value="" />
		        	<input class="text" type="hidden" id="step"  name="step" value="1"  />
		        	<input type="hidden" id="userzwjyy" name="userzwjyy" value="${userzwjyy}" />
		        	<input type="hidden" id="loginIdbgszr" name="loginIdbgszr" value="${loginIdbgszr}" />
		        	<input type="hidden" id="loginIdbgszrname" name="loginIdbgszrname" value="${loginIdbgszrname}" />
		            <table class="stty">
		            <tr class="yty">
					    <td colspan="2" class="rre"><B>全宗号：</B>
					      <input type="text" id="fondsNum" name="fondsNum" value=""/>
					      </td>
					    <td colspan="2" class="rre02">
					      <input type="radio" id="category" name="category" value="1" onclick="return wjlx(1);"/>办理件
						  <input type="radio" id="category" name="category" value="2" onclick="return wjlx(2);"/>传阅件
						  <input type="radio" id="category" name="category" value="3" onclick="return wjlx(3);"/>特办件
 						</td>
					  <td colspan="2" class="rre">
					       <B>全宗名称：</B>
					      <input type="text" id="fondsName" name="fondsName" value="四川省新闻出版广电局"/>
					      </td>
					    </tr>
					  <tr>
					    <th width="9%">来文单位：</th>
					    <td>
					     <input type="text" name="fileDept" id="fileDept" value=""/>
					     </td>
					     <th width="9%">文件编号：</th>
					    <td>
					     <input type="text" name="fileNum" id="fileNum" value=""/>
					     <div id='diseases' style="width:215px;"></div>
					     </td>
					     <th width="9%">缓急程度：</th>
					    <td>
					      <select name="urgent" id="urgent">
                					 	<option value= 1>正常</option>
                                      	<option value= 2>加急</option>
                                      	<option value= 3>特急</option>
                                      	<option value= 4>紧急</option>
                                      	<option value= 5>特提</option>
                         </select>
					     </td>
					  </tr>
					  <tr>
					    <!--<th width="9%">成文时间：</th>
					    <td>
					     <input type="text" name="textTime" id="textTime" value=""/>
					     </td>-->
					     <th width="9%">收文时间：</th>
					    <td>
					     <input type="text" name="receiverTime" id="receiverTime" value=""/>
					     </td>
					      <th width="9%">登记号：</th>
					    <td>
					     <input type="text" name="registerNum" id="registerNum" value="" />
					     </td>
					     <th width="9%">办理期限：</th>
					    <td>
					       <input type="text" name="blqx" id="blqx" value=""/>
					     </td>
					    </tr>
					  <tr>
		                     <th>
		                      	收文流程：
		                    </th>
		                    <td>
		                    <input type="hidden" name="approvalId" id="approvalId" value="" readonly="readonly"/>
		                    <input type="text" name="approvalName" id="approvalName" value="" readonly="readonly"/>
		                    </td>
		                    <th>督　　办：</th>
					    	<td colspan="3"><input type="checkbox" id="supervise" name="supervise" checked="true" value="1" style="width:auto;" />是否列为督办</td>
		                </tr>
					  <tr>
					    <th>文件标题：</th>
					    <td colspan="5"><input type="text" name="title" id="title" class="wid" value=""/></td>
					    </tr>
					  <tr>
					    <th rowspan="2">附　　件：</th>
					    <td colspan="5">
					    <input type="file" class=" " name="srcUploadFile" id="srcUploadFile">
                    	<input type="button" id="uploadBtn" class="btn" onclick="return ajaxFileUpload();" value="上传"/>
                    	<img src="${jsDomain}/js/upload/loading.gif" id="loading" style="display: none;">
					    </td>
					    </tr>
					    <tr>
						<td colspan="5">
							<input type="hidden" id="srcFileName" name="srcFileName" value="">
							<input type="hidden" id="fileDir" name="fileDir" value="">
	                    	<div id="fileDirDiv" style="height:30px;border: 2px solid green;overflow-y:scroll;overflow-x:hidden; width:95%;"></div>
	                    </td>
					  </tr>	
					   <tr>
					    <th>局　　长<br />意　　见</th>
					    <td colspan="5" height="130" ><textarea name="textarea" id="textarea" class="tt"></textarea></td>
					    </tr>
					  <tr>
					    <th>分管领导<br />意　　见</th>
					    <td colspan="5" height="130"><textarea name="textarea" id="textarea" class="tt"></textarea></td>
					    </tr>
					  <tr>
					    <th>承办处室<br />意　　见</th>
					    <td colspan="5" height="80"><textarea name="textarea" id="textarea" class="tt02"></textarea></td>
					    </tr>
					  <tr>
					    <th>办公室<br />意　　见</th>
					    <td colspan="5" height="80"><textarea name="textarea" id="textarea" class="tt02"></textarea></td>
					    </tr>
		             <tr class="act">
		                    <td colspan="6">
		                        <input id="draftBtn" class="btn" name="draftBtn" type="button" value="保存" />
		                        <input id="submitBtn" class="btn" name="draftBtn" type="button" value="确认提交" />
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