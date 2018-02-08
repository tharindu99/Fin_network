<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Fin network</title>
	<!-- Bootstrap -->
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="build/css/custom.min.css" rel="stylesheet">
    <link href="css/jquery.auto-complete.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/tabs.css">
    <style type="text/css">
      #container{
       position: relative;
       overflow: hidden;
      }
    </style>
</head>
<body class="nav-md">
    <div class="container body">
      <div class="main_container">
         <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
             <jsp:include page="menu.jsp" />
            <div class="clearfix"></div>           
          </div>
        </div> 
        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>
          </div>
        </div>
        <!-- /top navigation --> 
        <!-- page content -->
        <div class="right_col" role="main">
          <div class="row">
           <div class="x_panel">
           		<div class="x_title">
                    <h2>TNIC DataSet</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <div class="input-group">
	                    <input id="company_search" type="text" class="form-control" placeholder="Search for...">
	                    <span class="input-group-btn">
	                      <button id="select_company" class="btn btn-default" type="button">Go!</button>
	                    </span>
                  	</div>
                  </div>
           </div>
           <div id="company_network" class="x_panel" >
           		<div class="x_title">
                    <h2 id="company_header" ></h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                  <div class="col-xs-2">
                      <!-- required for floating -->
                      <!-- Nav tabs -->
                      <ul class="nav nav-tabs tabs-left">
                        <li class="active"><a href="#id2015" data-toggle="tab">2015</a></li>
                        <li><a href="#id2014" data-toggle="tab">2014</a></li>
                        <li><a href="#id2013" data-toggle="tab">2013</a></li>
                        <li><a href="#id2012" data-toggle="tab">2012</a></li>
                        <li><a href="#id2011" data-toggle="tab">2011</a></li>
                        <li><a href="#id2010" data-toggle="tab">2010</a></li>
                        <li><a href="#id2009" data-toggle="tab">2009</a></li>
                        <li><a href="#id2008" data-toggle="tab">2008</a></li>
                        <li><a href="#id2007" data-toggle="tab">2007</a></li>
                        <li><a href="#id2006" data-toggle="tab">2006</a></li>
                        <li><a href="#id2005" data-toggle="tab">2005</a></li>
                        <li><a href="#id2004" data-toggle="tab">2004</a></li>
                        <li><a href="#id2003" data-toggle="tab">2003</a></li>
                        <li><a href="#id2002" data-toggle="tab">2002</a></li>
                        <li><a href="#id2001" data-toggle="tab">2001</a></li>
                        <li><a href="#id2000" data-toggle="tab">2000</a></li>
                        <li><a href="#id1999" data-toggle="tab">1999</a></li>
                        <li><a href="#id1998" data-toggle="tab">1998</a></li>
                        <li><a href="#id1997" data-toggle="tab">1997</a></li>
                        <li><a href="#id1996" data-toggle="tab">1996</a></li>
                      </ul>
                    </div>

                    <div class="col-xs-10">
                      <!-- Tab panes -->
                      <div class="tab-content">
                        <div class="tab-pane active" id="id2015"><div id="content_2015" style="height:650px;"></div></div>
                        <div class="tab-pane" id="id2014"><div id="content_2014" style="height:650px;"></div></div>
                        <div class="tab-pane" id="id2013"><div id="content_2013" style="height:650px;"></div></div>
                        <div class="tab-pane" id="id2012">2012</div>
                        <div class="tab-pane" id="id2011">2011</div>
                        <div class="tab-pane" id="id2010">2010</div>
                        <div class="tab-pane" id="id2009">2009</div>
                        <div class="tab-pane" id="id2008">2008</div>
                        <div class="tab-pane" id="id2007">2007</div>
                        <div class="tab-pane" id="id2006">2006</div>
                        <div class="tab-pane" id="id2005">2005</div>
                        <div class="tab-pane" id="id2004">2004</div>
                        <div class="tab-pane" id="id2003">2003</div>
                        <div class="tab-pane" id="id2002">2002</div>
                        <div class="tab-pane" id="id2001">2001</div>
                        <div class="tab-pane" id="id2000">2000</div>
                        <div class="tab-pane" id="id1999">1999</div>
                        <div class="tab-pane" id="id1998">1998</div>
                        <div class="tab-pane" id="id1997">1997</div>
                        <div class="tab-pane" id="id1996">1996</div>
                      </div>
                    </div>		
						
				</div>
           </div>
           </div>
       </div>
       </div>
      
       
      
       
        <!-- footer content -->
        <footer>

        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="vendors/pnotify/dist/pnotify.js"></script>
    <script src="vendors/pnotify/dist/pnotify.buttons.js"></script>
    <script src="build/js/custom.min.js"></script>
    <script src="js/d3.v4.min.js"></script>
    <script src="js/d3-selection-multi.v1.js"></script>
    <script src="js/TNIC2_viz.js"></script>
    <script src="js/jquery.auto-complete.min.js"></script>

    <script>
     $(document).ready(function (){
    	//$("#company_network").hide();
     	$('.ui-pnotify').remove(); 
     	
     	$.getJSON("rest/tnic2/company",
     		function(data) {
     		$('#company_search').autoComplete({
                minChars: 1,
                source: function(term, suggest){
                    term = term.toLowerCase();
                    var choices = data.company;
                    var suggestions = [];
                    for (i=0;i<choices.length;i++)
                        if (~choices[i].toLowerCase().indexOf(term)) suggestions.push(choices[i]);
                    suggest(suggestions);
                }
            });        
     	});
     	
     	$("#select_company").click(function(){
     		var company_record = $('#company_search').val();
     		var company_cik = null;
     		var company_tsy ='';
     		if(company_record){
     			var res = company_record.split("cik:");
     			if(res.length>1){
     				var cik_no = res[1].split(" ");
     				var tsy = res[0].split(" ")
     				if(cik_no.length>1){
     					company_cik = cik_no[1];
     					company_tsy = tsy[0];
     					$("#company_network").show();
     					$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+"</h2>");
     					
     					$("#select_company").click(function(){});
     					TNIC2_viz("rest/tnic2/"+company_cik+"/2015","content_2015");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/2014","content_2014");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/2012","content_2012");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/2011","content_2011");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/2010","content_2010");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/2009","content_2009");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/2008","content_2008");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/2007","content_2007");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/2006","content_2006");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/2005","content_2005");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/2004","content_2004");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/2003","content_2003");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/2002","content_2002");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/2001","content_2001");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/2000","content_2000");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/1999","content_1999");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/1998","content_1998");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/1997","content_1997");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/1996","content_1996"); 
     					
     					
     				}
     			}
     		}
     		
     		
     		//console.log(company_cik+"  "+ company_tsy);
     	});
    	
     	
     	//TNIC2_viz("rest/sec/ADP/2013","content_2015");
     	
     });
     
    </script>

  </body>
</html>