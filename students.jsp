<%@ page import="java.util.List, com.demo.Student" %>
<%
    List<Student> students = (List<Student>) request.getAttribute("students");
    Student selected = (Student) request.getAttribute("selected");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        .container { display: flex; gap: 40px; }
        .list a { display: block; padding: 8px 14px; margin: 5px 0; background: #eee;
                  text-decoration: none; color: #000; border-radius: 4px; }
        .list a:hover { background: #cde; }
        .card { border: 1px solid #888; padding: 20px; border-radius: 6px; min-width: 260px; }
    </style>
</head>
<body>
    <h1>Student Dashboard</h1>
    <div class="container">


        <div class="list">
            <h3>Students</h3>
            <% for (Student s : students) { %>
                <a href="students?roll=<%= s.getRollNo() %>"><%= s.getName() %></a>
            <% } %>
        </div>


        <div class="card">
            <% if (selected == null) { %>
                <p>Left se koi student select karo.</p>
            <% } else { %>
                <h2><%= selected.getName() %></h2>
                <p><b>Roll No:</b> <%= selected.getRollNo() %></p>
                <p><b>Course:</b> <%= selected.getCourse() %></p>
            <% } %>
        </div>


    </div>
</body>
</html>