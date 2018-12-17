public class Demo {

    public static void main(String[] args) {

    }

    class ProxyEstateAgent {
        private Garsoniera garsoniera;

        public ProxyEstateAgent(Garsoniera garsoniera) {
            this.garsoniera = garsoniera;
        }

        public void inchiriezCuiVreauEu(int suma, String nume) {
            garsoniera.inchiriaza(suma);
        }
    }
    
    interface Garsoniera {
        void inchiriaza(int suma);
    }

    class GarsonieraInCentru implements Garsoniera {

        @Override
        public void inchiriaza(int suma) {

            if (suma < 2_000) {
                throw new RuntimeException("No money, sir");
            }

            else {
                // OK
            }
        }
    }
}
