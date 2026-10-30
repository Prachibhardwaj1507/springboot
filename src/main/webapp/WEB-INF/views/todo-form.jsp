<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><title>Todo Form</title></head>
<body style="font-family: Arial; margin: 40px;">
<h1>${empty todo ? 'Add Todo' : 'Edit Todo'}</h1>


<form action="${pageContext.request.contextPath}/todos" method="post">
    <input type="hidden" name="id" value="${todo.id}">


    <p>Title:<br>
        <input type="text" name="title" value="<c:out value='${todo.title}'/>" required></p>


    <p>Description:<br>
        <input type="text" name="description" value="<c:out value='${todo.description}'/>"></p>


    <p><label>
        <input type="checkbox" name="completed" ${todo.completed ? 'checked' : ''}> Completed
    </label></p>


    <button type="submit">Save</button>
    <a href="${pageContext.request.contextPath}/todos">Cancel</a>
</form>
</body>
</html>