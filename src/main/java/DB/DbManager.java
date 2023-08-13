package DB;

import entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbManager implements IDbManager{
    @Override
    public List<Student> getActiveStudents() {

        List<Student> res = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_7_student",
                    "root","Diarmaid98");

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
    public void createStudent (String surname, String name,String group,String date) {

        List<Student> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_7_student",
                    "root", "Diarmaid98");

            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO `student` " +
                    "(`surname`, `name`, `group`, `date_in`)" +
                    " VALUES ('"+surname+"', '"+name+"', '"+group+"', '"+date+"');\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
