<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
	<form action="addbookLink" method="post">
		<label>Enter Book Name :</label>
		<input type="text" name="book_name"><br><br>
		<label>Enter Author Name :</label>
		<input type="text" name="book_auth"><br><br>
		<label>Enter No Of Pages :</label>
		<input type="text" name="no_of_pages"><br><br>
		<input type="submit" class="btn btn-outline-success" value="Add Book">
	</form>

</body>
</html>