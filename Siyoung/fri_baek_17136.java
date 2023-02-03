package assign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 17136 색종이 붙이기 
 * @author SSAFY
 * 백트래킹
 */
public class fri_baek_17136 {

	private static int res = 100;
	private static int cur = 0;
	private static int[][] map;
	//5, 4, 3, 2, 1칸짜리 개수
	private static int[] paper = {0,5,5,5,5,5};
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[10][10];
		
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		back(0, 0);
		
		if(res > 25) System.out.println(-1);
		else System.out.println(res);
		
	}
	
	private static void back(int a, int b) {
		if(a == 9 && b == 9) return;
		System.out.println(res);
		boolean flag = true;
		boolean er = false;
		
		for(int i=a; i<10; i++) {
			for(int j=b; j<10; j++) {
				if(map[i][j]==1) {
					flag = false;
					for(int k=5; k>0; k--) {
						if(paper[k] < 1) continue;
						if(paper[1] < 1) {
							er = true;
							break;
						}
						if(check(i, j, k)) {
							fill(i, j, k);
							paper[k]--;
							cur++;
							back(i, j);
							unfill(i, j, k);
							paper[k]++;
							cur--;
						}
					}
				}
			}
		}
		
		if(flag&&!er) {
			res = Math.min(cur, res);
		}
		return;
	}

	
	private static boolean check(int i, int j, int cnt) {
		if(i+cnt > 9 || j+cnt > 9) return false;
		
		for(int ci=i; ci<i+cnt; ci++) {
			for(int cj=j; cj<j+cnt; cj++) {
				if(map[ci][cj] != 1) return false;
			}
		}
		return true;
	}
	
	private static void fill(int i, int j, int cnt) {
		if(i+cnt > 9 || j+cnt > 9) return;
		
		for(int ci=i; ci<i+cnt; ci++) {
			for(int cj=j; cj<j+cnt; cj++) {
				map[ci][cj] = 0;
			}
		}
	}
	
	private static void unfill(int i, int j, int cnt) {
		if(i+cnt >= 10 || j+cnt >= 10) return;
		
		for(int ci=i; ci<i+cnt; ci++) {
			for(int cj=j; cj<j+cnt; cj++) {
				map[ci][cj] = 1;
			}
		}
	}
	
	
	
	/*
	 * 최솟값 저장할 전역변수
	 * 색종이 갯수 배열
	 * 현재 갯수 배열
	 * 0, 0 부터 5~1칸짜리 들어가는지 확인하며 탐색
	 * 들어갈 경우 들어간 자리 -1로 채우기
	 * 종이 개수가 모자라면 다음으로 넘어가는데
	 * 	어떤식으로?
	 * 
	 * 현재 위치 주고 5*5, 4*4, 3*3, 2*2 되는지 체크하는 함수
	 * 
	 */
}
