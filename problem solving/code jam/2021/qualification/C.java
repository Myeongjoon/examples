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
    public static String make(int a, int b) {
        StringBuilder response = new StringBuilder();
        int[] input = new int[a];
        for (int i = 0; i < a; i++) {
            input[i] = i + 1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int max = a - 1;
        while (b > 0) {
            if (max <= b) {
                queue.add(max);
                b -= max;
            }
            max--;
        }
        while (!queue.isEmpty()) {
            int front = queue.poll();
            input = reverse(a - 1 - front, a - 1,input);
        }
        for (int i = 0; i < a; i++) {
            response.append(input[i]).append(" ");
        }
        return response.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (b < a - 1 || b + 1 > (a * (a + 1)) / 2) {
                System.out.println("Case #" + tt + ": IMPOSSIBLE");
            } else {
                String s = make(a, b - a + 1);
                System.out.println("Case #" + tt + ": " + s);
            }
        }
    }
}