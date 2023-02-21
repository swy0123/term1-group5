import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int res = 0;
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        // 가로 방향 탐색
        out: for (int i = 0; i < n; i++) {
        	int y = -1;
			for (int j = 0; j < n - 1; j++) {
				if (map[i][j] == map[i][j + 1]) continue;
				else if (Math.abs(map[i][j] - map[i][j + 1]) != 1) continue out;
				if (map[i][j] - map[i][j + 1] == 1) {
					int cnt = l - 1;
					for (int k = j + 2; k < j + 1 + l; k++) {
						if ( k >= n || (map[i][k] != map[i][k - 1])) continue out;
						cnt--;
					}
					if (cnt != 0) continue out;
					j = j + l - 1;
					y = j + 1;
				}
				else if (map[i][j] - map[i][j + 1] == -1) {
					if (j - l + 1 >= 0 && y >= j - l + 1) continue out;
					int cnt = l - 1;
					for (int k = j; k > j - l + 1; k--) {
						if ( k - 1 < 0 || (map[i][k] != map[i][k - 1])) continue out;
						if (j - l + 1 >= 0 && (map[i][j] != map[i][j - l + 1])) continue out;
						cnt--;
					}
					if (cnt != 0) continue out;
				}
			}
			res++;
		}
		
		// 세로 방향 탐색
		out: for (int j = 0; j < n; j++) {
			int x = -1;
			for (int i = 0; i < n - 1; i++) {
				if (map[i][j] == map[i + 1][j]) continue;
				else if (Math.abs(map[i][j] - map[i + 1][j]) != 1) continue out;
				if (map[i][j] - map[i + 1][j] == 1) {
					int cnt = l - 1;
					for (int k = i + 2; k < i + 1 + l; k++) {
						if ( k >= n || (map[k][j] != map[k - 1][j])) continue out;
						cnt--;
					}
					if (cnt != 0) continue out;
					i = i + l - 1;
					x = i + 1;
				}
				else if (map[i][j] - map[i + 1][j] == -1) {
					if (i - l + 1 >= 0 && x >= i - l + 1) continue out;
					int cnt = l - 1;
					for (int k = i; k > i - l + 1; k--) {
						if ( k - 1 < 0 || (map[k][j] != map[k - 1][j])) continue out;
						if (i - l + 1 >= 0 && (map[i][j] != map[i - l + 1][j])) continue out;
						cnt--;
					}
					if (cnt != 0) continue out;
				}
			}
			res++;
		}
        System.out.println(res);
    }
}