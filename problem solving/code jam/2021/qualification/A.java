import java.util.*;

class Solution {

    public static int[] reverse(int a, int b, int[] c) {
        for (int i = 0; i < b - a; i++) {
            if (i + a >= b - i) {
                break;
            }
            int t = c[a + i];
            c[a + i] = c[b - i];
            c[b - i] = t;
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            long response = 0;
            int n = scanner.nextInt();
            int[] in = new int[n];
            for (int i = 0; i < n; i++) {
                in[i] = scanner.nextInt();
            }
            for (int i = 0; i < n - 1; i++) {
                int min = Integer.MAX_VALUE;
                int min_i = i;
                for (int j = i; j < n ; j++) {
                    if (min > in[j]) {
                        min = in[j];
                        min_i = j;
                    }
                }
                response += min_i - i + 1;
                in = reverse(i, min_i, in);
            }

            System.out.println("Case #" + tt + ": " + response);
        }
    }
}