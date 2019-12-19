<%@page import="com.ncl.database"%>
<%@page import="com.ncl.Flight_Details_Info"%>
?<!doctype html>
<%@page import="java.sql.*"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>AhmadHassan Airlines</title>
<link href="css//bootstrap.css" rel="stylesheet" type="text/css">
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
      	<img src="../images/logo.png"   alt="site logo" />
      	
<!--      	site name ( keep span )-->
      	<span>Welcome To Manager  </span>Portal
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
     
      <ul class="nav navbar-nav navbar-right text-uppercase">
        
        <!--       if you want to customize the navigation menu use the list bellow-->
        <li class="active"><a href="#heroarea"></a></li>
        <%
        HttpSession session2=request.getSession(false);  
        session2.setAttribute("email", "manager@OurAiline.com");
    		%>
        <li><a href="#services"></a></li>
        <li><a href="#blog"></a></li>
        <li><a href="#works"></a></li>
        <li><a href="#portfolio"><%=session2.getAttribute("email") %></a></li>
        <li><a href="Log_out"> Log Out</a></li>
        



        <!--        end menu list-->
        
      </ul>
    </div>
    <!-- /.navbar-collapse --> 
  </div>
  <!-- /.container-fluid --> 
</nav>

<!-----------------------------------------end homepage navigation--> 

<!-----------------------------------------the hero area or the big title area-->
















     <div class="col-md-4">
      <div class="service"> 
        
        <!--      customize the icon go to fontawesome website to find the complete list of icons--> 
        <span class="fa fa-archive"></span> 
        <!--       end icon-->
        
          <!--        customize the column heading--> 
<h3 >Please Click To Approve Prices And Features          <!--        end heading--> 
        </h3>
        <p> 
          <!--        customize the column text--> 
          <!--        end column text--> 
        </p>
		
<form method=post action="Manager_Approved_DB">		
		<h1>First Class </h1><br>








<%

 database db=new database();
 
String bf=db.getFlightDetails().BFeatures;

String ff=db.getFlightDetails().FFeatures;
String ef=db.getFlightDetails().EFeatures;
int ep=db.getFlightDetails().EPrice;
int fp=db.getFlightDetails().FPrice;
int bp=db.getFlightDetails().BPrice;
%>





		<input type="radio" name="choose1" value="PHP"><label for="PHP"> <%= fp%> </label>
	

<br>




		<input type="radio" name="choose2" value="PHP"><label for="PHP"> <%= ff%></label>
	
	

  <br>
  
  

<br>

<h1>Bussiness Class </h1> <br>

		<input type="radio" name="choose3" value="PHP"><label for="PHP"> <%= bp%></label>
	
  <br><br>
  
  
  

		<input type="radio" name="choose4" value="PHP"><label for="PHP"> <%= bf%></label>
	
	


  <br>
  

<br>  
  
<h1>Economy Class </h1> <br>

		<input type="radio" name="choose5" value="PHP"><label for="PHP"> <%= ep%></label>


  <br><br>
		<input type="radio" name="choose6" value="PHP"><label for="PHP"> <%= ef%></label>


	
	


  <br>
  

 <input type="submit" value="Submit">
  </form>
  
  
  
		
      </div>
    </div>







	
	
	
	




<script>

        function addRow(tableID) {

          var table = document.getElementById(tableID);

          var rowCount = table.rows.length;
          if (rowCount >= 21) { // +1 for header row.
            alert("There can be no more than 20 participants per session.");
            return;
          }
          var row = table.insertRow(rowCount);

          var cell1 = row.insertCell(0);
          var element1 = document.createElement("input");
          element1.type = "checkbox";
          element1.name = "chkbox[]";
          cell1.appendChild(element1);

          var cell2 = row.insertCell(1);
          cell2.innerHTML = rowCount;

          var cell3 = row.insertCell(2);
          var element2 = document.createElement("input");
          element2.type = "text";
          element2.name = "txtbox[]";
          cell3.appendChild(element2);

        }

        function deleteRow(tableID) {
          try {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;

            for (var i = 0; i < rowCount; i++) {
              var row = table.rows[i];
              var chkbox = row.cells[0].childNodes[0];
              if (null != chkbox && true == chkbox.checked) {
                table.deleteRow(i);
                rowCount--;
                i--;
              }

            }
          } catch (e) {
            alert(e);
          }
        }
</script>

	
	
	
	
	
	
	
	
	

</body>
</html>
