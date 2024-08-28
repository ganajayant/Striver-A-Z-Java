package Step6.Lec4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Problem2 {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        while (head != null) {
            if (hs.contains(target - head.data)) {
                int arr[] = new int[2];
                arr[0] = target - head.data;
                arr[1] = head.data;
                Arrays.sort(arr);
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[0]);
                list.add(arr[1]);
                result.add(list);
            }
            hs.add(head.data);
            head = head.next;
        }
        result.sort((a, b) -> a.get(0) - b.get(0));
        return result;
    }
}
