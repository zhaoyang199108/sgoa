 <div class="side">
  <div class="s_menu">
    <div class="gnct">
      <p>功能菜单</p>
    </div>
	<div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">会议室预约</a></p>
        </div>
       <ul class="sub-list">
           <#if userAuth("ROLE_ADMIN","ROLE_MEETING_NEW")>
        	<li <#if menuHighLight == 'add_meetingYy'>class="high_light"</#if>>
                <a href="${appDomain}/meetingYy/add_meetingYy.htm">新增预约</a>
            </li>
            <li <#if menuHighLight == 'meetingYy_list'>class="high_light"</#if>>
                <a href="${appDomain}/meetingYy/meetingYy_list.htm">预约列表</a>
            </li>
             </#if>
           <#if userAuth("ROLE_ADMIN","ROLE_MEETING_REW")>
            <li <#if menuHighLight == 'meetingYy_review_list'>class="high_light"</#if>>
                <a href="${appDomain}/meetingYy/meetingYy_review_list.htm">待审核列表</a>
            </li>
            <li <#if menuHighLight == 'my_review_list'>class="high_light"</#if>>
                <a href="${appDomain}/meetingYy/my_review_list.htm">经我审核列表</a>
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
