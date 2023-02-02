package week3;

import java.util.Scanner;

/**
 * 
 * boj_8320 직사각형을 만드는 방법 브론즈2
 * 
 * @author elder
 *
 */
public class boj_8320 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		
		for(int i = 1; i <= N ; i++) {
			int temp = i;
			while(true) {
				if(i * temp <= N) {
					cnt++;
				}else {
					break;
				}
				temp++;
			}
		}
		
		System.out.print(cnt);
	}

}
