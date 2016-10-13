<div class="side">
  <div class="s_menu">
    <div class="gnct">
      <p>功能菜单</p>
    </div>
	<div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">日程管理</a></p>
        </div>
       <ul class="sub-list">
    	  <#if userAuth("ROLE_ADMIN","ROLE_SCHEDULER_EDIT")>
        	<li <#if menuHighLight == 'scheduler'>class="high_light"</#if>>
                 <a href="${appDomain}/scheduler/scheduler.htm">日程列表</a>
            </li>
            <li <#if menuHighLight == 'scheduler_list'>class="high_light"</#if>>
                <a href="${appDomain}/scheduler/scheduler_list.htm">日程提醒</a>
            </li>
           </#if>
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
