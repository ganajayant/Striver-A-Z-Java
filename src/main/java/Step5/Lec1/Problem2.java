package Step5.Lec1;

public class Problem2 {
    public boolean rotateString(String s, String goal) {
        String result1 = s + s;
        return s.length() != goal.length() && result1.contains(goal);
    }
}
