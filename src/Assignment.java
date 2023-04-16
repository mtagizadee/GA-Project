import java.util.ArrayList;

public class Assignment {
    private Student student;
    private CostCalculator costCalculator;
    private ArrayList<Destination> destinations;
    private double totalCost;

    public Assignment(Student student, ArrayList<Destination> destinations) {
        this.student = student;
        this.costCalculator = new CostCalculator(destinations, student);
        this.destinations = destinations;
        this.totalCost = 0;
    }

    public Student getStudent() {
        return this.student;
    }

    public String toString() {
        return "{ " + this.student + " // " + this.totalCost  + " }";
    }

    public void calculateTotalCost() {
        this.totalCost = 0;
        for (Destination destination : this.destinations) {
            double cost = this.costCalculator.calculate(destination.getId());
            this.totalCost += cost;
        }
    }

    public String toChromosome() {
        StringBuilder result = new StringBuilder();
        for (Destination destination : this.destinations) {
            int isPreferable = this.costCalculator.isPreferable(destination.getId());
            result.append(isPreferable != -1 ? "1" : "0");
        }

        return result.toString();
    }

    public double getTotalCost() {
        return this.totalCost;
    }
}
