package week1;

import java.util.ArrayList;
import java.util.Scanner;

public class SaltManSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int SaltN = sc.nextInt();

			ArrayList<int[]> arr = new ArrayList<>();
			ArrayList<Integer> saltDir = new ArrayList<>();

			for (int i = 0; i < SaltN; i++) {
				arr.add(new int[2]);
				arr.get(i)[0] = sc.nextInt();
				arr.get(i)[1] = sc.nextInt();
				saltDir.add(sc.nextInt());
			}

			for (int j = 0; j < arr.size(); j++) {
				for (int i = 0; i < 3; i++) {
					// arr.get(j)

					// 폴짝
					switch (saltDir.get(j)) {
					// 상
					case 1:
						arr.get(j)[0] -= (3 - i);
						break;
					// 하
					case 2:
						arr.get(j)[0] += (3 - i);
						break;
					// 좌
					case 3:
						arr.get(j)[1] -= (3 - i);
						break;

					// 우
					case 4:
						arr.get(j)[1] += (3 - i);
						break;
					}

					// check - 1 연못 안?
					if (arr.get(j)[0] >= 0 && arr.get(j)[0] < N && arr.get(j)[1] >= 0 && arr.get(j)[1] < N) {
						// check - 2 충돌?
						for (int j2 = 0; j2 < arr.size(); j2++) {
							if (j2 != j) {
								if (arr.get(j)[0] == arr.get(j2)[0] && arr.get(j)[1] == arr.get(j2)[1]) {
									
									// 제거
									arr.remove(j);
									saltDir.remove(j);
									j--;
									i = 3;
									break;
								}
							}
						}
					} else {
						
						// 제거
						arr.remove(j);
						saltDir.remove(j);
						i = 3;
						j--;
					}
				}
			}

			System.out.println("#" + test_case + " " + arr.size());

		}
	}

}
