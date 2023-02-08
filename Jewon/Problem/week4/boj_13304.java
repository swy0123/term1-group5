import java.util.Scanner;

/**
 * 
 * boj_13304 방 배정 브론즈2
 * 
 * @author SSAFY
 *
 */
// 1~2 학년은 남녀 구분 x
// 3~6 학년은 남녀 구분 0
// 1~2 , 3~4 , 5~6
public class boj_13304 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[2][3];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			int S = sc.nextInt();
			int Y = sc.nextInt();
			switch (Y) {
			case 1:
			case 2:
				arr[S][0]++;
				break;
			case 3:
			case 4:
				arr[S][1]++;
				break;
			case 5:
			case 6:
				arr[S][2]++;
				break;
			}
			
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= 2; j++) {
				cnt += (arr[i][j] / K);
				if (arr[i][j] % K != 0)
					cnt++;
			}
		}

		cnt += (arr[0][0] + arr[1][0]) / K;
		if ((arr[0][0] + arr[1][0]) % K != 0)
			cnt++;
		
		
		System.out.println(cnt);
	}

}
