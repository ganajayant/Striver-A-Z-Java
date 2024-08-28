package Step14.Lec1;

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

public class Problem3 {
    int minValue(Node root) {
        if (root == null) {
            return -1;
        } else if (root.left == null) {
            return root.data;
        }
        return minValue(root.left);
    }

}
