import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        int n = 0;
        while (n == 0) {
            System.out.print("n = ");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String input = bufferedReader.readLine();

            try {
                n = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.err.println("Invalid Format");
            }
        }

        
        List<List<Integer>> pascal = new ArrayList<>();

        for (int i = 0; i < n; ++i) {

            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);

            for (int j = 1; j < i + 1; ++j) {
                if (j == i) {
                    currentRow.add(1);
                    continue;
                }

                int x = pascal.get(i - 1).get(j - 1);
                int y = pascal.get(i - 1).get(j);

                currentRow.add(x + y);
            }

            pascal.add(currentRow);
        }

        for (int i = 0; i < n; ++i) {

            for (int j = 1; j <= n - i - 1; ++j) {
                System.out.print(" ");
            }

            for (int j = 0; j < pascal.get(i).size(); ++j) {
                System.out.print(pascal.get(i).get(j) + " ");
            }

            System.out.println();
        }
    }
}
