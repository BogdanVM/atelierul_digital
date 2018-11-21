import Classes.ArrayIterator;
import Classes.Glove;
import Classes.Sock;
import Interfaces.IArrayIterator;

public class Main {

    public static void main(String[] args) {

        Sock[] socks = new Sock[10];
        Glove[] gloves = new Glove[10];

        for (int i = 0; i < 10; i++) {
            socks[i] = new Sock(i + 1, "blue");
            gloves[i] = new Glove(i + 1, "maroon");
        }

        IArrayIterator socksIterator = new ArrayIterator<>(socks);
        while (socksIterator.hasNext()) {
            System.out.println(socksIterator.next());
        }

        IArrayIterator glovesIterator = new ArrayIterator<>(gloves);
        while (glovesIterator.hasNext()) {
            System.out.println(glovesIterator.next());
        }
    }
}
