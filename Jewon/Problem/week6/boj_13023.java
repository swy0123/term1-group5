package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * boj_13023 ABCDE 골드5
 * 
 * @author SSAFY
 *
 */
public class boj_13023 {

	static List<Integer>[] list;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new List[N];
		
		for (int i = 0; i < N; i++) {
			list[i]  = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		//
		for (int i = 0; i < N; i++) {
			visit = new boolean[N];
			dfs(i, 0);
		}
		
		System.out.println(0);
	}

	private static void dfs(int vertex, int depth) {
		if(depth == 5) {
			System.out.println(1);
			System.exit(0);
			return;
		}
		
		for (int vertex_t : list[vertex]) {
			if(!visit[vertex_t]) {
				visit[vertex_t] = true;
				dfs(vertex_t, depth+1);
				visit[vertex_t] = false;
			}
		}
	}

}
