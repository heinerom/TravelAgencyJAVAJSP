
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- 
	This is the Main Page displaying packages, agents, login/register and etc.
	
	Author: Sheila Zhao
	Date: April 2019
 -->
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Travel Experts</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />

    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
        // When the user scrolls down 20px from the top of the document, show the button
        
        window.onscroll = function() {scrollFunction()};

        function scrollFunction() {
          if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
            document.getElementById("myBtn").style.display = "block";
          } else {
            document.getElementById("myBtn").style.display = "none";
          }
        }

        // When the user clicks on the button, scroll to the top of the document
        function topFunction() {
          document.body.scrollTop = 0;
          document.documentElement.scrollTop = 0;
        }
    </script>

    <!-- css files -->
    <link rel="icon" href="assets/images/world.png">
     <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link href="assets/bootstrap/css/bootstrap.css" rel='stylesheet' type='text/css' /><!-- bootstrap css -->
    <link href="assets/bootstrap/css/style.css" rel='stylesheet' type='text/css' /><!-- custom css -->
    <link href="assets/bootstrap/css/font-awesome.min.css" rel="stylesheet"><!-- fontawesome css -->
    <!-- //css files -->
    
     <script src="assets/bootstrap/js/bootstrap.min.js"></script> 
	 <script src="assets/jquery.js"></script> 

    <!-- google fonts -->
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
    <!-- //google fonts -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    


</head>

<body>

<!-- declare the session -->
<%
session.setAttribute("custId",0);
session.setAttribute("custFirstName","");
session.setAttribute("custLastName","");
session.setAttribute("packageId",0);

%>

    <!-- //header -->
    <header>
        <div class="container">
            <!-- top header -->
            <section class="row top_header pt-3">
                <div class="col-lg-6 buttons ml-auto">
                    <ul class="social mt-lg-0 mt-3">
                        <li class="mr-sm-4 mr-1"><span class="fa mr-2 fa-envelope-open-o"></span> <a href="mailto:info@travelexperts.com">info@travelexperts.com</a> </li>
                        <li class="mr-1"><a href="#"><span class="fa fa-facebook"></span></a></li>
                        <li class="mr-1"><a href="#"><span class="fa fa-twitter"></span></a></li>
                        <li class="mr-1"><a href="#"><span class="fa fa-google-plus"></span></a></li>
                        <li class="mr-1"><a href="#"><span class="fa fa-linkedin"></span></a></li>

                    </ul>
                </div>
            </section>
            <!-- top header -->
            <!-- nav -->
            <nav class="pt-2 d-lg-flex">
                <div id="logo">
                    <h1> <a href="index.html"><span class="fa fa-globe"></span>Travel Experts</a></h1>
                </div>
                <label for="drop" class="toggle"><span class="fa fa-bars"></span></label>
                <input type="checkbox" id="drop" />
                <ul class="menu mt-md-2 ml-auto">
                    <li class="mr-lg-4 mr-2 active"><a href="index.jsp">Home</a></li>                   
                    <li class="mr-lg-4 mr-2"><a href="#about">About Us</a></li>
                    <li class="mr-lg-4 mr-2"><a href="#pricing">Packages</a></li>
                    <li class="mr-lg-4 mr-2"><a href="#contact">Contact</a></li>
                    <li class="mr-lg-4 mr-2"><a href="#subscribe">Subscribe</a></li>
                    <li class=""><a href="SignIn.jsp">Sign In/up</a></li>
                </ul>
            </nav>
            <!-- //nav -->
        </div>
    </header>
    <!-- //header -->


    <!-- banner -->
    <section class="banner" id="home">
        <div class="container">
            <div class="banner-text">
                <div class="slider-info">
                    <div class="w3layouts-text mt-lg-5">
                        <h2>Plan your Holiday Trip Now Exceptional Adventure</h2>
                        <p class="mt-3"> Book your next travel with us!!</p>
                    </div>
                </div>
                <!-- To bottom button-->
                <div class="thim-click-to-bottom mt-sm-5 mt-3 pt-lg-5">
                    <div class="rotate">
                        <a href="#choose" class="scroll">
                            <span class="fa fa-angle-double-down"></span>
                        </a>
                    </div>
                </div>
                <!-- //To bottom button-->
            </div>
        </div>
    </section>
    <!-- //banner -->
 
   
    <!-- why choose us -->
    <section class="choose py-5" id="choose">
        <div class="container py-sm-3">
            <h3 class="heading text-center mb-4">Why <span>Choose Us</span></h3>
            <div class="row text-center">
                <div class="col-lg-3 col-md-6 choose-icon mt-4">
                    <span class="fa fa-cogs" aria-hidden="true"></span>
                    <div class=" choose-grid">
                        <h3 class="mt-4">Knowledge & Experience</h3>
                        <p class="mt-2">We work hard to ensure we find you the most exciting, intriguing and amazing destinations and experiences that work within your budget.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 choose-icon mt-4">
                    <span class="fa fa-headphones" aria-hidden="true"></span>
                    <div class="choose-grid">
                        <h3 class="mt-4">Personal Touch</h3>
                        <p class="mt-2">Travel arrangements are designed to give you a tailored travel experience based on your interests and dreams.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 choose-icon mt-4">
                    <span class="fa fa-calendar" aria-hidden="true"></span>
                    <div class="choose-grid">
                        <h3 class="mt-4">Hassle-free Planning</h3>
                        <p class="mt-2">With our extensive travel experience, we will work to make your planning and travel as care-free as possible giving you more enjoyment at your destination.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 choose-icon mt-4">
                    <span class="fa fa-cubes" aria-hidden="true"></span>
                    <div class="choose-grid">
                        <h3 class="mt-4">All the Little Details</h3>
                        <p class="mt-2">We will help you with the important and often over-looked details such as travel insurance, documentation and recommendations for the little extras to further enhance your travel.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- //why choose us -->

    <!-- About -->
    <section class="about py-5" id="about">
        <div class="container py-3">
            <div class="row about-grids">
                <div class="col-lg-6">
                    <img src="assets/images/about.jpg" alt="About assets/images" class="img-fluid" />
                </div>
                <div class="col-lg-6 mt-lg-0 mt-3">
                    <h6 class="text-uppercase mt-4 mb-2">Mount Everest</h6>
                    <h4>Explore the world with us</h4>
                    <h5 class="my-sm-4 my-2"><span class="fa fa-plane"></span> Starting from $235</h5>
                    <p> Travel Experts is your one-stop online travel shop. so forget trawling the web for the latest flight specials. With low airfares on international and domestic flights from all your favourite airlines, vehicle hire options from top car rental companies and hotel reservations bookable for properties on every continent, we offer something for every traveller's budget. For custom holiday packages to anywhere you can imagine, contact our travel experts and let's start planning!</p>
                </div>
            </div>
        </div>
    </section>
    <!-- //About -->

    <!-- packages -->
    <section class="pricing py-5" id="pricing">
        <div class="container py-md-5">
            <h3 class="heading text-center mb-5"> Travel <span>Packages</span></h3>
            <div class="row pricing-grids">
                <div class="col-lg-6 col-md-6 price mb-md-0 mb-sm-5 mb-4">
                    <div class="shadow">
                        <div class="pricing-grid mb-md-0 mb-sm-5 mb-4">
                            <div class="head">
                                <h3>Caribbean New Year </h3>
                            </div>
                            <h4>$4800</h4>
                            <p class="py-3 text-center">Cruise the Caribbean & Celebrate the New Year.</p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  Start Date: 2019-05-17</p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  End Date: 2019-05-21</p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  Agency Comission Fee: $400.0</p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  4 days Travel Trip</p>
                        </div>
                    </div>
                    <a href="SignIn.jsp">Select Plan <span class="fa fa-angle-double-right"></span></a><br/><br/>
                </div>
                <div class="col-lg-6 col-md-6 price mb-lg-0 mb-sm-5 mb-4">
                    <div class="shadow">
                        <div class="pricing-grid">
                            <div class="head">
                                <h3>Polynesian Paradise </h3>
                            </div>
                            <h4>$3000</h4>
                            <p class="py-3 text-center">8 Day All Inclusive Hawaiian Vacation</p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  Start Date: 2019-07-12</p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  End Date: 2019-07-20</p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  Agency Comission Fee: $310.0</p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  8 days Travel Trip</p>
                        </div>
                    </div>
                    <a href="SignIn.jsp">Select Plan <span class="fa fa-angle-double-right"></span></a><br/><br/>
                </div>
                <div class="col-lg-6 col-md-6 price mb-sm-0 mb-4">
                    <div class="shadow">
                        <div class="pricing-grid">
                            <div class="head">
                                <h3>Asian Expedition </h3>
                            </div>
                            <h4>$2800</h4>
                            <p class="py-3 text-center">Airfaire, Hotel and Eco Tour.</p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  Start Date: 2019-06-14</p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  End Date: 2019-07-01</p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  Agency Comission Fee: $300.0</p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  17 days Travel Trip</p>
                        </div>
                    </div>
                    <a href="SignIn.jsp">Select Plan <span class="fa fa-angle-double-right"></span></a>
                </div>
                <div class="col-lg-6 col-md-6 price mb-sm-0 mb-4">
                    <div class="shadow">
                        <div class="pricing-grid">
                            <div class="head">
                                <h3>European Vacation </h3>
                            </div>
                            <h4>$3000</h4>
                            <p class="py-3 text-center">Euro Tour with Rail Pass and Travel Insurance</p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  Start Date: 2019-08-01</p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  End Date: 2019-08-24</p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  Agency Comission Fee: $280.0</p>
                            <p> <span class="fas fa-dove" aria-hidden="true"></span>  23 days Travel Trip</p>
                        </div>
                    </div>
                    <a href="SignIn.jsp">Select Plan <span class="fa fa-angle-double-right"></span></a>
                </div>
            </div>
        </div>

    </section>
    <!-- packages -->
    
    
    <!-- team -->
    <section class="team py-5" id="team">
        <div class="w3_dot_info two py-3">
            <div class="container">
                <h3 class="heading text-center mb-4"> Our <span>Agents</span></h3>
                <div class="row w3pvt_team_grids">
                    <div class="col-lg-3 col-sm-6">
                        <div class="w3_team_grid">
                            <div class="w3_team_grid_figure">
                                <img src="assets/images/agent1.JPG" alt=" " class="img-fluid" />
                            </div>
                            <h4>Jane Watson</h4>
                            <p>Travel Agent</p>
                            <p>+1(403)555-5555</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6 mt-sm-0 mt-4">
                        <div class="w3_team_grid">
                            <div class="w3_team_grid_figure">
                                <img src="assets/images/agent2.jpg" alt=" " class="img-fluid" />
                            </div>
                            <h4>James Doe</h4>
                            <p>Travel Agent</p>
                            <p>+1(403)555-5556</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6 mt-lg-0 mt-4">
                        <div class="w3_team_grid">
                            <div class="w3_team_grid_figure">
                                <img src="assets/images/agent3.jpg" alt=" " class="img-fluid" />
                            </div>
                            <h4>Laura Carl</h4>
                            <p>Travel Agent</p>
                            <p>+1(403)555-5557</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6 mt-lg-0 mt-4">
                        <div class="w3_team_grid">
                            <div class="w3_team_grid_figure">
                                <img src="assets/images/agent4.jpg" alt=" " class="img-fluid" />
                            </div>
                            <h4>Anderson</h4>
                            <p>Travel Agent</p>
                            <p>+1(403)555-5558</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- //team -->
   
    <!--/Blog-Posts-->
    <section class="banner-bottom-w3layouts py-md-5 py-4" id="blog">
        <div class="container">
            <h3 class="heading text-center mb-4">Latest <span>News Blog</span></h3>
            <div class="inner-sec-w3ls py-md-5 py-4">
                <!--/services-grids-->
                <div class="row blog-sec">
                    <div class="col-lg-4 col-md-6 about-in blog-grid-info text-left">
                        <div class="card img">
                            <div class="card-body img">
                                <img src="assets/images/blog.jpg" alt="" class="img-fluid">
                                <div class="blog-des mt-3">
                                    <span class="entry-date"><span class="fa fa-clock-o" aria-hidden="true"></span> 8th Dec, 2018 <span class=" ml-4 fa fa-user" aria-hidden="true"></span> John Watson</span>
                                    <h5 class="card-title mt-2"><a href="#">Boating trip in a beach</a></h5>
                                    <p class="card-text">Nulla eu elementum quam. Pellentesque consectetur magna purus, nec facilisis.
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 about-in blog-grid-info text-left mt-md-0 mt-5">
                        <div class="card img">
                            <div class="card-body img">
                                <img src="assets/images/blog1.jpg" alt="" class="img-fluid">
                                <div class="blog-des mt-3">
                                    <span class="entry-date"><span class="fa fa-clock-o" aria-hidden="true"></span> 8th Dec, 2018 <span class=" ml-4 fa fa-user" aria-hidden="true"></span> John Watson</span>
                                    <h5 class="card-title mt-2"><a href="#">Vacational Happy trip</a></h5>
                                    <p class="card-text">Nulla eu elementum quam. Pellentesque consectetur magna purus, nec facilisis.
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 about-in blog-grid-info text-left mt-lg-0 mt-5">
                        <div class="card img">
                            <div class="card-body img">
                                <img src="assets/images/blog2.jpg" alt="" class="img-fluid">
                                <div class="blog-des mt-3">
                                    <span class="entry-date"><span class="fa fa-clock-o" aria-hidden="true"></span> 8th Dec, 2018 <span class=" ml-4 fa fa-user" aria-hidden="true"></span> John Watson</span>
                                    <h5 class="card-title mt-2"><a href="#">Holiday trip to mountains</a></h5>
                                    <p class="card-text">Nulla eu elementum quam. Pellentesque consectetur magna purus, nec facilisis.
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--//Blog-Posts-->

    <!-- Book -->
    <section class="book py-5" id="book">
        <div class="container py-md-5">
            <div class="row">
                <div class="col-lg-8">
                    <h4 class="heading">Do You Want To Go?</h4>
                    <p class="mt-4"> Aliquam sodales neque ullamcorper vestibulum consequat. Curabitur mauris justo, rutrum sit amet pulvinar et, rutrum mattis augue. In faucibus orci vitae nulla ipsum. Curabitur mauris justo, rutrum sit amet pulvinar et, rutrum mattis augue. In faucibus orci.</p>
                    <form action="#" method="post" class="d-sm-flex mt-sm-5 mt-3">
                        <input type="text" name="Name" placeholder="Full Name" required="">
                        <input type="text" name="Phone no" class="mx-sm-2 my-sm-0 my-2" placeholder="Phone Number" required="">
                        <button type="submit" class="btn"> Submit</button>
                    </form>
                </div>
                <div class="col-lg-4">
                </div>
            </div>
        </div>
    </section>
    <!-- //Book -->

    <!-- contact -->
    <section class="contact py-5" id="contact">
        <div class="container py-md-3">
            <h3 class="heading text-center mb-4">Contact Us</h3>
            <div class="row contact-w3layouts">
                <div class="col-lg-5 contact-right">
                    <form action="#" method="post">
                        <input type="text" name="Name" placeholder="Enter Your Name" required="">
                        <input type="email" class="email" name="Email" placeholder="Enter Your Email" required="">
                        <input type="text" name="Phone no" placeholder="Enter Your Phone Number" required="">
                        <textarea name="Message" placeholder="Add Your Message" required=""></textarea>
                        <button class="btn submit">Submit </button>
                    </form>
                </div>
                <div class="col-lg-7 contact-middle mt-lg-0 mt-4">
                    <div class="location-w3layouts-map">
                        <iframe src="" allowfullscreen></iframe>
                    </div>
                </div>
            </div>
        </div>

    </section>
    <!-- //contact -->

    <!-- footer -->
    <section class="footer-top pt-5">
        <div class="container">
            <div class="row">
                <div class="col-lg-5 mt-lg-0 mt-3 footer" id="subscribe">
                    <div class="icon-subscribe">
                        <h3><span class="fa fa-paper-plane" aria-hidden="true"></span> Join our newsletter</h3>
                        <p>Get Our Latest News And Special Offers</p>
                    </div>
                </div>
                <div class="col-lg-7 mt-lg-0 mt-4">
                    <form action="#" method="post">
                        <input type="email" placeholder="Enter your email..." name="email" required="">
                        <button type="submit" class="btn">Subscribe</button>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <section class="w3pvt-footer middle w3ls-section">
        <div class="container">
            <div class="w3layouts-footer-bottom position-relative">
                <div class="row w3_layouts-footer-grids py-5">
                    <div class="col-lg-3 col-md-5 mb-sm-0 mb-4 w3_layout-footer1 f1">
                        <h5 class="mb-3">Who We Are</h5>
                        <h6>10+ years of experience</h6>
                        <p class="mt-2">Integer pulvinar leots idut viver sed feugiat. Pellentesque libero justo orcis fermentum sit amet consec adipiscing. Ipsum dolor sit amet idut viver sed.</p>
                    </div>
                    <div class="col-lg-5 col-md-7 row w3_layout-footer1 f2 mt-md-0 mt-4">

                        <div class="col-lg-7 col-md-7 col-sm-6 mb-sm-0 mb-4 inner-li">
                            <h5 class="mb-3">Address Info</h5>
                            <ul class="w3ls-footer-bottom-list">
                                <li> <span class="fa fa-map-marker"></span> 123 st Calgary<span> AB, Canada </span></li>
                                <li> <span class="fa fa-envelope"></span> <a href="mailto:info@travelexperts.com"> info@travelexperts.com</a> </li>
                                <li> <span class="fa fa-phone"></span> +112 367 896 2449 </li>
                                <!-- <li> <span class="fas fa-globe"></span> <a href="#"> www.website.com</a> </li> -->
                                <li> <span class="fa fa-clock-o"></span> 8:00 a.m - 6:00 p.m</li>
                            </ul>
                        </div>
                        <div class="col-lg-5 col-md-5 col-sm-6 inner-li">
                            <h5 class="mb-3">Useful Links </h5>
                            <ul class="w3ls-footer-bottom-list">
                                <li><a href="about.html">About our company</a></li>
                                <li><a href="#">What we do</a></li>
                                <li><a href="projects.html">Best travel places</a></li>
                                <li><a href="#">Team members</a></li>
                                <li><a href="contact.html">Write to us</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12 w3_layout-footer1 f3 mt-lg-0 mt-4">
                        <h5 class="mb-3">Latest Tweets</h5>
                        <ul class="tweet-w3pvt">
                            <li>
                                <p class="tweet-p1"><span class="fa fa-twitter" aria-hidden="true"></span><a href="mailto:support@company.com">@example</a> sit amet libero consectetur sed adipiscing libero justo orci sit amet.</p>
                                <p class="tweet-p2">Posted 2 days ago.</p>
                            </li>
                            <li>
                                <p class="tweet-p1"><span class="fa fa-twitter" aria-hidden="true"></span><a href="mailto:support@company.com">@example</a> sit amet libero consectetur sed adipiscing libero justo orci sit amet.</p>
                                <p class="tweet-p2">Posted 4 days ago.</p>
                            </li>
                        </ul>
                    </div>
                    <a href="#home" class="move-top text-center"><span class="fa fa-angle-double-up" aria-hidden="true"></span></a>
                </div>
            </div>
        </div>
    </section>

    <section class="copyright py-4">
        <div class="w3layouts-copyright text-center">
            <p>Copyright &copy; 2019.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">Travel Experts</a></p>
        </div>

    </section>
    <!-- //footer -->
<!--  Added a go to top button-->
    <button onclick="topFunction()" id="myBtn" title="Go to top"><i class="fa fa-chevron-up"></i></button>

</body>

</html>
