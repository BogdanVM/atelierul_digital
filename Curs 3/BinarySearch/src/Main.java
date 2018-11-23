import Exceptions.ListNotSortedException;

public class Main {

    public static <T extends Comparable> boolean binarySearch(T[] list, T value)
            throws ListNotSortedException {

        boolean ascending = true;
        try {

            for (int i = 1; i < list.length - 1; i++) {
                if (list[i].compareTo(list[i - 1]) != list[i + 1].compareTo(list[i]))
                    throw new ListNotSortedException("The array is not sorted");
            }
        } finally {

            /* after iterating through the list we check if the array is ascending or not */
            if (list[1].compareTo(list[0]) < 0)
                ascending = false;
        }

        int left = 0;
        int right = list.length - 1;

        while (left <= right) {

            int middle = (left + right) / 2;
            if (value.compareTo(list[middle]) > 0) {

                if (ascending) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }

            } else if (value.compareTo(list[middle]) < 0) {

                if (ascending) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }

            } else {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        Integer[] list01 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] list02 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        try {

            System.out.println(binarySearch(list01, -30) == false);
            System.out.println(binarySearch(list02, -30) == false);
            System.out.println(binarySearch(list01, 30) == false);
            System.out.println(binarySearch(list02, 30) == false);

            for (int i = 1; i <= 10; ++i) {
                System.out.println(binarySearch(list01, i) == true);
                System.out.println(binarySearch(list02, i) == true);
            }

        } catch (ListNotSortedException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
