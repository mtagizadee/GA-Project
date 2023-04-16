import java.util.ArrayList;

public class CostCalculator {
    private ArrayList<Destination> destinations;
    private Student student;

    public CostCalculator(ArrayList<Destination> destinations, Student student) {
        this.destinations = destinations;
        this.student = student;
    }

    public double calculate(int destinationId) {
        int isPreferableIndex = this.isPreferable(destinationId);
        if (isPreferableIndex == -1) return 10 * Math.pow(student.getDestinationsNumber(), 2);

        return Math.pow(isPreferableIndex - 1, 2);
    }

    public int isPreferable(int destinationId) {
        ArrayList<Destination> preferences = student.getPreferences();
        for (int i = 0; i < preferences.size(); i++) {
            if (preferences.get(i).getId() == destinationId) return i;
        }

        return -1;
    }
}
