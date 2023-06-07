package algorithm.week1;

import java.util.Scanner;

/*
 * 좋은 수열
 */
public class baek_2661 {
	
	static int[] arr = {1, 2, 3};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		good(num, "");

	}
	
	private static void good(int n, String str) {
		if(n==0) {
			System.out.println(str); 
		}
		boolean flag = true;
		for(int i=0; i<3; i++) {
			int len = str.length();
			
			if(len>1 && str.charAt(len-1)-'0' == arr[i]) continue;
			str += Integer.toString(arr[i]);
			for(int j=1; j<len+1/2; j++) {
				if(len<j*2+1) continue;
				if(str.substring(len-j, len).equals(str.substring(len-j*2-1, len-j-1))) {
//					str = str.substring(0, len);
					continue;
				}
			}
			
			System.out.println(str); 
		}
		good(n-1, str);
		
	}

}
