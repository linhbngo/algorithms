import java.util.Scanner;

class AppendNode {
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    Node head = new Node(in.nextLine()); // assume that there will always be an
                                        // initial String input.
    //popultating list
    Node current = head;
    while (true) {
      String s = in.nextLine();
      if (s.compareTo("END") == 0) break;
      else {
        current.next = new Node(s);
        current = current.next;
      }
    }
    current = head;
    while (current != null) {
      System.out.println(current.val);
      current = current.next;
    }
  }
}
