package week2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 창고 다각형 2304번 Silver 2
 * 
 * @author elder
 *
 */
public class BEAK_2304 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Integer[][] list = new Integer[N][2];

		for (int i = 0; i < N; i++) {
			list[i][0] = sc.nextInt();
			list[i][1] = sc.nextInt();
		}

		Arrays.sort(list, new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[0], o2[0]); // x - y > 0 이면 교환
			}

		});

		// Applying Labda + 레퍼런스 추정 
		//Arrays.sort(list, (o1,o2) -> Integer.compare(o1[0], o2[0]));
		
		int maxval = 0, maxidx = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i][1] > maxval) {
				maxval = list[i][1];
				maxidx = i;
			}
		}

		int sum = 0, currentmaxidx = 0;
		for (int i = 1; i <= maxidx; i++) {
			if (list[i][1] >= list[currentmaxidx][1]) {
				sum += (list[i][0] - list[currentmaxidx][0]) * list[currentmaxidx][1];
				currentmaxidx = i;
			}
		}

		currentmaxidx = list.length - 1;
		for (int i = currentmaxidx - 1; i >= maxidx; i--) {
			if (list[i][1] >= list[currentmaxidx][1]) {
				sum += (list[currentmaxidx][0] - list[i][0]) * list[currentmaxidx][1];
				currentmaxidx = i;
			}
		}

		sum += maxval;

		System.out.println(sum);

	}

}
