package assign;

import java.util.Scanner;

public class wed_baek_15650 {

	static int m;
	static int[] arr;
	static boolean[] flag;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		flag = new boolean[n];
		
		comb(m, 0);
	}
	
	private static void comb(int depth, int cnt) {
		if(depth == 0) {
			for(int i=0; i<flag.length; i++) {
				if(flag[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		
		for(int i=cnt; i<flag.length; i++) {
			flag[i] = true;
			comb(depth-1, i+1);
			flag[i] = false;
		}
	}

}
