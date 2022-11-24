<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.z9devs.SpringBootJPAMVCTutorial.Document" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Add document</p>
	<form action="addDocument">
		id: <input type="text" name="id"><br>
		name: <input type="text" name="name"><br>
		skills: <input type="text" name="skills"><br>
		<input type="submit"><br>
	</form>
	
	<br>
	<p>Find document by id</p>
	<form action="getDocument">
		name: <input type="text" name="name"><br>
		skill: <input type="text" name="skill"><br>
		<input type="submit"><br>
	</form>
	
	<br>
	<p>All documents:</p>
	<ul>
	<%
	List<Document> l =  (List<Document>) request.getAttribute("documents");
	if(l != null) {
		for(Document d : l)
		{
			System.out.println(d.getName());
		%>
		<li><%=d.getName()%></li>
		
		<%}} %>
	</ul>

</body>
</html>