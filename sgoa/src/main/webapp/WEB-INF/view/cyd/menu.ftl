 <div class="side">
  <div class="s_menu">
    <div class="gnct">
      <p>功能菜单</p>
    </div>
	<div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">传阅单管理</a></p>
        </div>
       <ul class="sub-list">			
          <#if userAuth("ROLE_ADMIN","ROLE_CYD")>
          <li <#if menuHighLight == 'cyd_list'>class="high_light"</#if>>
                <a href="${appDomain}/cyd/cyd_list.htm">传阅单列表</a>
            </li>
            <li <#if menuHighLight == 'to_add_cyd'>class="high_light"</#if>>
                <a href="${appDomain}/cyd/to_add_cyd.htm">登记传阅单</a>
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