$(function() {
	$.fn.toTop = function(options) {
		var defaults = {
			showHeight: 150,
			speed: 500
		}

		var options = $.extend(defaults, options);
		$('body').append('<div id="toTop"></div>');

		var $toTop = $('#toTop');

		$(window).scroll(function(event) {
			var scrollTop = $(window).scrollTop();
			if(scrollTop >= options.showHeight) {
				$toTop.show();
			} else {
				$toTop.hide();
			}
		});

		$toTop.hover(function() {
			$(this).addClass('cur');
		}, function() {
			$(this).removeClass('cur');
		});

		$toTop.click(function(event) {
			$('html,body').animate({scrollTop: 0}, options.speed);
		});
	}
});