import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileHandling {
    public static FileHandling instance;
    StudentManager studentManager;

    public FileHandling(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    public static FileHandling getInstance(StudentManager studentManager){
        if(instance==null)
            instance = new FileHandling(studentManager);
        return instance;
    }

    public void saveToFile() throws IOException {
        File file = new File("students.txt");
        if(!file.exists())
            file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        for(Student student : studentManager.getStudents()){
            fileWriter.write(student.toString()+System.lineSeparator());
        }
        fileWriter.close();
    }
    public void loadFromFile() throws IOException {
        File file = new File("students.txt");
        if(!file.exists())
            file.createNewFile();
            Scanner scanner = new Scanner(file);
            String regex = "id=(\\d+), name='(.*?)', age=(\\d+), grade='(.*?)'";
            Pattern pattern = Pattern.compile(regex);
            String line,name,grade;
            int id, age;
            while(scanner.hasNext()) {
                line = scanner.nextLine();
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    id = Integer.parseInt(matcher.group(1));
                    name = matcher.group(2);
                    age = Integer.parseInt(matcher.group(3));
                    grade = matcher.group(4);
                    studentManager.students.add(new Student(id, name, age, grade));
                }
            }
    }

}
