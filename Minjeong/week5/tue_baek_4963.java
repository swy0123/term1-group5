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
	static int w, h, res;
	static int[][] del = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while(true) {
        	res = 0;
        	st = new StringTokenizer(br.readLine());
        	w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) return;
            int[][] map = new int[h][w];
            
            for (int i = 0; i < h; i++) {
            	st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
            int res = 0;
            for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						map[i][j] = 0;
						bfs(i, j, map);
						res++;
					}
				}
			}
            System.out.println(res);
        }
        
    }

	private static void bfs(int sx, int sy, int[][] map) {
        Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(sx, sy));
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			
			for (int i = 0; i < 8; i++) {
				int nx = x + del[i][0];
				int ny = y + del[i][1];
				if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == 0) continue;
				q.offer(new Pair(nx, ny));
				map[nx][ny] = 0;
			}
		}
	}
}