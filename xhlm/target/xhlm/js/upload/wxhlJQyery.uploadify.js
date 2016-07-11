$(document).ready(function (){
			$('#uploadify').uploadify({
				'uploader':'jquery.uploadify-v2.1.4/uploadify.swf',
				'cancelImg':'jquery.uploadify-v2.1.4/cancel.png',
				'method': 'get',//提交方式
				'script':'uploayify',//后台处理程序的相对路径
				'scriptData': {'_path':'file'},//传参数(method 为 get 时有效)
				'queueID': 'div1',
				'folder': 'file',//上传文件保存的位置
				'onComplete'	 : function(event,queueId,fileObj,response,data){
				},
				'onAllComplete': function (event, data){//文件全部上传完成后调用
					_showAll(1);
					$("#_wxhl2").html("\u6587\u4ef6\u4e0a\u4f20\u6210\u529f\uff0c\u5171\u4e0a\u4f20\u6587\u4ef6 " + data.filesUploaded + "" + " \u4e2a\uff0c\u603b\u4e0a\u4f20\u5927\u5c0f\u4e3a\uff1a" + data.allBytesLoaded + " KB");
					_hideTime();
				},
				'buttonText': 'BROWSE',//选择文件按钮文字
				//'buttonImg': 'button_browse.png',//选择文件按钮背景
				'hideButton': false,//是否隐藏选择文件按钮，默认为false
				//'width': 65,//设置按钮宽度 默认120 
				//'height': 26,//设置按钮高度 默认30
				'queueSizeLimit':6,//设置最多上传文件个数
				'sizeLimit': 5120000,//允许文件上传大小( 单位：KB)
				'auto':false,//是否立即上传
				//'fileExt' :'*.jpg,*.gif',//设置文件上传格式
				//'fileDesc': '请选择 .jpg,.gif 文件',//设置文件上传格式显示文字
				'multi': true //是否可以上传多个文件
			});
			$("#_wxhl").css("width",document.body.scrollWidth);
			$("#_wxhl").css("height",document.body.scrollHeight);
			$("#wxhlfileupload").css("top",document.body.scrollHeight/2-200);
			$("#wxhlfileupload").css("left",document.body.scrollWidth/2-200);
			$("#uploadify").attr("valign","absmiddle");
			$("#wxhlfileupload").attr("onselectstart","return false");
			$("#_wxhl").attr("onselectstart","return false");
		});
		function _showAll(p1){
			$("#_wxhl").show();
			if(p1==1){
				$("#_wxhl2").show();
				$("#_wxhl1").hide();
				$("#div1").hide();
			}else{
				$("#_wxhl2").hide();
				$("#_wxhl1").show();
				$("#div1").show();
			}
		}
		function _hideTime(){
			setTimeout("$('#_wxhl').hide(300)",2000);
		}function _hide(){
			$('#uploadify').uploadifyClearQueue();
			$('#_wxhl').hide(300);
		}
		
var datelayerx, datelayery;
var bDrag=false;
function document.onmousemove() {
	if (bDrag && window.event.button == 1) {
		var a=document.all.wxhlfileupload.style;
		//$("#div1").html(a.posLeft +"--"+ window.event.clientX +"--"+ datelayerx+"<br><br>"+a.posTop +"--"+ window.event.clientY +"--"+datelayery);
		a.posLeft = window.event.clientX - datelayerx;
		a.posTop = window.event.clientY - datelayery;
		//$("#div1").html($("#div1").html()+"<br><br>"+a.posLeft +"--"+ window.event.clientX +"--"+ datelayerx+"<br><br>"+a.posTop +"--"+ window.event.clientY +"--"+datelayery);
	}
}
function DragStart() {
		var a=document.all.wxhlfileupload.style;
		datelayerx = window.event.clientX - a.posLeft;
		datelayery = window.event.clientY - a.posTop;
		bDrag = true;
}
function DragEnd() {
	bDrag = false;
}
document.oncontextmenu=function (){ event.cancelBubble = true; event.returnValue = false; return false;}

