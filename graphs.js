$(function() {
		var xy=[[0,98],[1,98.3],[2,98],[3,98.6],[5,98],[6,98],[8,98.5],[10,98.5],[12,98],[13,98.9],[14,98.2]];

		var d5 = xy;
		// for (var i = 0; i < 14; i += 0.5) {
		// 	d5.push([i, Math.sqrt(i)]);
		// }

		$.plot("#placeholder", [{
		// 	data: d2,
		// 	bars: { show: true }
		// },{
		// 	data: d3,
		// 	points: { show: true }
		// },{
			data: d5,
			lines: { show: true },
			points: { show: true, radius: 5},
			grid: {hoverable: true}
		}]);

		$("#footer").prepend("Flot " + $.plot.version + " &ndash; ");
	});
