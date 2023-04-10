/* Modified based on https://www.geeksforgeeks.org/avl-tree-set-1-insertion/ */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class Node {
  int key, height;
  Node left, right;
  Node(int x) {
    key = x;
    height = 1;
  }
}

class AVLTree {
	Node root;

	int height(Node N) {
		if (N == null)
			return 0;
		return N.height;
	}

	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;
		// Perform rotation
		x.right = y;
		y.left = T2;
		// Update heights
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;
		// Return new root
		return x;
	}

	Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;
		// Perform rotation
		y.left = x;
		x.right = T2;
		// Update heights
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;
		// Return new root
		return y;
	}

	// Get Balance factor of node N
	int getBalance(Node N) {
		if (N == null)
			return 0;
		return height(N.left) - height(N.right);
	}

  Node insert(Node node, int key) {
    /* 1. Perform normal BST insertion) */
    if (node == null)
      return (new Node(key));
    if (key < node.key)
      node.left = insert(node.left, key);
    else if (key > node.key)
      node.right = insert(node.right, key);
    else // Duplicate keys not allowed
      return node;
    /* 2. Update height of this ancestor node */
    node.height = 1 + max(height(node.left), height(node.right));
    /* 3. Get the balance factor of this ancestor node to check whether 
    this node became unbalanced. If this node becomes unbalanced, then 
    there are 4 cases */
    int balance = getBalance(node); 
    if (balance > 1 && key < node.left.key) /* LL */
      return rightRotate(node);
    if (balance > 1 && key > node.left.key) { /* LR */
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }
    if (balance < -1 && key > node.right.key) /* RR */
      return leftRotate(node);
    if (balance < -1 && key < node.right.key) { /* RL */
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }
    return node; /* return the (unchanged) node pointer */
  }

  static void print2DUtil(Node root, int space, int COUNT) {
    // Base case
    if (root == null)
        return;
    // Increase distance between levels
    space += COUNT;
    // Process right child first
    print2DUtil(root.right, space, COUNT);
    // Print current node after space
    // count
    System.out.print("\n");
    for (int i = COUNT; i < space; i++)
        System.out.print(" ");
    System.out.print(root.key + "\n");
    // Process left child
    print2DUtil(root.left, space, COUNT);
  }

  public static void main(String[] args) {
		AVLTree tree = new AVLTree();
    try {
      Scanner scanner = new Scanner(new File(args[0]));
      int [] array = new int [scanner.nextInt()];
      int i = 0;
      while(scanner.hasNextInt()) {
        array[i++] = scanner.nextInt();
      }

      for (i = 0; i < array.length; i++) {
        tree.root = tree.insert(tree.root, array[i]);
      }
      System.out.println("Current tree: ");
      print2DUtil(tree.root, 0, array.length);
		  System.out.println("After insert " + Integer.parseInt(args[1]) + " :");
		  tree.root = tree.insert(tree.root, Integer.parseInt(args[1]));
      print2DUtil(tree.root, 0, array.length + 1);
    } catch (IOException e) {
      e.printStackTrace();
    }
	}
}
