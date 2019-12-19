<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>AhmadHassan Airlines</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/animate.min.css" rel="stylesheet" type="text/css">
        <link href="fontawesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="style.css" rel="stylesheet" type="text/css">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>

        <!-----------------------------------------the homepage navigation-->

        <nav class="navbar navbar-inverse">
            <div class="container-fluid"> 
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#inverseNavbar1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                    <a class="navbar-brand" href="index.jsp">

                        <!--      	the site logo-->
                        <img src="images/logo.png" alt="site logo" />

                        <!--      	site name ( keep span )-->
                        <span>Welcome To Admin  </span>Portal
                    </a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="inverseNavbar1">
                    <!--     search form-->
                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control">
                        </div>
                    </form>
                    <!--      end search form-->

                    <%
                        HttpSession session2 = request.getSession(true);
                    %>

                    <ul class="nav navbar-nav navbar-right text-uppercase">

                        <!--       if you want to customize the navigation menu use the list bellow-->
                        <li class="active"><a href="#heroarea"><%=session2.getAttribute("email")%></a></li>

                        <li class="active"><a href="Log_out"> Log Out</a></li>

                    </ul>
                </div>
                <!-- /.navbar-collapse --> 
            </div>
            <!-- /.container-fluid --> 
        </nav>
  <div class="col-md-4">
            <div class="service"> 

                <!--      customize the icon go to fontawesome website to find the complete list of icons--> 
                <span class="fa fa-archive"></span> 
                <!--       end icon-->

                <!--        customize the column heading--> 
                <h3>Please Set Prices          <!--        end heading--> 
                </h3>

                <Form action="Admin_DB_Controller" method="post">
                <h1>First Class </h1><br>
                
                    <input type="text" name="First_Class" >
                    <br>
                   
                    <textarea name="F1" required id="Message" form="contact-form" placeholder="Features"></textarea>
                    <br>
                    <br>
                    
                    
                    <h1>Economy Class </h1> <br>

                    <input type="text" name="Economy_Class" >
                    <br>
                    <textarea name="F2" required id="Message" form="contact-form" placeholder="Features"></textarea>

                    <br>
                    <br>

                    <br>  
                    
                    <h1> Bussiness Class </h1> <br>
                    <input type="text" name="Bussiness_Class" >
                    <br>
                    <textarea name="F3" required id="Message" form="contact-form" placeholder="Features"></textarea>
                    <br>
                    <br>
                    <br>
                    <br>  

                    

                    <h1>From </h1> <br>
                    <input type="text" name="From" >

                    <br>  
                    <h1> To </h1>
                    <input type="text" name="To" >
                    <br>
                    <h1> Seats </h1>
                    <input type="text" name="Seats" >
                    <br>
                    <h1> Arrival Time </h1>
                    <input type="text" name="Arrival_Time" >
                    <br>

                    <h1> Departure Time </h1>

                    <input type="text" name="Departure_Time" >

                    <br>
                    <br>
                    <br>
                    
                    
                    
                     <h1> Departure Date </h1>

                    <input type="text" name="Departure_Date" value="2015-11-11">

                    <br>
                    <br>
                    <br>
                    
                    
                     <h1> Arrival Date </h1>

                    <input type="text" name="Arrival_Date" value="2015-11-11">

                    <br>
                    <br>
                    <br>
                    <button type="submit" class="button button-block"/>Submit</button>
                    <br>

                </form>
            </div>
        </div>


    </body>
</html>
