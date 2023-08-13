package controllers;

import DB.DbManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentCreateController", value = "/student_creating")
public class StudentCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("JSP/student_creating.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String surname = request.getParameter("surname");
        String name = request.getParameter("name");
        String group = request.getParameter("group");
        String date = request.getParameter("date");

        if (!surname.isEmpty() || !name.isEmpty() || !group.isEmpty() || !date.isEmpty()) {
            DbManager manager = new DbManager();
            manager.createStudent(surname, name, group, date);

            response.sendRedirect("/students");
        }
    }
}
