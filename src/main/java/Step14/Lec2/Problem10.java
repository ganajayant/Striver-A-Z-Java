package Step14.Lec2;

import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> stacky;
    TreeNode node;

    public BSTIterator(TreeNode root) {
        stacky = new Stack<TreeNode>();
        this.node = root;
        update(node);
    }

    public int next() {
        TreeNode x = stacky.pop();
        update(x.right);
        return x.val;
    }

    public boolean hasNext() {
        return !stacky.isEmpty();
    }

    public void update(TreeNode node) {
        while (node != null) {
            stacky.add(node);
            node = node.left;
        }
    }
}

public class Problem10 {

}
