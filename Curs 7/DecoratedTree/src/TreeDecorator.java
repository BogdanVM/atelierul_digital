import java.util.ArrayList;
import java.util.List;

public class TreeDecorator implements DecorableTree {

    protected DecorableTree originalTree;

    protected int decoratedRow;
    protected String symbol;

    public TreeDecorator(DecorableTree originalTree) {
        this.originalTree = originalTree;
    }

    @Override
    public List<List<String>> getTree() {
        List<List<String>> tree = this.originalTree.getTree();
        List<List<String>> decoratedTree = new ArrayList<>(tree);

        List<String> decorableRow = new ArrayList<>(decoratedTree.get(decoratedRow));

        int left = decorableRow.indexOf("<");
        int right = decorableRow.indexOf(">");

        for (int i = left + 1; i < right; ++i) {
            decorableRow.set(i, symbol);
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
