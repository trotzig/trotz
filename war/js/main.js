function load(name, index) {
	var container = $('#' + name);
	loadItems(container, name);
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
var slider;
function loadItems(container, section) {
	container.html("...");
	$.getJSON('/portfolio/' + section, function(json) {
		container.empty();
		container.addClass("slider");
		var next = $('<a href="" class="next"/>');
		var previous = $('<a href="" class="previous"/>');
		var items = $('<div class="portfolio-items"/>');
		for ( var i = 0; i < json.length; i++) {
			var item = json[i];
			var div = $('<div class="item"/>');
			var box = $('<div class="info">');
			box.append('<p class="header">' + item.name + '</p>');
			box.append('<p class="desc">' + item.description + '</p>');
			if (item.extra) {
				box.append('<p class="extra">' + item.extra + '</p>');
			}
			div.append(box);
			div.append($('<img>', {src: item.image}));
			items.append(div);
		}
		container.append(items);
		container.append(next);
		container.append(previous);
		slider = new Lectric();
		slider.init(items, {next: previous, previous: next});
		
	});
}
