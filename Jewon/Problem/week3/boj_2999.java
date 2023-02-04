package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * boj_2999 비밀 이메일 브론즈1
 * 
 * @author elder
 *
 */
public class boj_2999 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 정인이는 R<=C이고, R*C=N인 R과 C를 고른다. 만약, 그러한 경우가 여러 개일 경우, R이 큰 값을 선택한다.
		// 행이 R개고, 열이 C개인 행렬
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		List<Integer> list = new ArrayList<>();
		int R, C;
		// 약수 구하기
		for (int i = 1; i <= str.length(); i++) {
			if (str.length() % i == 0) {
				list.add(i);
			}
		}

		if (list.size() % 2 == 0) {
			C = list.get(list.size() / 2);
			R = list.get(list.size() / 2 - 1);
		} else {
			C = R = list.get(list.size() / 2);
		}

		char[][] arr = new char[R][C];
		int temp = 1;
		
		for (int i = C - 1; i >= 0; i--) {
			for (int j = R - 1; j >= 0; j--) {
				arr[j][i] = str.charAt(str.length() - temp);
				temp++;
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
			}
		}
		
	}

}
