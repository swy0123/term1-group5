package algorithm.week1.thu;

import java.util.Scanner;
/*
 * 백준 2023 신기한 소수
 */
public class thu_baek_2023 {

	static int[] arr = {1, 3, 7, 9};
	static int num = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		count(2, n-1);
		count(3, n-1);
		count(5, n-1);
		count(7, n-1);
		
	}
	
	private static void count(int cur, int cnt) {
		if(cnt == 0) {
			System.out.println(cur);
			return;
		}
		
		int tmp;
		boolean flag;
		
		for(int i=0; i<4; i++) {
			flag = true;
			
			tmp = cur*10 + arr[i];
			for(int j=3; j<tmp/2; j++) {
				if(tmp%j==0) {
					flag = false;
					break;
				}
			}
			if(flag) count(tmp, cnt-1);
		}
	}
	
	

}
