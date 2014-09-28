$(function() {

		$.plot("#placeholder", [{
			data: bbt_data,
			color: '#BE1623',
			lines: {show: true},
			points: {show: true},
		}],
		);
		$("#footer").prepend("Flot " + $.plot.version + " &ndash; ");
	});