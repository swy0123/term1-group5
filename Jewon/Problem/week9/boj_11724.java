import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * boj_11724 연결 요소의 개수
 * 
 * @author elder
 *
 */
public class boj_11724 {
	static int N, M;
	static int[] nodes;
	static int cnt = 0;
	static boolean[] checkList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nodes = new int[N + 1];
		checkList = new boolean[N + 1];
		for (int i = 1; i < N + 1; i++) {
			nodes[i] = i;
		}
//		System.out.println(Arrays.toString(nodes));
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			union(a, b);
//			System.out.println(Arrays.toString(nodes));
		}
		
		
		
		for (int i = 1; i < checkList.length; i++) {
			if(!checkList[find(nodes[i])]) {
				cnt++;
				checkList[find(nodes[i])] = true;
			}
		}
		
		System.out.println(cnt);

	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa != pb) {
			nodes[pb] = pa;
		}
	}

	private static int find(int k) {
		if (nodes[k] == k)
			return k;
		else
			return nodes[k] = find(nodes[k]);

	}
}
