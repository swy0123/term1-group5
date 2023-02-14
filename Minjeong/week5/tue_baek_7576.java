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
        StringTokenizer st;
        
        int res = 0;
    	st = new StringTokenizer(br.readLine());
    	int w = Integer.parseInt(st.nextToken());
    	int h = Integer.parseInt(st.nextToken());
    	
    	int[][] map = new int[h][w];
    	boolean flag = true;
    	Queue<Pair> q = new ArrayDeque<>();
    	
        for (int i = 0; i < h; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) q.offer(new Pair(i, j));
				else if (map[i][j] == 0) flag = false;
			}
		}
        
        // 이미 다 익었으면 0 출력
        if (flag) {
        	System.out.println(res);
        	return;
        }

		while(!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int x = q.peek().x;
				int y = q.poll().y;

				for (int i = 0; i < 4; i++) {
					int nx = x + del[i][0];
					int ny = y + del[i][1];
					if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
					if (map[nx][ny] == 0) {
						q.offer(new Pair(nx, ny));
						map[nx][ny] = 1;
					}
				}
			}
			
			res++;
			
			flag = true;
			loop: for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 0) {
						flag = false;
						break loop;
					}
				}
			}
			if (flag) {
				System.out.println(res);
				return;
			}
		}
		System.out.println(-1);
    }
}