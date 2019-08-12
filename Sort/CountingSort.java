import java.util.Arrays;

class CountingSort {
    /**
     * This method implements the Counting Sort algorithm as desribed in the
     * Knuth book. This sorts data elements in an ascending order. It should be
     * noted that in pseudo code, array starts from 1.
     *
     * for i = 1 to A.length
     *   COUNT[i] = 0
     *
     * for j = A.length to 2
     *   for i = j - 1 to 1
     *     if (A[i] < A[j])
     *       COUNT[j] = COUNT[j] + 1
     *     else
     *       COUNT[i] = COUNT[i] + 1
     *
     **/

    public int[] sort(int[] array) {
        int[] COUNT = new int[array.length];

        for (int i = 0; i < COUNT.length; i++) {
          COUNT[i] = 0;
        }
        for (int j = array.length - 1; j > 0; j--) {
            for (int i = j - 1; i >= 0; i--) {
              if (array[i] < array[j]) {
                COUNT[j]++;
              } else {
                COUNT[i]++;
              }
            }
        }
        return COUNT;
    }

    public static void main(String[] args) {
        int[] unsorted = {14, 23, 5, 67, 1, 54, 121, 8, 12};
        CountingSort sort = new CountingSort();
        int[] sortedIndex = sort.sort(unsorted);
        System.out.println(Arrays.toString(unsorted));
        System.out.println(Arrays.toString(sortedIndex));
    }
}
