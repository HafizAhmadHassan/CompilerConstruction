// JavaScript Document
$(function() {
	 "use strict";
	
	 var topoffset = 50; //variable for menu height
  
   $('body').scrollspy({
     target: 'nav.navbar',
     offset: topoffset
   });

  // Add an inbody class to nav when scrollspy event fires
   $('nav.navbar').on('activate.bs.scrollspy', function() {
     var hash = $(this).find('li.active a').attr('href');
     if(hash !== '#heroarea') {
   
       $('nav.navbar').addClass('inbody navbar-fixed-top animated fadeInRight');
     } else {
      $('nav.navbar').removeClass('inbody navbar-fixed-top animated fadeInRight');
     }
   });
  
 //Use smooth scrolling when clicking on navigation
   $('a[href*=\\#]:not([href=\\#])').click(function() {
     if (location.pathname.replace(/^\//,'') === 
       this.pathname.replace(/^\//,'') && 
       location.hostname === this.hostname) {
       var target = $(this.hash);
       target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
       if (target.length) {
         $('html,body').animate({
           scrollTop: target.offset().top-topoffset+2
         }, 500);
         return false;
       } //target.length
     } //click function
   }); //smooth scrolling
	
	
//	footer function
  var maxheight = 0;

$('#footer .col-md-4').each(function () {
    maxheight = ($(this).height() > maxheight ? $(this).height() : maxheight); 
});

$('#footer .col-md-4').height(maxheight);
	
//	scrolling animations
	
	$("#services,#works,#portfolio,#blog,#contact").css('opacity',0);
  
  //  animate
  $("#services").waypoint(function(){ $("#services").addClass('fadeInLeft animated');},{offset:'50%'});
  $("#works").waypoint(function(){ $("#works").addClass('fadeInLeft animated');},{offset:'50%'});
  $("#portfolio").waypoint(function(){ $("#portfolio").addClass('fadeInLeft animated');},{offset:'50%'});
  $("#blog").waypoint(function(){ $("#blog").addClass('fadeInLeft animated');},{offset:'50%'});
  $("#contact").waypoint(function(){ $("#contact").addClass('fadeInLeft animated');},{offset:'50%'});
//  end animation

	$(".more-link,.pagination li a").addClass('hover-transition');
	$(".blog-page nav.navbar,.portfolio-page nav.navbar,.contact-page nav.navbar").addClass('navbar-fixed-top');
	$(".blog-page .section-title,.portfolio-page .section-title,.contact-page .section-title").css("marginTop",81);
	
});