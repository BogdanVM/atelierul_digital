import java.util.List;

public class GarlandDecorator extends TreeDecorator {

    public GarlandDecorator(DecorableTree originalTree) {
        super(originalTree);
        decoratedRow = 8;
        symbol = "G";
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
