<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>添加分组</title>
		<base target="_self">
        <link href="${cssDomain}/css/base.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/demo.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/demo_dept.css" type="text/css" rel="stylesheet">
		<link href="${cssDomain}/css/zTreeStyle/zTreeStyle.css"  type="text/css" rel="stylesheet">
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery-1.4.4.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery.ztree.core-3.1.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery.ztree.excheck-3.1.js"></script>
	    <script type="text/javascript"  src="${jsDomain}/js/ztree/jquery.ztree.exedit-3.1.js"></script>
		<script type="text/javascript">
			// 部门树形菜单设置
			var setting = {
				data: {
					simpleData: {
						enable: true
					}
				},
				callback: {
					onClick: zTreeOnClick
				}
			};
			var log, className = "dark";
			function showLog(str) {
				if (!log) log = $("#log");
				log.append("<li class='"+className+"'>"+str+"</li>");
				if(log.children("li").length > 8) {
					log.get(0).removeChild(log.children("li")[0]);
				}
			}
			function getTime() {
				var now= new Date(),
				h=now.getHours(),
				m=now.getMinutes(),
				s=now.getSeconds(),
				ms=now.getMilliseconds();
				return (h+":"+m+":"+s+ " " +ms);
			}
			// 部门信息全选
			function selectAll() {
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
			}
			// 部门信息节点单击事件
			function zTreeOnClick(event, treeId, treeNode){
				// 取得人员信息
	            $.ajax({
	                type: 'GET',
	                contentType: 'application/json',
	                url: '/grpo/get_dept_user.htm',
	                dataType: 'json',
	                data: 'deptId=' + treeNode.id + '&r=' + Math.random(),
	                success: function(data){
	                    $("#currDeptId").val(treeNode.id);
	                    // 设置部门用户列表,并设置选中部门背景色
	                    if (data == null || data.length == 0) {
	                        alert("此部门暂时没有人员");
	                    }
	                    else {
	                        addCurrentDeptStyle(treeNode.id);
	                        appendDeptUserList(data);
	                    }
	                },
	                error: function(){
	                    alert("取得人员失败,请联系管理员");
	                }
	            });
			}
		
		    $(document).ready(function(){
		    
		    	// 取得部门信息
		        $.ajax({
		            type: 'GET',
		            contentType: 'application/json',
		            url: '/grpo/find_dept.htm',
		            dataType: 'json',
		            data: 'r=' + Math.random(),
		            success: function(data){
		            	// 从Controller里取得对象数组
		            	var deptListObj = data.deptList;
		            	// 定义树形数组对象
		            	var zNodes = [deptListObj.length];
		            	// 循环取得对象里信息
		            	for (var i=0;i<deptListObj.length;i++) {
		            		// 设置树形结构数组
		            		var dept = deptListObj[i];
		            		zNodes[i] = {id:dept.id,pId:dept.unitId,name:dept.deptName, open:true};
		            	}
		            	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		            	$("#selectAll").bind("click", selectAll);
		            },
		            error: function(){
		            	// 请求错误时,提示用户
		                alert("取得部门信息失败！");
		            }
		        });
		    	
		        /**
		         * 人员选择完成后, 点击确认按钮返回父页面
		         */
		        $("#doneBtn").click(function(){
		            var selectUl = $(".select-list li:not(:first)");
		            if (selectUl.length == 0) {
		                alert("请选择人员");
		                return false;
		            }
					
		            var loginIds = "";
		            selectUl.each(function(i){
		                if (i > 0) {
		                    loginIds = loginIds + ",";
		                }
		                loginIds = loginIds + $(this).find("a.opt").attr("alt");
		            });
		            
		       var item = $("input[name=chkItem]:checked");
		        // 校验是否至少选择了一个单选框
		        if (item.length == 0) {
		            alert("请至少选择一条分组名称");
		            return false;
		        }
		        
		        if (confirm("确定提交?")) {
		            // 将所选Checkbox值转换为字符串
		            var value = "";
		            item.each(function(i){
		                if (i > 0) {value += ",";}
		                value += $(this).val();
		            }); 
		            }
		            
					var url = "${appDomain}/grpo/users_role.htm"
		            $.get(url, {idArray:loginIds,gropIds:value
		            }, function(result){
		                alert("操作成功");
		                //跳转到分组页面
		             	location.href="${appDomain}/grpo/group.htm";
		            });
		          
		        });
		        
		        /**
		         * 关闭当前页面
		         */
		        $("#closeBtn").click(function(){
		            window.returnValue = new Array();
		            window.close();
		        });
		        
		        /**
		         * 用户列表中全选按钮
		         */
		        $("#allBtn").click(function(){
		            $("input[name='loginId']").each(function(){
		                $(this).attr("checked", $("#allBtn").attr("checked"));
		                selectOneUser($(this).val(), $(this));
		            });
		            $("#oppBtn").attr("checked", false);
		        });
		        
		        /**
		         * 用户列表中反选按钮
		         */
		        $("#oppBtn").click(function(){
		            $("input[name='loginId']").each(function(){
		                $(this).attr("checked", !$(this).attr("checked"));
		                selectOneUser($(this).val(), $(this));
		            });
		            // 反选后,根据Checkbox选中情况确定全选框是否需要被选中
		            var checkedSize = $("input[name=loginId]:checked").length; // 选中数量
		            var allSize = $("input[name=loginId]").length; // 全部数量
		            $("#allBtn").attr("checked", checkedSize == allSize);
		        });
		        
		    });
		    
		    /**
		     * 点击部门下的用户时,根据操作将该用户添加至已选择列表或者删除
		     */
		    function selectUser(loginId, obj){
		        selectOneUser(loginId, obj);
		        setAllAndOppBtn();
		        // 取得人员分组信息
	            $.ajax({
	                type: 'GET',
	                contentType: 'application/json',
	                url: '/grpo/get_grpo_user.htm',
	                dataType: 'json',
	                data: 'loginId=' + loginId + '&r=' + Math.random(),
	                
	                success: function(data){
	                    $("#currLoginId").val(loginId);
	                    // 设置部门用户列表,并设置选中部门背景色
	                    if (data == null || data.length == 0) {
	                        alert("此用户暂时没有分组");
	                    }
	                    else {
							addCurrentLoginStyle(loginId);
							var selectUl = $(".select-list li:not(:first)");
							if(selectUl.length==1){	                        
								isExistInRoleList(data);
	                        } else{
								$(".grpo-list li").each(function(){
					             	var id= $(this).find("a.opt").attr("alt");
									$("#gp_"+id).attr("checked",false);	
		            			});
	                        }
	                    }
	                },
	                error: function(){
	                    alert("取得人员失败,请联系管理员");
	                }
	            });
		    }
		        /**
		     * 点击部门下的用户时,根据操作将该用户添加至已选择列表或者删除
		     */
		    function selectRoleUser(loginId, obj){
		        selectOneUser(loginId, obj);
		        setAllAndOppBtn();
		    }
		    
		    /**
		     * 点击部门下的用户时,根据操作将该用户添加至已选择列表或者删除
		     */
		    function selectOneUser(loginId, obj){
		        // 判断操作事件,选中还是取消
		        if ($(obj).attr("checked")) {
		            appendSelectUser(loginId, obj);
		        }
		        else {
		            removeSelectUser(loginId);
		        }
		    }
		    
		    function appendSelectUser(loginId, obj){
		        if (isExistInList(loginId)) {
		            return;
		        }
		        var userName = $(obj).parent().find("span.uname").text();
		        var deptName = $(obj).parent().find("input[name=deptName]").val();
		        
		        var li = "<li id=\"li_" + loginId + "\">";
		        li = li + "<span class=\"uname\">" + userName + "</span>";
		        li = li + "<span class=\"udept\">" + deptName + "</span>";
		        li = li + "<a class=\"opt\" href=\"javascript:void(0)\" alt=\"" + loginId + "\" onclick=\"removeUser('" + loginId + "')\">删除</a></li>";
		        
		        var selectUl = $(".select-list");
		        $(li).appendTo(selectUl);
		    }
		    
		    /**
		     * 设置部门列表
		     */
		    function appendDeptUserList(data){
		        // 设置全选反选按钮的初始值
		        $("#allBtn").attr("checked", false);
		        $("#oppBtn").attr("checked", false);
		        
		        // 设置用户列表
		        var userUl = $(".user-list001");
		        userUl.find("li:not(:first)").remove();
		        // 如果当前用户已经被选择,此单选框默认选中
		        $.each(data, function(i, user){
		        	
		            var li = "<li><input type=\"checkbox\" name=\"loginId\" value=\"" + user.loginId + "\" ";
		            if (isExistInList(user.loginId)) {
		                li = li + "checked=\"checked\" ";
		            }
		            li = li + "onclick=\"selectUser('" + user.loginId + "', this)\" />";
		            li = li + "<span class=\"uname\">" + user.userName + "</span>";
		            li = li + "<input type=\"hidden\" name=\"deptName\" value=\"" + user.deptName + "\" /></li>";
					
		            $(li).appendTo(userUl);
		        });
		        setAllAndOppBtn();
		    }
		    
		    /**
		     * 判断当前用户是否已经被选择
		     */
		    function isExistInList(id){
		        var isExist = false;
		        $(".select-list li:not(:first)").each(function(){
		            var loginId = $(this).find("a.opt").attr("alt");
		            if (id == loginId) {
		                isExist = true;
		                return;
		            }
		        });
		        return isExist;
		    }
		    /**
		     * 判断当前用户是否已经被选择
		     */
		    function isExistInRoleList(date){
		    	$.each(date, function(i, userRole){
		        	var loginId = userRole.grpoId;
		            $(".grpo-list li").each(function(){
		            var id= $(this).find("a.opt").attr("alt");
		            if (id == loginId) {
						$("#gp_"+id).attr("checked",true);	
						}
		            });
					
		        });
		            
		    }
		    
		    // 删除某一被选中的用户
		    function removeUser(loginId){
		        // 删除已选择的记录 
		        removeSelectUser(loginId);
		        // 查看当前部门列表中是否有当前ID,如果有清除选择框
		        $(".user-list001 li:not(:first)").each(function(){
		            var checkbox = $(this).find("input[name=loginId]");
		            if (loginId == checkbox.val()) {
		                checkbox.attr("checked", false);
		                setAllAndOppBtn();
		                return false;
		            }
		        });
		    }
		    
		    // 删除某一被选中的用户
		    function removeSelectUser(loginId){
		        $('#li_' + loginId).remove();
		    }
		      // 删除某一被选中的用户
		    function removeSelectRole(id){
		        $('#li_' + id).remove();
		    }
		    
		    
		    // 当部门被选择时, 设置背景色
		    function addCurrentDeptStyle(id){
		        $(".dept-list li").removeClass("current");
		        $('#d_' + id).addClass("current");
		    }
		    
		    // 当用户被选择时, 设置背景色
		    function addCurrentLoginStyle(id){
		        $(".login-list li").removeClass("current");
		        $('#d_' + id).addClass("current");
		    }
		    
		    function setAllAndOppBtn(){
		        var checkedSize = $("input[name=loginId]:checked").length; // 选中数量说
		        var allSize = $("input[name=loginId]").length; // 全部数量
		        $("#allBtn").attr("checked", checkedSize == allSize); //全选框
		        $("#oppBtn").attr("checked", false); //反选框
		    }
		    
		      function setAllAndRoleBtn(){
		        var checkedSize = $("input[name=loginId]:checked").length; // 选中数量说
		        var allSize = $("input[name=loginId]").length; // 全部数量
		        $("#allBtn").attr("checked", checkedSize == allSize); //全选框
		        $("#oppBtn").attr("checked", false); //反选框
		    }
		</script>
    </head>
    <body>
    <div id="main">
    <div class="main_nav">
    <#include "seal/menu.ftl">
    	<div class="f0">
    		<div class="wrap">
		    	<input type="hidden" id="currDeptId" name="currDeptId" value="" />
		    	<input type="hidden" id="currLoginId" name="currLoginId" value="" />
		        <table class="dlo" style="width:80%;">
		        <tr>
		        <td width="32%">
		        
		        <div class="wrap-div">
		         	<div class="content_wrap">
						<div class="zTreeDemoBackground left">
							<ul id="treeDemo" class="ztree" style="margin-top:0px; width:auto;"></ul>
						</div>
					</div>
		        </div>
		        </td>
		        <td width="18%">
		        <div class="ki001">  
		        <ul class="user-list001">
		            <li class="act001">
		                <input type="checkbox" id="allBtn" name="allBtn" value="" />全选<input type="checkbox" id="oppBtn" name="oppBtn" value="" />反选
		            </li>
		        </ul>
		        </div>
		        </td>
		        <td width="30%">
		         <div class="isu">
				<ul class="grpo-list" style="padding-left:10px;" >
				 <#list grpoPages.grpoList as grpo>
				<li id="li_${grpo.id}">
				  <input type="checkbox" id="gp_${grpo.id}" name="chkItem" value="${grpo.id}" />${grpo.grpoName}
				   <a class="opt" href="#" alt="${grpo.id}" onclick="removeSelectRole('${grpo.id}')"></a>
				</li>
				</#list>
				</ul>
				</div>
		        </td>
		        </tr>
		        <tr>
		        <td colspan="3" align="center" style="float:none;">
		        <input type="button" class="but02" id="doneBtn" name="doneBtn" value="提 交" />
		        </td>
		        </tr>
		        </table>
				 <div style="display:none;">
		        <ul class="select-list">
		            <li>
		            </li>
		            <#list selUserList as selUser>
			            <li id="li_${selUser.loginId}">
			                <span class="uname">${selUser.userName}</span>
			                <span class="udept">${selUser.deptName}</span>
			                <a class="opt" href="#" alt="${selUser.loginId}" onclick="removeSelectUser('${selUser.loginId}')">删除</a>
			            </li>
		            </#list>
		        </ul>
		        </div>
	     	</div>
	     </div>
	     </div>
	     </div>
    </body>
</html>