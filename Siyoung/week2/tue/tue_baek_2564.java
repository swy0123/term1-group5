package com.sy.secweek.tue;

import java.util.Scanner;
/**
 * 문제29: 백준 : 2564 경비원 3
 * @author swy05
 */
public class tue_baek_2564 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int w, h, n;
		int ddir, ddis;
		
		w = sc.nextInt();
		h = sc.nextInt();
		n = sc.nextInt();
		
		int[][] pos = new int[n][2];
		int[] start = new int[2];
		
		//1 = 북, 2 = 남, 3 = 서, 4 = 동
		for(int i=0; i<n; i++) {
			pos[i][0] = sc.nextInt();
			pos[i][1] = sc.nextInt();
		}
		ddir = sc.nextInt();
		ddis = sc.nextInt();
		
		int sum = 0;
		for(int i=0; i<n; i++) {
			switch (ddir) {
			case 1:
				switch (pos[i][0]) {
				case 1:
					sum += Math.abs(ddis-pos[i][1]);
					break;
				case 2:
					if(ddis+pos[i][1] < 2*w-(ddis+pos[i][1]))
						sum += ddis+pos[i][1] + h;
					else sum += 2*w-(ddis+pos[i][1]) + h;
					break;
				case 3:
					sum += ddis + pos[i][1];
					break;
				case 4:
					sum += w-ddis + pos[i][1];
					break;
				default:
					break;
				}
				break;
			case 2:
				switch (pos[i][0]) {
				case 1:
					if(ddis+pos[i][1] < 2*w-(ddis+pos[i][1]))
						sum += ddis+pos[i][1] + h;
					else sum += 2*w-(ddis+pos[i][1]) + h;
					break;
				case 2:
					sum += Math.abs(ddis-pos[i][1]);
					break;
				case 3:
					sum += ddis + h-pos[i][1];
					break;
				case 4:
					sum += w-ddis + h-pos[i][1];
					break;

				default:
					break;
				}
				break;
			case 3:
				switch (pos[i][0]) {
				case 1:
					sum += ddis + pos[i][1];
					break;
				case 2:
					sum += h-ddis + pos[i][1];
					break;
				case 3:
					sum += Math.abs(ddis-pos[i][1]);
					break;
				case 4:
					if(ddis+pos[i][1] < 2*h-(ddis+pos[i][1]))
						sum += ddis+pos[i][1] + w;
					else sum += 2*h-(ddis+pos[i][1]) + w;
					break;
				default:
					break;
				}
				break;
			case 4:
				switch (pos[i][0]) {
				case 1:
					sum += ddis + w-pos[i][1];
					break;
				case 2:
					sum += h-ddis + w-pos[i][1];
					break;
				case 3:
					if(ddis+pos[i][1] < 2*h-(ddis+pos[i][1]))
						sum += ddis+pos[i][1] + w;
					else sum += 2*h-(ddis+pos[i][1]) + w;
					break;
				case 4:
					sum += Math.abs(ddis-pos[i][1]);
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
			
		}
		
		System.out.println(sum);
	}

}
