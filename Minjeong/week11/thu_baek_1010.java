import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class thu_baek_1010 {

    public static void main(String[] args) throws Exception {
        int[][] res = new int[30][30];
        res[1][0] = res[1][1] = 1;
        for (int i = 2; i < 30; i++) {
            res[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int lt = Integer.parseInt(st.nextToken());
            int rt = Integer.parseInt(st.nextToken());
            System.out.println(res[rt][lt]);
        }
    }
}
