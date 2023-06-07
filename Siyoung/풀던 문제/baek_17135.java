package algorithm.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_17135 {

//	static int[] pos;
//	static int[][] map;
	static int n, m, d;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][m];
		int[] pos = new int[m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		archerPosition(pos, 0, 3, new boolean[m], map);

	}
	
	//궁수 위치 정하기
	private static void archerPosition(int[] pos, int idx, int cnt, boolean[] v, int[][] map) {
		if(cnt == 0) {
			for(int i=0; i<v.length; i++) {
				if(v[i]) {
					pos[i] = 2;
				}
				else pos[i] = 0;
			}
//			archerAttack(pos, cnt, cnt, map);
//			System.out.println(Arrays.toString(v));
		}
		
		
		for(int i=idx; i<v.length; i++) {
			if(v[i] == false) {
				v[i] = true;
				archerPosition(pos, i+1, cnt-1, v, map);
				v[i] = false;
			}
			
		}
		
	}
	
	
	//1 아래로 이동, 궁수 범위 내 가장 가까운 적 공격하여 1 제거, 킬 카운트 증가
	// 잘못짬
//	private static void archerAttack(int[] pos, int round, int kill, int[][] map) {
//		for(int a=0; a<m; a++) {
//			map[n][a] = pos[a];
//			if(pos[a] == 2) {
//				loop : for(int i=0; i<=d; i++) {
//					for(int y=0; y<d; y++) {
//						for(int x=1; x<d-y; x++) {
//							if(n-x>=0 && pos[a]-y>=0) {
//								if(map[n-x][pos[a]-y] == 1) {
//									map[n-x][pos[a]-y] = -1;
//									break loop;
//								}
//							}
//							if(n-x>=0 && pos[a]+y< m) {
//								if(map[n-x][pos[a]+y] == 1) {
//									map[n-x][pos[a]+y] = -1;
//									break loop;
//								}
//							}
//						}
//					}
//				}
//			}
//			
//		}
//		
//		System.out.println();
//		for (int[] m : map) {
//			System.out.println(Arrays.toString(m));
//		}
//		
//		
//		
//		
//		return;
//	}
	

	
	
	

}
