import java.util.*;

class Solution {

    public static int[] insert(int[] arr, int i, int s, int n) {
        int[] next = new int[n];
        int index = 0;
        for (index = 0; index < s; index++) {
            next[index] = arr[index];
        }
        next[s] = i;
        index = s + 1;
        for (; index < i; index++) {
            next[index] = arr[index - 1];
        }
        return next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            int i = 3;
            int[] arr = new int[n];
            int a = 1;
            int b = 2;
            int c = 3;
            System.out.println(a + " " + b + " " + c);
            int mid = scanner.nextInt();
            arr[1] = mid;
            switch (mid) {
                case 1:
                    arr[0] = 2;
                    arr[2] = 3;
                    break;
                case 2:
                    arr[0] = 1;
                    arr[2] = 3;
                    break;
                case 3:
                    arr[0] = 1;
                    arr[2] = 2;
                    break;
            }
            for (i = 4; i <= n; i++) {
                int s = 0;
                int e = i - 2;
                while (true) {
                    // for (int ii = 0; ii < n; ii++) {
                    //     System.out.print(arr[ii] + " ");
                    // }
                    //System.out.println();
                    if (s == e) {
                        if (s > 0) {
                            s -= 1;
                        } else {
                            e += 1;
                            //arr = insert(arr, i, s, n);
                            //break;
                        }
                    }
                    if (s == e - 1) {
                        System.out.println(arr[s] + " " + arr[e] + " " + i);
                        mid = scanner.nextInt();
                        if(mid == i){
                            arr = insert(arr,i,e,n);
                        }else if(mid == arr[s]){
                            arr = insert(arr,i,s,n);
                        }else{
                            arr = insert(arr,i,e+1,n);
                        }
                        break;
                    } else {
                        mid = (s + e) / 2;
                        System.out.println(arr[s] + " " + arr[mid] + " " + i);
                        int next = scanner.nextInt();
                        if (next == arr[s]) {
                            arr = insert(arr, i, s, n);
                            break;
                        } else if (next == arr[mid]) {
                            s = mid + 1;
                        } else {
                            e = mid - 1;
                        }
                    }
                }
            }
            String s = "";
            for (i = 0; i < n; i++) {
                s += arr[i] + " ";
            }
            System.out.println(s);
            int f = scanner.nextInt();
        }
    }
}