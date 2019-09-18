import java.util.Arrays;

class QuickSort {

  public static void QuickSort(int[] A, int p, int r) {
    if (p < r) {
      int q = Partition(A, p, r);
      QuickSort(A, p, q - 1);
      QuickSort(A, q + 1, r);
    }
  }

  public static int Partition(int[] A, int p, int r) {
    int x = A[r];
    int i = p - 1;
    for (int j = p; j <= r - 1; j ++) {
      if (A[j] <= x) {
        i = i + 1;
        int tmp = A[j];
        A[j] = A[i];
        A[i] = tmp;
      }
    }
    int tmp = A[i + 1];
    A[i + 1] = A[r];
    A[r] = tmp;
    return (i + 1);
  }


  public static void main(String[] args) {
    int[] A = {14, 25, 6, 18, 23, 5, 7, 10};
    System.out.println(Arrays.toString(A));
    QuickSort(A, 0, A.length - 1);
    System.out.println(Arrays.toString(A));
  }
}
