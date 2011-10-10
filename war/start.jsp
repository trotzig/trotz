<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Malin Trotzig</title>
    <link href='http://fonts.googleapis.com/css?family=Quattrocento' rel='stylesheet' type='text/css'>
    <link href="/css/main.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/jquery-1.6.4.min.js"></script>
    <script type="text/javascript" src="/js/jquery.scrollTo-min.js"></script>
    <script type="text/javascript" src="/js/lectric.js"></script>
    <script type="text/javascript" src="/js/main.js"></script>
  </head>
  <body>
   
  	<div class="wrapper">
	  	<div class="top-wrapper">
	  		<div class="top">
		  		<div class="header">
		  			<h1>Malin Trotzig</h1>
		  			<p>En text som ska bytas ut, med all sannolikhet</p>
		  		</div>
			  	<p class="message">
			  		${taco.message}
			  	</p>  
			  	
		  		<img class="image" src="/img/frilagd_malin.png" alt=""/>
	  		</div>
	  	</div>
	  	
	  	
 
	  	
	  	<div class="lower-wrapper container_12">
	  		<div class="lower">
	  			<div class="quotes">
		  			<h2>Sagt om Malin:</h2>
	  				<p class="quote grid_4">
	  					"...lätt att samarbeta med – kvicktänkt och proffsig."
	  				</p>
	  				<p class="quote grid_4">
	  					"...lätt att samarbeta med – kvicktänkt och proffsig."
	  				</p>
	  				<p class="quote grid_4">
	  					"...lätt att samarbeta med – kvicktänkt och proffsig."
	  				</p>
	  			</div>
	  			<div class="clear"></div>
	  			
	  			<div class="portfolio">
	  				<h2>Portfolio:</h2>
	  				<div class="item" onclick="load('MAGAZINES', 0);">
	  					<div class="image"></div>
	  					<h3>Magasinslayout</h3>
	  				</div>
	  				<div class="item" onclick="load('LOGOS', 1);">
	  					<div class="image"></div>
	  					<h3>Logotyper</h3>
	  				</div>
	  				<div class="item" onclick="load('BOOKS', 2);">
	  					<div class="image"></div>
	  					<h3>Böcker</h3>
	  				</div>
	  				<div class="item" onclick="load('PRINT', 3);">
	  					<div class="image"></div>
	  					<h3>Trycksaker</h3>
	  				</div>
	  				<div class="item last" onclick="load('WEB', 4);">
	  					<div class="image"></div>
	  					<h3>Form för webben</h3>
	  				</div>
	  			</div>
	  			<div class="clear"></div>
  				<div class="arrow-container" style="display: none;"><div id="arrow"></div></div>
	  			<div id="MAGAZINES" class="content" style="display:none">
	  				Här visas magasin
	  			</div>
	  			<div id="LOGOS" class="content" style="display:none">
	  				Här visas logotyper
	  			</div>
	  			<div id="BOOKS" class="content" style="display:none">
	  				Här visas böcker
	  			</div>
	  			<div id="PRINT" class="content" style="display:none">
	  				Här visas print
	  			</div>
	  			<div id="WEB" class="content" style="display:none">
	  				Här visas web
	  			</div>
	  		</div>
	  	</div>
  	
  	</div>
  </body>
</html>
