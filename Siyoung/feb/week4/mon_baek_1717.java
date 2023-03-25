package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 백준 1717 집합의 표현
 */
public class mon_baek_1717 {
	
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int o = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(o == 0) union(a, b);
			else {
				if(find(a) == find(b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
		
	}
	
	private static int find(int num) {
		if(arr[num] == num) return num;
		else {
			arr[num] = find(arr[num]);
			return arr[num];
		}
	}
	
	private static void union(int a, int b) {
		int ca = find(a);
		int cb = find(b);
		
		if(ca != cb) {
			arr[ca] = cb;
		}
		
	}

}
