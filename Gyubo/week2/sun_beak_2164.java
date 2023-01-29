import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class sun_beak_2164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(n);
            return;
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        while (true) {
            deque.pollFirst();

            if (deque.size() == 1) {
                System.out.println(deque.pop());
                return;
            }

            Integer lastValue = deque.pollFirst();
            deque.add(lastValue);
        }
    }
}
