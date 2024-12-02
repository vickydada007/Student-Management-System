import java.util.Scanner;

public class AddStudent{
    private static AddStudent instance;
    private int id;
    private String name;
    private int age;
    private String grade;

    StudentManager studentManager;
    public AddStudent(StudentManager studentManager){
        this.studentManager = studentManager;
    }

    public static AddStudent getInstance(StudentManager studentManager){
        if(instance==null)
           instance = new AddStudent(studentManager);
        return instance;
    }
    Scanner sc = new Scanner(System.in);
    public void addStudent() {
        while (true) {
            System.out.println("Student ID:");
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                sc.nextLine();
                if(!studentManager.uniqueIdCheck(id))
                break;
                System.out.println("ID match found. Enter different ID:");
            }
            else {
                System.out.println("Invalid input. Please enter an integer.");
                sc.nextLine();
            }
        }
        System.out.println("Student name:");
        name=sc.nextLine();
        while (true) {
            System.out.println("Student age:");
            if (sc.hasNextInt()) {
                age = sc.nextInt();
                sc.nextLine();
                break;
            }
            else {
                System.out.println("Invalid input. Please enter an integer.");
                sc.nextLine();
            }
        }
        System.out.println("Student grade:");
        grade=sc.nextLine();
        studentManager.addToList(new Student(id,name,age,grade));
        System.out.println("Student added successfully");
    }

}
