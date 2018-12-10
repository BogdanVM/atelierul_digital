import java.util.ArrayList;
import java.util.List;

public class Main {

    static class Chopstick {

        private int i;

        public Chopstick(int i) {
            this.i = i;
        }
    }

    static class Philosopher extends Thread {

        private String name;
        private int i;
        private Chopstick left, right;

        public Philosopher(int i, Chopstick left, Chopstick right) {
            this.name = "P" + i;
            this.left = left;
            this.right = right;
        }

        @Override
        public void run() {
            while (true) {
                eat();
                think();
            }
        }

        private void think() {
            System.out.println(name + " is thinking");
        }

        private void eat() {
            synchronized (left) {
                synchronized (right) {
                    System.out.println(name + " is eating");
                }
            }
        }
    }
    public static void main(String[] args) {
        int nrOfPhilosophers = 11;
        List<Chopstick> chopsticks = new ArrayList<>();
        List<Philosopher> philosophers = new ArrayList<>();

        for (int i = 0; i < nrOfPhilosophers; ++i) {
            chopsticks.add(new Chopstick(i));
        }

        for (int i = 0; i < nrOfPhilosophers; ++i) {
            Chopstick left = chopsticks.get(i);
            Chopstick right = chopsticks.get((i + 1) % nrOfPhilosophers);

            philosophers.add(new Philosopher(i, left, right));
        }

        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }

    }
}
