function dispalyResult(url){
	console.log("drawing " + url);

	var barDiv = document.getElementById("barChart");
	var margin = {top: 20, right: 20, bottom: 20, left: 20};
	var width = barDiv.clientWidth - margin.left - margin.right;
	var height = barDiv.clientHeight - margin.top - margin.bottom;

	var x = d3.scaleBand()
          .range([0, width])
          .padding(0.1);
	var y = d3.scaleLinear()
          .range([height, 0]);

	var svg = d3.select("#barChart").append("svg")
    .attr("width", width + margin.left + margin.right)
    .attr("height", height + margin.top + margin.bottom)
  .append("g")
    .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

	d3.json(url, function(error, data) {
		if (error) throw error;

		// format the data
	  data.companyData.forEach(function(d) {
			d.connectionDetails.forEach(function(i) {
				console.log(i.conn);
			});
	  });


	});

}
