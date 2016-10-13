<div class="side">
  <div class="s_menu">
    <div class="gnct">
      <p>功能菜单</p>
    </div>
	<div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">知识管理</a></p>
        </div>
       <ul class="sub-list">
           <#if userAuth("ROLE_ADMIN","ROLE_RESFILE_UPLOAD")>
       
            <li <#if menuHighLight == 'resfile_folder'>class="high_light"</#if>>
                <a href="${appDomain}/resFile/folder.htm">知识上传</a>
            </li>
             </#if>
        </ul>
      </div>
    </div>
    <div class="simu">
      <div class="woie">
        <div class="module">
          <p><a href="#">共享管理</a></p>
        </div>
       <ul class="sub-list">
           <#if userAuth("ROLE_ADMIN","ROLE_RESFILE_LOOK")>
        	<li <#if menuHighLight == 'resfile_folder_all'>class="high_light"</#if>>
                <a href="${appDomain}/resFile/folder_all.htm">知识浏览</a>
            </li>
             </#if>
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
