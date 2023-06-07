package week2;

import java.util.Scanner;

/*
 * 1493. 수의 새로운 연산 D3
 * 
 */


public class SWEA_1493 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int p = sc.nextInt();
			int q = sc.nextInt();

			if (p > q) {
				int temp = p;
				p = q;
				q = temp;
			}

			int px = 0, py = 0, qx = 0, qy = 0;
			int X = 1, Y = 1, val = 1, layer = 1;

			// p
			while (true) {
				if (val == p) {
					px = X;
					py = Y;
					break;
				}

				// 이동
				if (Y == 1) {
					X = 1;
					Y = ++layer;
				} else {
					X++;
					Y--;
				}
				val++;
			}
			
			// q
			while (true) {
				if (val == q) {
					qx = X;
					qy = Y;
					break;
				}

				// 이동
				if (Y == 1) {
					X = 1;
					Y = ++layer;
				} else {
					X++;
					Y--;
				}
				val++;
			}
			int tX = px + qx;
			int tY = py + qy;
			// search
			while (true) {
				
				if(X == tX && Y == tY) {
					System.out.println("#"+ test_case + " " + val);
					break;
				}
				
				// 이동
				if (Y == 1) {
					X = 1;
					Y = ++layer;
				} else {
					X++;
					Y--;
				}
				val++;
				
			}
		}
	}

}
