package controllers;

import DB.DbManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="StudentModifyController", value = "/student_modify")
public class StudentModifyController extends HttpServlet {
    private String stId;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //получить данные студента
        //отобразить их
        //открыть страницу
        stId = req.getParameter("modifyStudentHidden");
        DbManager manager = new DbManager();
        Student student = manager.getStudentToId(stId);
        req.setAttribute("student", student);
        req.getRequestDispatcher("JSP/student_modifying.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //получаем данные со страницы
        //сохраняем их
        //возвращаемся на страницу студентов

        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String date = req.getParameter("date");

        DbManager manager = new DbManager();
        manager.modifyStudent(stId, surname, name, group, date);

        resp.sendRedirect("/students");
    }
}
