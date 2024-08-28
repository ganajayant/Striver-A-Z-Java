package Step12.Lec1;

public class Problem4 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int num : bills) {
            if (num == 5) {
                five++;
            } else if (num == 10) {
                if (five < 1) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (ten > 0) {
                    if (five == 0) {
                        return false;
                    }
                    ten--;
                    five--;
                } else {
                    if (five < 3) {
                        return false;
                    }
                    five = five - 3;
                }
            }
        }
        return true;
    }
}
