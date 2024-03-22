<%@page import="Model.DTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.DAO"%>
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
	<h1 align="center">BOOKS</h1>
	<% ArrayList<DTO> data = DAO.displayBook(); %>
	<form action="displaybookLink" method="post">
	<table class="table table-success table-striped">
  		<thead>
    		<tr>
      		<th scope="col">Book Id</th>
      		<th scope="col">Book Name</th>
      		<th scope="col">Book Author</th>
      		<th scope="col">No. Pages</th>
      		<th scope="col">Operation</th>
    		</tr>
  		</thead>
  		<tbody>
  		<%for(DTO res:data) {%>
    		<tr>
    		<td><%= res.getBook_id() %></td>
      		<td><%= res.getBook_name() %></td>
      		<td><%= res.getBook_auth() %></td>
      		<td><%= res.getNo_of_pages() %></td>
      		<td>
      			<button type="submit" class="btn btn-outline-primary" name="id" value="<%= res.getBook_id()%>">UPDATE</button>
      		</td>
    		</tr>
    		<%} %>
  		</tbody>
	</table>
	</form>
	<div align="center">
		<a href="AddBook.jsp"><button class="btn btn-outline-success">Add Book</button></a>
	</div>
</body>
</html>