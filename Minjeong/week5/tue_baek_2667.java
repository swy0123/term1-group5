import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

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
        int[][] map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
        	char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				map[i][j] = tmp[j] - '0';
			}
		}
        
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					map[i][j] = 0;
					list.add(bfs(i, j, map, n, res));
					res++;
				}
			}
		}
        System.out.println(res);
        Collections.sort(list);
        for (Integer num : list) {
			System.out.println(num);
		}
    }
	
	private static int bfs(int sx, int sy, int[][] map, int n, int val) {
        Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(sx, sy));
		int cnt = 0;
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			cnt++;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + del[i][0];
				int ny = y + del[i][1];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] == 0) continue;
				q.offer(new Pair(nx, ny));
				map[nx][ny] = 0;
			}
		}
		return cnt;
	}
}