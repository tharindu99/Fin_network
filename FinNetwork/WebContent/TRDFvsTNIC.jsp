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
    <link href="vendors/ion.rangeSlider/css/ion.rangeSlider.css" rel="stylesheet">
    <link href="vendors/ion.rangeSlider/css/ion.rangeSlider.skinFlat.css" rel="stylesheet">
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
                    <h2>TRDF Vs TNIC </h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  	<div class="col-md-3 col-sm-6 col-xs-12">
	                	<input id="company_search" type="text" class="form-control" placeholder="Search for TRDF...">
                  	</div>
                  	<div class="col-md-2 col-sm-6 col-xs-12">
	                	<select id="heard" class="form-control" required>
                            <option value="isCompetitorOf">isCompetitorOf</option>
                            <option value="hasImmediateParent">hasImmediateParent</option>
                            <option value="hasUltimateParent">hasUltimateParent</option>
                            <option value="hasStrategicAlliance">hasStrategicAlliance</option>
                            <option value="isSupplierOf">isSupplierOf</option>
                            <option value="hasJointVenture">hasJointVenture</option>
                        </select>
                  	</div>
                  	<div class="col-md-3 col-sm-6 col-xs-12">
                    	<input id="company_search" type="text" class="form-control" placeholder="Search for TNIC...">
                  	</div>
                  	<div class="col-md-2 col-sm-6 col-xs-12">
                        <p>Default grid slider with min and max values</p>
                        <input type="text" class="range_min_max" value="" name="range" />
                  	</div>
                  	<div class="col-md-2 col-sm-6 col-xs-12">
                  		<button id="select_company" class="btn btn-default" type="button">Compare</button>
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
    <script src="js/TNIC2_viz.js"></script>
    <script src="js/jquery.auto-complete.min.js"></script>
    <script src="vendors/ion.rangeSlider/js/ion.rangeSlider.min.js"></script>

    <script>
     $(document).ready(function (){
     	$('.ui-pnotify').remove();
     	 
     });
     
    </script>

  </body>
</html>