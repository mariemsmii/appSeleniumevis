<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<form:form servletRelativeAction="/">
		<button type="submit">Envoyer</button>
		<button type="Submit" name="action" value="VALID"></button>
	</form:form>

</body>
</html>