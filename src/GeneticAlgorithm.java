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

        for (Student student : this.students) {
            this.population.add(new Assignment(student, this.destinations));
        }
    }

    private void computeFitness() {
        for (Assignment assignment : this.population) {
            assignment.calculateTotalCost();
        }
    }

    private ArrayList<Integer> selection() {
        ArrayList<Double> probabilities = new ArrayList<Double>();
        ArrayList<Integer> selected = new ArrayList<Integer>();
        for (Assignment assignment : population) probabilities.add(1 / assignment.getTotalCost());

        for (int i = 0; i < 2; i++) {
            int maxIndex = this.findMaxProbability(probabilities);
            selected.add(maxIndex);
            probabilities.remove(maxIndex);
        }

        return selected;
    }

    private int findMaxProbability(ArrayList<Double> probabilities) {
        int maxIndex = 0;
        double max = 0;
        for (int i = 0; i < probabilities.size(); i++) {
            if (probabilities.get(i) > max) {
                max = probabilities.get(i);
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    private String[] crossover(ArrayList<Integer> selected) {
        String father = this.population.get(selected.get(0)).toChromosome();
        String mother = this.population.get(selected.get(1)).toChromosome();

        int index  = Helpers.rand(0, father.length() - 1);

        String child1 = father.substring(0, index) + mother.substring(index);
        String child2 = mother.substring(0, index) + father.substring(index);

        return new String[]{child1, child2};
    }

    private boolean isConverged() {
        return true;
    }

    private void mutation() {

    }

    public void optimize() {
        this.generatePopulation();
        this.computeFitness();

        while (!isConverged()) {
            ArrayList<Integer> selected = this.selection();
            String[] children = this.crossover(selected);
            // find a way to convert chromosome to assignment and add it to the population

            this.mutation();
            this.computeFitness();
        }
    }
}
