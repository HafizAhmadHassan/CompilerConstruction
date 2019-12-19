
<!DOCTYPE html>





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
                        <img src="../images/logo.png"  alt="site logo" />

                        <!--      	site name ( keep span )-->
                        <span>Welcome To Admin  </span>Portal
                    </a>

                    <!--	</div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="inverseNavbar1">
                        <!--     search form-->
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <input type="text" class="form-control">
                            </div>
                        </form>
                        <!--      end search form-->

                    </div>
                    <!-- /.navbar-collapse --> 
                </div>
                <!-- /.container-fluid --> 
        </nav>

        <section class="container-fluid text-center section" id="heroarea">
            <div class="heroarea-caption">
                <h2 class="text-uppercase"> 

                    Payment

                </h2>
                <form method="post" action="Payment_Controller">
                    <input id="input-field" type="text" style="background-color:black"; size="50" width="70" name="streetaddress" required="required" autocomplete="on" maxlength="45" placeholder="Streed Address"/>
                    <input id="column-left" type="text" style="background-color:black"; size="50" width="70"name="city" required="required" autocomplete="on" maxlength="20" placeholder="City"/>
                    <input id="column-right" style="background-color:black"; size="50" width="70" type="text" name="zipcode" required="required" autocomplete="on" pattern="[0-9]*" maxlength="5" placeholder="ZIP code"/>
                    <input id="input-field"  style="background-color:black"; size="50" width="70"type="email" name="email" required="required" autocomplete="on" maxlength="40" placeholder="Email"/>

                    <input id="column-left" type="text" style="background-color:black";  size="50" width="70" name="first-name" placeholder="First Name"/>
                    <input id="column-right" type="text" style="background-color:black";  size="50" width="70" name="last-name" placeholder="Surname"/>
                    <input id="input-field" type="text" style="background-color:black";  size="50" width="70" name="number" placeholder="Card Number"/>
                    <input id="column-left" type="text" style="background-color:black";  size="50" width="70" name="expiry" placeholder="MM / YY"/>
                    <input id="column-right" style="background-color:black";  size="50" width="70" type="text" name="cvc" placeholder="CCV"/>
                    <br>      
                    <button  style="font-size: 16px;padding: 15px 32px;"size="50" href="#" class="btn btn-primary"> 

                        <!--    the button text--> 
                        Proceed    <!--    end button text--> 

                    </button>
                </form>
            </div>
        </section>


    </body>
</html>




















