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
                    <h2>TRDF ground truth DataSet</h2>
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
    <script src="js/TRDF_gt_viz.js"></script>
    <script src="js/jquery.auto-complete.min.js"></script>

    <script>
     $(document).ready(function (){
    	$("#company_network").hide();
     	$('.ui-pnotify').remove(); 
     	
     	$.getJSON("rest/trdf_gt/company",
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
     		var company_uriID = null;
     		var company_tsy ='';
     		if(company_record){
     			var res = company_record.split("CIK:");
     			if(res.length>1){
     				var cik_no = res[1].split(" ");
     				
     				var tsy = res[0]
     				if(cik_no.length>1){
     					company_cik = cik_no[1];
     					company_uriID = cik_no[3];
     					company_tsy = tsy;
     					$("#company_network").show();
     					$("#company_header").html("<h2>"+company_tsy+ " | CIK : " +company_cik);
     					TRDF_gt_viz("rest/trdf_gt/"+company_uriID,"content_btn");
     					
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