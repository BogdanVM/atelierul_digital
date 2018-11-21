package Classes;

public class Glove {

    private int size;
    private String color;

    public Glove(int size, String color) {
        this.size = size;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Glove: " + size + " => " + color;
    }
}
