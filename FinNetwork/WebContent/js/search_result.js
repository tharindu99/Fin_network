function dispalyResult(url){
	console.log("drawing " + url);

	d3.json(url, function(error, data) {

			var numOfDiv = Object.keys(data.companyData).length;

			for (var i = 0; i < numOfDiv; i++) {
				var nameDiv = document.createElement('div');
				nameDiv.id = 'companyName'+i;
				document.getElementById("resultDiv").appendChild(nameDiv);
				nameDiv.textContent = data.companyData[i].companyName;

				var chartDiv = document.createElement('div');
				chartDiv.id = 'barChart'+i;
				chartDiv.style.width = '500px';
				chartDiv.style.height = '250px';
				document.getElementById("companyName"+i).appendChild(chartDiv);

			}

			var years = ['x', '2011', '2012', '2013', '2014', '2015', '2016'];
			var chartData = [];
			data.companyData.forEach(
				function(d, i) {
					var item = ['year'];
					d.connectionDetails.forEach(
						function(j) {
							item.push(j.conn);
						}
					);
					chartData.push(item);
				}
			);

			for (var i = 0; i < numOfDiv; i++) {
				var tagID = "#barChart"+i;
				drawChart(tagID, years, chartData[i])
			}

			function drawChart(tagID, datax, datay) {
				console.log(datax);
				console.log(datay);
				console.log(tagID);

				var chart = c3.generate({
					bindto: tagID,
			    data: {
							x : 'x',
	        columns: [
	            datax,
	            datay,
	        ],
	        type: 'bar',
					labels: true
			    },
					axis: {
			        x: {
			            type: 'category',
			            height: 30
			        }
			    },
					bar: {
		        width: {
		            ratio: 0.5
		        }
		    	}
			  });

			}
	});
}
