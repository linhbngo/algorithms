import java.util.Scanner;
class RemoveOneNode {
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
    //removing the third node from the list:
    current = head;
    int count = 0;
    while (current != null) {
      if (count == 1 && current.next != null) {
        Node tmp = current.next.next;
        current.next.next = null;
        current.next = tmp;
        break;
      } else {
        current = current.next;
        count++;
      }
    }
    current = head;
    while (current != null) {
      System.out.println(current.val);
      current = current.next;
    }
  }
}
