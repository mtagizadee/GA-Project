public class Assignment {
    private Destination destination;
    private Student student;
    private CostCalculator costCalculator;

    public Assignment(Destination destination, Student student, DataContainer dataContainer) {
        this.destination = destination;
        this.student = student;
        this.costCalculator = new CostCalculator(dataContainer, student);
    }

    public Student getStudent() {
        return this.student;
    }

    public Destination getDestination() {
        return this.destination;
    }
}
