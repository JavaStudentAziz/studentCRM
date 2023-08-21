package controllers;

import DB.DbManager;
import entity.DisciplineMark;
import entity.Student;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentProgressController", value = "/student_progress")
public class StudentProgressController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("progressStudentHidden");
        DbManager manager = new DbManager();
        Student student = manager.getStudentToId(id);
        request.setAttribute("student", student);

        List<Term> terms = manager.getActiveStudentTerm(id);
        Term first = terms.get(0);
        request.setAttribute("terms", terms);
        request.setAttribute("first", first);

        List<DisciplineMark> dm = manager.getDisciplineMark(first, student);
        request.setAttribute("dm", dm);

        request.getRequestDispatcher("JSP/student_progress.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
