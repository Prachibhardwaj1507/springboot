<%
    String[] names   = {"Rahul Sharma", "Priya Verma", "Amit Singh", "Neha Gupta"};
    int[]    rollNos = {101, 102, 103, 104};
    String[] courses = {"B.Tech CSE", "B.Tech IT", "BCA", "MCA"};


    String idParam = request.getParameter("id");
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


        <!-- LEFT: students ki list, har naam ek link -->
        <div class="list">
            <h3>Students</h3>
            <% for (int i = 0; i < names.length; i++) { %>
                <a href="dashboard.jsp?id=<%= i %>"><%= names[i] %></a>
            <% } %>
        </div>


        <!-- RIGHT: jo student click hua uski detail -->
        <div class="card">
            <% if (idParam == null) { %>
                <p>Left se koi student select karo.</p>
            <% } else {
                   int id = Integer.parseInt(idParam);
                   if (id >= 0 && id < names.length) { %>
                       <h2><%= names[id] %></h2>
                       <p><b>Roll No:</b> <%= rollNos[id] %></p>
                       <p><b>Course:</b> <%= courses[id] %></p>
            <%     } else { %>
                       <p>Student nahi mila.</p>
            <%     }
               } %>
        </div>


    </div>
</body>
</html>