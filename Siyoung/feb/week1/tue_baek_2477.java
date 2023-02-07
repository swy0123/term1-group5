package com.ssafy.feb.week1;

import java.util.Scanner;
/*
 * 난이도 하 2477번 - 참외밭
 */
public class tue_baek_2477 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		int dir, len;
		int e = 0, w = 0, s = 0, n = 0, sx=0, sy=0;
		int[][] order = new int[7][2];
		int[] next = {4, 3, 1, 2};
		
		for(int i=0; i<6; i++) {
			dir = sc.nextInt()-1;
			len = sc.nextInt();
			order[i][0] = dir;
			order[i][1] = len;
			switch (dir) {
			case 0:
				e = len;
				break;
			case 1:
				w = len;
				break;
			case 2:
				s = len;
				break;
			case 3:
				n = len;
				break;
			default:
				break;
			}
			
		}
		order[6][0] = order[0][0];
		order[6][1] = order[0][1];
		
//		for (int[] i : order) {
//			for (int j : i) {
//				System.out.print(j+" ");
//			}
//			System.out.println();
//		}
		
		
		for (int i=0; i<6; i++) {
			if(sx != 0) continue;
			if(next[order[i][0]]-1 != order[i+1][0]) {
				 sx = order[i][1];
				 sy = order[i+1][1];
			}
		}
		int max1 = (e>w)?e:w;
		int max2 = (s>n)?s:n;
//		System.out.println(e + " "+ w + " "+ s + " "+ n + " "+ sx + " "+ sy);
		System.out.println((max1*max2-sx*sy)*cnt);
	}

	
}
