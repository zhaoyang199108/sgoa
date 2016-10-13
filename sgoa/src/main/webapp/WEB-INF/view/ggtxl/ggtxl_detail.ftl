<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>办公用品添加页面</title>  
    <link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
    <link href="${cssDomain}/css/addressbook.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js" defer="defer"></script>
	<script type="text/javascript" src="${jsDomain}/js/xheditor/xheditor-1.1.11-zh-cn.min.js"></script>        
	<script type="text/javascript" src="${jsDomain}/js/upload/ajaxfileupload.js"></script>
</head>
<body>
	<div class="xjlx">
			<h3 class="title"><font size="3"><strong>详细公共通讯录</strong></font></h3>
			<form class="f0" action="${appDomain}/ggtxl/add_ggtxl.htm" method="POST">
			<input type="hidden" id="id" name="id" value="${ggtxl.id}" />
			<table class="tableblock">
			 <tr>
			      <td   colspan="3" class="tableheader"><b>&nbsp;个人信息</b></td>
			    </tr>
			    <tr> <td> 排序号：</td>
			      <td  >
			        <input type="text" maxlength="50" size="12" name="sorting"  value="${ggtxl.sorting}">
			      </td>
			      <td width="250" rowspan="6"  >
			<center>
			<#if ggtxl.photo==null><img src="${imageDomain}/images/0.png" width="128" height="128" id="imgPhoto"/>
			<#else><img src="${ggtxl.photo}" width="248" height="208" id="imgPhoto" /></#if>
			</center>	
			      </td>
			    </tr>
			    <tr> <td> 姓名：</td>
			      <td  >
			        <input type="text" maxlength="50" size="20" name="addName"  value="${ggtxl.addName}">
			      </td>
			    </tr>
			    <tr> <td> 性别：</td>
			      <td>						
					<select name="gender">
						<option value=1 <#if ggtxl.gender == 1>selected="selected"</#if>>男</option>
						<option value=0 <#if ggtxl.gender == 0>selected="selected"</#if>>女</option>
					</select>
				</td>	
			    </tr>
			     <tr> <td> 是否公共：</td>
			      <td  >
			        <select class="BigSelect" name="ismm">
			            <option value="Y" <#if ggtxl.ismm =='Y'>selected="selected"</#if>>公共</option>
						<option value="N" <#if ggtxl.ismm =='N'>selected="selected"</#if>>紧急</option>
			        </select>
			      </td>
			    </tr>
			    <tr>
			      <td   >生日：</td>
			      <td>
			      	<input class="text" type="text" name="birthday" value="${ggtxl.birthday}" />
              	  </td>
			    </tr>
			      <tr>
			      <td  > 年龄：</td>
			      <td  >
			        <input width="60" type="text" size="25" name="age" value="${ggtxl.age}">
			      </td>
			    </tr>
			    <tr>
			      <td  > 昵称：</td>
			      <td  >
						<input class="text" type="text" name="nickName"  maxlength="10" value="${ggtxl.nickName}"/>
			      </td>
			    </tr>
			    <tr>
			      <td   > 职务：</td>
			      <td  >
			        <input class="text" type="text" name="duties" value="${ggtxl.duties}" />
			      </td>
			    </tr>
			    <tr>
			      <td   > 配偶：</td>
			      <td colspan="2" >
			        <input class="text" type="text" name="spouse" value="${ggtxl.spouse}" />
			      </td>
			    </tr>
			    <tr>
			      <td   > 子女：</td>
			      <td colspan="2" >
			        <input class="text" type="text" name="children" value="${ggtxl.children}" />
			      </td>
			    </tr>
			    
			    <tr>
			      <td  > 联系人照片上传：</td>
			      <td colspan="2" >
			            <input width="60" type="hidden" id="photo" name="photo" value="${ggtxl.photo}">
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
			        <input width="60" type="text"  size="25" name="unitName" value="${ggtxl.unitName}" >
			      </td>
			    </tr>
			
			    <tr>
			      <td   >单位地址：</td>
			      <td colspan="2" >
			        <input type="text" maxlength="100" size="40" name="unitAddress"  value="${ggtxl.unitAddress}" >
			      </td>
			    </tr>
			
			    <tr>
			      <td   > 单位邮编：</td>
			      <td colspan="2" >
			        <input width="60" type="text"  size="25" name="unitCode" value="${ggtxl.unitCode}" >
			      </td>
			    </tr>
			
			    <tr>
			      <td   > 工作电话：</td>
			      <td colspan="2" >
			        <input width="60" type="text" size="25" name="unitTel" value="${ggtxl.unitTel}" >
			      </td>
			    </tr>
			
			    <tr>
			      <td   > 工作传真：</td>
			      <td colspan="2" >
			        <input width="60" type="text"  size="25" name="unitFax" value="${ggtxl.unitFax}" >
			      </td>
			    </tr>
			
			    <tr>
			      <td   colspan="3" class="tableheader" ><b>&nbsp;联系方式（家庭）</b></td>
			    </tr>
			
			    <tr>
			      <td   > 家庭住址：</td>
			      <td colspan="2" >
			        <input type="text"  maxlength="100" size="40" name="homeAddress" value="${ggtxl.homeAddress}" >
			      </td>
			    </tr>
			
			    <tr>
			      <td   > 家庭邮编：</td>
			      <td colspan="2" >
			        <input width="60" type="text"  size="25" name="homeCode" value="${ggtxl.homeCode}" >
			      </td>
			    </tr>
			
			    <tr>
			      <td   > 家庭电话：</td>
			      <td colspan="2">
			        <input width="60" type="text" size="25" name="homeTel" value="${ggtxl.homeTel}" >
			      </td>
			    </tr>
			
			    <tr>
			      <td   > 手机：</td>
			      <td colspan="2"  >
			        <input width="60" type="text" size="25" name="cellPhone" value="${ggtxl.cellPhone}" >
			      </td>
			    </tr>
			
			    <tr> <td> 小灵通：</td>
			      <td colspan="2"  >
			        <input width="60" type="text"  size="25" name="homePhs" value="${ggtxl.homePhs}" >
			      </td>
			    </tr>
			
			    <tr> <td> 电子邮件：</td>
			      <td colspan="2"  >
			        <input type="text" maxlength="80" size="25" name="email" value="${ggtxl.email}" >
			      </td>
			    </tr>
			
			    <tr> <td> QQ：</td>
			      <td colspan="2"  >
			        <input width="60" type="text"   size="25" name="qq" value="${ggtxl.qq}" >
			      </td>
			    </tr>
			
			    <tr> <td> MSN：</td>
			      <td colspan="2"  >
			        <input width="60" type="text" size="25" name="msn" value="${ggtxl.msn}" >
			      </td>
			    </tr>
			    <tr>
			      <td   colspan="3" class="tableheader"><b>&nbsp;备　注</b></td>
			    </tr>
			    <tr>
			      <td colspan="3"  >
			        <textarea wrap="on" rows="5" name="remark" cols="60">${ggtxl.remark}</textarea>
			      </td>
			    </tr>
			    <tr>
			      <td colspan="3">
			       </td>
			    </tr>
			    <tr align="center" >
			      <td   colspan="3">
					<input type="button" value="返 回" class="btn" onclick="window.close();" />
			      </td>
			    </tr>
			  </tbody></table>
			  </form>
			</div>	  				
    </body>
</html>