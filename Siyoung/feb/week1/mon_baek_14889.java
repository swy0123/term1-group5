package algorithm;

import java.util.Scanner;


public class mon_baek_14889 {
	
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[] arr;
	static int[] res;
//	static int[] num;
	static int[] chr;
	static boolean[] flag;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		arr = new int[n];
		res = new int[n-1];
		flag = new boolean[n-1];
		chr = new int[n-1];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int plus = sc.nextInt();
		int minus = sc.nextInt();
		int mul = sc.nextInt();
		int dev = sc.nextInt();
		
		int cnt = 0;

		for(int i=0; i<plus; i++) {
			chr[cnt++] = 1;
		}
		for(int i=0; i<minus; i++) {
			chr[cnt++] = 2;
		}
		for(int i=0; i<mul; i++) {
			chr[cnt++] = 3;
		}
		for(int i=0; i<dev; i++) {
			chr[cnt++] = 4;
		}
		
		num(0);
		
		System.out.println(max);
		System.out.println(min);
		
	}
	
	private static void num(int cnt) {
		if(cnt == flag.length) {
			int ret = arr[0];
			for(int i=0; i<chr.length; i++) {
				if(flag[i]) {
					ret = calc(res[i], ret, arr[i+1]);
				}
			}
			if(min > ret) min = ret;
			if(max < ret) max = ret;
		}
		
		for(int i=0; i<flag.length; i++) {
			if(!flag[i]) {
				flag[i] = true;
				res[cnt] = chr[i];
				num(cnt+1);
				flag[i] = false;
			}
		}
		
	}
	
	private static int calc(int n, int num1, int num2) {
		int res = 0;
		switch (n) {
		case 1:
			res = num1 + num2;
			break;
		case 2:
			res = num1 - num2;
			break;
		case 3:
			res = num1 * num2;
			break;
		case 4:
			res = num1 / num2;
			break;
		default:
			break;
		}
		return res;
	}
	

}
