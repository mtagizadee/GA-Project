public class Assignment {
    private Destination destination;
    private Student student;

    public Assignment(Destination destination, Student student) {
        this.destination = destination;
        this.student = student;
    }

    public Student getStudent() {
        return this.student;
    }

    public Destination getDestination() {
        return this.destination;
    }
}
