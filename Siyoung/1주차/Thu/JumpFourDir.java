package assignment;

import java.util.Scanner;

public class JumpFourDir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		int[] di = {0, 1, 0, -1};
		int[] dj = {1, 0, -1, 0};
		
		int y, x, n, tn, ti, tj;
		int ret;
		
		for(int t=1; t<=test; t++) {
			//y좌표, x좌표, 참가자 수 입력
			y = sc.nextInt();
			x = sc.nextInt();
			n = sc.nextInt();
			ret = 0;
			
			//놀이공간 입력
			//앞자리 = 방향, 뒷자리 = 점프칸수
			int[][] map = new int[y][x];
			for(int i=0; i<y; i++) {
				for(int j=0; j<x; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//참가자 정보 입력
			//시작위치 행,열, 점프횟수
			int[][] parr = new int[n][3];
			for(int i=0; i<n; i++) {
				parr[i][0] = sc.nextInt();
				parr[i][1] = sc.nextInt();
				parr[i][2] = sc.nextInt();
			}
			
			//함정 위치
			tn = sc.nextInt();
			for(int i=0; i<tn; i++) {
				ti = sc.nextInt();
				tj = sc.nextInt();
				map[ti-1][tj-1]=0;
			}
			
			for(int k=0; k<n; k++) {
				int ci = parr[k][0]-1, cj = parr[k][1]-1, cc = parr[k][2];
				int cur = map[ci][cj];
				int dir = (cur/10)-1;
				int cnt = cur%10;

				ret -= 1000;
//				System.out.println(cur + " i: " + ci + " j: " + cj + " dir:" + dir + " cnt:" + cnt +  " cc:" + cc);
				
				//점프 횟수만큼 뛸 때마다 뛴 위치를 기준으로 방향과거리를 다시 정하고 점프
				for(int jc=1; jc<=cc; jc++) {
					if(dir<0) break;
					if(ci+di[dir]*cnt>=0 && ci+di[dir]*cnt<y &&
							cj+dj[dir]*cnt>=0 && cj+dj[dir]*cnt<x) {
						ci += di[dir]*cnt;
						cj += dj[dir]*cnt;
						cur = map[ci][cj];
						dir = (cur/10)-1;
						cnt = cur%10;
						if(map[ci][cj]==0) {
							break;
						}
					}
					else {
						break;
					}
					if(jc==cc) {
						ret += map[ci][cj]*100;
					}

				}
			}
			
			System.out.println("#"+t+" "+ret);
		}
	}

}
