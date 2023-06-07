import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test1_황제원 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String var = sc.next();

		switch (var) {
		case "1":
			int tempi = 1;
			for (int i = 1; i <= 4; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print(tempi++ + " ");
				}
				System.out.println();
			}
			break;

		case "a":
			char tempc = 'a';
			for (int i = 1; i <= 5; i++) {
				for (int j = 0; j < 5 - i; j++) {
					System.out.print("  ");
				}

				for (int j = 0; j < i; j++) {
					System.out.print(tempc++ + " ");
				}
				System.out.println();
			}

			break;
		}

	}

}
