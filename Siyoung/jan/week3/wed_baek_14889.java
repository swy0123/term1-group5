package assign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class wed_baek_14889 {

	static ArrayList<ArrayList<Integer>> sar = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> lar = new ArrayList<>();
	static boolean[] flag;
	static int[][] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		flag = new boolean[n];
		
		comb(n/2, 0);
//		System.out.println(sar);
//		System.out.println(lar);
		getMin();
		
	}
	
	private static void comb(int depth, int cnt) {
		if(depth == 0) {
			ArrayList<Integer> sart = new ArrayList<>();
			ArrayList<Integer> lart = new ArrayList<>();
			for(int i=0; i<n; i++) {
				if(flag[i]) sart.add(i);
				else lart.add(i);
			}
			
			sar.add(sart);
			lar.add(lart);
			return;
		}
		for(int i=cnt; i<n; i++) {
			if(i+depth > n) break;
			flag[i] = true;
			comb(depth-1, i+1);
			flag[i] = false;
		}
		
	}
	
	private static void getMin() {
		int min = 100000;
		
		for(int i=0; i<sar.size(); i++) {
			int sum = 0;
			for (Integer j : sar.get(i)) {
				for (Integer k : sar.get(i)) {
					sum += arr[j][k];
				}
			}
			for (Integer j : lar.get(i)) {
				for (Integer k : lar.get(i)) {
					sum -= arr[j][k];
				}
			}
			if(Math.abs(sum)<min) min = Math.abs(sum);
		}
		
		System.out.println(min);
	}
	
	

}
