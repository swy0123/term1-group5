import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n, m, maxVal = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) cards[i] = sc.nextInt();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int tmp = cards[i] + cards[j] + cards[k];
                    if (tmp <= m) maxVal = Math.max(maxVal, tmp);
                }
            }
        }
        System.out.println(maxVal);
    }
}
