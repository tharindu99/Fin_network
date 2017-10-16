function dispalyResult(url){

	console.log("drawing " + url);

	// load JSON data from URL
	d3.json(url, function(error, data) {

			// get the length of the JSON object which also means number of companies that should be displayed
			var numOfDiv = Object.keys(data.companyData).length;
			
			// get the id of the div element which results get displayed
			document.getElementById("resultDiv").innerHTML = null;
			
			// dynamically creating and adding elements to html page
			for (var i = 0; i < numOfDiv; i++) {
				
				// create a link to display company name with type and CIK
				var nameLink = document.createElement('a');
				nameLink.id = 'companyName'+i;
				nameLink.style.fontSize = "15px";
				// add the link to resultDIV
				document.getElementById("resultDiv").appendChild(nameLink);

				// format the company name text and set it as the text of the link
				var companyName = data.companyData[i].companyName;
				if(companyName.split(":").length == 3){
					nameLink.textContent = companyName.split(":")[1] + '\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0' + " Type : " + companyName.split(":")[0] + " entity" + '\xa0\xa0\xa0\xa0 CIK : ' + companyName.split(":")[2];
				}
				else{
					nameLink.textContent = companyName.split(":")[1] + '\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0' + " Type : " + companyName.split(":")[0] + " entity";
				}
				
				// when the link is clicked, it will got to this url with the companyName parameter
				document.getElementById("companyName"+i).href = "../../FinNetwork/companyYearWise.jsp?param=" + companyName.split(":")[1];
				
				// create a div to display bar chart
				var chartDiv = document.createElement('div');
				chartDiv.id = 'barChart'+i;
				chartDiv.style.width = '500px';
				chartDiv.style.height = '250px';
				// append it after company name
				document.getElementById("companyName"+i).appendChild(chartDiv);

			}
			
			// this data is for x axis of the bar chart
			var years = ['x', '2011', '2012', '2013', '2014', '2015', '2016'];
			
			// format json data and extract number of connections for years for y axis of the bar chart
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
			
			
			// calling drawChart function with div ID, x axis data and y axis data
			for (var i = 0; i < numOfDiv; i++) {
				var tagID = "#barChart"+i;
				drawChart(tagID, years, chartData[i])
			}

			// Function to draw bar chart using c3
			function drawChart(tagID, datax, datay) {

				var chart = c3.generate({	
					bindto: tagID,		// tag this chart to passed div ID
			    data: {
						x : 'x',
		        columns: [
		            datax,		// data for x axis
		            datay,		// data for y axis
		        ],
		        type: 'bar',		// draw a bar chart
						colors: {
		            connections: '#27576c'
		        },
						labels: true		// display values on top of the each bar
			    },
			    tooltip: {
			        show: false		// disable tooltip
			    },
					axis: {
			        x: {
			            type: 'category',		// seperate each bar with a white space
			            height: 30
			        }
			    },
					bar: {
		        width: {
		            ratio: 0.5		// bar width
		        }
		    	}
			  });

			}
	});
}
