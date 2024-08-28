package Step3.Lec2;

public class Problem6 {
    public int maxProfit(int[] prices) {
        int lowest = prices[0];
        int maxScore = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            }
            if (prices[i] > lowest) {
                maxScore = Math.max(maxScore, prices[i] - lowest);
            }
        }
        return maxScore;
    }
}
