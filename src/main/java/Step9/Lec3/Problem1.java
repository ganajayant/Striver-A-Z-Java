package Step9.Lec3;

import java.util.Stack;
import java.util.TreeMap;

public class Problem1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stacky = new Stack<Integer>();
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i : nums2) {
            while (!stacky.isEmpty() && i > stacky.peek()) {
                map.put(stacky.pop(), i);
            }
            stacky.add(i);
        }
        int i = 0;
        for (int integer : nums1) {
            nums1[i++] = map.getOrDefault(integer, -1);
        }
        return nums1;
    }
}