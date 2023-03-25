import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
	static int chickenDist = Integer.MAX_VALUE, n, m, total;
	static List<Pair> chickens, houses;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		chickens = new ArrayList<>();
		houses = new ArrayList<>();
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) chickens.add(new Pair(i, j));
				else if (map[i][j] == 1) houses.add(new Pair(i, j));
			}
		}
		
		total = chickens.size();
		pickChickens(0, 0, new int[m]);
		
		System.out.println(chickenDist);
	}

	// m개의 치킨집 고르기
	private static void pickChickens(int pos, int depth, int[] res) {
		if (depth == m) {
			getChickenDist(res);
			return;
		}
		
		for (int i = pos; i < total; i++) {
			res[depth] = i;
			pickChickens(i + 1, depth + 1, res);
		}
		
	}

	// 치킨 거리 계산
	private static void getChickenDist(int[] res) {
		int distSum = 0;
		
		for (Pair house : houses) {
			int dist = Integer.MAX_VALUE;
			for (int i : res) {
				dist = Math.min(dist, Math.abs(house.x - chickens.get(i).x) + Math.abs(house.y - chickens.get(i).y));
				
			}
			distSum += dist;
		}
		
		chickenDist = Math.min(chickenDist, distSum);
	}
}