package algorithm.week1;

import java.util.Scanner;
/*
 * swea 1954. 달팽이 숫자
 */
public class wed_swea_1954 {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			
			int num = 1;
			for(int i=0; i<n; i++) {
				map[0][i] = num++;
			}
			int cnt = n;
			int x = n-1, y=0;
			boolean down = true;
			for(int i=cnt; i>0; i--) {
				cnt--;
				if(down) {
					for(int j=0; j<cnt; j++) {
						y++;
						map[y][x] = num++;
					}
					for(int j=0; j<cnt; j++) {
						x--;
						map[y][x] = num++;
					}
					down = false;
				}
				else {
					for(int j=0; j<cnt; j++) {
						y--;
						map[y][x] = num++;
					}
					for(int j=0; j<cnt; j++) {
						x++;
						map[y][x] = num++;
					}
					down = true;
				}
			}
			System.out.println("#" + test_case);
			for (int[] is : map) {
				for (int is2 : is) {
					System.out.print(is2+" ");
				}
				System.out.println();
			}
			
		
		}
	}

}
