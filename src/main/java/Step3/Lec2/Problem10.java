package Step3.Lec2;

import java.util.TreeSet;

public class Problem10 {
    public int longestConsecutive(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int integer : nums) {
            set.add(integer);
        }
        int count = 0;
        for (Integer integer : set) {
            int element = integer;
            int temp = 1;
            if (set.contains(element - 1)) {
                continue;
            }
            while (set.contains(element + 1)) {
                element++;
                temp++;
            }
            count = Math.max(temp, count);
        }
        return count;
    }
}
