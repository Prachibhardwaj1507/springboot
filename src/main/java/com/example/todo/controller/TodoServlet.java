package com.example.todo.controller;
import com.example.todo.dao.TodoDao;
import com.example.todo.model.Todo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/todos")
public class TodoServlet extends HttpServlet {
    private TodoDao dao;

    @Override
    public void init() {
        dao = new TodoDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";
        try {
            switch (action) {
                case "new":
                    req.getRequestDispatcher("/WEB-INF/views/todo-form.jsp").forward(req, resp);
                    break;
                case "edit":
                    int id = Integer.parseInt(req.getParameter("id"));
                    req.setAttribute("todo", dao.getById(id));
                    req.getRequestDispatcher("/WEB-INF/views/todo-form.jsp").forward(req, resp);
                    break;
                case "delete":
                    dao.delete(Integer.parseInt(req.getParameter("id")));
                    req.getSession().setAttribute("msg", "Todo deleted");
                    resp.sendRedirect(req.getContextPath() + "/todos");
                    break;
                default:
                    req.setAttribute("todos", dao.getAll());
                    req.getRequestDispatcher("/WEB-INF/views/todo-list.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Todo t = new Todo();
        t.setTitle(req.getParameter("title"));
        t.setDescription(req.getParameter("description"));
        t.setCompleted(req.getParameter("completed") != null);
        try {
            if (idStr == null || idStr.isEmpty()) {
                dao.insert(t);
                req.getSession().setAttribute("msg", "Todo added");
            } else {
                t.setId(Integer.parseInt(idStr));
                dao.update(t);
                req.getSession().setAttribute("msg", "Todo updated");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        resp.sendRedirect(req.getContextPath() + "/todos");
    }
}