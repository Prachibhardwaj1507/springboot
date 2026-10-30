package com.demo2;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println(">>> init(): Servlet ka object bana");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println(">>> doGet(): request aayi");
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Namaste!");
        resp.getWriter().println("<p>Abhi ka time: " + LocalTime.now() + "</p>");
    }

    @Override
    public void destroy() {
        System.out.println(">>> destroy(): Servlet band ho raha hai");
    }
}