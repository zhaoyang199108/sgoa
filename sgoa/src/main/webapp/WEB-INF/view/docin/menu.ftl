 <div class="side">
  <div class="s_menu">
    <div class="gnct">
      <p>功能菜单</p>
    </div>
	<div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">收文管理</a></p>
        </div>
       <ul class="sub-list">
          <#if userAuth("ROLE_ADMIN","ROLE_DOCIN_EDIT")>
            <li <#if menuHighLight == 'add_docin'>class="high_light"</#if>>
                <a href="${appDomain}/docin/add_docin.htm">登记收文</a>
            </li>
            <li <#if menuHighLight == 'my_draft_list'>class="high_light"</#if>>
                <a href="${appDomain}/docin/my_draft_list.htm">我的草稿</a>
            </li>
            <li <#if menuHighLight == 'docin_list'>class="high_light"</#if>>
                <a href="${appDomain}/docin/list.htm">我的申请</a>
            </li>
           </#if>
          <#if userAuth("ROLE_ADMIN","ROLE_DOCIN_REW")>
             <li <#if menuHighLight == 'docin_review_list'>class="high_light"</#if>>
                <a href="${appDomain}/docin/docin_review_list.htm">待审核</a>
            </li>
            <li <#if menuHighLight == 'my_docin_list'>class="high_light"</#if>>
                <a href="${appDomain}/docin/my_docin_list.htm">经我审核</a>
            </li>
             </#if>
             <#if userAuth("ROLE_ADMIN")>  
            <li <#if menuHighLight == 'docin_search'>class="high_light"</#if>>
                <a href="${appDomain}/docin/docin_search.htm">收文查询</a>
            </li>
            </#if>
             <#if userAuth("ROLE_ADMIN","ROLE_DOCIN_LOOK")>  
            <li <#if menuHighLight == 'docin_received'>class="high_light"</#if>>
                <a href="${appDomain}/docin/docin_received.htm">收文存档</a>
            </li>
            </#if>
             <#if userAuth("ROLE_ADMIN","ROLE_DOCIN_DUBAN")>  
            <li <#if menuHighLight == 'docin_isduban'>class="high_light"</#if>>
                <a href="${appDomain}/docin/docin_isduban.htm">收文督办</a>
            </li>
            </#if>
            <#if userAuth("ROLE_ADMIN","ROLE_DOCIN_CHANGE")>  
            <li <#if menuHighLight == 'docin_lcbg_list'>class="high_light"</#if>>
                <a href="${appDomain}/docin/docin_lcbg_list.htm">流程变更</a>
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