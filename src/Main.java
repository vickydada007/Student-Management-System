import java.io.IOException;
import java.util.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        StudentManager studentManager = new StudentManager();
        int choice;
        Scanner sc = new Scanner(System.in);

        FileHandling file = new FileHandling(studentManager);
        file.loadFromFile();

        do{
            System.out.println("---> Student Management System <---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student Details");
            System.out.println("5. Delete Student Record");
            System.out.println("6. Save & Exit");
            System.out.println("Enter your choice: ");
            while (true) {
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
                }
                else {
                    System.out.println("Invalid input. Please enter an integer.");
                    sc.nextLine();
                }
            }

            try {
                switch (choice) {
                    case 1:
                        AddStudent.getInstance(studentManager).addStudent();
                        break;
                    case 2:
                        ViewStudents.getInstance(studentManager).viewAllStudents();
                        break;
                    case 3:
                        ViewStudents.getInstance(studentManager).searchStudent();
                        break;
                    case 4:
                        UpdateStudent.getInstance(studentManager).modifyStudent();
                        break;
                    case 5:
                        DeleteStudent.getInstance(studentManager).deleteStudent();
                        break;
                    case 6:
                        FileHandling.getInstance(studentManager).saveToFile();
                        System.out.println("<--- Student System Closed --->");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Try again!");
                        break;
                }
            } catch (Exception e) {
                if (e.getMessage().equals("Student not found"))
                    System.out.println("Student not found");
                else{
                    System.out.println("Last Operation failed. Details: \n"+e.getMessage());
                }
            }
        }while(true);
        }
    }
