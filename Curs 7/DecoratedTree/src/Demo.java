import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        DecorableTree christmasTree = new ChristmasTree();

        DecorableTree decorableTree = new GarlandDecorator(new BulbDecorator(new CandyDecorator(christmasTree)));

        christmasTree.display();
        decorableTree.display();
    }
}