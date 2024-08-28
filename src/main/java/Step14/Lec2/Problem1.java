package Step14.Lec2;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Problem1 {
    int findCeil(Node root, int key) {
        if (root == null) {
            return -1;
        }
        if (root.data == key) {
            return root.data;
        }
        if (root.data < key) {
            return findCeil(root.right, key);
        }
        int leftCeil = findCeil(root.left, key);
        return (leftCeil >= key) ? leftCeil : root.data;
    }
}
