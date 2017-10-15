function dispalyResult(url){

	console.log("drawing " + url);

	d3.json(url, function(error, data) {

			var numOfDiv = Object.keys(data.companyData).length;

			document.getElementById("resultDiv").innerHTML = null;

			for (var i = 0; i < numOfDiv; i++) {
				var nameLink = document.createElement('a');
				nameLink.id = 'companyName'+i;
				nameLink.style.fontSize = "15px";
				document.getElementById("resultDiv").appendChild(nameLink);

				var companyName = data.companyData[i].companyName;
				if(companyName.split(":").length == 3){
					nameLink.textContent = companyName.split(":")[1] + '\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0' + " Type : " + companyName.split(":")[0] + " entity" + '\xa0\xa0\xa0\xa0 CIK : ' + companyName.split(":")[2];
				}
				else{
					nameLink.textContent = companyName.split(":")[1] + '\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0' + " Type : " + companyName.split(":")[0] + " entity";
				}

				document.getElementById("companyName"+i).href = "#";
								
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
					var item = ['connections'];
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

				var chart = c3.generate({
					bindto: tagID,
			    data: {
						x : 'x',
		        columns: [
		            datax,
		            datay,
		        ],
		        type: 'bar',
						colors: {
		            connections: '#27576c'
		        },
						labels: true
			    },
			    tooltip: {
			        show: false
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
