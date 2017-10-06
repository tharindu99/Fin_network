<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Search Companies</title>

<!-- Bootstrap -->
<link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">  
<!-- Font Awesome -->
<link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">  
<!-- Custom Theme Style -->
<link href="build/css/custom.min.css" rel="stylesheet"> 
<style>
	#myInput {
	  background-image: url('css/search.png');
	  background-position: 6px 6px;
	  background-repeat: no-repeat;
	  width: 100%;
	  font-size: 16px;
	  padding: 12px 20px 12px 40px;
	  border: 1px solid #ddd;
	}
</style>
</head>
<body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><!-- <i class="fa fa-paw"></i> --> <span>Fin Network</span> </a>
            </div>

            <div class="clearfix"></div>

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> Annual Basis <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a id="2011_y">2011</a></li>
                      <li><a id="2012_y">2012</a></li>
                      <li><a id="2013_y">2013</a></li>
                      <li><a id="2014_y">2014</a></li>
                      <li><a id="2015_y">2015</a></li>
                      <li><a id="2016_y">2016</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-home"></i> Company Basis <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="" id="sid_14">Goldman</a></li>
                      <li><a href="" id="sid_16">JP Morgan Chase</a></li>
                      <li><a href="" id="sid_25">US Bank</a></li>
                      <li><a href="" id="sid_19">Morgan Stanley</a></li>
                      <li><a href="" id="sid_6">CapitalOne</a></li>
                      <li><a href="" id="sid_3">Bank of America CORP</a></li>
                    </ul>
                  </li>                
              
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
                    <h3>Search Companies <small>FEIIIY2 data set</small></h3>
                  </div>
                  <div class="col-md-6">
                  </div>
                </div>

                <div class="col-md-12 col-sm-9 col-xs-12" >
                  <div id="container" class="demo-placeholder" style="height: auto;">
                 	<form action="" method="get">
					    <input type="text" id="myInput" onkeyup="searchCompany()" placeholder="Search for companies..." title="Type in a name">
				   </form>                	  
                  </div>
                </div>
                <div class="col-md-3 col-sm-3 col-xs-12 bg-white">
               		<ul id="myList">
               			<li>Sandu</li>
               			<li>Sulo</li>
               			<li>Nanda</li>
               			<li>Ravee</li>
               			<li>Sithu</li>
               			<li>Priya</li>
               			<li>Pani</li>
               			<li>Anu</li>
               		</ul>
                </div>

                <div class="clearfix"></div>
              </div>
            </div>

          </div>
          <br />

          <div class="row">
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="vendors/jquery/dist/jquery.min.js"></script>  
    <!-- Bootstrap -->
    <script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>  
    <script src="build/js/custom.min.js"></script>
    <script src="js/d3.v4.min.js"></script>
    <script src="js/d3-selection-multi.v1.js"></script>
    <script src="js/graph_draw.js"></script>
 
 	<script>
 		function searchCompany(){
 			console.log("comapny is being searched...");
 			var input = document.getElementById("myInput");
 			var filter = input.value.toUpperCase();
 			var list = document.getElementById("myList");
 			var li = list.getElementsByTagName("li");
 			var i;
 			for(i=0; i<li.length; i++){
 				if(li[i].innerHTML.toUpperCase().indexOf(filter) > -1){
 					li[i].style.display = "";
 					console.log(li[i]);
 				} else {
 					li[i].style.display = "none";
 				}
 			}
 		}
 	</script>
 
  </body>
</html>