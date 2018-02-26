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
                	<button id="grph2015" type="button" class="btn btn-default">2015</button>
					<button id="grph2014" type="button" class="btn btn-default">2014</button>
					<button id="grph2013" type="button" class="btn btn-default">2013</button>
					<button id="grph2012" type="button" class="btn btn-default">2012</button>
					<button id="grph2011" type="button" class="btn btn-default">2011</button>
					<button id="grph2010" type="button" class="btn btn-default">2010</button>
					<button id="grph2009" type="button" class="btn btn-default">2009</button>
					<button id="grph2008" type="button" class="btn btn-default">2008</button>
					<button id="grph2007" type="button" class="btn btn-default">2007</button>
					<button id="grph2006" type="button" class="btn btn-default">2006</button>
					<button id="grph2005" type="button" class="btn btn-default">2005</button>
					<button id="grph2004" type="button" class="btn btn-default">2004</button>
					<button id="grph2003" type="button" class="btn btn-default">2003</button>
					<button id="grph2002" type="button" class="btn btn-default">2002</button>
					<button id="grph2001" type="button" class="btn btn-default">2001</button>
					<button id="grph2000" type="button" class="btn btn-default">2000</button>
					<button id="grph1999" type="button" class="btn btn-default">1999</button>
					<button id="grph1998" type="button" class="btn btn-default">1998</button>
					<button id="grph1997" type="button" class="btn btn-default">1997</button>
					<button id="grph1996" type="button" class="btn btn-default">1996</button>
                   
                    <div id="content_btn" style="height:650px;"></div>
                    
                   
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
    	$("#company_network").hide();
     	$('.ui-pnotify').remove(); 
     	
     	$.getJSON("rest/tnic2/company",
     		function(data) {
     		console.log(data.company);
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
     					$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 2015 </h2>");
     					TNIC2_viz("rest/tnic2/"+company_cik+"/2015","content_btn");
     					
     					$("#grph2015").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 2015 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/2015","content_btn");});
     					$("#grph2014").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 2014 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/2014","content_btn");});	
     					$("#grph2013").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 2013 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/2013","content_btn");});
     					$("#grph2012").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 2012 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/2012","content_btn");});
     					$("#grph2011").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 2011 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/2011","content_btn");});
     					$("#grph2010").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 2010 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/2010","content_btn");});
     					$("#grph2009").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 2009 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/2009","content_btn");});
     					$("#grph2008").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 2008 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/2008","content_btn");});
     					$("#grph2007").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 2007 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/2007","content_btn");});
     					$("#grph2006").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 2006 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/2006","content_btn");});
     					$("#grph2005").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 2005 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/2005","content_btn");});
     					$("#grph2004").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 2004 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/2004","content_btn");});
     					$("#grph2003").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 2003 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/2003","content_btn");});
     					$("#grph2002").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 2002 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/2002","content_btn");});
     					$("#grph2001").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 2001 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/2001","content_btn");});
     					$("#grph2000").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 2000 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/2000","content_btn");});
     					$("#grph1999").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 1999 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/1999","content_btn");});
     					$("#grph1998").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 1998 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/1998","content_btn");});
     					$("#grph1997").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 1997 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/1997","content_btn");});
     					$("#grph1996").click(function(){$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik+" | Year : 1996 </h2>");TNIC2_viz("rest/tnic2/"+company_cik+"/1996","content_btn");});
     					
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