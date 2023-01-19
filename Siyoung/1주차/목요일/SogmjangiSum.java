package assignment;

import java.util.Scanner;

public class SogmjangiSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for(int t=1; t<test+1; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int ret=m;
			int[][] map = new int[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = 0;
				}
			}
			
			int[] darr = new int[m];
			int[][] parr = new int[m][2];
			for(int c=0; c<m; c++) {
				int x=sc.nextInt();
				int y=sc.nextInt();
				int dir=sc.nextInt();
				
				//뛰기 전에 처음 시작 위치 확인
				if(map[x][y]!=0) {
					ret = ret-1;
					parr[c][0] = -1;
					parr[c][1] = -1;
					darr[c] = dir;
					continue;
				}
				map[x][y]=1;
				darr[c] = dir;
				parr[c][0] = x;
				parr[c][1] = y;
			}
			for(int c=0; c<m; c++) {
				int x=parr[c][0];
				int y=parr[c][1];
				int cur=darr[c]-1;
				if(x==-1) continue;
				map[x][y] = 0;

				if((x+3*dx[cur])<n &&(x+3*dx[cur])>=0 && (y+3*dy[cur])<n && (y+3*dy[cur])>=0) {
					if(map[x+3*dx[cur]][y+3*dy[cur]]!=0) {
						ret = ret-1;
						continue;
					}
				}
				if((x+5*dx[cur])<n &&(x+5*dx[cur])>=0 && (y+5*dy[cur])<n && (y+5*dy[cur])>=0) {
					if(map[x+5*dx[cur]][y+5*dy[cur]]!=0) {
						ret = ret-1;
						continue;
					}
				}
				if((x+6*dx[cur])<n &&(x+6*dx[cur])>=0 && (y+6*dy[cur])<n && (y+6*dy[cur])>=0) {
					if(map[x+6*dx[cur]][y+6*dy[cur]]!=0) {
						ret = ret-1;
						continue;
					}
					else map[x+6*dx[cur]][y+6*dy[cur]]=1;
				}
				else ret = ret-1;
			}
			System.out.println("#"+t + " " + ret);
			
		}

	}

}