import java.io.*;
import java.time.Duration;
import java.time.Instant;

public class Main {

    public static void copyBufferFile() throws IOException {
        Instant start = Instant.now();

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader( new FileReader("myBuffer1.txt"));
            bufferedWriter = new BufferedWriter( new FileWriter("myBuffer2.txt"));

            int c;
            while ((c = bufferedReader.read()) != -1) {
                bufferedWriter.write(c);
            }

        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }

            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }

        Instant stop = Instant.now();
        Duration duration = Duration.between(start, stop);

        System.out.println("Durata buffer: " + duration);
    }
    public static void copyFile() throws IOException {

        Instant start = Instant.now();

        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader("my1.txt");
            fileWriter = new FileWriter("my2.txt");

            int c;
            while((c = fileReader.read()) != -1) {
                fileWriter.write(c);
            }


        } finally {
            if (fileReader != null) {
                fileReader.close();
            }

            if (fileWriter != null) {
                fileWriter.close();
            }
        }

        Instant stop = Instant.now();
        Duration duration = Duration.between(start, stop);

        System.out.println("Durata fara buffer: " + duration);
    }

    public static void main(String[] args) {
        try {
            copyFile();
            copyBufferFile();
        } catch (IOException e) {
            System.err.println("Fisierul nu s-a inchis corect");
        }
    }
}
