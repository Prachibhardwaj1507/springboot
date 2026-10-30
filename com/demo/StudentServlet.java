package com.demo;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/students")
public class StudentServlet extends HttpServlet {


    private final List<Students> students = new ArrayList<>();


    @Override
    public void init() {
        students.add(new Students(101, "Rahul Sharma", "B.Tech CSE"));
        students.add(new Students(102, "Priya Verma", "B.Tech IT"));
        students.add(new Students(103, "Amit Singh", "BCA"));
        students.add(new Students(104, "Neha Gupta", "MCA"));
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        String rollParam = req.getParameter("roll");
        Students selected = null;


        if (rollParam != null) {
            int roll = Integer.parseInt(rollParam);
            for (Students s : students) {
                if (s.getRollNo() == roll) {
                    selected = s;
                }
            }
        }


        req.setAttribute("students", students);
        req.setAttribute("selected", selected);


        req.getRequestDispatcher("/students.jsp").forward(req, resp);
    }
}