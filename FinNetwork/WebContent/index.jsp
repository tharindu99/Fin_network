<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Fin network</title>

<!-- Bootstrap -->
<link href="vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="vendors/pnotify/dist/pnotify.css" rel="stylesheet">
<link href="vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
<!-- Custom Theme Style -->
<link href="build/css/custom.min.css" rel="stylesheet">
<style type="text/css">
#container {
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
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"> <!-- <i class="fa fa-paw"></i> -->
							<span>Fin Network</span>
						</a>
					</div>

					<div class="clearfix"></div>

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3>General</h3>
							<ul class="nav side-menu">
								<li><a onclick="IBM_OC('IBM OC (Open Corporate)')" href="#"><i class="glyphicon glyphicon-plus"></i>  IBM_OC (Open Corporate)</a></li>
                    			<li><a onclick="TR_dataSet('TR data set')" href="#"><i class="glyphicon glyphicon-plus"></i>  TR dataset</a></li>

							</ul>
						</div>


					</div>
					<!-- /sidebar menu -->


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
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="dashboard_graph">

							<div class="row x_title">
								<div class="col-md-6">
									<h3 id = "page_title">
										Financial Network Activities <small> data set</small>
									</h3>
								</div>
								<div class="col-md-6">
									<h3 id="show_year"></h3>
								</div>
							</div>

							<div class="col-md-12 col-sm-9 col-xs-12">
								<div id="container" class="demo-placeholder"
									style="height: 500px;"></div>
							</div>
							<div class="col-md-3 col-sm-3 col-xs-12 bg-white"></div>

							<div class="clearfix"></div>
						</div>
					</div>

				</div>
				<br />
			</div>
		</div>
	</div>
	<!-- /page content -->

	<!-- footer content -->
	<footer> </footer>
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
	<script src="js/graph_draw.js"></script>

	<script>
     $(document).ready(function (){
             $('.ui-pnotify').remove();
  
     });
     
     function IBM_OC(title) {
		console.log("IMB oc clicked...........");
		document.getElementById("page_title").innerHTML = title ;
		draw_me_new("../../FinNetwork/rest/OpenCorp_IBM");
	 }
     
     function TR_dataSet(title){
    	console.log("TR clicked...........");
 		document.getElementById("page_title").innerHTML = title ;
 		draw_me_new("../../FinNetwork/rest/TR_IBM");
     }
    </script>

</body>
</html>