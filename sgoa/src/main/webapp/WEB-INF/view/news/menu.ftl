 <div class="side">
  <div class="s_menu">
    <div class="gnct">
      <p>功能菜单</p>
    </div>
	<div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">要情管理</a></p>
        </div>
       <ul class="sub-list">
      	 <#if userAuth("ROLE_ADMIN","ROLE_NEWS_EDIT")>
            <li <#if menuHighLight == 'add_news'>class="high_light"</#if>>
                <a href="${appDomain}/news/add_news.htm?sort=1">发布要情</a>
            </li>
            <li <#if menuHighLight == 'my_draft_list'>class="high_light"</#if>>
                <a href="${appDomain}/news/my_draft_list.htm?sort=1">我的草稿</a>
            </li>
            <li <#if menuHighLight == 'list'>class="high_light"</#if>>
                <a href="${appDomain}/news/list.htm?sort=1">我的申请</a>
            </li>
          </#if>
         <#if userAuth("ROLE_ADMIN","ROLE_NEWS_REW")>
             <li <#if menuHighLight == 'news_review_list'>class="high_light"</#if>>
                <a href="${appDomain}/news/news_review_list.htm?sort=1">待审核</a>
            </li>
            <li <#if menuHighLight == 'my_news_list'>class="high_light"</#if>>
                <a href="${appDomain}/news/my_news_list.htm?sort=1">经我审核</a>
            </li>
          </#if>
          <#if userAuth("ROLE_ADMIN","ROLE_NEWS_LOOK")>
            <li <#if menuHighLight == 'news_search'>class="high_light"</#if>>
                <a href="${appDomain}/news/news_search.htm">要情查询</a>
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