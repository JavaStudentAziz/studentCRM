package DB;

import entity.DisciplineMark;
import entity.Student;
import entity.Term;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbManager implements IDbManager {
    @Override
    public List<Student> getActiveStudents() {

        List<Student> res = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_7_student",
                    "root", "Diarmaid98");

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM java_7_student.student where status = 1;");
            while (rs.next()) {

                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setSurname(rs.getString("surname"));
                student.setName(rs.getString("name"));
                student.setGroup(rs.getString("group"));
                student.setDate_in(rs.getDate("date_in"));
                student.setStatus(rs.getByte("status"));

                res.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public void createStudent(String surname, String name, String group, String date) {

        List<Student> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_7_student",
                    "root", "Diarmaid98");

            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO `student` " +
                    "(`surname`, `name`, `group`, `date_in`)" +
                    " VALUES ('" + surname + "', '" + name + "', '" + group + "', '" + date + "');\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(String ids) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_7_student",
                    "root", "Diarmaid98");

            Statement statement = connection.createStatement();
            statement.execute("UPDATE `student` SET `status` = '0' WHERE (`id` in (" + ids + "));");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudentToId(String id) {
        Student res = new Student();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_7_student",
                    "root", "Diarmaid98");

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM student where id = " + id + ";");
            while (rs.next()) {

                res.setId(rs.getInt("id"));
                res.setSurname(rs.getString("surname"));
                res.setName(rs.getString("name"));
                res.setGroup(rs.getString("group"));
                res.setDate_in(rs.getDate("date_in"));
                res.setStatus(rs.getByte("status"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public void modifyStudent(String id, String surname, String name, String group, String date) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_7_student",
                    "root", "Diarmaid98");

            Statement statement = connection.createStatement();
            statement.execute(
                    "UPDATE `student` SET `surname` = '" + surname + "', `name` = '" + name + "', `group` = '" + group + "', `date_in` = '" + date + "' WHERE (`id` = " + id + ");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Term> getActiveStudentTerm(String id) {
        List<Term> res = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_7_student",
                    "root", "Diarmaid98");

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT t.* FROM term t\n" +
                    "join term_discipline td on t.id = td.discipline_id\n" +
                    "join student_term_discipline std on std.term_discipline_id = td.id\n" +
                    "where std.student_id = " + id + " and t.status = 1 order by t.name;");
            while (rs.next()) {

                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setName(rs.getString("name"));
                term.setDuration(rs.getString("duration"));
                term.setStatus(rs.getByte("status"));

                res.add(term);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<DisciplineMark> getDisciplineMark(Term term, Student student) {
        List<DisciplineMark> res = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_7_student",
                    "root", "Diarmaid98");

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT d.id as id_d, d.name, m.id as id_m, m.mark FROM student s\n" +
                    "join student_term_discipline std on s.id = std.student_id\n" +
                    "join term_discipline td on td.id = std.term_discipline_id\n" +
                    "join term t on t.id = td.term_id\n" +
                    "left join discipline d on d.id = td.discipline_id\n" +
                    "left join student_term_discipline_mark stdm on stdm.student_id = s.id and stdm.term_discipline_id = td.id\n" +
                    "left join mark m on stdm.mark_id = m.id\n" +
                    "where s.id = "+student.getId()+" and t.id = "+term.getId()+"");
            while (rs.next()) {

                DisciplineMark dm = new DisciplineMark();
                dm.setIdD(rs.getInt("id_d"));
                dm.setNameD(rs.getString("name"));
                dm.setIdM(rs.getInt("id_m"));
                dm.setNameM(rs.getString("mark"));

                res.add(dm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
