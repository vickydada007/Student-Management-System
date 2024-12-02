import java.util.Scanner;

public class DeleteStudent {
    public static DeleteStudent instance;
    StudentManager studentManager;

    public DeleteStudent(StudentManager studentManager) {
        this.studentManager = studentManager;
    }
    public static DeleteStudent getInstance(StudentManager studentManager){
        if(instance==null)
            instance = new DeleteStudent(studentManager);
        return instance;
    }
    Scanner scanner = new Scanner(System.in);
    public void deleteStudent() throws Exception {
        System.out.println("Enter Student ID: ");
        int studentID = scanner.nextInt();
        studentManager.deleteStudent(studentID);
        System.out.println("Student id:"+ studentID +" Deleted!");
    }
}
