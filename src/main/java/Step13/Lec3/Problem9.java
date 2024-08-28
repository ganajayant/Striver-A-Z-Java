package Step13.Lec3;

import java.util.HashMap;

public class Problem9 {
    HashMap<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0);
    }

    private TreeNode buildTree(int[] preorder, int start, int end, int preStart) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inorderIndex = inorderMap.get(root.val);
        root.left = buildTree(preorder, start, inorderIndex - 1, preStart + 1);
        root.right = buildTree(preorder, inorderIndex + 1, end, preStart + inorderIndex - start + 1);
        return root;
    }
}
