package Step3.Lec3;

import java.util.LinkedList;
import java.util.List;

public class Problem2 {
    public List<Integer> majorityElement(int[] nums) {
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE, count1 = 0, count2 = 0;
        for (int i : nums) {
            if (element1 == Integer.MIN_VALUE) {
                element1 = i;
                count1 = 1;
            } else if (element2 == Integer.MIN_VALUE && element1 != i) {
                element2 = i;
                count2 = 1;
            } else if (element1 == i) {
                count1++;
            } else if (element2 == i) {
                count2++;
            } else if (count1 == 0) {
                element1 = i;
                count1 = 1;
            } else if (count2 == 0) {
                element2 = i;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (i == element1) {
                count1++;
            }
            if (i == element2) {
                count2++;
            }
        }
        int n = nums.length;
        LinkedList<Integer> result = new LinkedList<>();
        if (count1 > n / 3) {
            result.add(element1);
        }
        if (count2 > n / 3) {
            result.add(element2);
        }
        return result;
    }
}