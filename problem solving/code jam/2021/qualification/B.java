import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int tt = 1; tt <= t; tt++) {
            String s = scanner.nextLine();
            String[] sliced = s.split(" ");
            int a = Integer.parseInt(sliced[0]);
            int b = Integer.parseInt(sliced[1]);
            s = sliced[2];
            long[][] dp = new long[s.length()][2];
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'C') {
                    dp[i][1] = Integer.MAX_VALUE;
                    dp[i][0] = i == 0 ? 0 : Math.min(dp[i - 1][1] + b, dp[i - 1][0]);
                } else if (s.charAt(i) == 'J') {
                    dp[i][0] = Integer.MAX_VALUE;
                    dp[i][1] = i == 0 ? 0 : Math.min(dp[i - 1][0] + a, dp[i - 1][1]);
                } else if (s.charAt(i) == '?') {
                    dp[i][1] = i == 0 ? 0 : Math.min(dp[i - 1][0] + a, dp[i - 1][1]);
                    dp[i][0] = i == 0 ? 0 : Math.min(dp[i - 1][1] + b, dp[i - 1][0]);
                }
            }
            long min = Math.min(dp[s.length() - 1][0], dp[s.length() - 1][1]);
            System.out.println("Case #" + tt + ": " + min);
        }
    }
}