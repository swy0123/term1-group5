package se;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 활주로건설_swea_4014 {
	
static int n, l;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n][n];
			int res = 0;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<n; i++) {
				if(checkgaro(map, new boolean[n][n], i)) res++;
				if(checksero(map, new boolean[n][n], i)) res++;
			}
			
			System.out.println("#"+tc+" "+res);
		}
	}
	
	private static boolean checkgaro(int[][] map, boolean[][] v, int i) {
		//오르막길
		for(int j=0; j<n; j++) {
			//다음 칸보다 작은지 확인
			if(j<n-1) {
				//1칸만 작을 때
				if(map[i][j] == map[i][j+1]-1) {
					//왼쪽 칸 부족
					if(j<l-1) return false;
					//오르막길 경사로 배치 불가
					for(int k=0; k<l; k++) {
						if(map[i][j] != map[i][j-k]) return false;
						//경사로가 이미 놓여 있음
						if(v[i][j-k]) return false;
						else v[i][j-k] = true;
					}
				}
				//2칸 이상 작음
				else if(map[i][j] < map[i][j+1]-1) return false;
			}
		}
		//내리막길 - 위에꺼 거꾸로
		for(int j=n-1; j>=0; j--) {
			//다음 칸보다 큰지 확인
			if(j>0) {
				//1칸만 작을 때
				if(map[i][j] == map[i][j-1]-1) {
					//오른쪽 칸 부족
					if(j+l>n) return false;
					//내리막길 경사로 배치 불가
					for(int k=0; k<l; k++) {
						if(map[i][j] != map[i][j+k]) return false;
						//경사로가 이미 놓여 있음
						if(v[i][j+k]) return false;
						else v[i][j+k] = true;
					}
				}
				//2칸 이상 작음
				else if(map[i][j] < map[i][j-1]-1) return false;
			}
		}
		return true;
	}
	private static boolean checksero(int[][] map, boolean[][] v, int i) {
		//오르막길
		for(int j=0; j<n; j++) {
			//다음 칸보다 작은지 확인
			if(j<n-1) {
				//1칸만 작을 때
				if(map[j][i] == map[j+1][i]-1) {
					//왼쪽 칸 부족
					if(j<l-1) return false;
					//오르막길 경사로 배치 불가
					for(int k=0; k<l; k++) {
						if(map[j][i] != map[j-k][i]) return false;
						//경사로가 이미 놓여 있음
						if(v[j-k][i]) return false;
						else v[j-k][i] = true;
					}
				}
				//2칸 이상 작음
				else if(map[j][i] < map[j+1][i]-1) return false;
			}
		}
		//내리막길 - 위에꺼 거꾸로
		for(int j=n-1; j>=0; j--) {
			//다음 칸보다 큰지 확인
			if(j>0) {
				//1칸만 작을 때
				if(map[j][i] == map[j-1][i]-1) {
					//오른쪽 칸 부족
					if(j+l>n) return false;
					//내리막길 경사로 배치 불가
					for(int k=0; k<l; k++) {
						if(map[j][i] != map[j+k][i]) return false;
						//경사로가 이미 놓여 있음
						if(v[j+k][i]) return false;
						else v[j+k][i] = true;
					}
				}
				//2칸 이상 작음
				else if(map[j][i] < map[j-1][i]-1) return false;
			}
		}
		return true;
	}
	
}