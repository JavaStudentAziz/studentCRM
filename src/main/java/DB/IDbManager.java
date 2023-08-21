package DB;

import entity.DisciplineMark;
import entity.Student;
import entity.Term;

import java.util.List;

public interface IDbManager {
    List<Student> getActiveStudents();
    void createStudent (String surname, String name,String group,String date);
    void deleteStudent(String ids);
    Student getStudentToId(String id);
    void modifyStudent(String id, String surname, String name, String group, String date);
    List<Term> getActiveStudentTerm(String id);
    List<DisciplineMark> getDisciplineMark(Term term, Student student);
}
