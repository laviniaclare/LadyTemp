// Set up Firebase references
var firebaseMain = new Firebase("https://ladytemp.firebaseio.com");
var firebaseTemp = firebaseMain.child('data');

function sensorPlot() {
	var time_read = [];
	var temp_read = [];
	var temp_plot = [];

	var time_in_sec = 0;
	firebaseTemp.on('child_added', function(snapshot){
		
		// Grab sensor data from Firebase

		new_temp = snapshot.val();
		console.log(new_temp);
		document.getElementById("updated_temp").innerHTML = new_temp;
		time_read.push(time_in_sec);
		temp_read.push(new_temp);

		// Put sensor data into Flot format [[x1,y1], [x2,y2]]
		temp_plot.push([time_in_sec, new_temp]);
		console.log(temp_plot);

		// Plot data

		var plot = $.plot("#placeholder", [temp_plot], {
			series: {
				shadowSize: 0
			},
			yaxis: {
				show: true,
				min: 50,
				max: 100
			},
			xaxis: {
				show: true
			}
		});

		function update() {
			plot.setData([temp_plot]);

			plot.setupGrid();

			plot.draw();
		}
		update();

		time_in_sec = time_in_sec + 1;

	});
}

sensorPlot()