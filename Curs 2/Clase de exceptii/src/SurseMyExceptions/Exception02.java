package SurseMyExceptions;

public class Exception02 extends RuntimeException {

    private String myMessage;

    public Exception02(String message) {
        myMessage = message;
    }
}
