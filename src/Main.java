import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DataContainer dataContainer = new DataContainer();
        dataContainer.shuffle();

        ArrayList<Student> students = dataContainer.getStudents();
        for (Student student : students) {
            System.out.println(student);
            for (Destination destination : student.getPreferences()) {
                System.out.println("\t" + destination);
            }
        }
        ArrayList<Destination> destinations = dataContainer.getDestinations();

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(students, destinations);
        geneticAlgorithm.optimize();

        for (Student student : students) {
            System.out.println(student);
            for (Destination destination : student.getPreferences()) {
                System.out.println("\t" + destination);
            }
        }
    }
}


