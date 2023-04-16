public class GeneticAlgorithm {

    public void generatePopulation() {

    }

    public void computeFitness() {

    }

    public void selection() {

    }

    public void crossover() {

    }

    public boolean isConverged() {
        return true;
    }

    public void mutation() {

    }

    public void optimize() {
        this.generatePopulation();
        this.computeFitness();
        while (!this.isConverged()) {
            this.selection();
            this.crossover();
            this.mutation();
            this.computeFitness();
        }
    }
}
