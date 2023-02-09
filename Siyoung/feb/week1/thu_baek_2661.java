package algorithm.week1;

import java.util.Scanner;

/*
 * 백준 2661 좋은 수열
 */
public class thu_baek_2661 {
	private static String min = "";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		good(num, "", 0);
		System.out.println(min);
	}
	
	private static void good(int n, String str, int cur) {
		if(n<=0) {
//			System.out.println(str);
			if(min.equals("")) min = str;
			if(str.compareTo(min)<0) min = str;
			return;
		}
		for(int i=1; i<=3; i++) {
			if(i==cur) continue;
			if(check(str, i)) {
//				System.out.println("good, n : " + Integer.toString(i) + ", " + n);
				good(n-1, str + Integer.toString(i), i);
				return;
			}
		}
		int last = str.charAt(str.length()-1)-'0';
		str = str.substring(0, str.length()-1);
//		System.out.println(str +" " + last);
		good(n+1, str, last);
		
		
	}
	
	private static boolean check(String str, int n) {
		int len = str.length();
		if(len == 0) {
			return true;
		}
		len++;
		str += Integer.toString(n);

//		System.out.println("check, len : " + str + ", " + len);
		for(int j=1; j<=len/2; j++) {
//			System.out.println("front "+str.substring(len-j*2, len-j));
//			System.out.println("back "+str.substring(len-j));
			if((str.substring(len-j).equals(str.substring(len-j*2, len-j)))) {
				return false;
			}
		}
		str = str.substring(len-1);
		return true;
		
	}

}