package Step5.Lec2;

public class Problem3 {
    public int romanToInt(String s) {
        int n = s.length();
        int x = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'M') {
                x += 1000;
            } else if (s.charAt(i) == 'D') {
                x += 500;
            } else if (s.charAt(i) == 'C') {
                x += 100;
                if (i + 1 < n && s.charAt(i + 1) == 'D') {
                    x += 300;
                    i++;
                } else if (i + 1 < n && s.charAt(i + 1) == 'M') {
                    x += 800;
                    i++;
                }
            } else if (s.charAt(i) == 'L') {
                x += 50;
            } else if (s.charAt(i) == 'X') {
                x += 10;
                if (i + 1 < n && s.charAt(i + 1) == 'L') {
                    x += 30;
                    i++;
                } else if (i + 1 < n && s.charAt(i + 1) == 'C') {
                    x += 80;
                    i++;
                }
            } else if (s.charAt(i) == 'V') {
                x += 5;
            } else if (s.charAt(i) == 'I') {
                x += 1;
                if (i + 1 < n && s.charAt(i + 1) == 'V') {
                    x += 3;
                    i++;
                } else if (i + 1 < n && s.charAt(i + 1) == 'X') {
                    x += 8;
                    i++;
                }
            }
        }
        return x;
    }
}
