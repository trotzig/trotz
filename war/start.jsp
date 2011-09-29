<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Malin Trotzig</title>
    <link href="/css/main.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/jquery-1.6.4.min.js"></script>
    <script type="text/javascript" src="/js/jquery.scrollTo-min.js"></script>
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
			  	
			  	<div class="image">
			  		<img src="/img/frilagd_malin.png" alt=""/>
			  	</div>
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
	  				<div class="item">
	  					<div class="image"></div>
	  					<h3 onclick="load('magasin', 0);">Magasinslayout</h3>
	  				</div>
	  				<div class="item">
	  					<div class="image"></div>
	  					<h3 onclick="load('logotyper', 1);">Logotyper</h3>
	  				</div>
	  				<div class="item">
	  					<div class="image"></div>
	  					<h3>Böcker</h3>
	  				</div>
	  				<div class="item">
	  					<div class="image"></div>
	  					<h3>Trycksaker</h3>
	  				</div>
	  				<div class="item last">
	  					<div class="image"></div>
	  					<h3>Form för webben</h3>
	  				</div>
	  			</div>
	  			<div class="clear"></div>
  				<div class="arrow-container" style="display: none;"><div id="arrow"></div></div>
	  			<div id="magasin" class="content" style="display:none">
	  				Här visas magasin
	  			</div>
	  			<div id="logotyper" class="content" style="display:none">
	  				Här visas logotyper
	  			</div>
	  			
	  			
	  		</div>
	  	</div>
  	
  	</div>
  </body>
</html>
