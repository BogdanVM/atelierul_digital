import java.util.List;

public class BulbDecorator extends TreeDecorator {

    public BulbDecorator(DecorableTree originalTree) {
        super(originalTree);
        decoratedRow = 6;
        symbol = "B";
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
