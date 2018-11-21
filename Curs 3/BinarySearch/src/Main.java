import Exceptions.ListNotSortedException;

public class Main {

    public static <T extends Comparable> boolean binarySearch(T[] list, T value)
            throws ListNotSortedException {

        try {

            for (int i = 1; i < list.length - 1; i++)
                if (list[i].compareTo(list[i - 1]) != list[i + 1].compareTo(list[i]))
                    throw ListNotSortedException;
        }
        int left = 0;
        int right = list.length - 1;

        while (left <= right) {

            int middle = (left + right) / 2;
            if (value.compareTo(list[middle]) > 0) {

            }
        }
    }
    public static void main(String[] args) {
        Integer[] list01 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] list02 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    }
}
