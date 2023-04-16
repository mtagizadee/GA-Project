import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DataContainer dataContainer = new DataContainer();
        dataContainer.shuffle();

        ArrayList<Student> students = dataContainer.getStudents();
        ArrayList<Destination> destinations = dataContainer.getDestinations();

        for (Student student : students) System.out.println(student);
        for (Destination destination : destinations) System.out.println(destination);
    }
}

