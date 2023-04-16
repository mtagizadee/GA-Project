import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DataContainer dataContainer = new DataContainer();
        dataContainer.shuffle();

        ArrayList<Student> students = dataContainer.getStudents();
        ArrayList<Destination> destinations = dataContainer.getDestinations();

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(students, destinations);
        geneticAlgorithm.optimize();
    }
}


