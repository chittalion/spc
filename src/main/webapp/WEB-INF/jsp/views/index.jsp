<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>SPC</title>

	
    <!-- Bootstrap -->
    <link href='<c:url value="/res/css/bootstrap.min.css"/>' rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
	<div class="container">
	  <div class="row">
	  	<div class="container">
	    	<div class="col-xs-8 col-md-8">
	    		<h1>SPC</h1>
	    		<c:url var="formUrl" value="/result"/>
				<form:form id="form" action="${formUrl}" method="post" commandName="spcInput">
				  <div class="form-group">
				  	<div class="alert alert-info" role="alert"><strong>Input numbers :</strong> <small>Please enter numbers line by line</small></div>
				    <form:textarea cssClass="form-control" rows="3" path="numbers" id="numbers" placeholder="Please enter Numbers" />
				  </div>
				  <button type="submit" class="btn btn-info">Show Result</button>
				</form:form>
				<div id="resultDiv">
					<%@ include file="/WEB-INF/jsp/views/result.jsp" %>
				</div>
	    	</div>
	    	</div>
	  </div>
	</div>
  
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value="/res/js/bootstrap.min.js"/>"></script>
    
    <script type="text/javascript">
	    $(document).ready(function() {
	        $("#form").submit(function(event){
	    		$.post($(this).attr("action"),$(this).serialize(), function( data ) {
	    			  $("#resultDiv").html( data );
				});   
	    		  return false;
	        });
	      
	     });
    </script>
  </body>
</html>