(function($) {

	$.suggest = function(input, options) {
		var $input = $(input).attr("autocomplete", "off");
		var $results;
		var $defaules = [ {
			infoId : 1,
			publisher : ''
		} ];// 默认点击显示列表
		var timeout = false; // hold timeout ID for suggestion results to
		// appear
		var prevLength = 0; // last recorded length of $input.val()
		var cache = []; // cache MRU list
		var cacheSize = 0; // size of cache in chars (bytes?)
		var settings = options;
		if (!options.attachObject)
			options.attachObject = $(document.createElement("ul")).appendTo(
					'body');
		$results = $(options.attachObject);
		$results.addClass(options.resultsClass);
		resetPosition();
		$(window).load(resetPosition) // just in case user is changing size of
				// page while loading
				.resize(resetPosition);
		$input.blur(function() {
			setTimeout(function() {
				$results.hide()
			}, 200);
		});
		$input.focus(function() {
			if ($.trim($(this).val()) == '') {
				displayItems('');
			}
		});
		$input.click(function() {
			var q = $.trim($(this).val());
			displayItems(q);
			// $(this).select();
			});

		// help IE users if possible
		try {
			$results.bgiframe();
		} catch (e) {
		}
		$input.keyup(processKey);//
		function resetPosition() {
			// requires jquery.dimension plugin
			var offset = $input.offset();
			$results.css( {
				top : (offset.top + input.offsetHeight) + 'px',
				left : offset.left + 'px'
			});
		}
		function processKey(e) {
			// handling up/down/escape requires results to be visible
			// handling enter/tab requires that AND a result to be selected
			if ((/27$|38$|40$/.test(e.keyCode) && $results.is(':visible'))
					|| (/^13$|^9$/.test(e.keyCode) && getCurrentResult())) {
				if (e.preventDefault)
					e.preventDefault();
				if (e.stopPropagation)
					e.stopPropagation();
				e.cancelBubble = true;
				e.returnValue = false;
				switch (e.keyCode) {
				case 38: // up
					prevResult();
					break;
				case 40: // down
					nextResult();
					break;
				case 13: // return
					selectCurrentResult();
					break;
				case 27: // escape
					$results.hide();
					break;
				}
				e.cancelBubble = true;
				e.returnValue = false;
			} else if ($input.val().length != prevLength) {
				if (timeout)
					clearTimeout(timeout);
				timeout = setTimeout(suggest, options.delay);
				prevLength = $input.val().length;
			}
		}
		function suggest() {
			var q = $.trim($input.val());
			displayItems(q);
		}
		function displayItems(items) {
			var html = '';
			if (items == '') {
			} else {
				$.ajax( {
					type : 'POST',
					// url : 'suggestJson.jsp',
					url : settings.url,
					async : false,
					data : 'date=' + new Date() + "&titlePy="
							+ encodeURI(items),
					success : function(_data) {
						var data = eval(_data);
						$.each(
							data,
							function(h, entry) {
								html += '<li rel="'
										+ entry['id']
										+ '"><a alt="'+entry['id']+'" style="display:block;" href="'+settings.urlres+'/Dept/5800'+entry['deptId']+'.htm'
										+ '">'
										+ entry['name']
										+ '</a><span>'
										+ entry['deptName']
										+ '</span></li>';
							});
					},
					error : function() {
						suggest_tip = '';
					}
				});
				html = '<ul>' + html + '</ul>';
			}
			$results.html(html).show();
			$results.children('ul').children('li:first-child').addClass(
					options.selectClass);
			$results.children('ul').children('li').mouseover(
					function() {
						$results.children('ul').children('li').removeClass(
								options.selectClass);
						$(this).addClass(options.selectClass);
					}).click(function(e) {
				e.preventDefault();
				e.stopPropagation();
				selectCurrentResult();
			});
		}
		function getCurrentResult() {
			if (!$results.is(':visible'))
				return false;
			var $currentResult = $results.children('ul').children(
					'li.' + options.selectClass);
			if (!$currentResult.length) {
				$currentResult = false;
			}
			return $currentResult;
		}
		function selectCurrentResult() {
			$currentResult = getCurrentResult();
			if ($currentResult) {
				$("#id").val($currentResult.children('a').attr("alt"));
				$input.val($currentResult.children('a').html());
				window.location.href=$currentResult.children('a').attr("href");
				$results.hide();
			}
		}
		function nextResult() {
			$currentResult = getCurrentResult();
			if ($currentResult)
				$currentResult.removeClass(options.selectClass).next()
						.addClass(options.selectClass);
			else
				$results.children('ul').children('li:first-child').addClass(
						options.selectClass);
		}
		function prevResult() {
			$currentResult = getCurrentResult();
			if ($currentResult)
				$currentResult.removeClass(options.selectClass).prev()
						.addClass(options.selectClass);
			else
				$results.children('ul').children('li:last-child').addClass(
						options.selectClass);
		}
	}
	$.fn.suggest = function(options) {
		options = options || {};
		options.delay = options.delay || 500;
		options.resultsClass = options.resultsClass || 'ac_results';
		options.selectClass = options.selectClass || 'ac_over';
		options.matchClass = options.matchClass || 'ac_match';
		options.onSelect = options.onSelect || false;
		options.dataDelimiter = options.dataDelimiter || '\t';
		options.attachObject = options.attachObject || null;
		this.each(function() {
			new $.suggest(this, options);
		});
		return this;
	};
})(jQuery);