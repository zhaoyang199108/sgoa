<div class="side">
  <div class="s_menu">
    <div class="gnct">
      <p>功能菜单</p>
    </div>
	<div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">站内信管理</a></p>
        </div>
        <ul class="sub-list">
           <#if userAuth("ROLE_ADMIN","ROLE_MSG_EDIT")>
            <li <#if menuHighLight == 'msg_write_list'>class="high_light"</#if>>
                <a href="${appDomain}/msg/write_list.htm">编写信息</a>
            </li>
           
            <li <#if menuHighLight == 'msgOutbox_list'>class="high_light"</#if>>
                <a href="${appDomain}/msg/msgOutbox_list.htm">已发信息</a>
            </li>
            <li <#if menuHighLight == 'msg_draft_list'>class="high_light"</#if>>
                <a href="${appDomain}/msg/draft_list.htm">我的草稿</a>
            </li>
            <li <#if menuHighLight == 'msg_dustbin_list'>class="high_light"</#if>>
                <a href="${appDomain}/msg/dustbin_list.htm">已删信息</a>
            </li>
              </#if>
           <#if userAuth("ROLE_ADMIN","ROLE_MSG_LOOK")>
             <li <#if menuHighLight == 'msgInbox_list'>class="high_light"</#if>>
                <a href="${appDomain}/msg/msgInbox_list.htm">已收信息</a>
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
 