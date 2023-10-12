<%@page import="javax.jms.Session"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <% session = request.getSession();
    
 String uid=null;
 if(session.getAttribute("userId")!=null){
         uid=session.getAttribute("userId").toString();
 }
%>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">
		
		<title>Insurance</title>

		<!-- Loading third party fonts -->
		<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400,700|" rel="stylesheet" type="text/css">
		<link href="fonts/font-awesome.min.css" rel="stylesheet" type="text/css">
		<link href="fonts/lineo-icon/style.css" rel="stylesheet" type="text/css">

		<!-- Loading main css file -->
		<link rel="stylesheet" href="css/style.css">
		
		<!--[if lt IE 9]>
		<script src="js/ie-support/html5.js"></script>
		<script src="js/ie-support/respond.js"></script>
		<![endif]-->

	</head>


	<body>
		
		<div id="site-content">
			<header class="site-header">
				<div class="top-header">
					<div class="container">
						<a href="index.html" id="branding">
							<img src="images/logo.png" alt="Company Name" class="logo">
							<div class="logo-text">
								<h1 class="site-title">SVS Insurance</h1>
								<small class="description">We Care You Always</small>
							</div>
						</a> <!-- #branding -->
					
						<div class="right-section pull-right">
							<a href="#" class="phone"><img src="images/icon-phone.png" class="icon">+0112789654</a>
					
							<form action="#" class="search-form">
								<input type="text" placeholder="Search...">
								<button type="submit"><img src="images/icon-search.png" alt=""></button>
							</form>
						</div>
					</div> <!-- .container -->
				</div> <!-- .top-header -->

				
				<div class="bottom-header">
					<div class="container">
						<div class="main-navigation">
							<button type="button" class="menu-toggle"><i class="fa fa-bars"></i></button>
							<ul class="menu">
                                                                <li class="menu-item"><a href="index.jsp">Home</a></li>	
                                                                  <% if(uid!=null && !uid.isEmpty()){%>
                            
                           <li>
                            <a href="http://localhost:8080/SVS_Insurance/dashboardServlet?uid=<%=uid%>">Dashboard</a>
                            
                        </li> 
                        <%}%>
								<li class="menu-item"><a href="about.jsp">About us</a></li>															
								<li class="menu-item"><a href="contact.jsp">Contact</a></li>
                                                                 <% if(uid!=null && !uid.isEmpty()){%>
                            
                           <li>
                            <li><a href="http://localhost:8080/SVS_Insurance/logout">Sign Out</a></li>
                            
                        </li> 
                        <%}
                        else{%>
                              <li><a href="login.jsp">Sign In</a></li>
                        <%}%>
							