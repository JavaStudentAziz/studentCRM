package controllers;

import DB.DbManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "StudentDeleteController", value = "/student_delete")
public class StudentDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //получение данных
        //удаление
        //перейти на контроллер студентов

        String ids = req.getParameter("deleteStudentHidden");
        DbManager manager = new DbManager();
        manager.deleteStudent(ids);
        resp.sendRedirect("/students");
    }
}
