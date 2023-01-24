package week2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


//1208 Flatten

public class SWEA_1208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int dumpcount = sc.nextInt();
			
			Integer[] list = new Integer[100];
			
			for(int i = 0 ; i< list.length; i++) {
				list[i] = sc.nextInt();
			}
			
			for(int i = 0; i< dumpcount ; i++) {
				Arrays.sort(list, Collections.reverseOrder());
				list[0]--;
				list[100 - 1]++;
			}
			
			Arrays.sort(list, Collections.reverseOrder());
			System.out.println("#" + test_case + " "+ (list[0] - list[99]));
			

	}

	}
}
