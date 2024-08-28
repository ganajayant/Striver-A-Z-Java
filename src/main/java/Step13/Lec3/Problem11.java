package Step13.Lec3;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Codec {
    // Serializes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                str.append("N#");
                continue;
            }
            str.append(node.val + "#");
            q.add(node.left);
            q.add(node.right);
        }
        return str.toString();
    }

    // Deserializes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] tokens = data.split("#");
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int index = 1;
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (index < tokens.length && !tokens[index].equals("N")) {
                temp.left = new TreeNode(Integer.parseInt(tokens[index]));
                q.add(temp.left);
            }
            index++;
            if (index < tokens.length && !tokens[index].equals("N")) {
                temp.right = new TreeNode(Integer.parseInt(tokens[index]));
                q.add(temp.right);
            }
            index++;
        }
        return root;
    }
}

public class Problem11 {

}
