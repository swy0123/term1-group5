package algorithm.week1;


import java.util.Scanner;
import java.io.FileInputStream;


class mon_swea_1289 {
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		int ret;
		char cur;
		
		for(int t=1; t<=T; t++) {
			ret = 0;
			cur = '0';
			String str = sc.nextLine();
			
			n=0;
			check(str, 0, '0');
			System.out.println("#"+t+" "+n);
			
		}

	}
	
	private static void check(String str, int idx, char cur) {
		if(idx == str.length()) return;
		
		if(str.charAt(idx) != cur) {
			cur = str.charAt(idx);
			n+=1;
		}
		
		check(str, idx+1, cur);
		
		
	}
	
}