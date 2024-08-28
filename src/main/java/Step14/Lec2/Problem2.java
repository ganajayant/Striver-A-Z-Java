package Step14.Lec2;

public class Problem2 {
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

    public static int floor(Node root, int x) {
        if (root == null) {
            return -1;
        }
        if (root.data == x) {
            return root.data;
        }
        if (root.data > x) {
            return floor(root.left, x);
        }
        int rightfloor = floor(root.right, x);
        return (rightfloor <= x && rightfloor != -1) ? rightfloor : root.data;
    }
}
