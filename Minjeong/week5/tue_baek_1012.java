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
	static boolean[][] map;
	static int w, h, k, res;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
        	
        	res = 0;
        	st = new StringTokenizer(br.readLine());
        	w = Integer.parseInt(st.nextToken());
        	h = Integer.parseInt(st.nextToken());
        	k = Integer.parseInt(st.nextToken());
        	
        	map = new boolean[h][w];
            for (int i = 0; i < k; i++) {
            	st = new StringTokenizer(br.readLine());
            	int y = Integer.parseInt(st.nextToken());
            	int x = Integer.parseInt(st.nextToken());
            	map[x][y] = true;
    		}
            
            for (int i = 0; i < h; i++) {
    			for (int j = 0; j < w; j++) {
    				if (map[i][j]) {
    					map[i][j] = false;
    					bfs(i, j);
    					res++;
    				}
    			}
    		}
            System.out.println(res);  
        }
    }
	
	private static void bfs(int sx, int sy) {
        Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(sx, sy));

		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;

			for (int i = 0; i < 4; i++) {
				int nx = x + del[i][0];
				int ny = y + del[i][1];
				if (nx < 0 || nx >= h || ny < 0 || ny >= w || !map[nx][ny]) continue;
				q.offer(new Pair(nx, ny));
				map[nx][ny] = false;
			}
		}
	}
}
