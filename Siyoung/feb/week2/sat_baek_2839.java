package feb.week2.sat;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 백준 2839 설탕배달
 */
public class sat_baek_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		int[] arr = new int[n+3];
		arr[1] = 0;
		arr[2] = 0;
		arr[3] = 1;
		arr[4] = 0;
		arr[5] = 1;
		
		int tmp = 3;
		while(tmp <= n) {
			if(tmp+5<=n && arr[tmp] > 0 && arr[tmp+5] == 0) arr[tmp+5] = arr[tmp]+1;
			if(tmp+3<=n && arr[tmp] > 0 && arr[tmp+3] == 0) arr[tmp+3] = arr[tmp]+1;
			tmp++;
		}
		
//		System.out.println(Arrays.toString(arr));
		if(arr[n] == 0) System.out.println(-1);
		else System.out.println(arr[n]);
		
		
	}

}
