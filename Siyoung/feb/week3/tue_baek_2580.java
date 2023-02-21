package algorithm.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 백준 2580 스도쿠
 */
public class tue_baek_2580 {
//	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] map = new int[9][9];
		int zero = 0;
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) zero++;
			}
		}
		
		sdoku(map, zero);
	}
	
	private static void sdoku(int[][] map, int zero) {
		if(zero == 0) {
			for (int[] is : map) {
				for (int is2 : is) {
					System.out.print(is2+" ");
				}
				System.out.println();
			}
			System.exit(0);
			return;
		}
		int[][] tmp = new int[9][9];
		for(int i=0; i<9; i++) {
			tmp[i] = map[i].clone();
		}
		
		int ci=-1, cj=-1;
		
		label : for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(tmp[i][j] == 0) {
					ci = i;
					cj = j;
					break label;
				}
			}
		}
		
		for(int k=1; k<=9; k++) {
			tmp[ci][cj] = k;
			if(check(tmp, ci, cj)) {
				sdoku(tmp, zero-1);
			}
			
		}
	}
	//가로 세로 3*3체크
	private static boolean check(int[][] map, int r, int c) {
		int[] arr1 = new int[9];
		int[] arr2 = new int[9];
		int[] arr3 = new int[9];
		//세로줄
		for(int i=0; i<9; i++) {
			if(map[i][c] == 0) continue;
			arr1[map[i][c]-1]+=1;
			if(arr1[map[i][c]-1]>1)return false;
		}
		
		//가로줄
		for(int i=0; i<9; i++) {
			if(map[r][i] == 0) continue;
			arr2[map[r][i]-1]+=1;
			if(arr2[map[r][i]-1]>1)return false;
		}
		
		//3*3
		for(int i=(r/3)*3; i<(r/3)*3+3; i++) {
			for(int j=(c/3)*3; j<(c/3)*3+3; j++) {
				if(map[i][j] == 0) continue;
				arr3[map[i][j]-1]+=1;
				if(arr3[map[i][j]-1]>1)return false;
			}
		}

		return true;
	}
	
}
