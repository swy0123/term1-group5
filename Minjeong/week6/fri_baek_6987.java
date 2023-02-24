import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean flag;
    static int[] gameResult;
    static int[] input = new int[18];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            gameResult = new int[18];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 18; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }
            flag = false;
            find(0, 1);
            int res = (flag ? 1 : 0);
            System.out.print(res + " ");
        }
    }

    private static void find(int cur, int next) {
        if (flag || cur > 0 && input[cur - 1] != gameResult[cur - 1]) return;

        if (cur == 5) {
            for (int i = 0; i < 18; i++) {
                if (input[i] != gameResult[i]) return;
            }
            flag = true;
            return;
        }

        // 이겼을 때
        gameResult[cur * 3] += 1;
        gameResult[next * 3 + 2] += 1;
        if (next < 5) find(cur, next + 1);
        else find(cur + 1, cur + 2);
        gameResult[cur * 3] -= 1;
        gameResult[next * 3 + 2] -= 1;

        // 무승부일 때
        gameResult[cur * 3 + 1] += 1;
        gameResult[next * 3 + 1] += 1;
        if (next < 5) find(cur, next + 1);
        else find(cur + 1, cur + 2);
        gameResult[cur * 3 + 1] -= 1;
        gameResult[next * 3 + 1] -= 1;

        // 졌을 때
        gameResult[cur * 3 + 2] += 1;
        gameResult[next * 3] += 1;
        if (next < 5) find(cur, next + 1);
        else find(cur + 1, cur + 2);
        gameResult[cur * 3 + 2] -= 1;
        gameResult[next * 3] -= 1;
    }
}