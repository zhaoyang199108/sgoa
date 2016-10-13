 <div class="side">
  <div class="s_menu">
    <div class="gnct">
      <p>功能菜单</p>
    </div>
	<div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">部门管理</a></p>
        </div>
       <ul class="sub-list">
        	 <li <#if menuHighLight == 'menu'>class="high_light"</#if>>
                <a href="${appDomain}/dept/menu.htm">部门列表</a>
            </li>
        </ul>
      </div>
	  </div>
	<div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">用户管理</a></p>
        </div>
       <ul class="sub-list">
        	 <li <#if menuHighLight == 'user_list'>class="high_light"</#if>>
                <a href="${appDomain}/user/user_list.htm">用户列表</a>
            </li>
        </ul>
      </div>
    </div>
    <div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">会议室管理</a></p>
        </div>
       <ul class="sub-list">
        	 <li <#if menuHighLight == 'meetingRoom_list'>class="high_light"</#if>>
                <a href="${appDomain}/meetingRoom/list.htm">会议室列表</a>
            </li>
        </ul>
      </div>
	  </div>
    <div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">知识管理</a></p>
        </div>
       <ul class="sub-list">
        	 <li <#if menuHighLight == 'folder_system'>class="high_light"</#if>>
                <a href="${appDomain}/resFile/folder_system.htm">目录管理</a>
            </li>
        </ul>
      </div>
    </div>
    <div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">权限设置</a></p>
        </div>
       <ul class="sub-list">
        	 <li <#if menuHighLight == 'grpo_list'>class="high_light"</#if>>
                <a href="${appDomain}/grpo/grpo_list.htm">权限分组</a>
            </li>
            <li <#if menuHighLight == 'posi_list'>class="high_light"</#if>>
                <a href="${appDomain}/posi/posi_list.htm">职责设置</a>
            </li>
        </ul>
      </div>
    </div>
  </div>
  <div class="s_io"> <a href="#"><img src="${imageDomain}/images/sq.jpg" /> </a></div>
  </div>
<script type="text/javascript">
    $(document).ready(function(){
        var leftHeight = document.documentElement.clientHeight;
        $("#left").height(leftHeight + "px");
    });
</script>
