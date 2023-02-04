package IM;

import java.util.Scanner;

/**
 * 
 * boj_1592 영식이와 친구들 브론즈2
 * 
 * @author SSAFY
 *
 */
public class boj_1592 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int cnt = 0;
		int[] arr = new int[N];

		int currentIdx = 0;
		arr[0]++;
		
		while (true) {		
			if (arr[currentIdx] == M) {
				System.out.println(cnt);
				return;
			}
			
			if (arr[currentIdx] % 2 == 0) {
				currentIdx = (N - (L - currentIdx)) % N;
				arr[currentIdx]++;
			} else {
				currentIdx = (currentIdx + L) % N;
				arr[currentIdx]++;
			}			
			cnt++;			
		}

	}

}
