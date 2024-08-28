package Step14.Lec2;

import java.util.LinkedList;

public class Problem8 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : preorder) {
            list.add(i);
        }
        return bstFromPreorder(list);
    }

    private TreeNode bstFromPreorder(LinkedList<Integer> list) {
        if (list.size() == 0) {
            return null;
        }
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(0)) {
                left.add(list.get(i));
            } else {
                right.add(list.get(i));
            }
        }
        TreeNode root = new TreeNode(list.get(0));
        root.left = bstFromPreorder(left);
        root.right = bstFromPreorder(right);
        return root;
    }
}
