import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int x;
	int y;
	boolean wall;
	
	public Pair(int x, int y, boolean wall) {
		this.x = x;
		this.y = y;
		this.wall = wall;
	}
}

public class Main {
	static int[][] del = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] map;
	static int[][][] res;
	static int n, m;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

    	st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	map = new int[n][m];  
    	res = new int[n][m][2];
        for (int i = 0; i < n; i++) {
        	char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = tmp[j] - '0';
				res[i][j][0] = Integer.MAX_VALUE;
				res[i][j][1] = Integer.MAX_VALUE;
			}
		}
        bfs();
        if (Math.min(res[n - 1][m - 1][0], res[n - 1][m - 1][1]) == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(Math.min(res[n - 1][m - 1][0], res[n - 1][m - 1][1]));  
    }
	
	private static void bfs() {
        Queue<Pair> q = new ArrayDeque<>();
        res[0][0][0] = 1;
		q.offer(new Pair(0, 0, false));
		
        while (!q.isEmpty()) {
        	int x = q.peek().x;
        	int y = q.peek().y;
        	boolean wall = q.poll().wall;

        	for (int i = 0; i < 4; i++) {
				int nx = x + del[i][0];
				int ny = y + del[i][1];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (map[nx][ny] == 0) {
					if (wall) {
						if (res[nx][ny][1] > res[x][y][1] + 1) {
							res[nx][ny][1] = res[x][y][1] + 1;
							q.offer(new Pair(nx, ny, true));
						}
					}
					else {
						if (res[nx][ny][0] > res[x][y][0] + 1) {
							res[nx][ny][0] = res[x][y][0] + 1;
							q.offer(new Pair(nx, ny, false));
						}
					}
				}
				else if (map[nx][ny] == 1 && !wall) {
					if (res[nx][ny][1] > res[x][y][0] + 1) {
						res[nx][ny][1] = res[x][y][0] + 1;
						q.offer(new Pair(nx, ny, true));
					}
				}
			}
        }
	}
}
