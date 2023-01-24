package week2;
import java.util.Scanner;

/**
 * SWEA  D2
 * 1940. 가랏! RC카!
 * @author elder
 *
 */
public class SWEA_1940 {

	static int veocity = 0;
	static int distance = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			veocity = 0;
			distance = 0;

			int value = 0;

			int commandt = sc.nextInt();

			for (int i = 0; i < commandt; i++) {
				int command = sc.nextInt();

				if (command != 0) {
					value = sc.nextInt();
				}

				command(command, value);
			}

			System.out.println("#" + test_case + " " + distance);
		}
	}

	private static void command(int command, int value) {
		// TODO Auto-generated method stub

		switch (command) {
		case 0:
			break;
		case 1:
			veocity += value;
			break;
		case 2:
			veocity -= value;
			break;
		}

		if (veocity < 0)
			veocity = 0;

		distance += veocity;
	}

}
