import java.util.Scanner;

class BuildTree {

  public static Node TreeInsert(Node root, Node newNode) {
    Node y = null;
    Node x = root;
    while (x != null) {
      y = x;
      if (newNode.val < x.val) {
        x = x.left;
      } else x = x.right;
    }
    if (y == null) {
      root = newNode;
    } else if (newNode.val < y.val) {
      y.left = newNode;
    } else y.right = newNode;
    return root;
  }

  public static void InOrderTreeWalk(Node root) {
    if (root != null) {
      InOrderTreeWalk(root.left);
      System.out.print(root.val + " ");
      InOrderTreeWalk(root.right);
    }
  }

  public static void PreOrderTreeWalk(Node root) {
    if (root != null) {
      System.out.print(root.val + " ");
      PreOrderTreeWalk(root.left);
      PreOrderTreeWalk(root.right);
    }
  }

  public static void PostOrderTreeWalk(Node root) {
    if (root != null) {
      PostOrderTreeWalk(root.left);
      PostOrderTreeWalk(root.right);
      System.out.print(root.val + " ");
    }
  }

  public static void main(String args[]) {
    int[] array = {14, 23, 5, 67, 1, 54, 121, 8, 12};
    Node root = null;
    for (int i = 0; i < array.length; i++) {
      Node newNode = new Node(array[i], null, null);
      root = TreeInsert(root, newNode);
    }

    System.out.println("In-order-walk: ");
    InOrderTreeWalk(root);
    System.out.println("");

    System.out.println("Pre-order-walk: ");
    PreOrderTreeWalk(root);
    System.out.println("");

    System.out.println("Post-order-walk: ");
    PostOrderTreeWalk(root);
    System.out.println("");
  }

}
