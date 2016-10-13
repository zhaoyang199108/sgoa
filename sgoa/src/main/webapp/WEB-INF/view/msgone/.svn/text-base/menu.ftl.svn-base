<div class="side">
  <div class="s_menu">
    <div class="gnct">
      <p>功能菜单</p>
    </div>
	<div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">文稿拟订管理</a></p>
        </div>
        <ul class="sub-list">
           <#if userAuth("ROLE_ADMIN","ROLE_MSG_EDIT")>
            <li <#if menuHighLight == 'msgone_write_list'>class="high_light"</#if>>
                <a href="${appDomain}/msgone/write_list.htm">编写文稿</a>
            </li>
           
            <li <#if menuHighLight == 'msgoneOutbox_list'>class="high_light"</#if>>
                <a href="${appDomain}/msgone/msgoneOutbox_list.htm">已发文稿</a>
            </li>
            <li <#if menuHighLight == 'msgone_draft_list'>class="high_light"</#if>>
                <a href="${appDomain}/msgone/draft_list.htm">我的草稿</a>
            </li>
            <li <#if menuHighLight == 'msgone_dustbin_list'>class="high_light"</#if>>
                <a href="${appDomain}/msgone/dustbin_list.htm">已删文稿</a>
            </li>
              </#if>
           <#if userAuth("ROLE_ADMIN","ROLE_MSG_LOOK")>
             <li <#if menuHighLight == 'msgoneInbox_list'>class="high_light"</#if>>
                <a href="${appDomain}/msgone/msgoneInbox_list.htm">已收信息</a>
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
 