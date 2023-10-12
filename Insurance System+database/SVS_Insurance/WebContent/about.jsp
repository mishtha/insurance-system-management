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
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">
		
		<title>Insurance | About Us</title>

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
								<h1 class="site-title">Company Name</h1>
								<small class="description">Taline goes here</small>
							</div>
						</a> <!-- #branding -->
					
						<div class="right-section pull-right">
							<a href="#" class="phone"><img src="images/icon-phone.png" class="icon">+1 823 424 9134</a>
					
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
							</ul> <!-- .menu -->
						</div> <!-- .main-navigation -->
						
						<div class="social-links">
							<a href="#"><i class="fa fa-facebook"></i></a>
							<a href="#"><i class="fa fa-twitter"></i></a>
							<a href="#"><i class="fa fa-google-plus"></i></a>
							<a href="#"><i class="fa fa-pinterest"></i></a>
						</div>
						
						<div class="mobile-navigation"></div>
					</div>
				</div>
				
			</header> <!-- .site-header -->


			<main class="main-content">
				<div class="breadcrumbs">
					<div class="container">
						<a href="index.html">Home</a>
						<span>About Us</span>
					</div>
				</div>

				<div class="page">
					<div class="fullwidth-block">
						<div class="container">
							<h1 class="entry-title">Why you should choose us?</h1>
							<p>Sri Lanka Insurance is a state owned institution and over decades of operation, it has received direction of exemplary leaders which has seen the company progress from strength to strength.</p>
<p>The company has invested in multi-faceted projects bringing in lucrative returns for all its stakeholders. The strategic investments made by Sri Lanka Insurance span through many diversified fields.</p>
<p><strong>Banking &amp; Finance</strong><br />
9.4% in Commercial Bank, 10% in DFCC Bank, 14.7% in Hatton National Bank, 15% in Seylan Bank and 10.4% in National Development Bank.</p>
<p><strong>Health Care</strong><br />
Sri Lanka Insurance holds the controlling stake in Lanka Hospitals- a star class hospital equipped with the best medical practitioners and latest medical equipment, providing expert medical care to the people of Sri Lanka.</p>
<p><strong>Power &amp; Energy</strong><br />
Litro Gas- the latest addition to Sri Lanka Insurance’s investment portfolio is the US$ 63 million share acquisition of Shell Gas Lanka Ltd and Shell Terminals Lanka Limited which is now rebranded as Litro Gas Lanka Limited and Litro Gas Terminal Limited</p>
<p><strong>Travel &amp; Leisure</strong><br />
Sri Lanka Insurance has also taken initiatives to diversify its business to the fast growing leisure sector through Sri Lanka Insurance Resorts &amp; Spas. Sri Lanka Insurance has also invested in the world renowned hotel chain Grand Hyatt Hotel Project in Sri Lanka.</p>
<p><strong>Construction &amp; Engineering</strong><br />
Sri Lanka Insurance has also invested in a 10% stake of Colombo Dockyard</p>
							<div class="features">
								<div class="feature-numbered">
									<div class="num">1</div>
									<h2 class="feature-title">Proin tempus</h2>
									<p> Proin tempus velit dui eu lobortis justo laoreet nec phasellus luctus elit neque eu aliquam velit dignissim donec porttitor.</p>
								</div>
								<div class="feature-numbered">
									<div class="num">2</div>
									<h2 class="feature-title">Proin tempus</h2>
									<p> Proin tempus velit dui eu lobortis justo laoreet nec phasellus luctus elit neque eu aliquam velit dignissim donec porttitor.</p>
								</div>
								<div class="feature-numbered">
									<div class="num">3</div>
									<h2 class="feature-title">Proin tempus</h2>
									<p> Proin tempus velit dui eu lobortis justo laoreet nec phasellus luctus elit neque eu aliquam velit dignissim donec porttitor.</p>
								</div>
								<div class="feature-numbered">
									<div class="num">4</div>
									<h2 class="feature-title">Proin tempus</h2>
									<p> Proin tempus velit dui eu lobortis justo laoreet nec phasellus luctus elit neque eu aliquam velit dignissim donec porttitor.</p>
								</div>
							</div>
						</div> <!-- .container -->
					</div> <!-- .fullwidth-block -->

					<div class="fullwidth-block" data-bg-color="#f1f1f1">
						<div class="container">
							<h2 class="section-title">The history</h2>
							<p>Established in 1962 as a state owned corporation, Sri Lanka Insurance was converted to a private limited liability company for a brief period of 6 years and was reinstated as a nationalized entity on 4th June 2009. The return of ownership to the state has further strengthened the company , which today is the largest government owned insurer in Sri Lanka with an unparalleled managed asset base of over Rs 171.8 billion, the largest life fund in the insurance industry of Rs 90.3 billion and a strong capitalization of Rs 6 billion.</p>
<p>As the pioneering insurer, Sri Lanka Insurance has the most experienced technical knowledge base in the country. The company’s financial stability and strong re-insurance arrangements have paved the way for it to mark many historical milestones in the Sri Lankan insurance arena such as the largest claim ever paid of Rs 39.5 billion and declaring the largest life insurance bonuses year on year to its life policy holders with the latest being a staggering 5.4 Billion.</p>
<p>The ethos and mandate promulgated at the inception by the state has flourished over the years and today Sri Lanka Insurance serves the people of Sri Lanka with merits, expertise and several decades of trust.</p> </div> <!-- .container -->
					</div> <!-- .fullwidth-block -->

					<div class="fullwidth-block">
						<div class="container">
							<h2 class="section-title">Our Team</h2>

							<div class="row">
								<div class="col-xs-12 col-sm-6 col-md-3">
									<div class="team">
										<figure class="team-image"><img src="dummy/team-1.jpg" alt=""></figure>
										<h2 class="team-name">Jessica Brown</h2>
										<small class="team-title">CEO</small>
										<div class="social-links">
											<a href="#"><i class="fa fa-facebook"></i></a>
											<a href="#"><i class="fa fa-twitter"></i></a>
											<a href="#"><i class="fa fa-google-plus"></i></a>
											<a href="#"><i class="fa fa-pinterest"></i></a>
										</div>
									</div> <!-- .team -->
								</div> <!-- .col-md-3 -->
								<div class="col-xs-12 col-sm-6 col-md-3">
									<div class="team">
										<figure class="team-image"><img src="dummy/team-2.jpg" alt=""></figure>
										<h2 class="team-name">Jeremy Stuart</h2>
										<small class="team-title">Managing Director</small>
										<div class="social-links">
											<a href="#"><i class="fa fa-facebook"></i></a>
											<a href="#"><i class="fa fa-twitter"></i></a>
											<a href="#"><i class="fa fa-google-plus"></i></a>
											<a href="#"><i class="fa fa-pinterest"></i></a>
										</div>
									</div> <!-- .team -->
								</div> <!-- .col-md-3 -->
								<div class="col-xs-12 col-sm-6 col-md-3">
									<div class="team">
										<figure class="team-image"><img src="dummy/team-3.jpg" alt=""></figure>
										<h2 class="team-name">Sarah Johnson</h2>
										<small class="team-title">Public Relation</small>
										<div class="social-links">
											<a href="#"><i class="fa fa-facebook"></i></a>
											<a href="#"><i class="fa fa-twitter"></i></a>
											<a href="#"><i class="fa fa-google-plus"></i></a>
											<a href="#"><i class="fa fa-pinterest"></i></a>
										</div>
									</div> <!-- .team -->
								</div> <!-- .col-md-3 -->
								<div class="col-xs-12 col-sm-6 col-md-3">
									<div class="team">
										<figure class="team-image"><img src="dummy/team-4.jpg" alt=""></figure>
										<h2 class="team-name">Paul ferguson</h2>
										<small class="team-title">Consultant</small>
										<div class="social-links">
											<a href="#"><i class="fa fa-facebook"></i></a>
											<a href="#"><i class="fa fa-twitter"></i></a>
											<a href="#"><i class="fa fa-google-plus"></i></a>
											<a href="#"><i class="fa fa-pinterest"></i></a>
										</div>
									</div> <!-- .team -->
								</div> <!-- .col-md-3 -->
							</div> <!-- .row -->
						</div> <!-- .container -->
					</div> <!-- .fullwidth-block -->
				</div> <!-- .page -->
			</main>

			<div class="site-footer">
				<div class="widget-area">
					<div class="container">
						<div class="row">
							<div class="col-xs-12 col-sm-4 col-md-2">
								<div class="widget">
									<h3 class="widget-title">Contact</h3>
									<address> Company Name INC. 523 Burt Street, Omaha
									</address>
									<a href="#">Phone: +1 823 424 9134</a>
									<a href="mailto:info@company.com">info@company.com</a>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4 col-md-2">
								<div class="widget">
									<h3 class="widget-title">Company</h3>
									<ul class="no-bullet">
										<li><a href="#">About us</a></li>
										<li><a href="#">Infoline</a></li>
										<li><a href="#">Team</a></li>
										<li><a href="#">Join us</a></li>
										<li><a href="#">Cooperation</a></li>
									</ul>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4 col-md-2">
								<div class="widget">
									<h3 class="widget-title">Products</h3>
									<ul class="no-bullet">
										<li><a href="#">Life insurance</a></li>
										<li><a href="#">Home insurance</a></li>
										<li><a href="#">Car insurance</a></li>
										<li><a href="#">Business insurance</a></li>
										<li><a href="#">Investment insurance</a></li>
									</ul>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4 col-md-2">
								<div class="widget">
									<h3 class="widget-title">Our Solutions</h3>
									<ul class="no-bullet">
										<li><a href="#">Presentation</a></li>
										<li><a href="#">Testimonials</a></li>
										<li><a href="#">Examples</a></li>
										<li><a href="#">Our experts</a></li>
										<li><a href="#">Resources</a></li>
									</ul>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4 col-md-2">
								<div class="widget">
									<h3 class="widget-title">Press Room</h3>
									<ul class="no-bullet">
									<li><a href="#">Advertisement</a></li>
									<li><a href="#">Interviews</a></li>
									<li><a href="#">Hot news</a></li>
									<li><a href="#">Photos</a></li>
									<li><a href="#">Marketing</a></li>
									</ul>
								</div>
							</div>
							<div class="col-xs-12 col-sm-4 col-md-2">
								<div class="widget">
									<h3 class="widget-title">Resources</h3>
									<ul class="no-bullet">
										<li><a href="#">Sed imperdiet magna</a></li>
										<li><a href="#">Pellentesque molestie</a></li>
										<li><a href="#">Nulla luctus cursus</a></li>
										<li><a href="#">Ligula vel lacinia</a></li>
										<li><a href="#">Mauris scelerisque</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="bottom-footer">
					<div class="container">
						<nav class="footer-navigation">
							<a href="#">Home</a>
							<a href="#">About us</a>
							<a href="#">Insurance plans</a>
							<a href="#">Resources</a>
							<a href="#">Contact</a>
						</nav>

						<div class="colophon">Copyright 2018 SVS Insurance. Designed by LasiiGroup.com. All rights reserved.</div>
					</div>
				</div>
			</div>
		</div>

		<script src="js/jquery-1.11.1.min.js"></script>
		<script src="js/plugins.js"></script>
		<script src="js/app.js"></script>
		
	</body>

</html>