package week3;

import java.util.Scanner;

/**
 * boj_2991 사나운 개 브론즈3
 * 
 * @author elder
 *
 */
public class boj_2991 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); // 개1 공격적 시간
		int B = sc.nextInt(); // 개1 조용한 시간
		int C = sc.nextInt(); // 개2 공격적 시간
		int D = sc.nextInt(); // 개2 조용한 시간
		
		int[] ans = new int[3];
		int[] list= new int[3];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = sc.nextInt();
		}
		
		
		for (int i = 0; i < 3; i++) {
			int temp = 1;
			while(true) {
				if(temp * (A+B) >= list[i]) {
					temp--;
					break;
				}
				temp++;
			}
			
			if(temp * (A+B) + A >= list[i]) {
				ans[i]++;
			}
			
			temp = 1;
			while(true) {
				if(temp * (C+D) >= list[i]) {
					temp--;
					break;
				}
				temp++;
			}
			
			if(temp * (C+D) + C >= list[i]) {
				ans[i]++;
			}
			
			System.out.println(ans[i]);
		}
		
		
		
	}

}
