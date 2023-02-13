import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_16935 배열 돌리기 3 실버 1
 * 
 * @author SSAFY
 *
 */
public class boj_16935 {
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] command = new int[R];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < command.length; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < command.length; i++) {
			func(command[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void func(int command) {
		int temp;
		int[][] arrt;
		int n;
		int m;
		
		switch (command) {
		case 1:
			for (int i = 0; i < arr.length / 2; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					temp = arr[i][j];
					arr[i][j] = arr[arr.length - i - 1][j];
					arr[arr.length - i - 1][j] = temp;
				}
			}
			break;
		case 2:
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length / 2; j++) {
					temp = arr[i][j];
					arr[i][j] = arr[i][arr[i].length - j - 1];
					arr[i][arr[i].length - j - 1] = temp;
				}
			}
			break;
		case 3:
			arrt = new int[arr[0].length][arr.length];
			for (int i = 0; i < arr[0].length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arrt[i][j] = arr[arr.length - j - 1][i];
				}
			}
			arr = arrt;
			break;
		case 4:
			arrt = new int[arr[0].length][arr.length];
			for (int i = 0; i < arr[0].length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arrt[i][j] = arr[j][arr[0].length - i - 1];
				}
			}
			arr = arrt;
			break;
		case 5:
			arrt = new int[arr.length][arr[0].length];
			n = arr.length/2;
			m = arr[0].length/2;
			
			for (int i = 0; i < arr.length / 2; i++) {
				for (int j = 0; j < arr[i].length / 2; j++) {
					arrt[i][j] = arr[i + n][j];
					arrt[i][j + m] = arr[i][j];
					arrt[i + n][j + m] = arr[i][j + m];
					arrt[i + n][j] = arr[i + n][j + m];
				}
			}
			arr = arrt;
			break;
		case 6:
			// 0,0 -> 0+n, 0 -> 0+n , 0+M -> 0, 0+M
			arrt = new int[arr.length][arr[0].length];
			n = arr.length/2;
			m = arr[0].length/2;
			
			for (int i = 0; i < arr.length / 2; i++) {
				for (int j = 0; j < arr[i].length / 2; j++) {
					arrt[i + n][j] = arr[i][j];
					arrt[i][j] = arr[i][j + m];
					arrt[i][j + m] = arr[i + n][j + m];
					arrt[i + n][j + m] = arr[i + n][j];
				}
			}
			arr = arrt;
			break;
		}
	}

}
