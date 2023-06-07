package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * boj_1976 여행 가자 골드4
 * 
 * @author elder
 *
 */
public class boj_1976 {

	static int N;
	static int M;
	static int[] city;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		city = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			city[i] = i;
		}

		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				int temp_city = Integer.parseInt(st.nextToken());
				if(temp_city == 1) {
					union(i,j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int check = find(Integer.parseInt(st.nextToken()));
		for (int i = 0; i < M-1; i++) {
			if(find(Integer.parseInt(st.nextToken())) != check) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		
		System.out.println("YES");
		
	}

	private static void union(int i, int j) {
		int pa = find(i);
		int pb = find(j);
		
		if(pa != pb) {
			city[pb] = pa;
		}
	}

	private static int find(int j) {
		if(city[j] == j)return j;
		else return city[j] = find(city[j]);
	}

}
