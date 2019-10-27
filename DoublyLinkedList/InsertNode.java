import java.util.Scanner;
class InsertNode {
  public static void main(String args[]) {
    String[] words = {"alpha", "beta", "charlie", "delta"};
    Node head = new Node(words[0]);
    Node current = head;
    for (int i = 1; i < words.length; i++) {
      current.next = new Node(words[i]);
      current.next.prev = current;
      current = current.next;
    }
    current = head;
    int count = 0;
    while (current != null) {
      count ++;
      if (count == 2) {
        Node tmp = new Node("HERE");
        tmp.next = current.next;
        current.next.prev = tmp;
        tmp.prev = current;
        current.next = tmp;
        break;
      } else current = current.next;
    }
    current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    System.out.println("");
  }
}
