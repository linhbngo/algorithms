import java.util.ArrayList;
import java.util.Queue;

public class ArrayListQueue
{
  public static void main(String[] args)
  {
    Queue<Integer> q = new ArrayList<>();
    for (int i=0; i<5; i++) {
      q.add(i);
    }

    System.out.println("Elements of queue: " + q);

    // To remove the head of queue.
    int e = q.remove();
    System.out.println("removed element: " + e);
    System.out.println("Remaining elements: " + q);

    // To view the head of queue
    int head = q.peek();
    System.out.println("head of queue: " + head);
    System.out.println("Remaining elements: " + q);
  }
}
