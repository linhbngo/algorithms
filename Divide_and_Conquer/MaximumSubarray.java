import java.util.Arrays;
import java.lang.Math;
import java.util.Random;

class MaxSum {
  public int left;
  public int right;
  public int sum;

  MaxSum(int left, int right, int sum) {
    this.left = left;
    this.right = right;
    this.sum = sum;
  }
}

class MaximumSubarray {
  /**
   * This method implements the divide and conquer approach to solve
   * the maximum subarray problem as described in the CLRS book.
   **/

  /** find_max_crossing_subarray (A, low, mid, high)
   * left-sum = -max_inf
   * sum = 0
   * for i = mid downto low
   *   sum = sum + A[i]
   *   if sum > left-sum
   *     left-sum = sum
   *     max-left = i
   *
   * right-sum = -max_inf
   * sum = 0
   * for j = mid + 1 to high
   *   sum = sum + A[j]
   *   if sum > right-sum
   *     right-sum = sum
   *     max-right = j
   * return (max-left; max-right; left-sum + right-sum)
   **/
  public static MaxSum findMaxCrossingSubarray(int[] A, int low, int mid, int high) {
    int max_left = low;
    int max_right = high;

    int left_sum = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = mid; i >= low; i--) {
      sum = sum + A[i];
      if (sum > left_sum) {
        left_sum = sum;
        max_left = i;
      }
    }

    int right_sum = Integer.MIN_VALUE;
    sum = 0;
    for (int j = mid + 1; j <= high; j++) {
      sum = sum + A[j];
      if (sum > right_sum) {
        right_sum = sum;
        max_right = j;
      }
    }

    return new MaxSum(max_left, max_right, left_sum + right_sum);
  }

  /** find_maximum_subarray (A, low, high)
   * if high == low
   *   return (low, high, A[low]) //base case
   * else
   *   mid = floor((low + high)/2)
   *   (left-low, left-high, left-sum) = find_maximum_subarray(A, low, mid)
   *   (right-low, right-high, right-sum) = find_maximum_subarray(A, mid + 1, *                                                                  high)
   *   (cross-low, cross-high, cross-sum) = find_maximum_crossing_subarray(A,
   *                                                          low, mid, high)
   *
   *   if left-sum >= right-sum and left-sum >= cross-sum
   *     return (left-low, left-high, left-sum)
   *   else if right-sum >= left-sum and right-sum >= cross-sum
   *     return (right-low, right-high, right-sum)
   *   else
   *     return (cross-low, cross-high, cross-sum)
   **/
  public static MaxSum findMaxSubarray(int[] A, int low, int high) {
    if (high == low) {
      return new MaxSum(low, high, A[low]);
    } else {
      int mid = (low + high) / 2;
      MaxSum leftSum = findMaxSubarray(A, low, mid);
      MaxSum rightSum = findMaxSubarray(A, mid + 1, high);
      MaxSum crossSum = findMaxCrossingSubarray(A, low, mid, high);

      if (leftSum.sum >= rightSum.sum && leftSum.sum >= crossSum.sum) {
        return leftSum;
      } else if (rightSum.sum >= leftSum.sum && rightSum.sum >= crossSum.sum) {
        return rightSum;
      } else return crossSum;
    }
  }


  /**
   * This method randomly generates an array of integers between -10 and 10
   **/
  public static int[] randomInt(int size) {
    Random random = new Random();
    int[] results = new int[size];
    for (int i = 0; i < size; i++){
      results[i] = random.nextInt() % 10;
    }
    return results;
  }

  public static void main(String[] args) {
    int[] A = randomInt(10);
    System.out.println(Arrays.toString(A));
    MaxSum result = findMaxSubarray(A, 0, A.length - 1);
    System.out.println(result.left + " " + result.right + " " + result.sum);
  }
}
