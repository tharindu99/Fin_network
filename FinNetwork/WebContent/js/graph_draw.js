function draw_me(filename){
 
            console.log(filename +" trying to draw");

            d3.select("#container").selectAll("svg").remove();

            var graphDiv = document.getElementById("container");
            var svg = d3.select(graphDiv).append("svg")
                        .attr('width', '100%')
                        .attr('height', '100%')
            var width = graphDiv.clientWidth;
            var height = graphDiv.clientHeight;

            var node_color = ['red','blue'];

            svg = svg.call(d3.zoom().on("zoom", zoomed));

            var color = d3.scaleOrdinal(d3.schemeCategory20);

            svg.append("defs").append("marker")
                .attr("id", "arrow")
                .attr("viewBox", "0 -5 10 10")
                .attr("refX", 20)
                .attr("refY", 0)
                .attr("markerWidth", 5)
                .attr("markerHeight", 5)
                .attr("orient", "auto")
                .append("svg:path")
                .attr("d", "M0,-5L10,0L0,5")
                .attr('fill', '#999');

            var simulation = d3.forceSimulation()
                .force("link", d3.forceLink().id(function (d) {return d.id;}).distance(200))
                .force("charge", d3.forceManyBody())
                .force("center", d3.forceCenter(width / 2, height / 2));
            console.log("data/"+filename+".json");
            d3.json("data/"+filename+".json", function(error, graph) {
            if (error) throw error;

            var link = svg.append("g")
                .attr("class", "links")
                .selectAll("line")
                .data(graph.links)
                .enter().append("line")
                .attr("marker-end", "url(#arrow)")
                .attr("stroke-width", 1)
                .style("stroke","#5F91FA")
                .on('mouseover', edge_mouseover)
                .on('mouseout', edge_mouseout)
                .on('click', edge_click);

            var node = svg.selectAll("circle")
                .data(graph.nodes)
                .enter().append("g")
                .attr("class", "nodes")
                .call(d3.drag()
                    .on("start", dragstarted)
                    .on("drag", dragged)
                    .on("end", dragended))
                    .on('click', connectedNodes);

            node.append("circle")
                .attr("class", "nodes")
                .attr("r", 5)
                .attr("fill", "#3F4061")
                .on('mouseover', node_mouseover(0))
                .on('mouseout', node_mouseout);

            /* var node = svg.append("g")
                .attr("class", "nodes")
                .selectAll("circle")
                .data(graph.nodes)
                .enter().append("circle")
                .attr("r", 5)
                .attr("fill", "#3F4061")
                .on('mouseover', node_mouseover(0))
                .on('mouseout', node_mouseout)
                .call(d3.drag()
                    .on("start", dragstarted)
                    .on("drag", dragged)
                    .on("end", dragended))
                    .on('click', connectedNodes);

            /*var nodelabels = svg.selectAll(".nodelabel")
                .data(graph.nodes)
                .enter()
                .append("text")
                .attrs({"x":function(d){return d.x;},
                        "y":function(d){return d.y;},
                        "class":"nodelabel",
                        'font-size': 8,
                        "stroke":"gray"})
                .text(function(d){return d.equity;});*/

            edgepaths = svg.selectAll(".edgepath")
                        .data(graph.links)
                        .enter()
                        .append('path')
                        .attrs({
                            'class': 'edgepath',
                            'fill-opacity': 0,
                            'stroke-opacity': 0,
                            'id': function (d, i) {return 'edgepath' + i}
                        })
                        .style("pointer-events", "none");

                edgelabels = svg.selectAll(".edgelabel")
                    .data(graph.links)
                    .enter()
                    .append('text')
                    .style("pointer-events", "none")
                    .attrs({
                        'class': 'edgelabel',
                        'id': function (d, i) {return 'edgelabel' + i}
                    })
                    .append('textPath')
                    .attr('xlink:href', function (d, i) {return '#edgepath' + i})
                    .style("text-anchor", "middle")
                    .style("pointer-events", "none")
                    .attr("startOffset", "50%")
                    .text(function (d) {return predicate_filter(d.predicate)});

            node.append("text")
                .attr('dx', 10)
                .attr('dy', '.35em')
                .text(function(d) {
                    return d.equity;
                })
                .style('font-family', 'sans-serif')
                .style("font-weight", "bold")
                .style('fill', '#55584E')
                .style("font-size", "11");
            
          
            simulation
                .nodes(graph.nodes)
                .on("tick", ticked);

            simulation.force("link")
                .links(graph.links);

        function ticked() {
            link
            .attr("x1", function(d) { return d.source.x; })
            .attr("y1", function(d) { return d.source.y; })
            .attr("x2", function(d) { return d.target.x; })
            .attr("y2", function(d) { return d.target.y; });

            node.attr("transform", function (d) {
            return "translate(" + d.x + "," + d.y + ")";
        });

        // nodelabels.attr("x", function(d) { return d.x; })
        //               .attr("y", function(d) { return d.y; });

             edgepaths.attr('d', function (d) {
                return 'M ' + d.source.x + ' ' + d.source.y + ' L ' + d.target.x + ' ' + d.target.y;
            });

            edgelabels.attr('transform', function (d) {
                if (d.target.x < d.source.x) {
                    var bbox = this.getBBox();

                    rx = bbox.x + bbox.width / 2;
                    ry = bbox.y + bbox.height / 2;
                    return 'rotate(180 ' + rx + ' ' + ry + ')';
                }
                else {
                    return 'rotate(0)';
                }
            });
    
    }
   
    function node_mouseover(opacity){
                    return function(d) {
                        // check all other nodes to see if they're connected
                        // to this one. if so, keep the opacity at 1, otherwise
                        // fade
                        node.style("stroke-opacity", function(o) {
                            thisOpacity = isConnected(d, o) ? 1 : opacity;
                            return thisOpacity;
                        });
                        node.style("fill-opacity", function(o) {
                            thisOpacity = isConnected(d, o) ? 1 : opacity;
                            return thisOpacity;
                        });
                        // also style link accordingly
                        link.style("stroke-opacity", function(o) {
                            return o.source === d || o.target === d ? 1 : opacity;
                        });
                        link.style("stroke-width", function(o){
                            return o.source === d || o.target === d ? o.source.colour : 2;
                        });
                        link.attr('marker-end', o => (opacity === 1 || o.source === d || o.target === d ? 'url(#arrow)' : 'url(#arrow-fade)'));
                        link.style('stroke-width', '2.5px');

                        edgelabels.style("visibility",function(o){
                            return o.source===d || o.target===d ? "visible":"hidden";
                        
                        });

                        
                    };
            }
            function node_mouseout(){
                    node.style("stroke-opacity", 1);
                    node.style("fill-opacity", 1);
                    link.style("stroke-opacity", 1);
                    link.style("stroke-width", 1);
                    link.attr("marker-end", "url(#arrow)");
                    edgelabels.style("visibility","visible");
                    
                // link.style("stroke", "#ddd");
            }
            function isConnected(a, b) {
                return linkedByIndex[`${a.index},${b.index}`] || linkedByIndex[`${b.index},${a.index}`] || a.index === b.index;
            }

            //Toggle stores whether the highlighting is on
            var toggle = 0;
            //Create an array logging what is connected to what
            var linkedByIndex = {};
            for (i = 0; i < graph.nodes.length; i++) {
                linkedByIndex[i + "," + i] = 1;
            };
            graph.links.forEach(function (d) {
                linkedByIndex[d.source.index + "," + d.target.index] = 1;
            });
            //This function looks up whether a pair are neighbours
            function neighboring(a, b) {
                return linkedByIndex[a.index + "," + b.index];
            }

            function edge_mouseover(d) {
            d3.select(this).style('stroke-width', '3.5px');
            }

            function edge_mouseout(d) {
            d3.select(this).style('stroke-width', '1px');
            }

            function connectedNodes() {
                if (toggle == 0) {
                    //Reduce the opacity of all but the neighbouring nodes
                    d = d3.select(this).node().__data__;
                    node.style("opacity", function (o) {
                        return neighboring(d, o) | neighboring(o, d) ? 1 : 0;
                    });
                    link.style("opacity", function (o) {
                        return d.index==o.source.index | d.index==o.target.index ? 1 : 0;
                    })
                        .style('stroke-width', '2.5px');

                   
                        //.text(function (o) {return d.index==o.source.index | d.index==o.target.index ? o.context : "";});

                    //$('#sideBar').css('display', 'none');
                // $('#container').css('left', '0px');
                    //Reduce the op
                    toggle = 1;

                } else {
                    //Put them back to opacity=1
                    node.style("opacity", 1);
                    link.style("opacity", 1);
                    
                // $('#sideBar').css('display', 'none');
                // $('#container').css('left', '0px');
                // svg.selectAll("text").remove();
                    toggle = 0;
                }
               
            }
            });

            

            function predicate_filter(a){
                var res = a.split("/");
                var tmp ;
                var prd = res[res.length-1];
                return prd;
            }

            function predicate_scaller(a){
                var res = a.split("/");
                var cnt = 1 ;
                var prd = res[res.length-1];
                if(prd==="hasImmediateParent") cnt = 5;
                if(prd==="hasUltimateParent") cnt = 10;
                if(prd==="isSupplierOf") cnt = 15;
               // console.log(cnt);
                return cnt ;
            }


            function dragstarted(d) {
            if (!d3.event.active) simulation.alphaTarget(0.3).restart();
            d.fx = d.x;
            d.fy = d.y;
            }

            function dragged(d) {
            d.fx = d3.event.x;
            d.fy = d3.event.y;
            }

            function dragended(d) {
            if (!d3.event.active) simulation.alphaTarget(0);
            d.fx = null;
            d.fy = null;
            }

            function zoomed() {
            svg.attr("transform", "translate(" + d3.event.transform.x + "," + d3.event.transform.y + ")" + " scale(" + d3.event.transform.k + ")");
            }
            function edge_click(d){
            new PNotify({
                title: 'Edge Details',
                text: 'Source: '+d.source.equity+'<br> Target: '+d.target.equity+'<br>Context: '+d.predicate+'<br>Predicts: '+d.predicate,
                type: 'success',
                styling: 'bootstrap3'
            });
            }

        
        
        
        
}


function draw_TR(filename,bind_id,company_id,year){
    
        var graphDiv = document.getElementById(bind_id);
        var svg = d3.select(graphDiv).append("svg")
                    .attr('width', '100%')
                    .attr('height', '100%')
        var width = graphDiv.clientWidth;
        var height = graphDiv.clientHeight;
    
        var node_color = ['red','blue'];
    
       // svg = svg.call(d3.zoom().on("zoom", zoomed));
    
        var color = d3.scaleOrdinal(d3.schemeCategory20);
    
        svg.append("defs").append("marker")
            .attr("id", "arrow")
            .attr("viewBox", "0 -5 10 10")
            .attr("refX", 20)
            .attr("refY", 0)
            .attr("markerWidth", 4)
            .attr("markerHeight", 4)
            .attr("orient", "auto")
          .append("svg:path")
            .attr("d", "M0,-5L10,0L0,5")
            .attr('fill', '#999');
    
        var simulation = d3.forceSimulation()
            .force("link", d3.forceLink().id(function (d) {return d.id;}).distance(175))
            .force("charge", d3.forceManyBody())
            .force("center", d3.forceCenter(width / 2, height / 2));
    
        d3.json("data/"+filename+".json", function(error, graph) {
          if (error) throw error;
    
          var modify_graph = {links:[],nodes:[]};
              Array.prototype.push.apply(modify_graph.links,graph.links.filter(function(d){return d.source == company_id | d.target == company_id;}));
              console.log(modify_graph);
          var temp_nodes = new Array();
            
          //console.log(modify_graph.links[0]);  
          for (var i = 0; i < modify_graph.links.length; i++) {
             temp_nodes.push(modify_graph.links[i].source);  
             temp_nodes.push(modify_graph.links[i].target); 
          };
    
          for (var i = 0; i < temp_nodes.length; i++) {
            modify_graph.nodes.push(graph.nodes.filter(function(d){return d.id == temp_nodes[i];}))
          };
    
        //console.log(modify_graph);
    
             
          
            
    
         // console.log(temp_nodes);
          //console.log(graph);
    
          var link = svg.append("g")
            .attr("class", "links")
            .selectAll("line")
            .data(graph.links.filter(function(d){return d.source == company_id | d.target == company_id;}))
            //.data(graph.links[0])
            .enter().append("line")
            .attr("marker-end", "url(#arrow)")
            .attr("stroke-width", 1)
            .style("stroke",function(d) { return color(d.role); })
            .on('mouseover', edge_mouseover)
            .on('mouseout', edge_mouseout)
            .on('click', edge_click);
    
         var node = svg.selectAll("circle")
              .data(graph.nodes.filter(function(d){return temp_nodes.includes(d.id);}))
            .enter().append("g")
              .attr("class", "nodes")
              .call(d3.drag()
                  .on("start", dragstarted)
                  .on("drag", dragged)
                  .on("end", dragended));
                  //.on('click', connectedNodes);
    
          node.append("circle")
              .attr("class", "nodes")
              .attr("r", 4)
              .attr("fill", "#3F4061")
              .on('mouseover', node_mouseover(0))
              .on('mouseout', node_mouseout);
    
    
          edgepaths = svg.selectAll(".edgepath")
                    .data(graph.links)
                    .enter()
                    .append('path')
                    .attrs({
                        'class': 'edgepath',
                        'fill-opacity': 0,
                        'stroke-opacity': 0,
                        'id': function (d, i) {return 'edgepath' + i+"e"+company_id+"s"+year}
                    })
                    .style("pointer-events", "none");
    
            edgelabels = svg.selectAll(".edgelabel")
                .data(graph.links)
                .enter()
                .append('text')
                .style("pointer-events", "none")
                .attrs({
                    'class': 'edgelabel',
                    'id': function (d, i) {return 'edgelabel' + i+"e"+company_id+"s"+year}
                });
    
    
    
    
          node.append("text")
              .attr('dx', 10)
              .attr('dy', '.35em')
              .text(function(d) {
                return d.equity;
              })
              .style('font-family', 'sans-serif')
              .style("font-weight", "bold")
              .style('fill', '#55584E')
              .style("font-size", "11");
    
          simulation
              .nodes(graph.nodes)
              .on("tick", ticked);
    
          simulation.force("link")
              .links(graph.links);
    
          function ticked() {
            link
                .attr("x1", function(d) { return d.source.x; })
                .attr("y1", function(d) { return d.source.y; })
                .attr("x2", function(d) { return d.target.x; })
                .attr("y2", function(d) { return d.target.y; });
    
           node.attr("transform", function (d) {
                return "translate(" + d.x + "," + d.y + ")";
            });
    
            // nodelabels.attr("x", function(d) { return d.x; })
            //               .attr("y", function(d) { return d.y; });
    
            // edgepaths.attr('d', function (d) {
            //         return 'M ' + d.source.x + ' ' + d.source.y + ' L ' + d.target.x + ' ' + d.target.y;
            //     });
    
                // edgelabels.attr('transform', function (d) {
                //     if (d.target.x < d.source.x) {
                //         var bbox = this.getBBox();
    
                //         rx = bbox.x + bbox.width / 2;
                //         ry = bbox.y + bbox.height / 2;
                //         return 'rotate(180 ' + rx + ' ' + ry + ')';
                //     }
                //     else {
                //         return 'rotate(0)';
                //     }
                // });
          }
          function node_mouseover(opacity){
                return function(d) {
                    // check all other nodes to see if they're connected
                    // to this one. if so, keep the opacity at 1, otherwise
                    // fade
                    node.style("stroke-opacity", function(o) {
                        thisOpacity = isConnected(d, o) ? 1 : opacity;
                        return thisOpacity;
                    });
                    node.style("fill-opacity", function(o) {
                        thisOpacity = isConnected(d, o) ? 1 : opacity;
                        return thisOpacity;
                    });
                    // also style link accordingly
                    link.style("stroke-opacity", function(o) {
                        return o.source === d || o.target === d ? 1 : opacity;
                    });
                    link.style("stroke-width", function(o){
                        return o.source === d || o.target === d ? o.source.colour : 2;
                    });
                    link.attr('marker-end', o => (opacity === 1 || o.source === d || o.target === d ? 'url(#arrow)' : 'url(#arrow-fade)'));
                    link.style('stroke-width', '2.5px');
                };
          }
          function node_mouseout(){
                node.style("stroke-opacity", 1);
                node.style("fill-opacity", 1);
                link.style("stroke-opacity", 1);
                link.style("stroke-width", 1);
                link.attr("marker-end", "url(#arrow)");
               // link.style("stroke", "#ddd");
          }
          function isConnected(a, b) {
            return linkedByIndex[`${a.index},${b.index}`] || linkedByIndex[`${b.index},${a.index}`] || a.index === b.index;
          }
    
        //Toggle stores whether the highlighting is on
        var toggle = 0;
        //Create an array logging what is connected to what
        var linkedByIndex = {};
        for (i = 0; i < graph.nodes.length; i++) {
            linkedByIndex[i + "," + i] = 1;
        };
        graph.links.forEach(function (d) {
            linkedByIndex[d.source.index + "," + d.target.index] = 1;
        });
        //This function looks up whether a pair are neighbours
        function neighboring(a, b) {
            return linkedByIndex[a.index + "," + b.index];
        }
    
        function edge_mouseover(d) {
          d3.select(this).style('stroke-width', '3.5px');
        }
    
        function edge_mouseout(d) {
          d3.select(this).style('stroke-width', '1px');
        }
    
        function connectedNodes() {
    
           if (toggle == 0) {
                //Reduce the opacity of all but the neighbouring nodes
                d = d3.select(this).node().__data__;
    
                //console.log(d);
    
                node.style("opacity", function (o) {
                    return neighboring(d, o) | neighboring(o, d) ? 1 : 0;
                });
                link.style("opacity", function (o) {
                    return d.index==o.source.index | d.index==o.target.index ? 1 : 0;
                })
                    .style('stroke-width', '2.5px');
    
                edgelabels.append('textPath')
                    .attr('xlink:href', function (d, i) {return '#edgepath' + i+"e"+company_id+"s"+year})
                    .style("text-anchor", "middle")
                    .style("pointer-events", "none")
                    .style("font", "11px sans-serif")
                    .style("font-weight", "bold")
                    .style('fill', '#55584E')
                    .attr("startOffset", "50%")
                    .text(function (o) {return d.index==o.source.index | d.index==o.target.index ? "" : "";});
    
                
                //Reduce the op
                toggle = 1;
    
            } else {
                //Put them back to opacity=1
                node.style("opacity", 1);
                link.style("opacity", 1);
                edgelabels.text("");
                
                toggle = 0;
            }
        }
        });
    
        function dragstarted(d) {
          if (!d3.event.active) simulation.alphaTarget(0.3).restart();
          d.fx = d.x;
          d.fy = d.y;
        }
    
        function dragged(d) {
          d.fx = d3.event.x;
          d.fy = d3.event.y;
        }
    
        function dragended(d) {
          if (!d3.event.active) simulation.alphaTarget(0);
          d.fx = null;
          d.fy = null;
        }
    
        function zoomed() {
          svg.attr("transform", "translate(" + d3.event.transform.x + "," + d3.event.transform.y + ")" + " scale(" + d3.event.transform.k + ")");
        }
        function edge_click(d){
          new PNotify({
              title: 'Edge Details',
              text: 'Source: '+d.source.equity+'<br> Target: '+d.target.equity+'<br>role: '+d.role+'<br>Sentences: '+d.threeSentences,
              type: 'success',
              styling: 'bootstrap3'
          });
        }
    }




function draw_me_single_equity(url,bind_id,company_id,year){
	console.log(url+" "+bind_id+" "+company_id+" "+year);
    //d3.select("#container").selectAll("svg").remove();
    //var graphDiv = document.getElementById("container");
	var graphDiv = document.getElementById(bind_id);
    var svg = d3.select(graphDiv).append("svg")
                            .attr('width', '100%')
                            .attr('height', '100%');

    var width = graphDiv.clientWidth;
    var height = graphDiv.clientHeight;

    svg.append('defs').append('marker')
    .attrs({'id':'arrowhead',
        'viewBox':'-0 -5 10 10',
        'refX':13,
        'refY':0,
        'orient':'auto',
        'markerWidth':8,
        'markerHeight':8,
        'xoverflow':'visible'})
    .append('svg:path')
    .attr('d', 'M 0,-5 L 10 ,0 L 0,5')
    .attr('fill', '#999')
    .style('stroke','none');

var color = d3.scaleOrdinal(d3.schemeCategory20);

    var simulation = d3.forceSimulation()
        .force("link", d3.forceLink().distance(200).strength(0.1))
        .force("charge", d3.forceManyBody())
        .force("center", d3.forceCenter(width / 2, height / 2));

    d3.json(url, function(error, graph) {
    	
        if (error) {
        	console.log(error);
        	throw error;
        }
		
		var modify_graph = {nodes:[], links:[]};
        Array.prototype.push.apply(modify_graph.links,graph.links.filter(function(d){return d.source === company_id | d.target == company_id;}));
        //console.log(modify_graph);
        var temp_nodes = new Array();
            
        //console.log(modify_graph.links[0]);  
        for (var i = 0; i < modify_graph.links.length; i++) {
            temp_nodes.push(modify_graph.links[i].source);  
            temp_nodes.push(modify_graph.links[i].target); 
        };
       
		var unique_temp_nodes = Array.from(new Set(temp_nodes));
	
			console.log('temp ', unique_temp_nodes);
			console.log('init modify graph nodes', modify_graph.nodes);
			for (var i = 0; i < unique_temp_nodes.length; i++) {
				//modify_graph.nodes.push(graph.nodes.filter(function(d){return d.id == temp_nodes[i];}))
				Array.prototype.push.apply(modify_graph.nodes,graph.nodes.filter(function(d){return d.id == unique_temp_nodes[i];}));
			};
		
		
			console.log('modify graph nodes', modify_graph);
			console.log('graph nodes', graph);
			//console.log(temp_nodes);
		var nodes = modify_graph.nodes,
           nodeById = d3.map(nodes, function(d) { return d.id; }),
           links = modify_graph.links,
           bilinks = [];

        links.forEach(function(link) {
            var s = link.source = nodeById.get(link.source),
                t = link.target = nodeById.get(link.target),
                i = {}
                pred = link.role = predicate_filter(link.role),
                context = link.threeSentences = link.threeSentences; // intermediate node
            nodes.push(i);
            links.push({source: s, target: i}, {source: i, target: t});
            bilinks.push([s, i, t,pred,context]);
        });

        var link = svg.selectAll(".link")
            .data(bilinks)
            .enter().append("path")
            .attr("class", "link")
            .attr("stroke","#bbb")
            .attr("fill","none")
            .attr('marker-end','url(#arrowhead)')
            .on('mouseover', edge_mouseover)
            .on('mouseout', edge_mouseout)
            .on('click', edge_click);

        var node = svg.selectAll(".node")
            .data(nodes.filter(function(d) { return d.id; }))
            .enter().append("g")
            .attr("class", "node")
            .call(d3.drag()
                .on("start", dragstarted)
                .on("drag", dragged)
                .on("end", dragended));

            node.append("circle")
				.attr("class", "nodes")
                .attr("r", 5)
                .attr("fill", "blue" )
                .on('mouseover', node_mouseover(0))
                .on('mouseout', node_mouseout);

            node.append("text")
          .attr('dx', 10)
          .attr('dy', '.35em')
          .text(function(d) {
            return d.equity;
          })
          .style('font-family', 'sans-serif')
          .style("font-weight", "bold")
          .style('fill', '#55584E')
          .style("font-size", "11");

		edgepaths = svg.selectAll(".edgepath")
				.data(bilinks)
				.enter()
				.append('path')
				.attrs({
					'class': 'edgepath',
					'fill-opacity': 0,
					'stroke-opacity': 0,
					'id': function (d, i) {return 'edgepath' + i+"e"+company_id+"s"+year}
				})
				.style("pointer-events", "none");

		// edgelabels = svg.selectAll(".edgelabel")
		// 		.data(bilinks)
		// 		.enter()
		// 		.append('text')
		// 		.style("pointer-events", "none")
		// 		.attrs({
		// 			'class': 'edgelabel',
		// 			'id': function (d, i) {return 'edgelabel' + i +"e"+company_id+"s"+year},
		// 			'font-size': 10,
		// 			'fill': '#aaa'
		// 		})
		// 		.append('textPath')
		// 		.attr('xlink:href', function (d, i) {return '#edgepath' + i +"e"+company_id+"s"+year})
		// 		.style("text-anchor", "middle")
		// 		.style("pointer-events", "none")
		// 		.attr("startOffset", "50%")
		// 		.text(function(d){
		// 			return d[3];
		// 		});



  simulation
      .nodes(nodes)
      .on("tick", ticked);

  simulation.force("link")
      .links(links);

  function ticked() {
    link.attr("d", positionLink);
    node.attr("transform", positionNode);
    edgepaths.attr("d",positionLink);

    // edgepaths.attr('d', function (d) {
    //     return 'M ' + d[0].x + ' ' + d[0].y + ' L ' + d[1].x + ' ' + d[1].y;
    // });

    // edgelabels.attr('transform', function (d) {
    //     if (d[1].x < d[0].x) {
    //         var bbox = this.getBBox();

    //         rx = bbox.x + bbox.width / 2;
    //         ry = bbox.y + bbox.height / 2;
    //         return 'rotate(180 ' + rx + ' ' + ry + ')';
    //     }
    //     else {
    //         return 'rotate(0)';
    //     }
    // });
  }

  //add zoom capabilities
    var zoom_handler = d3.zoom()
    .on("zoom", zoom_actions);
    zoom_handler(svg);

    var linkedByIndex = {};
    for (i = 0; i < graph.nodes.length; i++) {
        linkedByIndex[i + "," + i] = 1;
    };
    graph.links.forEach(function (d) {
        linkedByIndex[d.source.index + "," + d.target.index] = 1;
    });

    function isConnected(a, b) {
        return linkedByIndex[`${a.index},${b.index}`] || linkedByIndex[`${b.index},${a.index}`] || a.index === b.index;
    }

    function node_mouseover(opacity){
        return function(d){
            node.style("stroke-opacity",function(o){
                thisOpacity = isConnected(d, o) ? 1 : opacity;
                return thisOpacity;
            });
            node.style("fill-opacity", function(o){
                thisOpacity = isConnected(d, o) ? 1 : opacity;
                return thisOpacity;
            });
            link.style("stroke-opacity", function(o) {
                console.log(o);
                return o[0].id === d.id || o[2].id === d.id ? 1 : opacity;
            });
            link.attr('marker-end',function(o){
                return o[0].id === d.id || o[2].id === d.id ? 'url(#arrowhead)' : 'url(#arrowhead-fade)';
            });
            link.style('stroke-width', '2px');
            edgelabels.style("visibility",function(o){
                return o[0].id === d.id || o[2].id === d.id ? "visible":"hidden";

            });


        }
    }
    function node_mouseout(){
        node.style("stroke-opacity",1);
        node.style("fill-opacity", 1);
        link.style("stroke-opacity", 1);
        link.style("stroke-width", 1);
        link.attr("marker-end", "url(#arrowhead)");
        edgelabels.style("visibility","visible");
    }
    function edge_mouseover(d) {
        d3.select(this).style('stroke-width', '3.5px');
    }

    function edge_mouseout(d) {
        d3.select(this).style('stroke-width', '1px');
    }
    function edge_click(d){
        new PNotify({
            title: 'Edge Details',
            text: 'Source: '+d[0].equity+'<br> Target: '+d[2].equity+'<br>role: '+d[3]+'<br>Sentences: '+d[4],
            type: 'success',
            styling: 'bootstrap3'
        });
    }



});

function positionLink(d) {
  return "M" + d[0].x + "," + d[0].y
       + "S" +( d[1].x+10) + "," + d[1].y+10
       + " " + d[2].x + "," + d[2].y;
}

function positionNode(d) {
  return "translate(" + d.x + "," + d.y + ")";
}

function dragstarted(d) {
  if (!d3.event.active) simulation.alphaTarget(0.3).restart();
  d.fx = d.x, d.fy = d.y;
}

function dragged(d) {
  d.fx = d3.event.x, d.fy = d3.event.y;
}

function dragended(d) {
  if (!d3.event.active) simulation.alphaTarget(0);
  d.fx = null, d.fy = null;
}

//Zoom functions
function zoom_actions(){
    svg.attr("transform", d3.event.transform)
}
function predicate_filter(a){
    var res = a.split("/");
    var tmp ;
    var prd = res[res.length-1];
    return prd;
}

}
function a(){
	console.log("me balapan yakoo");
}

