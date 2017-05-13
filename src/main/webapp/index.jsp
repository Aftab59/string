<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>String Parser</title>
</head>
<body>
	<h1>String Parser Using Struts 2</h1>
	<form action="combinations">
		<label for=string>Please Enter String</label><br /> <input type="text"
			name="string" /> <input type="submit" value="Parse String" />
	</form>
</body>
</html>