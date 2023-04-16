import java.util.ArrayList;

public class GeneticAlgorithm {

    private ArrayList<Student> students;
    private ArrayList<Destination> destinations;
    private ArrayList<Assignment> population;

    public GeneticAlgorithm(ArrayList<Student> students, ArrayList<Destination> destinations) {
        this.students = students;
        this.destinations = destinations;
        this.init();
    }

    public void init() {
        this.population = new ArrayList<Assignment>();
    }

    private void generatePopulation() {
        // think about it again. What if we just iterate over all students and for each student
        // iterate over all destinations and take each gene as destination in student.preferences (if yes then 1 else 0)
        // in this case we will be able to build chromosomes and do crossover. But why then we need cost? 1 / cost defines the
        // probability of a individual to be chosen during the selection.

        for (Student student : students) {
            for (Destination preference : student.getPreferences()) {
                this.population.add(new Assignment(preference, student, this.destinations));
            }
        }
    }

    private void computeFitness() {

    }

    private void selection() {

    }

    private void crossover() {

    }

    private boolean isConverged() {
        return true;
    }

    private void mutation() {

    }

    public void optimize() {
        this.generatePopulation();
        for (Assignment assignment : this.population) System.out.println(assignment);

        this.computeFitness();
        while (!this.isConverged()) {
            this.selection();
            this.crossover();
            this.mutation();
            this.computeFitness();
        }
    }
}
