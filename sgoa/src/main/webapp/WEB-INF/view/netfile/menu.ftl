<div class="side">
  <div class="s_menu">
    <div class="gnct">
      <p>功能菜单</p>
    </div>
	<div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">网络硬盘</a></p>
        </div>
       <ul class="sub-list">
        	<li <#if menuHighLight == 'netfile_list'>class="high_light"</#if>>
                 <a href="${appDomain}/netFile/list.htm">我的文件</a>
            </li>
        </ul>
      </div>
	  </div>
	  <div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">网络硬盘</a></p>
        </div>
       <ul class="sub-list">
           <li <#if menuHighLight == 'shareDownList'>class="high_light"</#if>>
                <a href="${appDomain}/netFile/shareDownList.htm">共享(可下载)</a>
            </li>
        </ul>
      </div>
	  </div>
	  <div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">网络硬盘</a></p>
        </div>
       <ul class="sub-list">
        	 <li <#if menuHighLight == 'netfile_search_list'>class="high_light"</#if>>
                <a href="${appDomain}/netFile/search_list.htm">文件查询</a>
            </li>
        </ul>
      </div>
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
