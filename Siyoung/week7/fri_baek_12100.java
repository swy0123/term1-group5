package algorithm.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 백준 12100 2048 (Easy)
 */
public class fri_baek_12100 {

	static int di[] = {-1, 1, 0, 0};
	static int dj[] = {0, 0 ,-1, 1};
	
	static int n, map[][];
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}System.out.println();
//		up();
//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}

		perm(0, new int[5]);
		System.out.println(max);

	}
	
	
	private static void perm(int idx, int[] v) {
		if(idx==5) {
			int[][] tmp = new int[n][n];
			for(int i=0; i<n; i++) {
				tmp[i] = map[i].clone();
			}
			
			for(int i=0; i<v.length; i++) {
				numToDir(v[i]);
			}
			
			for (int[] is : map) {
				for (int is2 : is) {
					max = Math.max(max, is2);
				}
			}
			for(int i=0; i<n; i++) {
				map[i] = tmp[i].clone();
			}
			
			return;
		}
		
		for(int i=0; i<4; i++) {
			v[idx] = i;
			perm(idx+1, v);
		}
		
	}
	
	private static void numToDir(int n) {
		switch (n) {
		case 0:
			up();
			break;
		case 1:
			down();
			break;
		case 2:
			right();
			break;
		case 3:
			left();
			break;
		default:
			break;
		}
	}
	
	//방향으로 몰기
	//목표 지점부터 이동하는 행or열 별로 순서대로 당기기
	//같을 경우 합치기 - 인덱스 이동해서? 방문체크 해서 한번 곂친건 합치지 않기
	private static void up() {
		boolean[][] check = new boolean[n][n];
		
		for(int j=0; j<n; j++) {
			for(int i=0; i<n-1; i++) {
				if(map[i][j]==0) {
					for(int k=i+1; k<n; k++) {
						if(map[k][j]!=0) {
							map[i][j] = map[k][j];
							map[k][j] = 0;
							break;
						}
					}
				}
				if(map[i][j]!=0) {
					for(int k=i+1; k<n; k++) {
						if(map[k][j]==0)continue;
						if(map[k][j]==map[i][j] && !check[i][j]) {
							map[i][j] = map[i][j]+map[k][j];
							check[i][j] = true;
							map[k][j] = 0;
							break;
						}
						else if(map[k][j]!=map[i][j]) {
							break;
						}
					}
				}
			}
		}
	}
	
	private static void down() {
		boolean[][] check = new boolean[n][n];
		
		for(int j=0; j<n; j++) {
			for(int i=n-1; i>0; i--) {
				
				if(map[i][j]==0) {
					for(int k=i-1; k>=0; k--) {
						if(map[k][j]!=0) {
							map[i][j] = map[k][j];
							map[k][j] = 0;
							break;
						}
					}
				}
				if(map[i][j]!=0) {
					for(int k=i-1; k>=0; k--) {
						if(map[k][j]==0)continue;
						if(map[k][j]==map[i][j] && !check[i][j]) {
							map[i][j] = map[i][j]+map[k][j];
							check[i][j] = true;
							map[k][j] = 0;
							break;
						}
						else if(map[k][j]!=map[i][j]) {
							break;
						}
					}
				}
				
			}
		}
	}
	
	private static void left() {
		boolean[][] check = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++) {
				if(map[i][j]==0) {
					for(int k=j+1; k<n; k++) {
						if(map[i][k]!=0) {
							map[i][j] = map[i][k];
							map[i][k] = 0;
							break;
						}
					}
				}
				if(map[i][j]!=0) {
					for(int k=j+1; k<n; k++) {
						if(map[i][k]==0)continue;
						if(map[i][k]==map[i][j] && !check[i][j]) {
							map[i][j] = map[i][j]+map[i][k];
							check[i][j] = true;
							map[i][k] = 0;
							break;
						}
						else if(map[i][k]!=map[i][j]) {
							break;
						}
					}
				}
				
			}
		}
		
	}
	private static void right() {
		boolean[][] check = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>0; j--) {
				if(map[i][j]==0) {
					for(int k=j-1; k>=0; k--) {
						if(map[i][k]!=0) {
							map[i][j] = map[i][k];
							map[i][k] = 0;
							break;
						}
					}
				}
				if(map[i][j]!=0) {
					for(int k=j-1; k>=0; k--) {
						if(map[i][k]==0)continue;
						if(map[i][k]==map[i][j] && !check[i][j]) {
							map[i][j] = map[i][j]+map[i][k];
							check[i][j] = true;
							map[i][k] = 0;
							break;
						}
						else if(map[i][k]!=map[i][j]) {
							break;
						}
					}
				}
				
			}
		}
	}
}
