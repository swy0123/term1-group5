import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class thu_beak_14888 {

    private static int maxValue = Integer.MIN_VALUE;
    private static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int[] operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
        // 인풋
        dfs(0, operators, numbers, n - 1, new char[n - 1]);
        System.out.println(maxValue);
        System.out.println(minValue);
    }

    private static void dfs(int depth, int[] oper, int[] numbers, int n, char[] answer) {
        if (n == depth) {
            int prevValue = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                int operIndex = i - 1;
                if (answer[operIndex] == '+') {
                    prevValue += numbers[i];
                } else if (answer[operIndex] == '-') {
                    prevValue -= numbers[i];
                } else if (answer[operIndex] == 'x') {
                    prevValue *= numbers[i];
                } else if (answer[operIndex] == '/') {
                    prevValue /= numbers[i];
                }
            }
            maxValue = Math.max(prevValue, maxValue);
            minValue = Math.min(prevValue, minValue);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] == 0) {
                continue;
            }
            oper[i] -= 1;
            if (i == 0) {
                answer[depth] = '+';
            } else if (i == 1) {
                answer[depth] = '-';
            } else if (i == 2) {
                answer[depth] = 'x';
            } else if (i == 3) {
                answer[depth] = '/';
            }
            dfs(depth + 1, oper, numbers, n, answer);
            oper[i] += 1;
        }
    }

}
