<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-3 left_col">
		<div class="left_col scroll-view">
			<div class="navbar nav_title" style="border: 0;">
				<a href="index.jsp" class="site_title">
					<!-- <i class="fa fa-paw"></i> --> <span>Fin Network</span>
				</a>
			</div>

			<div class="clearfix"></div>

			<br />

			<!-- sidebar menu -->
			<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

				<div class="menu_section">
					<h3>General</h3>
					<ul class="nav side-menu">

						<li><a><i class="fa fa-sitemap"></i> SEC Dataset <span
								class="fa fa-chevron-down"></span></a>
							<ul class="nav child_menu">
								<%
								
								
								String array_sec[] = new String[8];
									
								//retrive data from first companies 
									
									array_sec[0] = "ADP";
									array_sec[1] = "AETNA";
									array_sec[2] = "BANKOFAMERICA";
									array_sec[3] = "BLACKROCK";
									array_sec[4] = "BOSTONPROPERTIES";	
									array_sec[5] = "FACEBOOK";	
									array_sec[6] = "TIMEWARNERCABLE";
									array_sec[7] = "WALTDISNEY";
								    
									for (int i = 0; i < array_sec.length; i++) {
									%>	<li><a href="data_visualizer.jsp?param1=<%= array_sec[i] %>&param2=sec_data" id="sid_14"><%= array_sec[i] %></a></li> <% 
									}
								%>
							</ul></li>
						<li><a href="#"> <i class="fa fa-sitemap"
								aria-hidden="true"></i> TRDF Dataset <span
								class="fa fa-chevron-down"></span>
						</a>
							<ul class="nav child_menu">
							<% 
								String array_tr[] = new String[8];
								array_tr[0] = "AETNA Inc";
								array_tr[1] = "AUTOMATIC DATA PROCESSING INC";								
								array_tr[2] = "BANK OF AMERICA corp";
								array_tr[3] = "BLACKROCK inc";
								array_tr[4] = "BOSTON PROPERTIES LP";	
								array_tr[5] = "FACEBOOK Inc";	
								array_tr[6] = "WALT DISNEY Co";
								array_tr[7] = "International Business Machines Corp";
								
								for (int i = 0; i < array_tr.length; i++) {
									%>	<li><a href="data_visualizer.jsp?param1=<%= array_tr[i] %>&param2=tr_data" id="sid_14"><%= array_tr[i] %></a></li> <% 
								}
								
							%>
							
							
							</ul></li>
						<li><a><i class="fa fa-sitemap"></i> OC Dataset <span
								class="fa fa-chevron-down"></span></a>
							<ul class="nav child_menu">
								<li><a href="#" id="sid_14">IBM</a></li>
							
			
							</ul></li>
						<li><a href="http://opensource.lk/"> <i
								class="fa fa-users" aria-hidden="true"></i> People
						</a></li>
					</ul>
				</div>
			</div>
			<!-- sidebar menu -->


		</div>
	</div>
</body>
</html>