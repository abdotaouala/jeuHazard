<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jeu Hazard</title>
</head>
<body>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="panel panel-primary col-md-8">
			<div class="panel-heading">
				<h3 class="panel-title">Veuillez entrer un nombre entre 0 et
					1000</h3>
			</div>
			<div class="panel-body">
				<form action="controleur.php" method="post">
					Devinez <input type="number" name="nombre" value="${model.nombre }" />
					<input type="submit" value="Jouer" name="action" />
					<c:if test="${model.fin==true }">
						<input type="submit" value="Relancer" name="action" />
					</c:if>
				</form>
			</div>
		</div>
		<div class="col-md-2"></div>
	</div>

	
	<div class="row">
		<div class="col-md-4"></div>
		<div class="alert ${model.fin==false ? 'alert-danger' : 'alert-success'  } col-md-4" role="alert">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			<span class="sr-only"></span> ${model.historique.get(model.historique.size()-1) } 
		</div>
		<div class="col-md-4"></div>
	</div>
	
	
	<div class="row">
		<div class="col-md-2"></div>
		<div class="panel panel panel-info col-md-8">
			<div class="panel-heading">
				<h3 class="panel-title">Historique</h3>
			</div>
			<div class="panel-body">
				<table>
					<c:forEach items="${model.historique}" var="rep">
						<tr>
							<td>${rep}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="col-md-2"></div>
	</div>

</body>
</html>