<div class="side">
  <div class="s_menu">
    <div class="gnct">
      <p>功能菜单</p>
    </div>
	<div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">消息中心</a></p>
        </div>
       <ul class="sub-list">
            <li <#if menuHighLight == 'remind_list'>class="high_light"</#if>>
                <a href="${appDomain}/remind/remind_list.htm">消息中心列表</a>
            </li>
        </ul>
      </div>
	  </div>
    </div>
  <div class="s_io"> <a href="#"><img src="../images/sq.jpg" /> </a></div>
  </div>
<script type="text/javascript">
    $(document).ready(function(){
        var leftHeight = document.documentElement.clientHeight;
        $("#left").height(leftHeight + "px");
    });
</script>
