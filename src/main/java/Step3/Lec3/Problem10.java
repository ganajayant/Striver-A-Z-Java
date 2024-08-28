package Step3.Lec3;

public class Problem10 {
    private static long Merge(long[] nums, long left, long mid, long right) {
        long count = 0;
        long n1 = mid - left + 1;
        long n2 = right - mid;
        long L[] = new long[(int) n1];
        long R[] = new long[(int) n2];

        for (long i = 0; i < n1; ++i) {
            L[(int) i] = nums[(int) (left + i)];
        }
        for (long j = 0; j < n2; ++j) {
            R[(int) j] = nums[(int) (mid + 1 + j)];
        }
        long i = 0, j = 0;
        long k = left;
        while (i < n1 && j < n2) {
            if (L[(int) i] <= R[(int) j]) {
                nums[(int) k] = L[(int) i];
                i++;
            } else {
                count += (mid - i + 1);
                nums[(int) k] = R[(int) j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[(int) k] = L[(int) i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[(int) k] = R[(int) j];
            j++;
            k++;
        }
        return count;
    }

    private static long MergeSort(long[] nums, long left, long right) {
        long count = 0;
        if (left < right) {
            long mid = left + (right - left) / 2;
            count += MergeSort(nums, left, mid);
            count += MergeSort(nums, mid + 1, right);
            count += Merge(nums, left, mid, right);
        }
        return count;
    }

    static long inversionCount(long[] nums, long N) {
        long count = MergeSort(nums, 0, N - 1);
        return count;
    }
}
