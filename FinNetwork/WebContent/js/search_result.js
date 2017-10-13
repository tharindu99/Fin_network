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
				chartDiv.id = 'barChart';
				chartDiv.style.background = '#fff';
				chartDiv.style.width = '500px';
				chartDiv.style.height = '250px';
				document.getElementById("companyName"+i).appendChild(chartDiv);
			}

	});
}
