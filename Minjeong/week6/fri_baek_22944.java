import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	int um;
	int h;
	int num;
	
	public Node(int x, int y, int um, int h, int num) {
		this.x = x;
		this.y = y;
		this.um = um;
		this.h = h;
		this.num = num;
	}
}

public class Main {
	static int n, h, d;
	static int[][] del = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
	static char[][] map;
	static boolean[][][] v;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		int sx = 0, sy = 0;
		map = new char[n][n];
		v = new boolean[n][n][11];
		char label = '0';
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'S') {
					sx = i;
					sy = j;
				}
				else if (map[i][j] == 'U') {
					map[i][j] = label++;
				}
			}
		}

		System.out.println(solve(sx, sy));
	}

	private static int solve(int sx, int sy) {
		Queue<Node> q = new ArrayDeque<>();
		for (int i = 0; i < 11; i++) v[sx][sy][i] = true;
		
		q.offer(new Node(sx, sy, 0, h, 0));
		int dist = -1;
		
		while (!q.isEmpty()) {
			int size = q.size();
			dist++;
			while (size-- > 0) {
				Node cur = q.poll();
				if (map[cur.x][cur.y] == 'E') return dist;
				
				for (int i = 0; i < 4; i++) {
					int nx = cur.x + del[i][0];
					int ny = cur.y + del[i][1];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					
					if (map[nx][ny] == '.' || map[nx][ny] == 'E') {
						if (cur.um > 0 && !v[nx][ny][cur.num]) {
							v[nx][ny][cur.num] = true;
							q.offer(new Node(nx, ny, cur.um - 1, cur.h, cur.num));
						}
						else if (cur.um == 0 && !v[nx][ny][0] && cur.h - 1 > 0) {
							v[nx][ny][0] = true;
							q.offer(new Node(nx, ny, 0, cur.h - 1, 0));
						}
					}
					else if (map[nx][ny] >= '0' && map[nx][ny] <= '9' && !v[nx][ny][(map[nx][ny] - '0') + 1]) {
						v[nx][ny][(map[nx][ny] - '0') + 1] = true;
						q.offer(new Node(nx, ny, d, cur.h, (map[nx][ny] - '0') + 1));
					}
				}
			}
		}
		return -1;
	}
}