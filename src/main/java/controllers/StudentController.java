package controllers;

import DB.DbManager;
import entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/students")
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DbManager db = new DbManager();
        List<Student> students = db.getActiveStudents();

        request.setAttribute("students", students);

        request.getRequestDispatcher("JSP/students.jsp").forward(request, response);
    }
}
