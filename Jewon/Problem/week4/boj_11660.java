import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 * boj_11660 구간 합 구하기 5 실버1
 * 
 * @author SSAFY
 *
 */
public class boj_11660 {

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				
				
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (i - 1 >= 0) {
					arr[i][j] += arr[i - 1][j];
				}
				if (j - 1 >= 0) {
					arr[i][j] += arr[i][j - 1];
				}
				if (i - 1 >= 0 && j - 1 >= 0) {
					arr[i][j] -= arr[i - 1][j - 1];
				}
			}
		}
		

		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int val = 0;
			int x1 = Integer.parseInt(st.nextToken())-1; int y1 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken())-1; int y2 = Integer.parseInt(st.nextToken())-1;
			
			val = arr[x2][y2];
			if(x1-1 >= 0) {
				val -= arr[x1-1][y2];
			}
			if(y1-1 >= 0) {
				val -= arr[x2][y1-1];
			}
			if(x1-1 >= 0 && y1-1 >= 0) {
				val += arr[x1-1][y1-1];
			}
			
			System.out.println(val);
		}
	}

}
