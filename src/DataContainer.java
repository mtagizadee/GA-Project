import java.util.ArrayList;

public class DataContainer {
    private final ArrayList<Destination> destinations;
    private final ArrayList<Student> students;
    public DataContainer() {
        this.destinations = new ArrayList<Destination>();
        this.students = new ArrayList<Student>();
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public ArrayList<Destination> getDestinations() {
        return this.destinations;
    }

    public void shuffle() {
        this.shuffleDestinations();
        this.shuffleStudents();
        this.shufflePreferences();
    }

    public void shuffleDestinations() {
        String[] destinationsNames = Helpers.getDestinationsNames();

        for (int i = 0; i < destinationsNames.length; i++) {
            final int capacity = Helpers.rand(1, 6);
            this.destinations.add(new Destination(i + 1, destinationsNames[i], capacity));
        }
    }

    public void shuffleStudents() { // TEMPORARY FUNCTION UNTIL GA IS NOT FINISHED
        String[] studentsNames = Helpers.getStudentsNames();

        for (int i = 0; i < studentsNames.length; i++) {
            final int destinationsNumber = Helpers.rand(1, 10);
            this.students.add(new Student(studentsNames[i], i + 1, destinationsNumber));
        }
    }

    public void shufflePreferences() { // TEMPORARY FUNCTION UNTIL GA IS NOT FINISHED
        for (Student student : this.students) {
            for (int i = 0; i < student.getDestinationsNumber(); i++) {
                int randomPreferenceIndex = Helpers.rand(0, this.destinations.size() - 1);
                student.addPreference(this.destinations.get(randomPreferenceIndex));
            }
        }
    }
}
