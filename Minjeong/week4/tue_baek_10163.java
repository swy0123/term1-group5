import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[1001][1001];
        for (int i = 0; i < 1001; i++)
            for (int j = 0; j < 1001; j++) arr[i][j] = -1;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            for (int j = x; j < x + h; j++) {
                for(int k = y; k < y + w; k++) arr[j][k] = i;
            }
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < 1001; j++) {
                for(int k = 0; k < 1001; k++) {
                    if (arr[j][k] == i) cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}