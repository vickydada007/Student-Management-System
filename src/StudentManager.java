import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {

    List<Student> students = new ArrayList<>();

    public void addToList(Student student){
        students.add(student);
    }
    public boolean uniqueIdCheck(int id){
        boolean idMatch = false;
        for(Student student : students){
            if(student.getId() == id){
                idMatch = true;
                break;
            }
        }
        return idMatch;
    }
    public List<Student> getStudents(){
        return students;
    }
    public Student getStudent(int index){
        for(Student student : students){
            if(index==student.getId())
                return student;
        }
        return null;
    }

    public void updateStudent(int index, Student student){
        students.set(index, student);
    }
    public void deleteStudent(int id) throws Exception {
        boolean found = false;
        for(Student student : students){
            if(student.getId()==id) {
                students.remove(student);
                found = true;
            }
        }
        if(!found)
        throw new Exception("Student not found");
    }

}
