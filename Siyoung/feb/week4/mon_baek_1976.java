package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 백준 1976 여행가자
 */
public class mon_baek_1976 {

	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = i;
		}
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp;
			for(int j=1; j<=n; j++) {
				tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1) {
					union(i, j);
				}
				
			}
		}
		boolean flag = true;
		st = new StringTokenizer(br.readLine());
		int tmp = Integer.parseInt(st.nextToken());
		int cur;
		for(int i=0; i<m-1; i++) {
			cur = Integer.parseInt(st.nextToken());
			if(find(tmp) != find(cur)) {
				flag = false;
				break;
			}
		}
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
	
	private static void union(int a, int b) {
		int ca = find(a);
		int cb = find(b);
		
		if(ca != cb) {
			arr[ca] = cb;
		}
	}
	
	private static int find(int num) {
		if(arr[num] == num) return num;
		else return arr[num] = find(arr[num]);
		
		
	}
}
