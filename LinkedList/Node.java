class Node {
  String val;
  Node next;

  Node (String x, Node n) {
    val = x;
    next = n;
  }

  Node (String x) {
    val = x;
    next = null
  }
}
