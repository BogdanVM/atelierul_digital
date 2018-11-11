public class FizzBuzz {

    private int numberOfElements;
    private PairFizzBuzz[] codifications;

    public FizzBuzz(int _numberOfElements) {

        numberOfElements = _numberOfElements;
        codifications = new PairFizzBuzz[0]; // at first there is no codification
    }

    public void addCodification(int position, String newCodification) {

        // create an auxiliar array where we add the new pair
        PairFizzBuzz[] auxArray = new PairFizzBuzz[codifications.length + 1];
        System.arraycopy(codifications, 0, auxArray, 0, codifications.length);
        auxArray[auxArray.length - 1] = new PairFizzBuzz(position, newCodification);

        // we save the changes in the codifications array
        codifications = auxArray;
    }

    public String getCode(int position) {

        String code = ""; // at first there is no codification at the current position
        for (int i = 0; i < codifications.length; ++i) {
            if (position % codifications[i].getNumber() == 0) {
                
                // if the position is divisible to the codified number, we add its codification to the final code
                code = code + codifications[i].getCode();
            }
        }

        return code;
    }

    public void displaySequence() {
        for (int i = 1; i <= numberOfElements; ++i) {

            String code = getCode(i);
            if (code.equals("")) {
                System.out.print(i + " ");
            }

            else {
                System.out.print(code + " ");
            }
        }
    }
}
