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
        <script type="text/javascript">
            $(document).ready(function(){
           
			$("input[name=outTime]").click(function(){
				WdatePicker();
			});
			$("input[name=inTime]").click(function(){
				WdatePicker();
			});
                
                $("#submitBtn").click(function(){
	                 // 标题非空校验
					if(!isEmpty($("input[name=numFirst]"),"文件编号不许为空！")){
						return;
					}					
	                $('form').submit();
			    });
			});
        </script>
    </head>
    <body>
		<div id="main">
          <div class="main_nav">
            <#include "cyd/menu.ftl">
            <div id="content">
           <div class="pst"><h4>四川省新闻出版广电局文件传阅单</h4>
		        <form class="f0" action="${appDomain}/cyd/add_cyd.htm">
		            <table class="st">
		            	<tr>
				    		<th width="2%" rowspan="4">文件编号</th>
						    <td ><input type="text" name="numFirst" /></td>
						    <th width="2%" rowspan="4">份数</th>
						    <td rowspan="4"><input type="text" name="count" /></td>
						  </tr>
						  <tr>
						    <td><input type="text" name="numSecond" /></td>
						  </tr>
						  <tr>
						    <td><input type="text" name="numThird" /></td>
						  </tr>
						  <tr>
						    <td><input type="text" name="numFourth" /></td>
						  </tr>
						 </table>
						  <table class="st">						  
						      <tr>
						        <th>姓名</th>
						        <th>送文时间</th>
						        <th>退文时间</th>
						        </tr>
						        <#list page.userList as user>
							  		<tr>
									    <td>${user.userName}<input type="hidden" name="userId" value="${user.id}" /></td>									    					
										<td><input type="text" name="outTime" /></td>
										<td><input type="text" name="inTime" /></td>																	
									</tr>
							   	</#list>							   		
									<tr>
				                    <td colspan="3">		                        				                    	
				                    	备注：各位领导阅文时，如需要留用文件，请在此注明文件编号。<br />
										<textarea name="remark" rows="10" cols="80" style="overflow:hidden"></textarea>
				                    </td>
				                </tr>
							   	<tr class="act">
				                    <td colspan="3">		                        
				                        <input id="submitBtn" class="btn" name="draftBtn" type="button" value="提交" />
				                        <input id="cancelBtn" class="btn" name="draftBtn" type="reset" value="取消" />
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