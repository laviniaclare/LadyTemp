$(function() {

		function generate(offset, amplitude) {

			var res = [];
			var start = 0, end = 10;

			for (var i = 0; i <= 50; ++i) {
				var x = start + i / 50 * (end - start);
				res.push([x, amplitude * Math.sin(x + offset)]);
			}

			return res;
		}

		var data = [
			{ data: generate(2, 1.8), points: { symbol: "circle" } },
			{ data: generate(3, 1.5), points: { symbol: "square" } },
			{ data: generate(4, 0.9), points: { symbol: "diamond" } },
			{ data: generate(6, 1.4), points: { symbol: "triangle" } },
			{ data: generate(7, 1.1), points: { symbol: "cross" } }
		];

		$.plot("#placeholder", data, {
			series: {
				points: {
					show: true,
					radius: 3
				}
			},
			grid: {
				hoverable: true
			}
		});

		// Add the Flot version string to the footer

		$("#footer").prepend("Flot " + $.plot.version + " &ndash; ");
	});
