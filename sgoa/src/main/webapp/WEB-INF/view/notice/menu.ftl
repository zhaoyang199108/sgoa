 <div class="side">
  <div class="s_menu">
    <div class="gnct">
      <p>功能菜单</p>
    </div>
	<div class="simu">
       <div class="woie">
        <div class="module">
          <p><a href="#">公告管理</a></p>
        </div>
       <ul class="sub-list">
        <#if userAuth("ROLE_ADMIN","ROLE_MESSAGE_EDIT")>
            <li <#if menuHighLight == 'add_notice'>class="high_light"</#if>>
                <a href="${appDomain}/notice/add_notice.htm?sort=2">发布公告</a>
            </li>
            <li <#if menuHighLight == 'my_drafts_list'>class="high_light"</#if>>
                <a href="${appDomain}/notice/my_drafts_list.htm?sort=2">我的草稿</a>
            </li>
            <li <#if menuHighLight == 'notice_list'>class="high_light"</#if>>
                <a href="${appDomain}/notice/list.htm?sort=2">我的申请</a>
            </li>
            </#if>
             <#if userAuth("ROLE_ADMIN","ROLE_MESSAGE_REW")>
             <li <#if menuHighLight == 'notice_review_list'>class="high_light"</#if>>
                <a href="${appDomain}/notice/notice_review_list.htm?sort=2">待审核</a>
            </li>
            <li <#if menuHighLight == 'my_notice_list'>class="high_light"</#if>>
                <a href="${appDomain}/notice/my_notice_list.htm?sort=2">经我审核</a>
            </li>
            </#if>
             <#if userAuth("ROLE_ADMIN","ROLE_MESSAGE_LOOK")>
            <li <#if menuHighLight == 'notice_search'>class="high_light"</#if>>
                <a href="${appDomain}/notice/notice_search.htm">公告查询</a>
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