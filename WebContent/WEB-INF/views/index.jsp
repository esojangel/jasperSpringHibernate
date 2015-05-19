<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Documents</h3>
	<p>para genear reportes por jaspers</p>
	<h3>Sistemas</h3>
<c:if test="${!empty sistemas}">
    <table class="tg">
    <tr>
        <th width="140">host</th>
        <th width="140">username</th>
        <th width="140">dbname</th>
    </tr>
    <c:forEach items="${sistemas}" var="sys">
        <tr>
            <td>${sys.host}</td>
            <td>${sys.username}</td>
            <td>${sys.dbname}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>