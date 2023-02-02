package week3;

import java.util.Scanner;
/**
 * 
 * SWEA_1873 상호의 배틀필드 D3
 * @author elder
 *
 */
public class SWEA_1873 {

	static String tank = "^v<>";
	static String wall = "*#";
	static char[][] map;
	static int x = 0, y = 0;
	static int H;
	static int W;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				String str = sc.next();
				for (int j = 0; j < str.length(); j++) {
					map[i][j] = str.charAt(j);
					if (tank.contains(map[i][j] + "")) {
						x = i;
						y = j;
					}
				}
			}

			int N = sc.nextInt();
			String command = sc.next();

			for (int i = 0; i < N; i++) {
				input(command.charAt(i));
			}


			for (int j = 0; j < H; j++) {
				for (int j2 = 0; j2 < W; j2++) {
					System.out.print(map[j][j2]);
				}
				System.out.println();
			}

		}
	}

	private static void input(char command) {
		// TODO Auto-generated method stub
		switch (command) {
		case 'U':
			if (x - 1 >= 0) {
				if (map[x - 1][y] == '.') {
					map[x][y] = '.';
					map[x - 1][y] = '^';
					x = x - 1;
				}
			}
			map[x][y] = '^';
			break;
		case 'D':
			if (x + 1 < H) {
				if (map[x + 1][y] == '.') {
					map[x][y] = '.';
					map[x + 1][y] = 'v';
					x = x + 1;
				}
			}
			map[x][y] = 'v';
			break;
		case 'L':
			if (y - 1 >= 0) {
				if (map[x][y - 1] == '.') {
					map[x][y] = '.';
					map[x][y - 1] = '<';
					y = y - 1;
				}
			}
			map[x][y] = '<';
			break;
		case 'R':
			if (y + 1 < W) {
				if (map[x][y + 1] == '.') {
					map[x][y] = '.';
					map[x][y + 1] = '>';
					y = y + 1;
				}
			}
			map[x][y] = '>';
			break;

		case 'S':
			shoot();
			break;
		}
	}

	private static void shoot() {
		// TODO Auto-generated method stub
		int dist = 1;
		switch (map[x][y]) {
		case '^':
			while (x - dist >= 0) {
				if (map[x - dist][y] == '*') {
					map[x - dist][y] = '.';
					return;
				} else if (map[x - dist][y] == '#') {
					return;
				}
				dist++;
			}
			break;
		case 'v':
			while (x + dist < H) {
				if (map[x + dist][y] == '*') {
					map[x + dist][y] = '.';
					return;
				} else if (map[x + dist][y] == '#') {
					return;
				}
				dist++;
			}
			break;
		case '<':
			while (y - dist >= 0) {
				if (map[x][y - dist] == '*') {
					map[x][y - dist] = '.';
					return;
				} else if (map[x][y - dist] == '#') {
					return;
				}
				dist++;
			}
			break;
		case '>':
			while (y + dist < W) {
				if (map[x][y + dist] == '*') {
					map[x][y + dist] = '.';
					return;
				} else if (map[x][y + dist] == '#') {
					return;
				}
				dist++;
			}
			break;
		}
	}

}
