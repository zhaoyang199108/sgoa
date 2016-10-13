 <div class="side">
  <div class="s_menu">
    <div class="gnct">
      <p>功能菜单</p>
    </div>
	<div class="simu">
       <div class="woie">
        <div class="module">
          <p><a href="#">简报管理</a></p>
        </div>
       <ul class="sub-list">
        <#if userAuth("ROLE_ADMIN","ROLE_NEWS_EDIT")>
            <li <#if menuHighLight == 'add_brief'>class="high_light"</#if>>
                <a href="${appDomain}/brief/add_brief.htm?sort=2">发布简报</a>
            </li>
            <li <#if menuHighLight == 'my_drafts_list'>class="high_light"</#if>>
                <a href="${appDomain}/brief/my_drafts_list.htm?sort=2">我的草稿</a>
            </li>
            <li <#if menuHighLight == 'brief_list'>class="high_light"</#if>>
                <a href="${appDomain}/brief/list.htm?sort=2">我的申请</a>
            </li>
            </#if>
             <#if userAuth("ROLE_ADMIN","ROLE_NEWS_REW")>
             <li <#if menuHighLight == 'brief_review_list'>class="high_light"</#if>>
                <a href="${appDomain}/brief/brief_review_list.htm?sort=2">待审核</a>
            </li>
            <li <#if menuHighLight == 'my_brief_list'>class="high_light"</#if>>
                <a href="${appDomain}/brief/my_brief_list.htm?sort=2">经我审核</a>
            </li>
            </#if>
             <#if userAuth("ROLE_ADMIN","ROLE_NEWS_LOOK")>
            <li <#if menuHighLight == 'brief_search'>class="high_light"</#if>>
                <a href="${appDomain}/brief/brief_search.htm">简报查询</a>
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