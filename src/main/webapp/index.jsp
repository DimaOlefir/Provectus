<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Library</title>
</head>
<body>
<h2>Library</h2>
<br/>
<a href="<c:url value="/admin/books"/>">For administrator</a>
<br/>
<br/>
<a href="<c:url value="/user/library"/>">For user</a>
<br/>
</body>
</html>