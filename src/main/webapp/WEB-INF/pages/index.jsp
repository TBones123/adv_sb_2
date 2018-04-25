<%--
  Created by IntelliJ IDEA.
  User: Radus
  Date: 24.04.2018
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index</title>
</head>
<body>
${asd}
<form action="/save" method="post">
    <input type="text" name="username" placeholder="username">
    <input type="submit" name="" placeholder="">
</form>

<ul>
    <c:forEach items="${allUsers}" var="user">
        <li>
                ${user.id} ${user.name}
            <a href="/delete/${user.id}">
                <button>delete</button>
            </a>
            <a href="/update/${user.id}">
                <button>update</button>
            </a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
