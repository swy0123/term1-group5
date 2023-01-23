package com.sy.secweek.mon;

import java.util.Scanner;
/**
 * 문제25: SWEA : 1873 상호의 배틀필드 ( 라스트 원 ) 5
 * @author swy05
 */
public class mon_swea_1873 {

	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0 ,-1, 1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int h, w, n;
		int ti, tj, cd;
		for(int t=1; t<=T; t++) {
			h = sc.nextInt();
			w = sc.nextInt();
			sc.nextLine();
			int tti, ttj;
			ti = 0;
			tj = 0;
			cd = 0;
			String[][] map = new String[h][w];
			
			for(int i=0; i<h; i++) {
				String str = sc.nextLine();
				String[] srr = str.split("");
				
				for(int j=0; j<w; j++) {
					map[i][j] = srr[j];
					if(srr[j].equals("^")) {
						ti = i;
						tj = j;
						cd = 0;
					}
					else if(srr[j].equals("v")) {
						ti = i;
						tj = j;
						cd = 1;
					}
					else if(srr[j].equals("<")) {
						ti = i;
						tj = j;
						cd = 2;
					}
					else if(srr[j].equals(">")) {
						ti = i;
						tj = j;
						cd = 3;
					}
				}
			}
			//------
//			System.out.println("--------------");
//			for(int i=0; i<h; i++) {
//				for(int j=0; j<w; j++) {
//					System.out.printf("%s", map[i][j]);
//				}
//				System.out.println();
//			}
			//------
			
			n = sc.nextInt();
			sc.nextLine();
			
			String input = sc.nextLine();
//			System.out.println(input);
			for(int o=0; o<input.length(); o++) {
				char curO = input.charAt(o);
				
				switch (curO) {
				case 'U':
					if(ti-1>=0 && map[ti-1][tj].equals(".")) {
						map[ti][tj] = ".";
						ti--;
					}
					map[ti][tj] = "^";
					cd = 0;
					break;
				case 'D':
					if(ti+1<h && map[ti+1][tj].equals(".")) {
						map[ti][tj] = ".";
						ti++;
					}
					map[ti][tj] = "v";
					cd = 1;
					break;
				case 'L':
					if(tj-1>=0 && map[ti][tj-1].equals(".")) {
						map[ti][tj] = ".";
						tj--;
					}
					map[ti][tj] = "<";
					cd = 2;
					break;
				case 'R':
					if(tj+1<w && map[ti][tj+1].equals(".")) {
						map[ti][tj] = ".";
						tj++;
					}
					map[ti][tj] = ">";
					cd = 3;
					break;
				case 'S':
					tti = ti;
					ttj = tj;
					while(true) {
						if(tti+di[cd]>=0 && tti+di[cd]<h &&
								ttj+dj[cd]>=0 && ttj+dj[cd]<w) {
							if(map[tti+di[cd]][ttj+dj[cd]].equals(".") || map[tti+di[cd]][ttj+dj[cd]].equals("-")) {
								tti = tti+di[cd];
								ttj = ttj+dj[cd];
								continue;
							}
							if(map[tti+di[cd]][ttj+dj[cd]].equals("*")){
								map[tti+di[cd]][ttj+dj[cd]] = ".";
								break;
							}
							if(map[tti+di[cd]][ttj+dj[cd]].equals("#")) {
								break;
							}
						}
						else break;
					}
					break;
				default:
					break;
				}
				//------
//				System.out.println("--------------");
//				for(int i=0; i<h; i++) {
//					for(int j=0; j<w; j++) {
//						System.out.printf("%s", map[i][j]);
//					}
//					System.out.println();
//				}
				//------
				
			}
			
			System.out.printf("#%d ", t);
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					System.out.printf("%s", map[i][j]);
				}
				System.out.println();
			}
		}
	}

}
