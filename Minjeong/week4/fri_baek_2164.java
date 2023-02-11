import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static int n;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) q.offer(i);

        while (true) {
        	if (q.size() == 1) {
        		System.out.println(q.peek());
        		return;
        	}
        	q.poll();
        	q.offer(q.poll());
        }
    }
}
