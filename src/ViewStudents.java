import java.util.Scanner;

public class ViewStudents {

    private static ViewStudents instance;

    StudentManager studentManager;
    public ViewStudents(StudentManager studentManager) {
        this.studentManager = studentManager;
    }
    public static ViewStudents getInstance(StudentManager studentManager){
        if(instance==null)
            instance = new ViewStudents(studentManager);
        return instance;
    }

    public void viewAllStudents() {
        for(Student s: studentManager.getStudents()){
            System.out.println(s.toString());
        }
    }
    public void searchStudent() {
        Scanner sc = new Scanner(System.in);
        int id;
        while (true) {
            System.out.println("Enter Student ID:");
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                sc.nextLine();
                break;
            }
            else {
                System.out.println("Invalid input. Please enter an integer.");
                sc.nextLine();
            }
        }
        Student student = studentManager.getStudent(id);
        if(student != null)
            System.out.println(student.toString());
        else
            System.out.println("Student not found");
    }
}
