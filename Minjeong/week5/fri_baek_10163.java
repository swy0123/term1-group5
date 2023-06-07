import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[][] del = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[1001][1001];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            for (int j = x; j < x + h; j++) {
                for(int k = y; k < y + w; k++) arr[j][k] = i;
            }
        }

        for (int i = 1; i <= n; i++) {
        	int cnt = 0;
            for (int j = 0; j < 1001; j++) {
                for(int k = 0; k < 1001; k++) {
                    if (arr[j][k] == i) cnt += findArea(j, k, arr, i);
                }
            }
            System.out.println(cnt);
        }
    }
    
    private static int findArea(int i, int j, int[][] paper, int val) {
		int cnt = 0;
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(i, j));
		paper[i][j] = 0;
		cnt++;

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;

			for (int k = 0; k < 4; k++) {
				int nx = x + del[k][0];
				int ny = y + del[k][1];
				if (nx < 0 || nx >= 1001 || ny < 0 || ny >= 1001 || paper[nx][ny] != val) continue;
				paper[nx][ny] = 0;
				q.offer(new Pair(nx, ny));
				cnt++;
			}
		}
		return cnt;
	}
}