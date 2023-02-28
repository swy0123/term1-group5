package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * boj_1717 집합의 표현 골드5
 * 
 * @author SSAFY
 *
 */
public class boj_1717 {
	static int N;
	static int M;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		parents = new int[N + 1];

		// make-set
		for (int i = 0; i < N + 1; i++) {
			parents[i] = i;
		}
		
		
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(command == 0) {
				union(a,b);
			}else {
				if(find(a) == find(b)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa != pb) {
			parents[pa] = pb;
		}
	}

	private static int find(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = find(parents[a]);
	}

}
