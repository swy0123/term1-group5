import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class fri_swea_1225 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc < 11; tc++) {
            br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 8; i++) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            Label:
            while (true) {
                for (int i = 1; i < 6; i++) {
                    deque.add(deque.pollFirst() - i);
                    if (deque.peekLast() <= 0) {
                        break Label;
                    }
                }
            }
            deque.pollLast();
            deque.add(0);
            System.out.print("#" + tc + " ");
            while (!deque.isEmpty()) {
                System.out.print(deque.pollFirst() + " ");
            }
            System.out.println();
        }
    }
}