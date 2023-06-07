import java.util.Arrays;
import java.util.Scanner;

/**
 * boj_1244 스위치 켜고 끄기 실버4
 * 
 * @author SSAFY
 *
 */
public class boj_1244 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int swtC = sc.nextInt();
		int[] arr = new int[swtC + 1];

		for (int i = 1; i <= swtC; i++) {
			arr[i] = sc.nextInt();
		}

		int student = sc.nextInt();
		int[][] students = new int[student][2];

		for (int i = 0; i < students.length; i++) {
			students[i][0] = sc.nextInt();
			students[i][1] = sc.nextInt();
		}
		
		//
		for (int i = 0; i < students.length; i++) {
			// 1 남자는 배수
			// 2 여자는 좌우대칭
			switch (students[i][0]) {
			case 1:
				int cnt = 1;
				while (students[i][1] * cnt <= swtC) {
					// 바꾸기
					arr[students[i][1] * cnt] = 1 - arr[students[i][1] * cnt];
					cnt++;
				}
				break;

			case 2:
				cnt = 0;
				while (true) {
					// arr[students[i][1]]
					if ((students[i][1] - (cnt + 1) >= 1) && (students[i][1] + (cnt + 1) <= swtC)) {
						if (arr[students[i][1] + (cnt + 1)] == arr[students[i][1] - (cnt + 1)]) {
							cnt++;
						} else {
							break;
						}
					} else {
						break;
					}
				}

				for (int j = students[i][1] - cnt; j <= students[i][1] + cnt; j++) {
					arr[j] = 1 - arr[j];
				}
				break;
			}

		}
		//
		int idx = 1;
		while(idx!=swtC+1) {
			System.out.print(arr[idx] + " ");
			if(idx%20 == 0) {
				System.out.println();
			}
			idx++;
		}

	}

}
