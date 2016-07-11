(function($) {
  $.fn.downloadr = function() {
  	return this.each(function() {
  	
  	function returnBrowserTest(){
				
					var dlBrowser = $.browser.browser();
					
					var dlString = '';
					
					switch(dlBrowser){
					
						case "Safari":
						
						dlString = 'right click on the icon below and choose <strong>Save Linked File As...</strong> or <strong>Download Linked File As...</strong> from the menu.';
						
						break;
						
						case "Firefox":
						
						dlString = 'right click on the icon below and choose <strong>Save Link As...</strong> from the menu.'
						
						break;
						
						case "Msie":
						
						dlString = 'right click on the icon below and choose <strong>Save Target As...</strong>.';
						
						break;
						
						default:
						
						dlString = 'right click on the icon below and choose <strong>Save Target As...</strong> from the menu.';
					}
					
					
					return dlString;
				}	
				
				var element = this;
			  
			  	$(element).addClass("download_link");
			  	
			  	var theTitle = $(element).attr('title');
			  				  	
				var theLink = $(element).attr('href');
	
			  	$(element).bind('click',function(e){
			  	
			  		e.preventDefault();

				  	var html = "";
				  	
				  	html += "<h2>下载</h2>";
				  	html += "<p>单击下面图片下载, 或者单击右键,选择目标另存为……进行下载" + "</p>";
				  	html += "<p style='text-align:center;'><a href='" + theLink + "'><img src='../js/download/downloadr/download.png' alt='点击右键 目标另存为……' id='download_file'/></a></p>";
				  	html += "<p>如果您想在浏览器中打开，请单击 <strong><a href='" + theLink + "'>这里</a></strong>.</p>";
				  	
				  	jQuery.facebox(html);
			  		
			  	});
			  	});

  }
})(jQuery);