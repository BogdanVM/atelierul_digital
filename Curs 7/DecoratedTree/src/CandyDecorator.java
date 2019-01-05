import java.util.ArrayList;
import java.util.List;

public class CandyDecorator extends TreeDecorator{

    public CandyDecorator(DecorableTree originalTree) {
        super(originalTree);
        decoratedRow = 3;
        symbol = "C";
    }

    @Override
    public List<List<String>> getTree() {
        return super.getTree();
    }

    @Override
    public void display() {
        super.display();
    }
}
