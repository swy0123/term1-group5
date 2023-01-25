import java.util.Scanner;

public class Test1_권민정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char a = sc.next().charAt(0);
		if (a == '1') {
			int k = 1;
			for (int i = 1; i <= 4; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print(k + " ");
					k++;
				}
				System.out.println();
			}
		}
		else {
			for (int i = 1; i <= 5; i++) {
				for (int k = 0; k < 5 - i; k++) {
					System.out.print("  ");
				}
				for (int j = 1; j <= i; j++) {
					System.out.print(a + " ");
					a++;
				}
				System.out.println();
			}
		}
	}
}
