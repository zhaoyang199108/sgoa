<div class="side">
  <div class="s_menu">
    <div class="gnct">
      <p>功能菜单</p>
    </div>
	<div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">工作日程管理</a></p>
        </div>
       <ul class="sub-list">
        	<li <#if menuHighLight == 'work_scheduler'>class="high_light"</#if>>
                 <a href="${appDomain}/workscheduler/work_scheduler.htm">工作日程安排</a>
            </li>
            <li <#if menuHighLight == 'workscheduler_list'>class="high_light"</#if>>
                <a href="${appDomain}/workscheduler/workscheduler_list.htm">工作日程提醒</a>
            </li>
            <li <#if menuHighLight == 'work_scheduler_check'>class="high_light"</#if>>
                <a href="${appDomain}/workscheduler/work_scheduler_check.htm">工作日程监督</a>
            </li>
        </ul>
      </div>
	  </div>
	  <#if userAuth("ROLE_ADMIN", "ROLE_LEADERSCHEDULER")>
	 <div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">领导活动管理</a></p>
        </div>
       <ul class="sub-list">
        	<li <#if menuHighLight == 'leader_scheduler'>class="high_light"</#if>>
                 <a href="${appDomain}/leaderscheduler/leader_scheduler.htm">局领导重大活动安排</a>
            </li>
            <li <#if menuHighLight == 'leaderscheduler_list'>class="high_light"</#if>>
                <a href="${appDomain}/leaderscheduler/leaderscheduler_list.htm">局领导重大活动提醒</a>
            </li>
            <li <#if menuHighLight == 'leader_scheduler_check'>class="high_light"</#if>>
                <a href="${appDomain}/leaderscheduler/leader_scheduler_check.htm">局领导重大活动督办</a>
            </li>
        </ul>
      </div>
	  </div>
	  </#if>
  </div>
  <div class="s_io"> <a href="#"><img src="${imageDomain}/images/sq.jpg" /> </a></div>
  </div>
<script type="text/javascript">
    $(document).ready(function(){
        var leftHeight = document.documentElement.clientHeight;
        $("#left").height(leftHeight + "px");
    });
</script>
