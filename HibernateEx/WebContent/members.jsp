<%@page import="java.util.List"%>
<%@page import="com.im.hibernate.model.Member"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hibernate Example</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>My Web Site</h1>
			<p> My Web Site Slogan </p>
			<hr/>
			<a href="register.jsp" class="btn btn-warning"> REGISTER </a>
			<a href="login.jsp" class="btn btn-success"> LOGIN </a>
		</div>
		<div class="jumbotron">
			<h3> My Web Site Profile Page</h3>
			<%
			Configuration con = new Configuration();
			SessionFactory sf = con.configure().buildSessionFactory();
			Session ses = sf.openSession();
			ses.beginTransaction();
			List<Member> list = ses.createCriteria(Member.class).list();
			for(Member member: list){
			%>
				<h1> <%=member.getName() %></h1>
				<p> Address: <%=member.getAddress() %></p>
				<p> Email: <%=member.getEmail() %></p>
				<p> Contact: <%=member.getMobile() %></p> 
			<%
			}
			%>
		</div>
	</div>
</body>
</html>