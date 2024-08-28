package Step3.Lec3;

import java.util.LinkedList;
import java.util.List;

public class Problem1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        temp.add(1);
        result.add(temp);
        for (int i = 1; i < numRows; i++) {
            LinkedList<Integer> row = new LinkedList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}