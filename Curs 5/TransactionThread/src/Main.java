public class Main {

    static class Transaction extends Thread {
        BankAccount from, to;
        String name;
        int amount;

        public Transaction(String name, BankAccount from, BankAccount to, int amount) {

            this.name = name;
            this.from = from;
            this.to = to;
            this.amount = amount;
        }

        @Override
        public void run() {
            try {
                BankAccount.transfer(from, to, amount);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class BankAccount {
        int debit;
        String name;

        public BankAccount(String name, int debit) {
            this.debit = debit;
            this.name = name;
        }

        static void transfer(BankAccount from, BankAccount to, int amount) throws Exception{
            if (from.debit < amount) {
                throw new Exception("Amount too large for current debit");
            }

            from.withdraw(amount);
            to.deposit(amount);
        }

        void withdraw(double amount) throws Exception{

            if (debit < amount) {
                throw new Exception("Amount too large for current debit");
            }

            longDatabaseCall();
            debit -= amount;
        }

        void deposit(double amount) {

            longDatabaseCall();
            debit += amount;
        }

        void longDatabaseCall() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "The account " + name +
                    " has the debit = " + debit;
        }
    }

    public static void main(String[] args) throws Exception {
        final BankAccount momAccount = new BankAccount("mom", 100_000);
        final BankAccount myAccount = new BankAccount("me", 100);

        Transaction t1 = new Transaction("T1", momAccount, myAccount, 10);
        Transaction t2 = new Transaction("T2", momAccount, myAccount, 100);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(momAccount);
        System.out.println(myAccount);
    }
}
