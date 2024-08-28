package Step13.Lec3;

import java.util.HashMap;

public class Problem10 {
    HashMap<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length - 1, 0);
    }

    private TreeNode buildTree(int[] postorder, int start, int end, int postStart) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postStart]);
        int inorderIndex = inorderMap.get(root.val);
        root.left = buildTree(postorder, start, inorderIndex - 1, postStart + 1);
        root.right = buildTree(postorder, inorderIndex + 1, end, postStart + inorderIndex - start + 1);
        return root;
    }
}
