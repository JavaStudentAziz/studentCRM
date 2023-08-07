package DB;

import entity.Student;

import java.util.List;

public interface IDbManager {
    List<Student> getActiveStudents();
}
