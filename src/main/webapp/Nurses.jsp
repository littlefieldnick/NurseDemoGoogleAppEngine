<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.lang.reflect.*" %>
<%@ page import="edu.usm.cos420.model.*" %> 
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nurses</title>
</head>
<body>

<h2> List Example</h2>
            
    <c:if test="${empty nurseList}">
	     Sorry, no items
	</c:if>
	<c:if test="${not empty nurseList}">
		<ul>
			<c:forEach var="listValue" items="${nurseList}">
				<li>${listValue}</li>
			</c:forEach>
		</ul>
 
	</c:if>
</body>
</html>