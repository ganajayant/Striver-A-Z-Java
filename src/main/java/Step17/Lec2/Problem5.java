package Step17.Lec2;

class Problem5Node {
    Problem5Node[] Children;
    boolean isword;

    public Problem5Node() {
        this.Children = new Problem5Node[2];
        this.isword = false;
    }
}

public class Problem5 {
    private int findMax(Problem5Node root, int num) {
        Problem5Node current = root;
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (current.Children[bit ^ 1] != null) {
                result += (1 << i);
                current = current.Children[bit ^ 1];
            } else {
                current = current.Children[bit];
            }
        }
        return result;
    }

    public int findMaximumXOR(int[] nums) {
        Problem5Node root = new Problem5Node();
        int max = 0;
        for (int num : nums) {
            Problem5Node current = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (current.Children[bit] == null) {
                    current.Children[bit] = new Problem5Node();
                }
                current = current.Children[bit];
            }
            current.isword = true;
        }
        for (int i : nums) {
            max = Math.max(max, findMax(root, i));
        }
        return max;
    }
}
