package Step8.Lec1;

public class Problem3 {
    static String oddEven(int N) {
        return (N | 1) == N ? "odd" : "even";
    }
}
