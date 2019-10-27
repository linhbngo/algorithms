import java.util.Scanner;
class RemovePortion {
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    Node head = new Node(in.nextLine());
    Node current = head;
    while (true) {
      String s = in.nextLine();
      if (s.compareTo("END") == 0) break;
      else {
        current.next = new Node(s);
        current = current.next;
      }
    }
    //removing the first two nodes from the list:
    current = head;
    int count = 0;
    Node tmpHead = null;
    while (current != null && current.next != null && count < 2) {
      tmpHead = current.next;
      current.next = null;
      current = tmpHead;
      count++;
    }
    head = tmpHead;
    current = head;
    while (current != null) {
      System.out.println(current.val);
      current = current.next;
    }
  }
}
