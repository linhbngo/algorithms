import java.util.Arrays;

class ShellSort {
    /**
     * This method implements the Shell Sort algorithm based on the description in the
     * Knuth book. This sorts data elements in an ascending order. It should be
     * noted that in pseudo code, array starts from 1.
     * - Variable h represents a diminishing sequence (Knuth).
     *
     * h = H
     * while h >= 1
     *   for j = h to A.length
     *     key = A[j]
     *     i = j - h
     *     while i > 0 and A[i] > key
     *       A[i+ 1] = A[i]
     *       i = i - 1
     *     A[i + 1] = key
     *   h = next_item_in_sequence
     **/

     public int[] sort(int[] array) {
         int h = seqLog2(array.length);
         while (h >= 1) {
             for (int j = h; j < array.length; j++) {
                 int key = array[j];
                 int i = j - h;
                 while (i >= 0 && array[i] > key) {
                     array[i + h] = array[i];
                     i = i - h;
                 }
                 array[i + h] = key;
             }
             h = seqLog2(h);
         }
         return array;
     }

    public static int seqLog2(int h) {
      return (h / 2);
    }

    public static void main(String[] args) {
        int[] array = {14, 23, 5, 67, 1, 54, 121, 8};
        System.out.println(Arrays.toString(array));
        ShellSort sort = new ShellSort();
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
