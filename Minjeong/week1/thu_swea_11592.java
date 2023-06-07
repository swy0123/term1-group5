import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            int d, n;
            d = sc.nextInt();
            n = sc.nextInt();

            int[] k = new int[n];
            int[] s = new int[n];
            float maxTime = 0;
            for (int i = 0; i < n; i++) {
                k[i] = sc.nextInt();
                s[i] = sc.nextInt();
                if ((float) (d - k[i]) / s[i] > maxTime) maxTime = (float) (d - k[i]) / s[i];
            }

            System.out.println("#" + testCase + " " + (d / maxTime));
        }
    }
}