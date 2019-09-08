import java.util.Arrays;
import java.lang.Math;

class MergeSort {
    /**
     * This method implements the Merge Sort algorithm as desribed in the
     * CLRS book. This sorts data elements in an ascending order. It should be
     * noted that in pseudo code, array starts from 1.
     **/

    /** MERGE-SORT(A, p, r)
     * if p < r
     *   q = floor((p + r)/2)
     *   MERGE-SORT(A, p, q)
     *   MERGE-SORT(A, q + 1, r)
     *   MERGE(A, p, q, r)
     *
     **/

    void mergeSort(int[] A, int p, int r) {
      if (p < r) {
        int q = (int) Math.floor((p + r) / 2);
        mergeSort(A, p, q);
        mergeSort(A, q + 1, r);
        merge(A, p, q, r);
      }
    }

    /** MERGE(A, p, q, r)
     * n1 = q - p + 1
     * n2 = r - q
     * let L[1..(n1+1)] and R[1..(n2+1)] be new arrays
     * for i = 1 to n1
     *   L[i] = A[p + i - 1]
     * for j = 1 to n2
     *   R[j] = A[q + j]
     * L[n1 + 1] = max_infinite
     * R[n2 + 1] = max_infinite
     * i = 1
     * j = 1
     * for k = p to r
     *   if L[i] <= R[j]
     *     A[k] = L[i]
     *     i = i + 1
     *   else
     *     A[k] = R[j]
     *     j = j + 1
     *
     **/
    void merge(int[] A, int p, int q, int r) {
      int n1 = q - p + 1;
      int n2 = r - q;
      int L[] = new int[n1];
      int R[] = new int[n2];
      int i, j, k;
      for (i = 0; i < n1; i++) {
        L[i] = A[p + i];
      }

      for (j = 0; j < n2; j++) {
        R[j] = A[q + j];
      }
      i = 0;
      j = 0;
      for (k = p; k < r; k++) {
        if (i >= n1) {
          A[k] = R[j];
          j += 1;
        }
        else if (j >= n2) {
          A[k] = L[i];
          i += 1;
        }
        else if (L[i] <= R[j]) {
          A[k] = L[i];
          i += 1;
        } else {
          A[k] = R[j];
          j += 1;
        }
      }
    }


    public static void main(String[] args) {
        int[] array = {14, 23, 5, 67, 1, 54, 121, 8};
        System.out.println(Arrays.toString(array));
        MergeSort sort = new MergeSort();
        sort.mergeSort(array, 0, array.length);
        System.out.println(Arrays.toString(array));
    }
}
