import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        DecorableTree christmasTree = new ChristmasTree();
        //DecorableTree decoratedTree = new Garland(new Bulb(new Candy(christmasTree)));

        DecorableTree decorableTree = new CandyDecoratedTree(christmasTree);
        //decoratedTree.display();
        christmasTree.display();
        decorableTree.display();
    }
}
interface DecorableTree {
    List<List<String>> getTree();
    void display();
}

class ChristmasTree implements DecorableTree {
    private List<List<String>> tree;
    private int size;
    public ChristmasTree() { this.size = 10; this.tree = getTree(); }

    public List<List<String>> getTree() {
        List<List<String>> tree = new ArrayList<>();
        List<String> row;

        for (int i = 0; i < size; i++) {
            row = new ArrayList<>();

            for (int j = 0; j < size * 2; j++) {
                if (j == (size - i)) row.add("<");
                if (j == (size + i)) row.add(">");
                row.add(" ");
            }

            tree.add(Collections.unmodifiableList(row));
        }

        for (int i = 0; i < 3; i++) {
            row = new ArrayList<>();

            for (int j = 0; j < size * 2; j++) {
                if (j == size - 2) row.add("|");
                if (j == size + 2) row.add("|");

                row.add(" ");
            }

            tree.add(Collections.unmodifiableList(row));
        }

        return Collections.unmodifiableList(tree);
    }
    public void display() {

        for (int i = 0; i < tree.size(); i++) {
            for (int j = 0; j < tree.get(i).size(); j++) {
                System.out.print(tree.get(i).get(j));
            }

            System.out.println();
        }
    }
}

class CandyDecoratedTree implements DecorableTree {

    private DecorableTree originalTree;
    private int decoratedRow = 3;

    public CandyDecoratedTree(DecorableTree originalTree) {
        this.originalTree = originalTree;
    }

    @Override
    public List<List<String>> getTree() {

        List<List<String>> tree = originalTree.getTree();
        List<List<String>> decoratedTree = new ArrayList<>(tree);

        List<String> decorableRow = new ArrayList<>(decoratedTree.get(decoratedRow));

        int left = decorableRow.indexOf("<");
        int right = decorableRow.indexOf(">");

        for (int i = left + 1; i < right; ++i) {
            decorableRow.set(i, "C");
        }

        decoratedTree.set(decoratedRow, decorableRow);
        return decoratedTree;
    }

    @Override
    public void display() {

        List<List<String>> tree = getTree();

        for (List<String> row : tree) {

            for (String cell : row) {
                System.out.print(cell);
            }

            System.out.println();
        }
    }
}