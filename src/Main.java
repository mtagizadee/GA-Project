import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DataContainer dataContainer = new DataContainer();
        dataContainer.shuffle();

        ArrayList<Student> students = dataContainer.getStudents();

        for (Student student : students) {
            System.out.println(student);
            System.out.println("# ----------- #");
            for (Destination preference : student.getPreferences()) System.out.println(preference);
            System.out.println("# ----------- #");
        }
    }
}

