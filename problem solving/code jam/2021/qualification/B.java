import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            String s = scanner.nextLine();
            int[][] dp = new int[s.length()][2];
            dp[0][0] = 0;
            dp[0][1] = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == 'C') {
                    dp[i][1] = 100*1000;
                    dp[i][0] = Math.min(dp[i - 1][1] + b, dp[i - 1][0]);
                } else if (s.charAt(i) == 'J') {
                    dp[i][0] = 100*1000;
                    dp[i][1] = Math.min(dp[i - 1][0] + a, dp[i - 1][1]);
                } else {
                    dp[i][1] = Math.min(dp[i - 1][0] + a, dp[i - 1][1]);
                    dp[i][0] = Math.min(dp[i - 1][1] + b, dp[i - 1][0]);
                }
            }
            long min = Math.min(dp[s.length() - 1][0], dp[s.length() - 1][1]);
            System.out.println("Case #" + tt + ": " + min);
        }
    }
}