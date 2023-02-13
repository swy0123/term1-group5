import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) q.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int r = 0;
        while (q.size() != 1) {
            if (++r == k) {
                sb.append(q.poll()).append(", ");
                r = 0;
            } else q.offer(q.poll());
        }
        sb.append(q.peek()).append(">");
        System.out.println(sb.toString());
    }
}