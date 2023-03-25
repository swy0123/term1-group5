package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 백준 1043 거짓말
 */
public class mon_baek_1043 {

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
		
		st = new StringTokenizer(br.readLine());
		int know = Integer.parseInt(st.nextToken());
		int[] karr = new int[know];
		for(int i=0; i<know; i++) {
			karr[i] = Integer.parseInt(st.nextToken());
		}

		ArrayList<Integer>[] list = new ArrayList[m];
		for(int i=0; i<m; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int cur = Integer.parseInt(st.nextToken());
			list[i].add(cur);
			for(int j=0; j<len-1; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				list[i].add(tmp);
				union(cur, tmp);
			}
		}


		int cnt = 0;
		L: for (ArrayList<Integer> arrayList : list) {
			boolean flag = true;
			for (int num : arrayList) {
				for(int k=0; k<karr.length; k++) {
					if(find(num)==find(karr[k])) { 
						flag = false;
						continue L;
					}
				}
			}
			if(flag) cnt++;
		}

		
//		System.out.println(Arrays.toString(arr));
		System.out.println(cnt);
	}
	
	private static int find(int num) {
		if(arr[num] == num) return num;
		else return arr[num] = find(arr[num]);
	} 
	
	private static void union(int a, int b) {
		int ca = find(a);
		int cb = find(b);
		if(ca != cb) {
			arr[cb] = ca;
		}
	}

}
