import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n, res = 0;
        n = sc.nextInt();
        int[] time = new int[n];
        for (int i = 0; i < n; i++) time[i] = sc.nextInt();
        Arrays.sort(time);
        for (int i = 0; i < n; i++) {
            res += time[i] * (n - i);
        }
        System.out.println(res);
    }
}
