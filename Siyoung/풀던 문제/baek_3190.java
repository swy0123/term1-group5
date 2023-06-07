package algorithm.week1.fri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_3190 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n];
		map[0][0] = 1;
		
		int i, j;
		for(int l=0; l<k; l++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			map[i][j] = 2;
		}
		int l = Integer.parseInt(br.readLine());

		int[][] dir = new int[l][2];
		for(int m=0; m<l; m++) {
			st = new StringTokenizer(br.readLine());
			dir[m][0] = Integer.parseInt(st.nextToken());
			dir[m][1] = Integer.parseInt(st.nextToken());
		}
		
		int x = 0;
		
		//뱀은 처음에 오른쪽을 향한다
		int di = 0, dj = 1;
		int dirIdx = 0;

		//뱀 현재 위치 큐에 넣기
			//이동 위치 확인
				//아무것도 없다 -> 다음 위치 1로 변환, 위치 좌표 큐에 넣기, 큐에서 하나 빼고 해당 위치 0으로 변환
				//사과 있다 -> 다음 위치 1로 변환, 위치 좌표 큐에 넣기
				//벽(outOfIdx) or 1(자기자신) -> 종료
		//x가 dir[dirIdx][0]에 도달하면 dirIdx++, dir[dirIdx][1]로 방향 전환
		
		while(true) {
			x++;
			
		}

	}

	//방향 전환
	//총 8가지
}
