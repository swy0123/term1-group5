import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class wed_beak_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합 계산
        for (int i = 1; i < n + 1; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken()) - 1;
            int endIndex = Integer.parseInt(st.nextToken());

            sb.append(arr[endIndex] - arr[startIndex]);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}