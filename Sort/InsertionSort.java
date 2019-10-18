import java.util.Arrays;

class InsertionSort {
    /**
     * This method implements the Insertion Sort algorithm as desribed in the
     * CLRS book. This sorts data elements in an ascending order. It should be
     * noted that in pseudo code, array starts from 1.
     *
     * for j = 2 to A.length
     *   key = A[j]
     *   i = j - 1
     *   while i > 0 and A[i] > key
     *     A[i+ 1] = A[i]
     *     i = i - 1
     *   A[i + 1] = key
     *
     **/

    public int[] sort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = { 503, 87, 512, 61, 170 };
        System.out.println(Arrays.toString(array));
        InsertionSort sort = new InsertionSort();
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
