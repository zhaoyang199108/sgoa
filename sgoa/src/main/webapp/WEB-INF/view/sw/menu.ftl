 <div class="side">
  <div class="s_menu">
    <div class="gnct">
      <p>功能菜单</p>
    </div>
	<div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">收文流转管理</a></p>
        </div>
       <ul class="sub-list">
          <#if userAuth("ROLE_ADMIN","ROLE_DOCIN_EDIT")>
            <li <#if menuHighLight == 'add_sw'>class="high_light"</#if>>
                <a href="${appDomain}/sw/add_sw.htm">登记收文</a>
            </li>
            <li <#if menuHighLight == 'my_draft_list'>class="high_light"</#if>>
                <a href="${appDomain}/sw/my_draft_list.htm">等待处理</a>
            </li>
            <li <#if menuHighLight == 'sw_list'>class="high_light"</#if>>
                <a href="${appDomain}/sw/list.htm">已发收文</a>
            </li>
           </#if>
           <#if userAuth("ROLE_ADMIN","ROLE_DOCIN_LOOK")>  
           <li <#if menuHighLight == 'sw_received'>class="high_light"</#if>>
                <a href="${appDomain}/sw/sw_received.htm">已收收文</a>
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