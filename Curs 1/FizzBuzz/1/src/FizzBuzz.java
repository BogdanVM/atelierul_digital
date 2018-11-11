public class FizzBuzz {

    private int numberOfElements;
    private PairFizzBuzz[] codifications;

    public FizzBuzz(int _numberOfElements) {

        numberOfElements = _numberOfElements;
        codifications = new PairFizzBuzz[0];
    }

    public void addCodification(int position, String newCodification) {

        PairFizzBuzz[] auxArray = new PairFizzBuzz[codifications.length + 1];
        System.arraycopy(codifications, 0, auxArray, 0, codifications.length);
        auxArray[auxArray.length - 1] = new PairFizzBuzz(position, newCodification);

        codifications = auxArray;
    }

    public String getCode(int position) {

        String code = "";
        for (int i = 0; i < codifications.length; ++i) {
            if (position % codifications[i].getNumber() == 0) {
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
