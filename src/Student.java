import java.util.ArrayList;


public class Student {
    private String name;
    private String surname;
    private int id;
    private final ArrayList<Destination> preferences;

    public Student(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.preferences = new ArrayList<Destination>();
    }

    public void addPreference(Destination destination) {
        this.preferences.add(destination);
    }

    public String getFullName() {
        return this.name + " " + this.surname;
    }

    public String toString() {
        return this.getFullName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Destination> getPreferences() {
        return this.preferences;
    }
}
