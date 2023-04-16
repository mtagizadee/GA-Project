import java.util.ArrayList;


public class Student {
    private String fullName;
    private int id;
    private int destinationsNumber;
    private final ArrayList<Destination> preferences;

    public Student(String fullName, int id, int destinationsNumber) {
        this.fullName = fullName;
        this.id = id;
        this.preferences = new ArrayList<Destination>();
        this.destinationsNumber = destinationsNumber;
    }

    public void addPreference(Destination destination) {
        this.preferences.add(destination);
    }

    public String getFullName() {
        return this.fullName;
    }

    public String toString() {
        return this.id + ". " + this.fullName + " --> " + this.destinationsNumber;
    }

    public int getId() {
        return this.id;
    }

    public int getDestinationsNumber() {
        return this.destinationsNumber;
    }

    public ArrayList<Destination> getPreferences() {
        return this.preferences;
    }
}
