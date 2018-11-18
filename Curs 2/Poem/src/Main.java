import Classes.Poem;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Poem poem = new Poem();
        try {
            poem.readPoem("poem.txt");
            poem.displayCommonWords();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
