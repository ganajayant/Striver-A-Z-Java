package Step3.Lec1;

import java.util.ArrayList;
import java.util.TreeSet;

public class Problem9 {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        TreeSet<Integer> hs = new TreeSet<>();
        for (int integer : arr1) {
            hs.add(integer);
        }
        for (int integer : arr2) {
            hs.add(integer);
        }
        return new ArrayList<>(hs);
    }
}
