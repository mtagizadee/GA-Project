import java.util.ArrayList;

public class Assignment {
    private Destination destination;
    private Student student;
    private CostCalculator costCalculator;

    public Assignment(Destination destination, Student student, ArrayList<Destination> destinations) {
        this.destination = destination;
        this.student = student;
        this.costCalculator = new CostCalculator(destinations, student);
    }

    public Student getStudent() {
        return this.student;
    }

    public Destination getDestination() {
        return this.destination;
    }

    public String toString() {
        return "{ " + this.student + " // " + this.destination + " }";
    }

    public double getCost() {
        return this.costCalculator.calculate(this.destination.getId());
    }
}
