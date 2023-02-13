import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class mon_beak_2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<int[]> stack1 = new Stack<>();
        Stack<int[]> stack2 = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stack1.add(new int[]{Integer.parseInt(st.nextToken()), i + 1});
        }

        int[] results = new int[n];

        while (!stack1.isEmpty()) {
            if (!stack2.isEmpty()) {
                // peek끼리 비교
                if (stack2.peek()[0] <= stack1.peek()[0]) {
                    int[] pop = stack2.pop();
                    results[pop[1] - 1] = stack1.peek()[1];
                    continue;
                }
            }

            // 비교했을때 아무일이 없다면
            stack2.add(stack1.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i : results) {
            sb.append(i);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}
