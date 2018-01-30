<%@page import="com.finnetwork.controllers.IDController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Fin network</title>
   <!-- Bootstrap -->
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="build/css/custom.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/tabs.css">
    <style type="text/css">
    .x_content{
		position: relative;
		overflow: hidden;
    }
	</style>
</head>
<%
	String comapny_name = request.getParameter("param1");
	String data_set =request.getParameter("param2");
	
	int id;
	if(data_set.equals("sec_data")){
		id = IDController.getID(comapny_name);
		
	}else{
		id=0;
	}
	
%>
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
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="dashboard_graph" id="tr_container" style="height: 700px" class="x_content" display:none>
						<div class="row x_title">
							<div class="col-md-6">
							<h3><%=comapny_name%> <small>TR Dataset</small></h3>
							</div>
							<div class="col-md-6">
							</div>
						</div>
					</div>
					
					<div class="dashboard_graph" id="oc_container" style="height: 700px" class="x_content" display:none>
						<div class="row x_title">
							<div class="col-md-6">
							<h3><%=comapny_name%> <small>OC Dataset</small></h3>
							</div>
							<div class="col-md-6">
							</div>
						</div>
					</div>
					
					
					<div class="dashboard_graph" id="sec_container" display:none>		
						<div class="row x_title">
							<div class="col-md-6">
							<h3><%=comapny_name%> <small>SEC triples</small></h3>
							</div>
							<div class="col-md-6">
							</div>
						</div>
						
						<div class="tab">
							<button class="tablinks" onclick="singleGraph(event, 'all')">All</button>
							<button class="tablinks" onclick="singleGraph(event, '2013')">2013</button>
							<button class="tablinks" onclick="singleGraph(event, '2014')">2014</button>
							<button class="tablinks" onclick="singleGraph(event, '2015')">2015</button>
							<button class="tablinks" onclick="singleGraph(event, '2016')">2016</button>
							<button class="tablinks" onclick="singleGraph(event, '2017')">2017</button>
						</div>
					
						<!-- Tab content -->
						<div id="all" class="tabcontent">
							<h3>All</h3>
							<div class="x_panel tile fixed_height_420">
								<ul class="nav navbar-right panel_toolbox">
									<li><a class="close-link" style="left:725px"><i class="fa fa-close" ></i></a></li>
								</ul>
								<div class="x_content" id="bind_all" style="height: 450px;"></div>
							</div>
						</div>
					
						<div id="2013" class="tabcontent">
							<h3>2013</h3>	
							<div class="x_panel tile fixed_height_420">
									<ul class="nav navbar-right panel_toolbox">
									<li><a class="close-link" style="left:625px"><i class="fa fa-close" ></i></a>
									</li>
									</ul>
								<div class="x_content" id="content_2013" style="height: 450px;">
								</div>
							</div>
						</div>
						
						<div id="2014" class="tabcontent">
							<h3>2014</h3>	
							<div class="x_panel tile fixed_height_420">
									<ul class="nav navbar-right panel_toolbox">
									<li><a class="close-link" style="left:625px"><i class="fa fa-close" ></i></a>
									</li>
									</ul>
								<div class="x_content" id="content_2014" style="height: 450px;">
								</div>
							</div>
						</div>
						
						<div id="2015" class="tabcontent">
							<h3>2015</h3>	
							<div class="x_panel tile fixed_height_420">
									<ul class="nav navbar-right panel_toolbox">
									<li><a class="close-link" style="left:625px"><i class="fa fa-close" ></i></a>
									</li>
									</ul>
								<div class="x_content" id="content_2015" style="height: 450px;">
								</div>
							</div>
						</div>
						
						<div id="2016" class="tabcontent">
							<h3>2016</h3>	
							<div class="x_panel tile fixed_height_420">
									<ul class="nav navbar-right panel_toolbox">
									<li><a class="close-link" style="left:625px"><i class="fa fa-close" ></i></a>
									</li>
									</ul>
								<div class="x_content" id="content_2016" style="height: 450px;">
								</div>
							</div>
						</div>
						
						<div id="2017" class="tabcontent">
							<h3>2017</h3>	
							<div class="x_panel tile fixed_height_420">
									<ul class="nav navbar-right panel_toolbox">
									<li><a class="close-link" style="left:625px"><i class="fa fa-close" ></i></a>
									</li>
									</ul>
								<div class="x_content" id="content_2017" style="height: 450px;">
								</div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<br/>
	
			<div class="row">
				</div>
			</div>
			</div>
       </div>
        <!-- /page content -->

        <!-- footer content -->
    <footer></footer>
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
    <script src="js/graph_per_company.js"></script>
    <script src="js/TR_viz.js"></script>
    <script src="js/oc_viz.js"></script>

    <script>
     var data_set= '<%=data_set%>'; 
     var comapny_name= '<%=comapny_name%>';
     
     if(data_set== 'sec_data'){
    	 var id = <%=id%> ; 
     $(document).ready(function (){
    	 
    	 document.getElementById("tr_container").style.display = "none";
    	 document.getElementById("sec_container").style.display = "block";
    	 document.getElementById("oc_container").style.display = "none";
    	
		graph_per_company("../../FinNetwork/rest/sec/"+comapny_name, "bind_all", id);
		draw_me_single_equity("../../FinNetwork/rest/sec/"+comapny_name+"/2013","content_2013",id,2013);
		draw_me_single_equity("../../FinNetwork/rest/sec/"+comapny_name+"/2014","content_2014",id,2014);
		draw_me_single_equity("../../FinNetwork/rest/sec/"+comapny_name+"/2015","content_2015",id,2015);
		draw_me_single_equity("../../FinNetwork/rest/sec/"+comapny_name+"/2016","content_2016",id,2016);
		draw_me_single_equity("../../FinNetwork/rest/sec/"+comapny_name+"/2017","content_2017",id,2017);
     
     });
     }else if(data_set== 'tr_data'){
    	 document.getElementById("tr_container").style.display = "block";
    	 document.getElementById("sec_container").style.display = "none";
    	 document.getElementById("oc_container").style.display = "none";
    	 TR_viz("../../FinNetwork/rest/tr/"+comapny_name);
     }
     else if(data_set== 'oc_data'){
    	 document.getElementById("oc_container").style.display = "block";
    	 document.getElementById("sec_container").style.display = "none";
    	 document.getElementById("tr_container").style.display = "none";
    	 oc_viz("../../FinNetwork/rest/oc");
     }
    </script>
	
	<script>
	function singleGraph(evt, year) {
		var i, tabcontent, tablinks;
		tabcontent = document.getElementsByClassName("tabcontent");
		for (i = 0; i < tabcontent.length; i++) {
			tabcontent[i].style.display = "none";
		}
		tablinks = document.getElementsByClassName("tablinks");
		for (i = 0; i < tablinks.length; i++) {
			tablinks[i].className = tablinks[i].className.replace(" active", "");
		}
		document.getElementById(year).style.display = "block";
		evt.currentTarget.className += " active";
	};
	</script>
	

  </body>
</html>