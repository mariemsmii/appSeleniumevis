<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Selenium test</title>
</head>
<div class="container">
	<body>
		</br>
		</br>
		</br>
		</br>
		<div class="row justify-content-center">
			<h1>Hello dear tester!</h1>
		</div>
		</br>
		</br>
		</br>
		<div class="container">
			<div class="row align-items-center">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Test</th>
							<th scope="col"></th>
							<th scope="col">OutPut</th>
						</tr>
					</thead>
					<tbody>
						<form:form method="post">
							<tr>
								<th scope="row">Test Back-End</th>
								<td>
									<input type="button" class="class="btn btn-outline-primary"" disabled></input>
									</td>
								<td>
									<div class="row align-items-center">
										<div class="alert alert-info" role="alert">this test is
											not run yet</div>
									</div>
								</td>
							</tr>
							<tr>
								<th scope="row">Test Front-End</th>
								<td><input type="submit" class="btn btn-outline-primary"
									value="Run Front-End test" name="action"></input></td>
								<td>
									<div class="row align-items-center">
										<div class="alert alert-info" role="alert">this test is
											not run yet</div>
											
									</div> 
									
								</td>
							</tr>
						</form:form>
					</tbody>
				</table>
			</div>
		</div>
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
			integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
			integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
			crossorigin="anonymous"></script>
	</body>
</div>




</html>