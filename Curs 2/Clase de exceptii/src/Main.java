import SurseMyExceptions.Exception02;
import SurseMyExceptions.MyClosableResource;

public class Main {

    public static void main(String[] args) {

        try(MyClosableResource mcr = new MyClosableResource()) {

            throw new Exception02("Error when doing work");

        } catch (Exception ex) {
            System.err.println("Exception encountered: " + ex.toString());

            final Throwable[] suppresedExceptions = ex.getSuppressed();
            final int numSuppressed = suppresedExceptions.length;

            if (numSuppressed > 0) {
                System.err.println("found " + numSuppressed + " suppressed ex:");
                for (final Throwable exception : suppresedExceptions) {
                    System.err.println("suppressed: " + exception.toString());
                }

            }

        }
    }
}
