import java.io.BufferedReader;
import java.io.IOException;
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

public class Solution {
	static List<Pair> customers;
	static int n;
	static int[] res;
	static Pair office, home;
	static int minVal;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			minVal = 98765421;
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			office = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			customers = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				customers.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			res = new int[n];
			makeOrder(0, new boolean[n]);

			
			System.out.println("#" + testCase + " " + minVal);
		}
		
		
	}
	private static void makeOrder(int depth, boolean[] v) {
		if (depth == n) {
			int dist = 0;
			dist += (Math.abs(customers.get(res[0]).x - office.x) + Math.abs(customers.get(res[0]).y - office.y));
			
			for (int i = 1; i < n; i++) {
				Pair cur = customers.get(res[i]);
				Pair pre = customers.get(res[i - 1]);
				dist += (Math.abs(cur.x - pre.x) + Math.abs(cur.y - pre.y));
			}
			dist += (Math.abs(customers.get(res[n - 1]).x - home.x) + Math.abs(customers.get(res[n - 1]).y - home.y));
			minVal = Math.min(minVal, dist);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!v[i]) {
				v[i] = true;
				res[depth] = i;
				makeOrder(depth + 1, v);
				v[i] = false;
			}
		}
	}
}
