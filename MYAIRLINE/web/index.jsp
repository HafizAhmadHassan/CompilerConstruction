<%@ page import="javax.servlet.http.HttpSession" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Our Airlines</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/animate.min.css" rel="stylesheet" type="text/css">
<link href="fontawesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="style.css" rel="stylesheet" type="text/css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if Our view the page via file:// -->
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
      <a class="navbar-brand" href="#">
      
<!--      	the site logo-->
      	<img src="images/logo.jpg" alt="site logo" />
      	
<!--      	site name ( keep span )-->
      	<span>Our</span>Airlines
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
        
        <!--       if Our want to customize the navigation menu use the list bellow-->
        <li class="active"><a href="#heroarea">home</a></li>
        <li><a href="#services">Book</a></li>
        <li><a href="#blog">blog</a></li>
        <li><a href="#works">team</a></li>
        <li><a href="#portfolio">Gallery</a></li>
        <li><a href="#contact">contact</a></li>
       
       <%! public String LogOut="You Are Not Logged"; 

    	       public String emails="Email";
    	    	      public String l2="Log In";

    	    	       public String l="NotLog";
    	    	      %>
       <%

       HttpSession session2=request.getSession(true);  
       if(session2!=null){  
       emails=(String)session2.getAttribute("email");  
      LogOut="Log Out";
       } else{
emails="Email";
l2="Log In";
    	   
    	   
       } 
       
       
       %>
       
     <li><a href=""><%=emails %></a></li>
  

        <li><a href="html/sign_in.html"><%=l2 %> </a></li>
        <li><a href="Log_out"><%=LogOut %><a></li>
        
        <li><a href="Admin_Controller">Admin Portal</a></li>
        <li><a href="Manager_Controller">Manager Portal</a></li>

        <!--        end menu list-->
        
      </ul>
    </div>
    <!-- /.navbar-collapse --> 
  </div>
  <!-- /.container-fluid --> 
</nav>

<!-----------------------------------------end homepage navigation--> 

<!-----------------------------------------the hero area or the big title area-->

<section class="container-fluid text-center section" id="heroarea">
  <div class="heroarea-caption">
    <h1 class="text-uppercase"> 
      
      <!--   customize the big title--> 
      what Our Airlines exactly right now 
      <!--    end big title--> 
      
    </h1>
    <p> 
      
      <!--   customize the hero area text--> 
     The mission of Southwest Airlines is dedication to the highest quality of Customer Service delivered with a sense of warmth, friendliness, individual pride, and Company Spirit. <!--   end the hero area text--> 
    
<div id="demo">

</div>

	
    </p>
    
<!--    replace the # in href bellow with the link of the destination page-->
    
	
	
	
	
	
    <!--    the button text--> 
   <button class="btn btn-primary" onclick="myFunction3()"> read more 
    <!--    end button text--> 
    </button>
	
	
	
	
	
	
	
	
	<script>
function myFunction2() {
    var x = document.getElementById('myDIV');
    
	
	
	
	if (x.style.display === 'none') {
        x.style.display = 'block';
    } else {
        x.style.display = 'none';
    }
}



function myFunction3() {
    var x = document.getElementById('myDIV');
       document.getElementById("demo").innerHTML = "Ahmad Hassn ";
	var x = document.getElementById('myDIV2');
       document.getElementById("demo2").innerHTML = "Ahmad Hassn ";
	
	
	
}


</script>

	
     </div>
</section>

<!-----------------------------------------end hero area--> 

<!-----------------------------------------features section-->

<section id="services" class="container section text-center">
   <div class="row"> 
    <div class="col-md-4">
      <div class="service"> 
        
        <!--      customize the icon go to fontawesome website to find the complete list of icons--> 
        <span class="fa fa-apple"></span> 
        <!--       end icon-->
        
        <h3 class="underlined"> 
          <!--        customize the column heading--> 
         Book A Flight  
          <!--        end heading--> 
        </h3>
        
		<p> 
          <!--        customize the column text--> 
         Whether it's Ourr first flight or simply Ourr latest, we work to anticipate 
		 <!--        end column text--> 
        </p>
		
		
		
		
		
		
		
<form method="post" action="Flight_Controller">
  From :<br>
  <input type="text" name="from" value="Mickey">
 
  <br>:To:<br>
  <input type="text" name="to" value="Mouse">
<br>
Departing :<br>

<input type="text" name="ddate" value="2017-02-09"><br>



Returning : <br>

<input type="text" name="rdate" value="2017-02-09"><br>

  <br><br>
  <input type="submit" value="Submit">
</form>

<p id="demo"></p>

<script>
function myFunction() {
    var x = document.getElementById("myDate").value;
    document.getElementById("demo").innerHTML = x;
}
</script>  
  </form> 
		
		
		

<!--<p>Click the button to get the date of the date field.</p>

<button onclick="myFunction()">Try it</button> 

<p><strong>Note:</strong> input elements with type="date" do not show as any date field/calendar in Firefox or in IE 11 and earlier versions.</p>
--->




		
		
		
      </div>
    </div>
     <form method="post" action="html/manage_booking.jsp">
     <div class="col-md-4">
      <div class="service"> 
        
        <!--      customize the icon go to fontawesome website to find the complete list of icons--> 
        <span class="fa fa-globe"></span> 
        <!--       end icon-->
        
        <h3 class="underlined"> 
          <!--        customize the column heading--> 
          Manage Booking 
          <!--        end heading--> 
        </h3>
        <p> 
          <!--        customize the column text--> 
        Please use one of the following options to access Ourr booking.
		<!--        end column text--> 
        </p>
		
		Reference ID :<br>

		<input type="text" name="myid" value="Mickey">

<br>

Last Name: <br>

  <input type="text" name="lastname" value="Mickey">

  <br>
  <input type="submit" value="Submit">
  </form>

  <br>
  <br>

		
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>

  </div>
    </div>
     
     <div class="col-md-4">
      <div class="service"> 
        
        <!--      customize the icon go to fontawesome website to find the complete list of icons--> 
        <span class="fa fa-archive"></span> 
        <!--       end icon-->
        
        <h3 class="underlined"> 
          <!--        customize the column heading--> 
         Flight Status 
          <!--        end heading--> 
        </h3>
        <p> 
          <!--        customize the column text--> 
         Select status options
		 <!--        end column text--> 
        </p>
		
		
		From :<br>

		<input type="text" name="firstname" value="City or Airport">

<br>

To : <br>

  <input type="text" name="lastname" value="City or Airport">

  <br><br>

Choose Date : <br>

<input type="date" id="myDate" value="2017-02-09"><br>



 <a href="html/book_flight_table.html"><input type="submit" value="Submit"></a>

  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>

		
      </div>
    </div>

















     <div class="col-md-4">
      <div class="service"> 
        
        <!--      customize the icon go to fontawesome website to find the complete list of icons--> 
        <span class="fa fa-archive"></span> 
        <!--       end icon-->
        
        <h3 class="underlined"> 
          <!--        customize the column heading--> 
Timetable Search
          <!--        end heading--> 
        </h3>
        <p> 
          <!--        customize the column text--> 
          <!--        end column text--> 
        </p>
		
	<Form method="post" action="Flight_Controller">	
		From :<br>

		<input type="text" name="firstname" value="City or Airport">

<br>

To : <br>

  <input type="text" name="lastname" value="City or Airport">

  <br><br>
Departing : <br>

<input type="date" id="myDate" value="2017-02-09"><br>


Returning: <br>

<input type="date" id="myDate" value="2017-02-09"><br>



 <input type="submit" value="Submit">
<Form>
  <br><br>

		
      </div>
    </div>







	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
     <div class="col-md-4">
      <div class="service"> 
        
        <!--      customize the icon go to fontawesome website to find the complete list of icons--> 
        <span class="fa fa-archive"></span> 
        <!--       end icon-->
        
        <h3 class="underlined"> 
          <!--        customize the column heading--> 
Booking Infornation          <!--        end heading--> 
        </h3>
        <p> 
          <!--        customize the column text--> 
          <!--        end column text--> 
        </p>
		
		
	<Form method="post" action="html/flight_t2.jsp">	
		From :<br>

		<input type="text" name="firstname" value="City or Airport">

<br>

To : <br>

  <input type="text" name="lastname" value="City or Airport">

  <br><br>
Departing : <br>

<input type="date" id="myDate" value="2017-02-09"><br>


Returning: <br>

<input type="date" id="myDate" value="2017-02-09"><br>



 <a href="html/book_flight_table.html"><input type="submit" value="Submit"></a>
</Form>
  <br><br>

		
      </div>
    </div>




	
	
     <div class="col-md-4">
      <div class="service"> 
        
        <!--      customize the icon go to fontawesome website to find the complete list of icons--> 
        <span class="fa fa-archive"></span> 
        <!--       end icon-->
        
        <h3 class="underlined"> 
          <!--        customize the column heading--> 
Rates        
  <!--        end heading--> 
        </h3>
        <p> 
          <!--        customize the column text--> 
          <!--        end column text--> 
        </p>
		
		
		From :<br>

		<input type="text" name="firstname" value="City or Airport">

<br>

To : <br>

  <input type="text" name="lastname" value="City or Airport">

  <br><br>
Departing : <br>

<input type="date" id="myDate" value="2017-02-09"><br>


Returning: <br>

<input type="date" id="myDate" value="2017-02-09"><br>


 <a href="html/book_flight_table.html"><input type="submit" value="Submit"></a>

  <br><br>

		
      </div>
    </div>




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

    
  </div>
</section>

<!-----------------------------------end features section-->

<!-----------------------------------blog section-->

<section class="section container-fluid" id="blog">
  <div class="section-title text-center text-uppercase">
    <h2 class="underlined">from the blog</h2>
  </div>
  <div class="container">
    <div class="row">
     
		<!--     begin article-->
      <div class="col-md-4 article"> <img src="images/b2.jpg" class="img-responsive"  alt="">
        <div class="article-caption">
          <ul class="meta list-unstyled list-inline text-uppercase">
           
<!--           customize the blog categories list change the # with the destination link and web design with category name ( if Our want to add more category name just copy and paste between <a ....</a> and change what Our want )-->
            <li><a href="#">United Airlines </a> | <a href="#">UK</a></li>
<!--            end category listing-->
<!--           customize the date-->
            <li>12 - 05 - 2017</li>
<!--            end the date-->
          </ul>
          <h2>
<!--          post title-->
        ?Alexa, Is My Flight On Time?? United Collaborates with Amazon Echo
<!--          end post title-->
          </h2>
          <p>
<!--          post content-->United Airlines has partnered with Amazon to become the first U.S. airline to offer an Alexa skill for customers to check-in for flights, check flight status, view in flight amenities and more. This new skill

          </p>
          
<!--          post destination link when Our click the read more button ( change the # with the destination page link )-->
          <p><a href="#" class="more-link btn text-uppercase">read more</a></p>
<!--          end post link/-->
        </div>
      </div>
<!--      end article-->

<!--     begin article-->
      <div class="col-md-4 article"> <img src="images/b1.jpg" class="img-responsive"  alt="">
        <div class="article-caption">
          <ul class="meta list-unstyled list-inline text-uppercase">
           
<!--           customize the blog categories list change the # with the destination link and web design with category name ( if Our want to add more category name just copy and paste between <a ....</a> and change what Our want )-->
            <li><a href="#">wordpress</a></li>
<!--            end category listing-->
<!--           customize the date-->
            <li>12 - 05 - 2017</li>
<!--            end the date-->
          </ul>
          <h2>
<!--          post title-->Win a Free Seat Onboard Star MegaDo?s ?Party? Flight Between Vienna, Brussels, and Palma de Mallorca on September 21
<!--          end post title-->
          </h2>
          <p>
<!--          post content-->
          Join MegaDo and AirlineGeeks for an exclusive opportunity to see behind-the-scenes at Vienna and Brussels airports while also being onboard a charter flight between Vienna, Brussels, and Palma de Mallorca from September 19-22, 2017.

If Our don?t want to try Ourr luck in the contest, email megado@megado.com as there are a few people who are interested in transferring a ticket for the airline enthusiast extravaganza.    end post content -->
         
		  </p>
          
<!--          post destination link when Our click the read more button ( change the # with the destination page link )-->
          <p><a href="#" class="more-link btn text-uppercase" >read more</a></p>
<!--          end post link/-->
        </div>
      </div>
<!--      end article-->

<!--     begin article-->
      <div class="col-md-4 article"> <img src="images/post.jpg" class="img-responsive"  alt="">
        <div class="article-caption">
          <ul class="meta list-unstyled list-inline text-uppercase">
           
<!--           customize the blog categories list change the # with the destination link and web design with category name ( if Our want to add more category name just copy and paste between <a ....</a> and change what Our want )-->
            <li><a href="#">jQuery</a></li>
<!--            end category listing-->
<!--           customize the date-->
            <li>12 - 05 - 2017</li>
<!--            end the date-->
          </ul>
          <h2>
<!--          post title-->
         United to Award Bonus Miles to Members Who Donate for Hurricane Harvey Relief Efforts
<!--          end post title-->
          </h2>
          <p>
<!--          post content-->
          United Airlines has announced a new partnership with disaster relief organizations, such as the American Red Cross, to assist in the relief efforts for those affected by Hurricane Harvey by incentivizing frequent fliers to donate.    end post content -->
          </p>
          
<!--          post destination link when Our click the read more button ( change the # with the destination page link )-->
          <p><a href="#" class="more-link btn text-uppercase">read more</a></p>
<!--          end post link/-->
        </div>
      </div>
<!--      end article-->
</div>
  </div>
</section>

<!-------------------------------------end blog section-->


<!-------------------------------------begin our team section-->


<section class="section container-fluid text-center" id="works">
  <div class="section-title text-center text-uppercase">
    <h2 class="underlined">our team</h2>
  </div>
  <div class="container">
    <div class="row">
      <div class="col-md-4">
       
<!--       begin team column-->
        <div class="work">
          <div class="work-img"> <img src="images/t1.jpg" class="img-responsive" alt="">
            <div class="work-title">
              <h3 class="text-uppercase"><a href="#">
<!--              team member name-->
              ----
<!--              end team member name-->
              </a></h3>
              <h5>
<!--              begin team member position-->
              CEO 
<!--              end team member position-->

              </h5>
            </div>
          </div>
          <div class="work-caption">
            <div>
              <p class="underlined">
<!--              begin team member description-->
Introduction<!--              end team member description-->
				</p>
              <ul class="social-links list-unstyled list-inline">
              
<!--               begin team member social media links, change the # with the facebook, twitter or gplus page link -->
                <li><a href="#"><span class="fa fa-facebook"></span></a></li>
                <li><a href="#"><span class="fa fa-twitter"></span></a></li>
                <li><a href="#"><span class="fa fa-google-plus"></span></a></li>
<!--               end team member social media links-->
                
              </ul>
            </div>
          </div>
        </div>
<!--        end team column-->
        
      </div>
      <div class="col-md-4">
<div class="work">
          <div class="work-img"> <img src="images/t2.jpg" class="img-responsive" alt="">
            <div class="work-title">
              <h3 class="text-uppercase"><a href="#">
                <!--              team member name-->
                <!--              end team member name-->
              ---
			  </a></h3>
              <h5>
                <!--              begin team member position-->
                Manager
				<!--              end team member position-->
              </h5>
            </div>
          </div>
          <div class="work-caption">
            <div>
              <p class="underlined">
                <!--              begin team member description-->
                Introduction<!--              end team member description-->
              </p>
              <ul class="social-links list-unstyled list-inline">
                <!--               begin team member social media links, change the # with the facebook, twitter or gplus page link -->
                <li><a href="#"><span class="fa fa-facebook"></span></a></li>
                <li><a href="#"><span class="fa fa-twitter"></span></a></li>
                <li><a href="#"><span class="fa fa-google-plus"></span></a></li>
                <!--               end team member social media links-->
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-4">
<div class="work">
          <div class="work-img"> <img src="images/t3.jpg" class="img-responsive" alt="">
            <div class="work-title">
              <h3 class="text-uppercase"><a href="#">
                <!--              team member name-->
              ----
                <!--              end team member name-->
              </a></h3>
              <h5>
                <!--              begin team member position-->
                CEO
                <!--              end team member position-->
              </h5>
            </div>
          </div>
          <div class="work-caption">
            <div>
              <p class="underlined">
                <!--              begin team member description-->
               introduction <!--              end team member description-->
              </p>
              <ul class="social-links list-unstyled list-inline">
                <!--               begin team member social media links, change the # with the facebook, twitter or gplus page link -->
                <li><a href="#"><span class="fa fa-facebook"></span></a></li>
                <li><a href="#"><span class="fa fa-twitter"></span></a></li>
                <li><a href="#"><span class="fa fa-google-plus"></span></a></li>
                <!--               end team member social media links-->
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-----------------------------------------------------end our team section-->

<!-----------------------------------------------------begin portfolio section-->

<section class="section" id="portfolio">
  <div class="container">
    <div class="section-title text-center text-uppercase">
      <h2 class="underlined">Here We Are</h2>
    </div>
    <ul id="filters" class="list-inline">
     
<!--     begin portfolio filters-->
<!--     to add a new filter just duplicate a line from the list bellow and change 'data-filter = ".NEW_CATEGORY"'-->
<!--     where NEW_CATEGORY is the class and the data-cat of the col-md-3 column bellow-->
      <li><span class="filter active" data-filter="all">All</span></li>
      <li><span class="filter" data-filter=".portfolio">portfolio</span></li>
      <li><span class="filter" data-filter=".design">design</span></li>
      <li><span class="filter" data-filter=".clients">clients</span></li>
<!--      end filters-->
    </ul>
    <div class="row">
      <div class="col-md-3 col-sm-6 mix portfolio" data-cat="portfolio ">
<!--      begin portfolio image (change the image src="image_link" and alt attributes )-->
       <img src="images/alex-jones-8205.jpg" class="img-responsive" alt="Placeholder image">
<!--       end image-->
        <div class="works-btn">
<!--        the a tag bellow controls the modal window that will be displays ones clicked ( #modal is the modal ID )-->
<!--        "#modal" ID is the id for the modal window that Our'll find in the page bellow after the footer section-->
        	<a data-toggle="modal" data-target="#modal">
        		<span class="fa fa-search-plus"></span>
        	</a>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 mix clients" data-cat="clients ">
        <!--      begin portfolio image (change the image src="image_link" and alt attributes )-->
        <img src="images/alex-jones-8205.jpg" class="img-responsive" alt="Placeholder image">
        <!--       end image-->
        <div class="works-btn">
          <!--        the a tag bellow controls the modal window that will be displays ones clicked ( #modal is the modal ID )-->
          <!--        "#modal" ID is the id for the modal window that Our'll find in the page bellow after the footer section-->
          <a data-toggle="modal" data-target="#modal"> <span class="fa fa-search-plus"></span> </a> </div>
      </div>
      <div class="col-md-3 col-sm-6 mix design" data-cat="design ">
        <!--      begin portfolio image (change the image src="image_link" and alt attributes )-->
        <img src="images/ales-krivec-1881.jpg" class="img-responsive" alt="Placeholder image">
        <!--       end image-->
        <div class="works-btn">
          <!--        the a tag bellow controls the modal window that will be displays ones clicked ( #modal is the modal ID )-->
          <!--        "#modal" ID is the id for the modal window that Our'll find in the page bellow after the footer section-->
          <a data-toggle="modal" data-target="#modal"> <span class="fa fa-search-plus"></span></a></div>
      </div>
      <div class="col-md-3 col-sm-6 mix portfolio" data-cat="portfolio ">
        <!--      begin portfolio image (change the image src="image_link" and alt attributes )-->
        <img src="images/b1.jpg" class="img-responsive" alt="Placeholder image">
        <!--       end image-->
        <div class="works-btn">
          <!--        the a tag bellow controls the modal window that will be displays ones clicked ( #modal is the modal ID )-->
          <!--        "#modal" ID is the id for the modal window that Our'll find in the page bellow after the footer section-->
          <a data-toggle="modal" data-target="#modal"> <span class="fa fa-search-plus"></span></a></div>
      </div>
      
      <div class="col-md-3 col-sm-6 mix portfolio" data-cat="portfolio ">
        <!--      begin portfolio image (change the image src="image_link" and alt attributes )-->
        <img src="images/ales-krivec-434.jpg" class="img-responsive" alt="Placeholder image">
        <!--       end image-->
        <div class="works-btn">
          <!--        the a tag bellow controls the modal window that will be displays ones clicked ( #modal is the modal ID )-->
          <!--        "#modal" ID is the id for the modal window that Our'll find in the page bellow after the footer section-->
        <a data-toggle="modal" data-target="#modal"> <span class="fa fa-search-plus"></span> </a> </div>
      </div>
      <div class="col-md-3 col-sm-6 mix clients" data-cat="clients ">
        <!--      begin portfolio image (change the image src="image_link" and alt attributes )-->
        <img src="images/alex-jones-8205.jpg" class="img-responsive" alt="Placeholder image">
        <!--       end image-->
        <div class="works-btn">
          <!--        the a tag bellow controls the modal window that will be displays ones clicked ( #modal is the modal ID )-->
          <!--        "#modal" ID is the id for the modal window that Our'll find in the page bellow after the footer section-->
        <a data-toggle="modal" data-target="#modal"> <span class="fa fa-search-plus"></span></a></div>
      </div>
      <div class="col-md-3 col-sm-6 mix design" data-cat="design ">
        <!--      begin portfolio image (change the image src="image_link" and alt attributes )-->
        <img src="images/alex-knight-192782.jpg" class="img-responsive" alt="Placeholder image">
        <!--       end image-->
        <div class="works-btn">
          <!--        the a tag bellow controls the modal window that will be displays ones clicked ( #modal is the modal ID )-->
          <!--        "#modal" ID is the id for the modal window that Our'll find in the page bellow after the footer section-->
        <a data-toggle="modal" data-target="#modal"> <span class="fa fa-search-plus"></span></a></div>
      </div>
      <div class="col-md-3 col-sm-6 mix portfolio" data-cat="portfolio ">
        <!--      begin portfolio image (change the image src="image_link" and alt attributes )-->
        <img src="images/ander-burdain-168833.jpg" class="img-responsive" alt="Placeholder image">
        <!--       end image-->
        <div class="works-btn">
          <!--        the a tag bellow controls the modal window that will be displays ones clicked ( #modal is the modal ID )-->
          <!--        "#modal" ID is the id for the modal window that Our'll find in the page bellow after the footer section-->
        <a data-toggle="modal" data-target="#modal"> <span class="fa fa-search-plus"></span></a></div>
      </div>
        </div>
  </div>
</section>

<!--              ########################end portfolio sectio
<!--######################################begin contact us-->

<!--to change the reception email address open contact.php and edit the info-->
<section class="section container-fluid" id="contact">
  <div class="section-title text-center text-uppercase">
    <h2 class="underlined">contact us</h2>
  </div>
  <div class="container">
    <div class="row">
      <div class="col-md-6">
       
<!--       contact form -- the one thing that Our Airlines to customize is the placeholder or the value of the input button(submit button) -->
        <form action="contact.php" method="post" name="form1" id="contact-form">
          <input name="name" type="text" id="name" form="contact-form" placeholder="Ourr name">
          <input name="subject" type="text" id="subject" form="contact-form" placeholder="Message subject">
          <input name="email" required type="email" id="email" form="contact-form" placeholder="Ourr Email">
          <textarea name="message" required id="Message" form="contact-form" placeholder="Ourr message"></textarea>
          <input name="submit" type="submit" class="btn btn-primary" id="submit" formaction="contact.php" value="submit">
        </form>
        
<!--        end contact form-->
       
        <ul class="info list-unstyled">
<!--         the list of contact information under contact form-->
          <li><strong>phone</strong> :  +92-321-4592939</li>
          <li><strong>email</strong> :  ahmadhassam061@gmail.com</li>
          <li><strong>Address</strong> :  FAST_NUCES LAHORE</li>
<!--          end list-->
        </ul>
      </div>
      
<!--      the map container don't remove it if Our want to display the map-->
      <div class="col-md-6">
        <div id="map"></div>
      </div>
<!--      end map container-->
    </div>
  </div>
</section>

<!--end contact form-->


<!--######################################begin page footer-->

<footer class="container-fluid section" id="footer">
  <div class="container">
    <div class="row text-center">
      <div class="col-md-4"><a class="footer-brand" href="#">
<!--      site logo in the footer-->
      <img src="images/footer-logo.png" alt="" />
<!--      site name-->
      <span>Our</span>Airlines</a>
      
      </div>
      <div class="col-md-4">
      
<!--       newsletter form-->
        <form action="" class="text-center" id="newsletter-form">
          <input name="newsletter" type="text" id="newsletter" placeholder="Please subscribe to our newsletter">
          <input name="newsletter-submit" type="submit" id="newsletter-submit" class="btn btn-primary" value="Subscribe">
        </form>
<!--        end newsletter-->
     
      </div>
      <div class="col-md-4 copyright">
        <p><a href="http://freethemeszone.com">click</a></p>
      </div>
    </div>
  </div>
</footer>

<!--end footer-->
<!--    works modals-->

<div class="modal fade" id="modal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">My best work</h4>
      </div>
      <div class="modal-body"> <img class="img-responsive" src="images/moment-1481334217954-c5d87e2a1bc6.jpg" alt=""/> </div>
    </div>
  </div>
</div>
<!--	         end modal--> 
<script src="js/jquery-1.11.2.min.js" type="text/javascript"></script> 
<script src="js/jquery.mixitup.min.js" type="text/javascript"></script> 
<script src="js/portfolio.js" type="text/javascript"></script> 
<script src="js/bootstrap.js" type="text/javascript"></script> 
<script type="text/javascript" src="js/jquery.waypoints.js"></script> 
<script src="js/main.js" type="text/javascript"></script> 

<!-- ###########################################google map --> 
<script type="text/javascript">
  
		
    function initMap() {
//		change the uluru variable with the latitude and longitude of the loaction Our want to show in the map {lat:somethging,lng:something}
//		Our must also enter a google map key in the following script
          var uluru = {lat: -25.363, lng: 131.044};
          var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 4,
            center: uluru
          });
          var marker = new google.maps.Marker({
            position: uluru,
            map: map
          });
        }
</script> 

<!--Our should get a map key from google website and enter it below in place of the A's (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)-->
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBOJkrfBTNVS3Zyzzx5Q_GBHKYxNmSvLJY&callback=initMap"></script>
<!-- end goole map -->

</body>
</html>
