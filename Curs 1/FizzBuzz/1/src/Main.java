public class Main {

    public static void main(String[] args) {

        FizzBuzz fizzBuzz = new FizzBuzz(40);
        fizzBuzz.addCodification(3, "fizz");
        fizzBuzz.addCodification(5, "buzz");
        fizzBuzz.addCodification(7, "foo");
        fizzBuzz.addCodification(11, "bar");

        fizzBuzz.displaySequence();
    }
}
