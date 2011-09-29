$(document).ready(function() {
	
});


function load(name, index) {
	var container = $('#' + name);
	var oldContainer = $('.active-content');
	var arrow = $('#arrow');
	$('.arrow-container').show();
	oldContainer.removeClass('active-content');
	var after = function() {
		arrow.animate({
			left: index * 200 + 60
			}, 300, function() {
				container.addClass('active-content');
				container.fadeIn(300);
				$.scrollTo($('.portfolio'), 500, 'top');
			});
	};
	if (oldContainer.size() > 0) {
		oldContainer.fadeOut(300, after());		
	} else {
		after();
	}
	 
}