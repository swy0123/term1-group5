import java.util.Scanner;

public class mon_beak_8320 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];

        for (int number = 1; number < n + 1; number++) {
            int count = 0;
            for (int i = 1; i <= (int) Math.sqrt(number); i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            arr[number] = arr[number - 1] + count;
        }

        System.out.println(arr[arr.length - 1]);
    }
}
