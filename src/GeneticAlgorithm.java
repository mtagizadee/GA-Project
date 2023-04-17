import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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

    private ArrayList<ArrayList<Integer>> selection() {
        ArrayList<Double> probabilities = new ArrayList<Double>();
        ArrayList<ArrayList<Integer>> selections = new ArrayList<ArrayList<Integer>>();
        for (Assignment assignment : population) probabilities.add(1 / assignment.getTotalCost());

        for (; probabilities.size() != 0; ) {
            ArrayList<Integer> selection = new ArrayList<Integer>();

            for (int i = 0; i < 2; i++) {
                int maxIndex = this.findMaxProbability(probabilities);
                selection.add(maxIndex);
                probabilities.remove(maxIndex);
            }

            selections.add(selection);
        }

        return selections;
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

    private void crossover(ArrayList<ArrayList<Integer>> selections) {
        for (ArrayList<Integer> selection : selections) {
            int fatherIdx = selection.get(0), motherIdx = selection.get(1);

            String father = this.population.get(fatherIdx).toChromosome();
            String mother = this.population.get(motherIdx).toChromosome();

            int index = Helpers.rand(0, father.length() - 1);

            String child1 = father.substring(0, index) + mother.substring(index);
            String child2 = mother.substring(0, index) + father.substring(index);

            this.population.get(fatherIdx).applyChromosome(child1);
            this.population.get(motherIdx).applyChromosome(child2);
        }
    }

    private boolean isConverged() {
        return true;
    }

    private void mutation() {
        for (Assignment assignment : this.population) {
            String[] genes =  assignment.toChromosome().split("");

            for (int i = 0; i < genes.length; i++) {
                int flipChance = Helpers.rand(1, 10);

                if (toFlip(flipChance)) {
                    String gene = genes[i];
                    genes[i] = Objects.equals(gene, "1") ? "0" : "1";
                }
            }

            String newChromosome = Arrays.toString(genes);
            assignment.applyChromosome(newChromosome);
        }
    }

    private boolean toFlip(int flipChance) {
        return flipChance == 2 || flipChance == 4 || flipChance == 6 || flipChance == 5;
    }

    public void optimize() {
        this.generatePopulation();
        this.computeFitness();

        System.out.println("Initial population");
        for (Assignment assignment : this.population) System.out.println(assignment.toChromosome());
        int count = 0;
        while (count++ != 20) {
            ArrayList<ArrayList<Integer>> selections = this.selection();
            this.crossover(selections);
            // find a way to convert chromosome to assignment and add it to the population

            this.mutation();
            this.computeFitness();
        }

        System.out.println("Final population");
        for (Assignment assignment : this.population) System.out.println(assignment.toChromosome());
    }
}
