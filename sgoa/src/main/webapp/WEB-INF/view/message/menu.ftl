 <div class="side">
  <div class="s_menu">
    <div class="gnct">
      <p>功能菜单</p>
    </div>
	<div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">通知管理</a></p>
        </div>
       <ul class="sub-list">
      	 <#if userAuth("ROLE_ADMIN","ROLE_MESSAGE_EDIT")>
            <li <#if menuHighLight == 'add_message'>class="high_light"</#if>>
                <a href="${appDomain}/message/add_message.htm?sort=1">发布通知</a>
            </li>
            <li <#if menuHighLight == 'my_draft_list'>class="high_light"</#if>>
                <a href="${appDomain}/message/my_draft_list.htm?sort=1">我的草稿</a>
            </li>
            <li <#if menuHighLight == 'list'>class="high_light"</#if>>
                <a href="${appDomain}/message/list.htm?sort=1">我的申请</a>
            </li>
          </#if>
         <#if userAuth("ROLE_ADMIN","ROLE_MESSAGE_REW")>
             <li <#if menuHighLight == 'message_review_list'>class="high_light"</#if>>
                <a href="${appDomain}/message/message_review_list.htm?sort=1">待审核</a>
            </li>
            <li <#if menuHighLight == 'my_message_list'>class="high_light"</#if>>
                <a href="${appDomain}/message/my_message_list.htm?sort=1">经我审核</a>
            </li>
          </#if>
          <#if userAuth("ROLE_ADMIN","ROLE_MESSAGE_LOOK")>
            <li <#if menuHighLight == 'message_search'>class="high_light"</#if>>
                <a href="${appDomain}/message/message_search.htm">通知查询</a>
            </li>
         </#if>
        </ul>
      </div>
      <br />
      <br />
      <br />
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