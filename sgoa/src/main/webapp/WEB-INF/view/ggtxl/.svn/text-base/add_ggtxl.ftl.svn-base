<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>公共通讯录添加页面</title>  
    <link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
    <link href="${cssDomain}/css/addressbook.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js" defer="defer"></script>
	<script type="text/javascript" src="${jsDomain}/js/xheditor/xheditor-1.1.11-zh-cn.min.js"></script>        
	<script type="text/javascript" src="${jsDomain}/js/upload/ajaxfileupload.js"></script>
	<script type="text/javascript">
		$(document).ready( function() {
		// 日期控件
			$("input[name=birthday]").click(function(){
				WdatePicker();
			});
			$("#saveBtn").click( function() {
			    // 分组非空校验
				if(!isEmpty($("select[name=typeId]"),"分组不允许为空！")){
					return;
				}
				// 姓名非空校验
				if(!isEmpty($("input[name=addName]"),"姓名不允许为空！")){
					return;
				}
				if(""!=$("input[name=email]").val()&&null!=$("input[name=email]").val()){	
					// 邮件是否合法校验
					if(!isEmail($("input[name=email]"),"邮件不合法！请重新输入")){
						return;
					}
				}
				$('form').submit();
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
					url:'${appDomain}/common/image_upload.htm',//用于文件上传的服务器端请求地址
					secureuri:false,//一般设置为false
					fileElementId:'srcUploadFile',//文件上传空间的id属性  <input type="file" id="file" name="file" />
					dataType: 'json',//返回值类型 一般设置为json
					success: function (data, status)  //服务器成功响应处理函数
					{
						if (data.fileDir != "undefined" && data.fileDir != undefined){
							$('#imgPhoto').attr("src",data.fileDir);
							$('#photo').val(data.fileDir);
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
	<div class="xjlx">
			<h3 class="title"><font size="3"><strong>新增公共通讯录</strong></font></h3>
			<form class="f0" action="${appDomain}/ggtxl/add_ggtxl.htm" method="POST">
			<table class="tableblock">
			 <tr>
			      <td   colspan="3" class="tableheader"><b>&nbsp;个人信息</b></td>
			    </tr>
			    <tr> <td> 排序号：</td>
			      <td  >
			        <input type="text" maxlength="50" size="12" name="sorting">
			      </td>
			      <td width="250" rowspan="6"  >
			<center>
			<img width="248" height="208" id="imgPhoto">
			</center>	
			      </td>
			    </tr>
			    <tr> <td> 姓名：</td>
			      <td  >
			        <input type="text" maxlength="50" size="20" name="addName">
			      </td>
			    </tr>
			    <tr> <td> 性别：</td>
			      <td  >
			        <select class="BigSelect" name="gender">
			          <option value="1">男</option>
			          <option value="0">女</option>
			        </select>
			      </td>
			    </tr>
			     <tr> <td> 是否公共：</td>
			      <td  >
			        <select class="BigSelect" name="ismm">
			          <option value="Y">公共</option>
			          <option value="N">紧急</option>
			        </select>
			      </td>
			    </tr>
			    <tr>
			      <td   >生日：</td>
			      <td  >
			        <input type="text"  maxlength="10" size="10" name="birthday">
			    
			      </td>
			    </tr>
			     <tr>
			      <td  > 年龄：</td>
			      <td  >
			        <input width="60" type="text" size="25" name="age">
			      </td>
			    </tr>
			    <tr>
			      <td  > 昵称：</td>
			      <td  >
			        <input width="60" type="text" size="25" name="nickName">
			      </td>
			    </tr>
			    <tr>
			      <td   > 职务：</td>
			      <td  >
			        <input width="60" type="text"  size="25" name="duties">
			      </td>
			    </tr>
			    <tr>
			      <td   > 配偶：</td>
			      <td colspan="2" >
			        <input width="60" type="text"  size="25" name="spouse">
			      </td>
			    </tr>
			    <tr>
			      <td   > 子女：</td>
			      <td colspan="2" >
			        <input width="60" type="text"  size="25" name="children">
			      </td>
			    </tr>
			    
			    <tr>
			      <td  > 联系人照片上传：</td>
			      <td colspan="2" >
			        <input width="60" type="hidden" id="photo" name="photo">
			        <input type="file" title="选择照片上传"  size="40" name="srcUploadFile" id="srcUploadFile">
			        <input type="button" id="uploadBtn" onclick="return ajaxFileUpload();" value="上传" style="height:23px;height:18px \9;"/>
					<img src="${jsDomain}/js/upload/loading.gif" id="loading" style="display: none;">
			      </td>
			    </tr>
			
			    <tr>
			      <td   colspan="3" class="tableheader" ><b>&nbsp;联系方式（单位）</b></td>
			    </tr>
			
			    <tr>
			      <td   > 单位名称：</td>
			      <td colspan="2">
			        <input width="60" type="text"  size="25" name="unitName">
			      </td>
			    </tr>
			
			    <tr>
			      <td   >单位地址：</td>
			      <td colspan="2" >
			        <input type="text" maxlength="100" size="40" name="unitAddress">
			      </td>
			    </tr>
			
			    <tr>
			      <td   > 单位邮编：</td>
			      <td colspan="2" >
			        <input width="60" type="text"  size="25" name="unitCode">
			      </td>
			    </tr>
			
			    <tr>
			      <td   > 工作电话：</td>
			      <td colspan="2" >
			        <input width="60" type="text" size="25" name="unitTel">
			      </td>
			    </tr>
			
			    <tr>
			      <td   > 工作传真：</td>
			      <td colspan="2" >
			        <input width="60" type="text"  size="25" name="unitFax">
			      </td>
			    </tr>
			
			    <tr>
			      <td   colspan="3" class="tableheader" ><b>&nbsp;联系方式（家庭）</b></td>
			    </tr>
			
			    <tr>
			      <td   > 家庭住址：</td>
			      <td colspan="2" >
			        <input type="text"  maxlength="100" size="40" name="homeAddress">
			      </td>
			    </tr>
			
			    <tr>
			      <td   > 家庭邮编：</td>
			      <td colspan="2" >
			        <input width="60" type="text"  size="25" name="homeCode">
			      </td>
			    </tr>
			
			    <tr>
			      <td   > 家庭电话：</td>
			      <td colspan="2">
			        <input width="60" type="text" size="25" name="homeTel">
			      </td>
			    </tr>
			
			    <tr>
			      <td   > 手机：</td>
			      <td colspan="2"  >
			        <input width="60" type="text" size="25" name="cellPhone">
			      </td>
			    </tr>
			
			    <tr> <td> 小灵通：</td>
			      <td colspan="2"  >
			        <input width="60" type="text"  size="25" name="homePhs">
			      </td>
			    </tr>
			
			    <tr> <td> 电子邮件：</td>
			      <td colspan="2"  >
			        <input type="text" maxlength="80" size="25" name="email">
			      </td>
			    </tr>
			
			    <tr> <td> QQ：</td>
			      <td colspan="2"  >
			        <input width="60" type="text"   size="25" name="qq">
			      </td>
			    </tr>
			
			    <tr> <td> MSN：</td>
			      <td colspan="2"  >
			        <input width="60" type="text" size="25" name="msn">
			      </td>
			    </tr>
			    <tr>
			      <td   colspan="3" class="tableheader"><b>&nbsp;备　注</b></td>
			    </tr>
			    <tr>
			      <td colspan="3"  >
			        <textarea wrap="on" rows="5" name="remark" cols="60"></textarea>
			      </td>
			    </tr>
			    <tr>
			      <td colspan="3">
			       </td>
			    </tr>
			    <tr align="center" >
			      <td   colspan="3">
			        <input type="button" id="saveBtn" class="btn" value="保 存" />&nbsp;&nbsp;
					<input type="button" value="返 回" class="btn" onclick="window.close();" />
			      </td>
			    </tr>
			  </tbody></table>
			  </form>
			</div>	  				
    </body>
</html>