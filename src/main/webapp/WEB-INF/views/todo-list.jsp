<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Todos</title>
    <style>
        body { font-family: Arial; margin: 40px; }
        table { border-collapse: collapse; width: 80%; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        .done { text-decoration: line-through; color: gray; }
        .msg { color: green; }
    </style>
</head>
<body>
<h1>Todo List</h1>


<c:if test="${not empty sessionScope.msg}">
    <p class="msg">${sessionScope.msg}</p>
    <c:remove var="msg" scope="session"/>
</c:if>


<a href="${pageContext.request.contextPath}/todos?action=new">+ Add Todo</a>
<br><br>


<table>
    <tr><th>ID</th><th>Title</th><th>Description</th><th>Status</th><th>Actions</th></tr>


    <c:forEach var="t" items="${todos}">
        <tr>
            <td>${t.id}</td>
            <td class="${t.completed ? 'done' : ''}"><c:out value="${t.title}"/></td>
            <td><c:out value="${t.description}"/></td>
            <td>${t.completed ? 'Done' : 'Pending'}</td>
            <td>
                <a href="${pageContext.request.contextPath}/todos?action=edit&id=${t.id}">Edit</a> |
                <a href=
                           "${pageContext.request.contextPath}/todos?action=delete&id=${t.id}"
                   onclick="return confirm('Delete karna hai?')">Delete</a>
            </td>
        </tr>
    </c:forEach>


    <c:if test="${empty todos}">
        <tr><td colspan="5">Abhi koi todo nahi hai</td></tr>
    </c:if>
</table>
</body>
</html>