import java.util.Scanner;

public class UpdateStudent {
    public static UpdateStudent instance;
    private int id;
    private String name;
    private int age;
    private String grade;

    StudentManager studentManager;
    Scanner sc = new Scanner(System.in);

    public UpdateStudent(StudentManager studentManager) {
        this.studentManager = studentManager;
    }
    public static UpdateStudent getInstance(StudentManager studentManager){
        if(instance==null)
            instance = new UpdateStudent(studentManager);
        return instance;
    }
    public void modifyStudent() throws Exception {
        while (true) {
            System.out.println("Enter Student ID to modify:");
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
        Student student =null;
        int i;
        boolean flag = false;
        for(i=0;i<studentManager.getStudents().size();i++){
            if(studentManager.getStudents().get(i).getId() == id){
                student = studentManager.getStudents().get(i);
                flag = true;
                break;
            }
        }
        if(!flag){
            throw new Exception("Student not found");
        }
        int choice;
        do {
            System.out.println("Choice option to modify field:");
            System.out.println("1. Modify id");
            System.out.println("2. Modify name");
            System.out.println("3. Modify age");
            System.out.println("4. Modify grade");
            System.out.println("5. Done & Exit");
            while (true) {
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
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
            switch (choice){
                case 1:
                    while (true) {
                        System.out.println("Enter new Student ID:");
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
                    student.setId(id);
                    break;
                case 2:
                    System.out.println("Enter new name:");
                    name = sc.nextLine();
                    student.setName(name);
                    break;
                case 3:
                    while (true) {
                        System.out.println("Enter new age:");
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
                    student.setAge(age);
                    break;
                case 4:
                    System.out.println("Enter new grade:");
                    grade = sc.nextLine();
                    student.setGrade(grade);
                    break;
                case 5:
                    studentManager.updateStudent(i,student);
                    System.out.println("Modification Applied");
                    return;
                default:
                    System.out.println("Modification not Applied");
                    break;
            }

        } while(true);

    }

}
