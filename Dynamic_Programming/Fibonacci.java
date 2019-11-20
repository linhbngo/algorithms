import java.util.HashMap;
import java.util.Map;

class Fibonacci {
  public static Map<Integer,Long> memo;

  public static int recursiveFib(int k) {
    if (k <= 2) {
      return 1;
    } else return recursiveFib(k - 1) + recursiveFib(k - 2);
  }

  public static long dpFibTopDown(int k, Map<Integer,Long> memo) {
    long f;
    if (memo.containsKey(k)) {
       return memo.get(k);
    } else if (k <= 2) {
      f = 1;
    } else {
      f = dpFibTopDown(k - 1, memo) + dpFibTopDown(k - 2, memo);
    }
    memo.put(k, f);
    return f;
  }

  public static long dpFibBottomUp(int k) {
    long[] fib = new long[k];
    for (int i = 0; i < k; i++) {
        if (i <= 1) {
          fib[i] = 1;
        } else {
          fib[i] = fib[i - 1] + fib[i - 2];
        }
    }
    return fib[k - 1];
  }

  public static void main(String args[]) {
    int k = Integer.parseInt(args[0]);
    long startTime, endTime, duration;

    if (k < 55) {
      startTime = System.currentTimeMillis();
      System.out.println(recursiveFib(k));
      endTime = System.currentTimeMillis();
      duration = (endTime - startTime);
      System.out.println("Run time of recursive Fib is " + duration + " ms");
    } else {
      System.out.println("Value too large to run with traditional recursive Fib");
    }
    startTime = System.currentTimeMillis();
    memo = new HashMap<Integer,Long>();
    System.out.println(dpFibTopDown(k, memo));
    endTime = System.currentTimeMillis();
    duration = (endTime - startTime);
    System.out.println("Run time of top down DP Fib is " + duration + " ms");

    startTime = System.currentTimeMillis();
    System.out.println(dpFibBottomUp(k));
    endTime = System.currentTimeMillis();
    duration = (endTime - startTime);
    System.out.println("Run time of bottom up DP Fib is " + duration + " ms");


  }
}
