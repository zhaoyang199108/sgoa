<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <base target="_self">
        <title>传阅单</title>
        <script type="text/javascript" src="${jsDomain}/js/print/jquery-1.9.0.js"></script>
       	<script type="text/javascript" src="${jsDomain}/js/print/jquery.PrintArea.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){	          	
				$("#printBtn").click(function(){
		            var mode = "iframe";		            
		            var close = "popup";
		            var extraCss = "";		            
		            var keepAttr = ["class","id","style","on"];		            
		            var headElements = '';		            
		            var options = { mode : mode, popClose : close, extraCss : extraCss, retainAttr : keepAttr, extraHead : headElements };		            
		            $("#cyd").printArea( options );		            
		        });
			});
		</script>
    </head>
    <body>
    <div align="center" class="btn"> <input type="button" id="printBtn" value="打  印" /></div>   
		<div id="cyd" class="cyd">
		<style type="text/css">
			<!--
			body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code, form, fieldset, legend, input, button, textarea, p, blockquote, th, td a {
			    margin: 0;
			    padding: 0;
			}
			table {
			    border-spacing: 0;
			    border-collapse:collapse;
			}
			tr{height:45px;}
			.cyd{ width:100%; margin:0 auto;}
			input, textarea{border-style:none;border:0px;}
			.cyd h4{ color:#F00; text-align:center; font-size:28px; height:70px; line-height:70px; font-family: "方正小标宋简体";margin-bottom:5px;}
			.cyd table.ttli{margin-right: auto;margin-left: auto;width:700px; border:1px solid #F00;}
			.cyd table.ecc{margin-right: auto;margin-left: auto;width:700px;  border-top: 0;}
			.cyd table.ttli td, .cyd table.ecc td{ line-height:28px; border:1px solid #F00; padding-left:5px;}
			.cyd table.ttli th, .cyd table.ecc th{ line-height:28px; border:1px solid #F00; font-family: "新宋体"; font-size:18px; font-weight:normal;}
			.cyd table.ecc th{border-top:0;}
			.cyd table.ecc{text-align:center;}
			.cyd table.ecc td input.le{float:left;}			
			.cyd table.ecc td.xst{text-align:left; font-size:18px; font-family:"新宋体";}
			.btn{margin-top:20px;}
			-->
		</style>
			<h4>四川省新闻出版广电局文件传阅单</h4>
		 	<table class="ttli">
            	<tr>
		    		<th rowspan="4" style="width:6%">文<br />件<br />编<br />号</th>
				    <td style="width:60%"><input type="text" name="numFirst" value="${cyd.numFirst}" readonly /></td>
				    <th style="width:6%" rowspan="4">份<br />数</th>
				    <td style="width:28%" rowspan="4"><input type="text" name="count" value="${cyd.count}" readonly /></td>
				  </tr>
				  <tr>
				    <td><input type="text" name="numSecond" value="${cyd.numSecond}" readonly /></td>
				  </tr>
				  <tr>
				    <td><input type="text" name="numThird" value="${cyd.numThird}" readonly /></td>
				  </tr>
				  <tr>
				    <td><input type="text" name="numFourth" value="${cyd.numFourth}" readonly /></td>
				  </tr>
			</table>						  
			<table class="ecc">
			   <tr>
			        <th style="width:20%">姓名</th>
			        <th style="width:40%">送文时间</th>
			        <th style="width:40%">退文时间</th>
			   </tr>
		        <#list page.cydDetailList as cyddetail>
			  		<tr>
					    						
						<td style="text-align:center;"><input type="text" name="outTime" id="outTime" value="${cyddetail.outTime}"/></td>
						<td style="text-align:center;width:15%;"><input type="text" name="inTime" id="inTime" value="${cyddetail.inTime}"/></td>
					</tr>
				</#list>
				<tr>
					<td colspan="3" class="xst">
						备注：各位领导阅文时，如需要留用文件，请在此注明文件编号。<br />
						<textarea name="remark" rows="10" cols="80" style="overflow:hidden">${cyd.remark}</textarea>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>