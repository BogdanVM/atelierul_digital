package Classes;

public class Sock {

    private int size;
    private String color;

    public Sock(int size, String color) {
        this.size = size;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sock: " + size + " => " + color;
    }
}
