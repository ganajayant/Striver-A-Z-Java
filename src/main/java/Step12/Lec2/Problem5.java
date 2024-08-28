package Step12.Lec2;

import java.util.Arrays;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class Problem5 {
    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> {
            if (b.profit == a.profit)
                return b.deadline - a.deadline;
            return b.profit - a.profit;
        });
        int count = 0, total_profit = 0;
        int max_deadline = Arrays.stream(arr).mapToInt(a -> a.deadline).max().getAsInt();
        boolean[] slots = new boolean[max_deadline];
        for (Job job : arr) {
            for (int j = Math.min(max_deadline, job.deadline) - 1; j >= 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    count++;
                    total_profit += job.profit;
                    break;
                }
            }
        }
        return new int[] { count, total_profit };
    }
}
