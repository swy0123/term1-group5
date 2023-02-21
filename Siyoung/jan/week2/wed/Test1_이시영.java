import java.util.Scanner;

public class Test1_이시영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		//1 입력 받았을 때
		if(str.equals("1")) {
			int n = 1;
			for(int i=0; i<4; i++) {
				for(int j=0; j<=i; j++) {
					System.out.printf("%d ", n);
					n++;
				}
				System.out.println();
			}
		}
		//a 입력받았을 때
		else if(str.equals("a")) {
			char c = 'a';
			for(int i=0; i<5; i++) {
				for(int j=i; j<4; j++) {
					System.out.printf("  ");
				}
				for(int j=0; j<=i; j++) {
					System.out.printf("%c ", (char)c);
					c++;
				}
				System.out.println();
			}
		}
		
	}

}
