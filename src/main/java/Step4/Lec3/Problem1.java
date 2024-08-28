package Step4.Lec3;

public class Problem1 {
    private int leftoccurence(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int leftoccurence = -1;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target) {
                    leftoccurence = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return leftoccurence;
    }

    int rowWithMax1s(int arr[][], int n, int m) {
        int max = Integer.MAX_VALUE, maxi = -1, i = 0;
        for (int[] is : arr) {
            int ans = leftoccurence(is, 1);
            if (ans == -1) {
                i++;
                continue;
            }
            if (ans < max) {
                maxi = i;
                max = ans;
            }
            i++;
        }
        return maxi;
    }
}
