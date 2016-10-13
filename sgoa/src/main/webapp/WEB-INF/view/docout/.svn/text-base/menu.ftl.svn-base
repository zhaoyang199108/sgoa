 <div class="side">
  <div class="s_menu">
    <div class="gnct">
      <p>功能菜单</p>
    </div>
	<div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">发文管理</a></p>
        </div>
       <ul class="sub-list">
           <#if userAuth("ROLE_ADMIN","ROLE_DOCOUT_EDIT")>
       
            <li <#if menuHighLight == 'add_docout'>class="high_light"</#if>>
                <a href="${appDomain}/docout/add_docout.htm">起草发文</a>
            </li>
            <li <#if menuHighLight == 'my_draft_list'>class="high_light"</#if>>
                <a href="${appDomain}/docout/my_draft_list.htm">我的草稿</a>
            </li>
            <li <#if menuHighLight == 'docout_list'>class="high_light"</#if>>
                <a href="${appDomain}/docout/list.htm">我的申请</a>
            </li>
             </#if>
           <#if userAuth("ROLE_ADMIN","ROLE_DOCOUT_REW")>
             <li <#if menuHighLight == 'docout_review_list'>class="high_light"</#if>>
                <a href="${appDomain}/docout/docout_review_list.htm">待审核</a>
            </li>
           
            <li <#if menuHighLight == 'my_docout_list'>class="high_light"</#if>>
                <a href="${appDomain}/docout/my_docout_list.htm">经我审核</a>
            </li>
             </#if>
           <#if userAuth("ROLE_ADMIN","ROLE_DOCOUT_DO")>
             <li <#if menuHighLight == 'docout_doinout_list'>class="high_light"</#if>>
                <a href="${appDomain}/docout/docout_doinout_list.htm">待办事项</a>
            </li>
             </#if>
           <#if userAuth("ROLE_ADMIN")>
            <li <#if menuHighLight == 'docout_search'>class="high_light"</#if>>
                <a href="${appDomain}/docout/docout_search.htm">发文查询</a>
            </li>
             </#if>
           <#if userAuth("ROLE_ADMIN","ROLE_DOCOUT_LOOK")>
            <li <#if menuHighLight == 'docout_received'>class="high_light"</#if>>
                <a href="${appDomain}/docout/docout_received.htm">发文存档</a>
            </li>
          </#if>
          <#if userAuth("ROLE_ADMIN","ROLE_DOCOUT_DUBAN")>  
            <li <#if menuHighLight == 'docout_isduban'>class="high_light"</#if>>
                <a href="${appDomain}/docout/docout_isduban.htm">发文督办</a>
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