public class Destination {
    private String name;
    private int id;

    public Destination(String name, int id) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
