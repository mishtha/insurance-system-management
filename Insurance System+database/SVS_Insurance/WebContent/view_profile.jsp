<%-- 
    Document   : create_user
    
    Author     : Dharmishtha
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="javax.jms.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% session = request.getSession();
   
String uid=session.getAttribute("userId").toString();   
String uType=session.getAttribute("userType").toString();
%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Sufee Admin - HTML5 Admin Template</title>
    <meta name="description" content="Sufee Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-icon.png">
    <link rel="shortcut icon" href="favicon.ico">

    <link rel="stylesheet" href="assets/css/normalize.css">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/themify-icons.css">
    <link rel="stylesheet" href="assets/css/flag-icon.min.css">
    <link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
    <!-- <link rel="stylesheet" href="assets/css/bootstrap-select.less"> -->
    <link rel="stylesheet" href="assets/scss/style.css">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->

</head>
<body>
        <!-- Left Panel -->

    <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">

            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="./"><img src="images/logo.png" alt="Logo"></a>
                <a class="navbar-brand hidden" href="./"><img src="images/logo2.png" alt="Logo"></a>
            </div>

            <div id="main-menu" class="main-menu collapse navbar-collapse">
                 <%
                                   
                                   if("Manager".equals(uType)){%>
               <ul class="nav navbar-nav">
                    <li>
                        <a href="http://localhost:8080/SVS_Insurance/dashboardServlet?uid=<%=uid%>"> <i class="menu-icon fa fa-dashboard"></i>Dashboard </a>
                    </li>
                    <li>
                        <a href="index.jsp"> <i class="menu-icon fa fa-dashboard"></i>Home</a>
                    </li>
                    <h3 class="menu-title">Actions</h3><!-- /.menu-title -->
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-laptop"></i>Agent</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-puzzle-piece"></i><a href="create_user.jsp">Add Agent</a></li>
                            <li><i class="fa fa-id-badge"></i><a href="http://localhost:8080/SVS_Insurance/adduserServlet">Show/Delete Agent</a></li>
                            <li><i class="fa fa-bars"></i><a href="search_user.jsp">Search Agent</a></li>
                           
                           
                        </ul>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-laptop"></i>Policy</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-puzzle-piece"></i><a href="create_policy.jsp">Add Policy</a></li>
                            <li><i class="fa fa-id-badge"></i><a href="http://localhost:8080/SVS_Insurance/addpolicyServlet">Show/Delete Policy</a></li>
                            <li><i class="fa fa-bars"></i><a href="search_policy.jsp">Search Policy</a></li>
                            
                           
                        </ul>
                    </li>  
                    <li>
                        <a href="http://localhost:8080/SVS_Insurance/logout"> <i class="menu-icon fa fa-dashboard"></i>Logout</a>
                    </li> 
                </ul>
               
               <%}
else if("Agent".equals(uType)){
        
        %>
               
          <ul class="nav navbar-nav">
                    <li>
                        <a href="http://localhost:8080/SVS_Insurance/dashboardServlet?uid=<%=uid%>"> <i class="menu-icon fa fa-dashboard"></i>Dashboard </a>
                    </li>
                    <li>
                        <a href="index.jsp"> <i class="menu-icon fa fa-dashboard"></i>Home</a>
                    </li>
                    <h3 class="menu-title">Actions</h3><!-- /.menu-title -->
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-laptop"></i>Client</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-puzzle-piece"></i><a href="create_user.jsp">Add Client</a></li>
                            <li><i class="fa fa-id-badge"></i><a href="http://localhost:8080/SVS_Insurance/adduserServlet">Show/Delete Client</a></li>
                            <li><i class="fa fa-bars"></i><a href="search_user.jsp">Search Client</a></li>
                            
                           
                        </ul>
                    </li>
                      <li>
                        <a href="http://localhost:8080/SVS_Insurance/logout"> <i class="menu-icon fa fa-dashboard"></i>Logout</a>
                    </li>                  
                </ul>    
             
        
        <%}

else if("Client".equals(uType)){
        %>
        
        <ul class="nav navbar-nav">
                    <li><i class="fa fa-puzzle-piece"></i><a href="http://localhost:8080/SVS_Insurance/userprofileServlet?uid=<%=uid%>">Dashboard</a></li>
                    
                    <li>
                        <a href="index.jsp"> <i class="menu-icon fa fa-dashboard"></i>Home</a>
                    </li>
                    <h3 class="menu-title">Actions</h3><!-- /.menu-title -->
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-laptop"></i>Client</a>
                        <ul class="sub-menu children dropdown-menu">
                            
                            <li><i class="fa fa-id-badge"></i><a href="search_policy.jsp">Search Policy</a></li>
                            <li><i class="fa fa-bars"></i><a href="http://localhost:8080/SVS_Insurance/userpolicyServlet">Request New Policy</a></li>
                                                       
                        </ul>
                    </li>
                     <li>
                        <a href="http://localhost:8080/SVS_Insurance/logout"> <i class="menu-icon fa fa-dashboard"></i>Logout</a>
                    </li>                  
                </ul>    
        
        
        
        <%}%>
            </div><!-- /.navbar-collapse -->
        </nav>
    </aside><!-- /#left-panel -->

    <!-- Left Panel -->

    <!-- Right Panel -->

    <div id="right-panel" class="right-panel">

        <!-- Header-->
        <header id="header" class="header">

            <div class="header-menu">

                <div class="col-sm-7">
                    <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks"></i></a>
                    <div class="header-left">
                        <button class="search-trigger"><i class="fa fa-search"></i></button>
                        <div class="form-inline">
                            <form class="search-form">
                                <input class="form-control mr-sm-2" type="text" placeholder="Search ..." aria-label="Search">
                                <button class="search-close" type="submit"><i class="fa fa-close"></i></button>
                            </form>
                        </div>

                        

                        <div class="dropdown for-message">
                          <button class="btn btn-secondary dropdown-toggle" type="button"
                                id="message"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="ti-email"></i>
                            <span class="count bg-primary">9</span>
                          </button>
                          <div class="dropdown-menu" aria-labelledby="message">
                            <p class="red">You have 4 Mails</p>
                            <a class="dropdown-item media bg-flat-color-1" href="#">
                                <span class="photo media-left"><img alt="avatar" src="images/avatar/1.jpg"></span>
                                <span class="message media-body">
                                    <span class="name float-left">Jonathan Smith</span>
                                    <span class="time float-right">Just now</span>
                                        <p>Hello, this is an example msg</p>
                                </span>
                            </a>
                            <a class="dropdown-item media bg-flat-color-4" href="#">
                                <span class="photo media-left"><img alt="avatar" src="images/avatar/2.jpg"></span>
                                <span class="message media-body">
                                    <span class="name float-left">Jack Sanders</span>
                                    <span class="time float-right">5 minutes ago</span>
                                        <p>Lorem ipsum dolor sit amet, consectetur</p>
                                </span>
                            </a>
                            <a class="dropdown-item media bg-flat-color-5" href="#">
                                <span class="photo media-left"><img alt="avatar" src="images/avatar/3.jpg"></span>
                                <span class="message media-body">
                                    <span class="name float-left">Cheryl Wheeler</span>
                                    <span class="time float-right">10 minutes ago</span>
                                        <p>Hello, this is an example msg</p>
                                </span>
                            </a>
                            <a class="dropdown-item media bg-flat-color-3" href="#">
                                <span class="photo media-left"><img alt="avatar" src="images/avatar/4.jpg"></span>
                                <span class="message media-body">
                                    <span class="name float-left">Rachel Santos</span>
                                    <span class="time float-right">15 minutes ago</span>
                                        <p>Lorem ipsum dolor sit amet, consectetur</p>
                                </span>
                            </a>
                          </div>
                        </div>
                    </div>
                </div>

                
            </div>

        </header><!-- /header -->
        <!-- Header-->

        <div class="breadcrumbs">
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1>Show users</h1>
                    </div>
                </div>
            </div>
            
        </div>

        <div class="content mt-3">
            <div class="animated fadeIn">


                <div class="row">
                  

                    
                      
                    
                      <%
        List mylist = (List)request.getAttribute("userprolist");
        Iterator it = mylist.iterator();
         while(it.hasNext()) {%>           
                  <div class=" col-md-6" style="flex: 0 0 100%;max-width: 100%;" >
                        <aside class="profile-nav alt">
                            <section class="card">
                                <div class="card-header user-header alt bg-dark">
                                    <div class="media">
                                        <a href="#">
                                            <img class="align-self-center rounded-circle mr-3" style="width:85px; height:85px;" alt="" src="images/admin.jpg">
                                        </a>
                                        <div class="media-body">
                                            <h2 class="text-light display-6"><%=it.next()%></h2>
                                            <p><%=it.next()%></p>
                                        </div>
                                    </div>
                                </div>


                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">
                                        <a href="#">User ID -<%=it.next()%> </a>
                                    </li>
                                    <li class="list-group-item">
                                        <a href="#">Email -<%=it.next()%> </a>
                                    </li>
                                    <li class="list-group-item">
                                        <a href="#">Address -<%=it.next()%> </a>
                                    </li>
                                    <li class="list-group-item">
                                        <a href="#">Contact Number -<%=it.next()%> </a>
                                    </li>
                                   <li class="list-group-item">
                                        <a href="#">Create Date -<%=it.next()%> </a>
                                    </li>
                                    <li class="list-group-item">
                                        <a href="#">Create Time -<%=it.next()%> </a>
                                    </li>
                                    <li>
                                        <div id='map2' style='height: 250px;'></div>
    <script>
      function initMap() {
        var colombo = {lat: <%=it.next()%>, lng: <%=it.next()%>};
        var map = new google.maps.Map(document.getElementById('map2'), {
          zoom: 12,
          center: colombo
        });
        var marker = new google.maps.Marker({
          position: colombo,
          map: map
        });
      }
    </script>
    <script async defer
    src='https://maps.googleapis.com/maps/api/js?key=AIzaSyAYAADu5VeXj9UHuI6qx7gdzjcFbYhcJ18&callback=initMap'>
    </script>
                                    </li>
                                </ul>

                            </section>
                        </aside>
                    </div>            
                              
                      <%}
        %>       
        
        
        
        <div class=" col-md-6" style="flex: 0 0 100%;max-width: 100%;" >
                        <aside class="profile-nav alt">
                            <section class="card">
                                
                                   <div class="card-header">
                            <strong class="card-title">User's Policies</strong>
                        </div>
                        <div class="card-body">
                            <table class="table">
                              <thead class="thead-dark">
                                <tr>
                                  <th scope="col">Policy ID</th>
                                  <th scope="col">Title</th>
                                  
                                  
                                </tr>
                              </thead>
                              <tbody>
                                   <%
        List mylist2 = (List)request.getAttribute("userpolicylist");
        Iterator it2 = mylist2.iterator();
         while(it2.hasNext()) {%> 
                                <tr>
                                  <th scope="row"><%=it2.next()%></th>
                                  <td><%=it2.next()%></td>
                                  
                                  
                                </tr>
                                <%}
        %>       
                               
                              </tbody>
                            </table>

                        </div>
                                
                                    </section>
                        </aside>
                    </div>
                              
                           
                      
                  
                </div>


            </div><!-- .animated -->
        </div><!-- .content -->


    </div><!-- /#right-panel -->

    <!-- Right Panel -->


    <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/main.js"></script>


</body>
</html>
