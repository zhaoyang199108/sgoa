<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>通讯录更新页面</title>
        <link href="${cssDomain}/css/addressbook.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
		<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>
		<script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js" defer="defer"></script>
		<script type="text/javascript" src="${jsDomain}/js/upload/ajaxfileupload.js"></script>
		<script type="text/javascript">
		$(document).ready( function() {
		    // 日期控件
			$("input[name=birthday]").click(function(){
				WdatePicker();
			});
		
			$("#updateBtn").click( function() {
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
     <div class="sear">
	 
    </div>
    <div class="xq">
	  <div class="lx_lb">
	   <h4 class="tite" >详 情</h4>
	   <form class="f0" action="${appDomain}/addressBook/edit_addressBook.htm" method="POST" enctype="multipart/form-data">
	   <input type="hidden" id="id" name="id" value="${addressBook.id}" />
	   <div class="dd">
	    <table width="98%" border="0">
          <tr>
            <td width="24%">
            <#if addressBook.photo==null><img src="${imageDomain}/images/0.png" width="128" height="128" id="imgPhoto"/>
			<#else><img src="${addressBook.photo}" width="128" height="128" id="imgPhoto" /></#if>
            </td>
            <td width="76%"><table  class="biw">
              <tr>
                <th>姓名：</th>
				<td><input class="text" type="text" name="addName" maxlength="10" value="${addressBook.addName}" />
				</td>																					  					    
                <th>昵称：</th>
                <td><input class="text" type="text" name="nickName"  maxlength="10" value="${addressBook.nickName}"/></td>
                </tr>
              <tr>
                <th>性别：</th>
                <td>						
					<select name="gender">
						<option value=1 <#if addressBook.gender == 1>selected="selected"</#if>>男</option>
						<option value=0 <#if addressBook.gender == 0>selected="selected"</#if>>女</option>
					</select>
				</td>	
                <th>生日：</th>
                <td><input class="text" type="text" name="birthday" value="${addressBook.birthday}" />
                </td>
                </tr>
              <tr>
              	<th>年龄：</th>
                <td><input class="text" type="text" name="age" value="${addressBook.age}" /></td>
                <th>职务：</th>
                <td><input class="text" type="text" name="duties" value="${addressBook.duties}" /></td>
                </tr>
              <tr>
              <tr>
                <th>照片：</th>
                <td colspan="3">
                 <input width="60" type="hidden" id="photo" name="photo" value="${addressBook.photo}">
			     <input type="file" title="选择照片上传"  size="40" name="srcUploadFile" id="srcUploadFile">
			     <input type="button" id="uploadBtn" onclick="return ajaxFileUpload();" value="上传" style="width:auto; height:23px;height:18px \9;"/>
				 <img src="${jsDomain}/js/upload/loading.gif" id="loading" style="display: none;">
                </td>
              </tr>
              
            </table></td>
          </tr>
        </table><table  class="biw">
  <tr>
    
    <th>单位：</th>
    <td><input class="text" type="text" name="unitName" value="${addressBook.unitName}" /></td>
    <th>单位地址：</th>
    <td><input class="text" type="text" name="unitAddress" value="${addressBook.unitAddress}" /></td>
  </tr>
  <tr>
    <th>工作电话：</th>
    <td><input class="text" type="text" name="unitTel" value="${addressBook.unitTel}" /></td>
    <th>单位邮编：</th>
    <td><input class="text" type="text" name="unitCode" value="${addressBook.unitCode}" /></td>
  </tr>
  <tr>
    <th>手机：</th>
    <td><input class="text" type="text" name="cellPhone" value="${addressBook.cellPhone}" /></td>
    <th>电子邮件：</th>
    <td><input class="text" type="text" name="email" value="${addressBook.email}" /></td>
  </tr>
  <tr>
    <th>小灵通：</th>
    <td><input class="text" type="text" name="homePhs" value="${addressBook.homePhs}" /></td>
    <th>家庭邮编：</th>
    <td><input class="text" type="text" name="homeCode" value="${addressBook.homeCode}" /></td>
  </tr>
  <tr>
    <th>家庭电话：</th>
    <td><input class="text" type="text" name="homeTel" value="${addressBook.homeTel}" /></td>
    <th>配偶：</th>
    <td><input class="text" type="text" name="spouse" value="${addressBook.spouse}" /></td>
  </tr>
  <tr>
    <th>工作传真：</th>
    <td><input class="text" type="text" name="unitFax" value="${addressBook.unitFax}" /></td>
    <th>子女：</th>
    <td><input class="text" type="text" name="children" value="${addressBook.children}" /></td>
  </tr>
  <tr>
    <th>QQ：</th>
    <td><input class="text" type="text" name="qq" value="${addressBook.qq}" /></td>
    <th>MSN：</th>
    <td><input class="text" type="text" name="msn" value="${addressBook.msn}" /></td>
  </tr>
  <tr>
    <th>分组：</th>
    <td>
     <select name="typeId" >
		<option value="">请选择</option>
		<#list addressBookTypePages.addressTypeList as addressBookType>
        <option value="${addressBookType.id}" <#if addressBookType.id == addressBook.typeId>selected="selected"</#if>>${addressBookType.typeName}</option>
        </#list>
    </select>
    </td>
    <th>排序号：</th>
    <td><input class="text" type="text" name="sorting" value="${addressBook.sorting}" /></td>
  </tr>
  <tr>
    <th>家庭地址：</th>
    <td><input class="text" type="text" name="homeAddress" value="${addressBook.homeAddress}" /></td>
    <th>备注：</th>
    <td><label>
      <textarea style="width:80%;" maxlength="500"  name="remark"/>${addressBook.remark}</textarea>
    </label></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>
      <input class="btn" type="reset" value="取 消"/>
      <input class="btn" type="button" id="updateBtn"  value="保 存" />
    </td>
  </tr>
</table>
</div>
</form>
	  </div>
	</div>


    </body>
</html>