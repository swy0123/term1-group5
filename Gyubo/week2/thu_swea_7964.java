import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class thu_swea_7964 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < testCase + 1; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for (int i = dist - 1; i < n; i++) {
                if (arr[i] == 1) {
                    continue;
                }

                boolean flag = false;
                for (int j = 1; j < dist; j++) {
                    int checkIndex = i - j;
                    if (arr[checkIndex] == 1) {
                        flag = true;
                        break;
                    }
                }
                // 포탈이 없다.
                if (!flag) {
                    arr[i] = 1;
                    count++;
                }
            }
            System.out.println("#" + tc + " " + count);
        }
    }
}
