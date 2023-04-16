public class Destination {
    private final String name;
    private final int id;
    private final int capacity;

    public Destination(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String toString() {
        return this.id + ". " + this.name + " --> " + this.capacity;
    }
}
