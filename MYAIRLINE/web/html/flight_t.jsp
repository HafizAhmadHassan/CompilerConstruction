
<%@page import="com.ncl.Flight_Details_Info"%>
<%@page import="com.ncl.database"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Fixed table header</title>


        <link rel="stylesheet" href="css/book_flight_table.css">

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/animate.min.css" rel="stylesheet" type="text/css">
        <link href="fontawesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="style.css" rel="stylesheet" type="text/css">

    </head>

    <body>
        <section>
            <!--for demo wrap-->

            <nav class="navbar navbar-inverse">
                <div class="container-fluid"> 
                    <!-- Brand and toggle get grouped for better mobile display -->
                    
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#inverseNavbar1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                        <a class="navbar-brand" href="../index.jsp">

                            <!--      	the site logo-->
                            <img src="images/logo.png" alt="site logo" />

                            <!--      	site name ( keep span )-->
                            <span>Welcome To Client  </span>Portal
                        </a>

                        <!--	</div>
                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse" id="inverseNavbar1">
                            <!--     search form-->
                            </form>
                            <!--      end search form-->

                        </div>
                        <!-- /.navbar-collapse --> 
                        <% Flight_Details_Info F=(Flight_Details_Info)request.getAttribute("FD"); %>


                        <ul style="color:white;list-style-type: none; margin: 0;padding: 0; overflow: hidden;">
                            <li style="float: left;"><h1>: <%=F.From  %>   To  :</h1></li>
                            <li style="float: left;"><h1>:  <%=F.To %>  :</h1></li> 
                            <br>

                        </ul>
            </nav>

            <Form method=post action="Booking_Controller">

                <div class="tbl-header">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <thead>
                            <tr>
                                <th>Departure</th>
                                <th>Arrival</th>
                                <th>Economy Price</th>
                                <th>First Price</th>
                                <th>Bussiness Price</th>
                                
                                <th>Seats</th>
                                <th>FLight Id</th>
                                
                            </tr>
                        </thead>
                    </table>
                </div>
                <div class="tbl-content">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <tbody>
                            <tr>
                                <td name="dtime"><h1 style="font-size:19px;text-align:left"><td> <%= F.DTime%></h1></td>
                                <td name="rtime"><h1 style="font-size:19px;text-align:left">   <td> <%= F.RTime%></h1></td>  
                                <td name="eprice"><h1 style="font-size:19px;text-align:left">   <td> <%= F.EPrice%></h1></td>  
                                <td name="fprice"><h1 style="font-size:19px;text-align:left">   <td> <%= F.FPrice%></h1></td>  
                                <td name="bprice"><h1 style="font-size:19px;text-align:left">   <td> <%= F.BPrice%></h1></td>  
                                <td name="seats"><h1 style="font-size:19px;text-align:left"> <td> <%= F.Seats%></h1></td>  
                                <td name="seats"><h1 style="font-size:19px;text-align:left"> <td> <%= F.Flight_Id%></h1></td>  

                            </tr>
                            
                        </tbody>
                    </table>

                         </br>
                         
                         </br>
                         
                         Enter Flight ID 
                         </br> <input type ="text" name="FID">

                         </br>
                         Enter Class 
                         </br> <input type ="text" name="clas">
                         <p>
                             Type: E , B , F For Economy,Business,First Class
                         </p>
                </div>
        </section>

        <br>	

        <input type="submit" align="center" value="Proceed To Payment ">
    </Form>
    <!-- <a href="../html/payment.html"> -->



























</body>
</html>
