<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${cssDomain}/css/allknow.css" type="text/css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="${jsDomain}/js/wst/css/reset.css" />
		<link rel="stylesheet" type="text/css" href="${jsDomain}/js/wst/css/cal_index.css" />
		<script type="text/javascript" src="${jsDomain}/js/wst/js/json.js"></script>
		<script type="text/javascript" src="${jsDomain}/js/wst/js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="${jsDomain}/js/wst/js/cal_main.js"></script>
		<script type="text/javascript" src="${jsDomain}/js/wst/js/calendarObj.js"></script>
		<script type="text/javascript" src="${jsDomain}/js/wst/js/workTime.js"></script>
        <title>万事通</title>
		<script type="text/javascript">
    	$(document).ready(function() {
    	
		    // 万年历点击事件
		    $("#wnlBtn").click(function(){
		    	$("#cal_container").show(); 
		    	$("#cal_container").init_cal(new Date(),'cal_container');
		    });
		    
		    // 地图点击事件
		    $("#mapBtn").click(function(){
		    	$("#cal_container").hide(); 
		    	$("#cal_container1").show();
		    	$("#cal_container2").hide();
		    	initialize();
		    });
		    
		    // 天气点击事件
		    $("#tqBtn").click(function(){
		    	$("#cal_container").hide(); 
		    	$("#cal_container1").hide();
		    	$("#cal_container2").show();
		    });

		});
    </script>
    <style type="text/css">
	html {
		height: 100%;
	}
	body {
		height: 100%;
		margin: 0px;
		padding: 0px;
	}
	#map_canvas {
		height: 468px;width:498px;
}
</style>
</head>
<body onload="">	
   <div id="smsbox_panel">
      <div class="head-title">
      	万事通
      </div>
      <div class="center">
         <div class="center-left">
            <div class="new_noc_list">
            	<ul class="noc_iterm_data">
            		<li><a id="wnlBtn" class="noc_iterm_content" href="#">万年历</a></li>
            		<li><a id="mapBtn" class="noc_iterm_content" href="#">地图</a></li>
            		<li><a id="tqBtn" class="noc_iterm_content" href="#">当地天气</a></li>
            	</ul>
            </div>
         </div>
         <div class="center-right">
            <div class="cal_container" id="cal_container" >
			</div>
			<div  id="cal_container1" >
				<div id="map_canvas"></div>
				<div id="content" style="display:none;" >
					<span id="loca"></span><br />
  					<span id="addr"></span>
  				</div>
			</div>
			<div id="cal_container2" style="display:none;align:center;">
				<iframe id="tqIframe" src="http://www.thinkpage.cn/weather/weather.aspx?uid=&cid=101270101&l=zh-CHS&p=CMA&a=0&u=C&s=1&m=1&x=1&d=3&fc=F47837&bgc=&bc=&ti=1&in=1&li=2&ct=iframe" frameborder="0" scrolling="no" width="450" height="400" allowTransparency="true"></iframe>
			</div>
         </div>
      </div>
   </div>
   <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script> 
	<script type="text/javascript">
		var map;
		var marker;
		var infowindow;
		var geocoder;
		var markersArray = [];
		
		var content = document.getElementById("content");
		var loca = document.getElementById("loca")
		var addr = document.getElementById("addr")
		
		function initialize() {
			geocoder = new google.maps.Geocoder(); 
			var latlng = new google.maps.LatLng(104.067923,30.679943);
		    var myOptions = {
				zoom: 11,
				center: latlng,
				navigationControl: true,
				scaleControl: true,
				streetViewControl: true,	  
				mapTypeId: google.maps.MapTypeId.ROADMAP
		    };
		    map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
			
			google.maps.event.addListener(map, 'click', function(event) {
				placeMarker(event.latLng);
		  	});
		  }
		
		function placeMarker(location) {
			clearOverlays(infowindow);
			marker = new google.maps.Marker({
				position: location, 
				map: map
			});
			markersArray.push(marker);
			
			var _cs = [];
			_cs[_cs.length] = "坐标为：";
			_cs[_cs.length] = location.lat();
			_cs[_cs.length] = ",";
			_cs[_cs.length] = location.lng();
			
			loca.innerHTML = _cs.join("");
			
			if (geocoder) {
			  geocoder.geocode({'location': location}, function(results, status) {
		        if (status == google.maps.GeocoderStatus.OK) {
				  if (results[0]) {
				  	addr.innerHTML = " 地址为：" + results[0].formatted_address;
				  } 
				} else {
					alert("Geocoder failed due to: " + status);
				}
			  });
			}
			
			content.style.display = "";
		 
			infowindow = new google.maps.InfoWindow({   
				content: content,
		        //size: new google.maps.Size(50,50),
		        position: location
		    });
		  	infowindow.open(map);
		 }
		 
		  // Deletes all markers in the array by removing references to them
		function clearOverlays(infowindow) {
			if (markersArray) {
				for (i in markersArray) {
					markersArray[i].setMap(null);
				}
				markersArray.length = 0;
			}
			if(infowindow){
				infowindow.close();
			}
		} 
	</script>
</body>
</html>
