<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>流程查看</title>
	<script type="text/javascript">
		mxBasePath = '${jsDomain}/js/workflow';
	</script>
	<script type="text/javascript" src="${jsDomain}/js/ztree/jquery-1.4.4.min.js"></script>
	<!-- Loads and initializes the library -->
	<script type="text/javascript" src="${jsDomain}/js/workflow/js/mxClient.js"></script>

	<!-- Example code -->
	<script type="text/javascript">
		// Program starts here. Creates a sample graph in the
		// DOM node with the specified ID. This function is invoked
		// from the onLoad event handler of the document (see below).
		function main(container)
		{
			// Checks if the browser is supported
			if (!mxClient.isBrowserSupported())
			{
				// Displays an error message if the browser is not supported.
				mxUtils.error('Browser is not supported!', 200, false);
			}
			else
			{
				// Creates the graph inside the given container
				var graph = new mxGraph(container);

				// Disables moving of edge labels in this examples
				graph.edgeLabelsMovable = false;
				graph.setEnabled(false);
				
				// Enables rubberband selection
				new mxRubberband(graph);

				// Needs to set a flag to check for dynamic style changes,
				// that is, changes to styles on cells where the style was
				// not explicitely changed using mxStyleChange
				graph.getView().updateStyle = true;
				
				// Overrides mxGraphModel.getStyle to return a specific style
				// for edges that reflects their target terminal (in this case
				// the strokeColor will be equal to the target's fillColor).
				var previous = graph.model.getStyle;
				
				graph.model.getStyle = function(cell)
				{
					if (cell != null)
					{
						var style = previous.apply(this, arguments);
						
						if (this.isEdge(cell))
						{
							var target = this.getTerminal(cell, false);

							if (target != null)
							{
								var state = graph.getView().getState(target);
								var targetStyle = (state != null) ? state.style : graph.getCellStyle(target);
								var fill = mxUtils.getValue(targetStyle, mxConstants.STYLE_FILLCOLOR);
								
								if (fill != null)
								{
									style += ';strokeColor='+fill;
								}
							}
						}
						else if (this.isVertex(cell))
						{
							var geometry = this.getGeometry(cell);
						}
						
						return style;
					}
					
					return null;
				};
				
				// Gets the default parent for inserting new cells. This
				// is normally the first child of the root (ie. layer 0).
				var parent = graph.getDefaultParent();
								
				// Adds cells to the model in a single step
				graph.getModel().beginUpdate();
				try
				{
					// 取得流程信息
			        $.ajax({
			            type: 'GET',
			            contentType: 'application/json',
			            url: '/common/get_work_flow.htm',
			            dataType: 'json',
			            data: 'busId=' + $("#busId").val() + '&approvalId=' + $("#approvalId").val() + '&type=' + $("#type").val()+ '&steps=' + $("#steps").val() + '&r=' + Math.random(),
			            success: function(data){
			            	// 从Controller里取得对象数组
			            	var dataObj=data.workFlowList;
							var j = 0;
							var res = null;
							var resValue = null;
							var rstValue = null;
							for(var i=0;i<dataObj.length;i++){
								var rtValue = null;
								if(dataObj[i].draftsName != null){
									var words = dataObj[i].draftsName.split(',');
									for(var j=0;j<words.length;j++){
										rtValue = graph.insertVertex(parent, null, words[j], 100+200*j, 40+90*i,200,30, 'fillColor='+dataObj[i].color);
										if(rstValue == null){
											rstValue = rtValue;
										}
									}
									if(i != 0){
										graph.insertEdge(parent, null, '下一步', resValue, rstValue, 'perimeterSpacing=2;strokeWidth=2;labelBackgroundColor=white;fontStyle=1');
										resValue = null;
									}
								}
								//v1 = graph.insertVertex(parent, null, dataObj[i].draftsName, 100, 40+90*i,200,30, 'fillColor='+dataObj[i].color);
								if (i < dataObj.length-1) {
									i++;
									var rsValue = null;
									if(dataObj[i].draftsName != null){
										var wordsObj = dataObj[i].draftsName.split(',');
										for(var k=0;k<wordsObj.length;k++){
											rsValue = graph.insertVertex(parent, null, wordsObj[k], 100+200*k, 40+90*i,200,30, 'fillColor='+dataObj[i].color);
											if(resValue == null){
												resValue = rsValue;
											}
										}
									}
									var e1 = graph.insertEdge(parent, null, '下一步', rstValue, resValue, 'perimeterSpacing=2;strokeWidth=2;labelBackgroundColor=white;fontStyle=1');
									rstValue = null;
								}
							}
			            },
			            error: function(){
			            	// 请求错误时,提示用户
			                alert("取得部门信息失败！");
			            }
			        });
				}
				finally
				{
					// Updates the display
					graph.getModel().endUpdate();
				}
			}
		};
	</script>
    </head>
    <body onload="main(document.getElementById('graphContainer'))">
    	<input type="hidden" name="busId" id="busId" value="${busId}"/>
    	<input type="hidden" name="approvalId" id="approvalId" value="${approvalId}"/>
    	<input type="hidden" name="type" id="type" value="${type}"/>
    	<input type="hidden" name="steps" id="steps"  value="${steps}"/>
		<div id="graphContainer" style="overflow:auto;width:100%;height:100%;_height:560px; height:460px;background:url('${jsDomain}/js/workflow/images/grid.gif')">
			<div style="font-size:13px;">
				颜色说明：  <span style="color:#4A708B; font-size:22px;">■</span>未处理&nbsp;&nbsp;
					   <span style="color:#66CCFF; font-size:22px;">■</span>已处理&nbsp;&nbsp;
					   <span style="color:#F76E30; font-size:22px;">■</span>处理中&nbsp;&nbsp;
					   <span style="color:#49DF8D; font-size:22px;">■</span>办理完毕&nbsp;&nbsp;
					   <span style="color:red; font-size:22px;">■</span>否决&nbsp;&nbsp;
			</div>
		</div>
    </body>
</html>