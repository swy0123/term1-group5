
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test4_황제원 {

	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("Test4.txt"));
		//여기에 작성하세요
		
		int T = in.nextInt();
		
		for (int i = 0; i < T; i++) {
			int person = in.nextInt();
			int[] list = new int[person];
			
			int sum = 0;
			int cnt = 0;
			
			//Sum
			for (int j = 0; j < person; j++) {
				list[j] = in.nextInt();
				sum += list[j];
			}
			
			
			//Avg
			double avg = (double)sum / person;
			
			//cnt
			for (int j = 0; j < person; j++) {
				if(avg > list[j]) {
					cnt++;
				}
			}
			
			
			
			double ans = (cnt * 100.0) / person;
			
			//printf 
			System.out.printf("#%d %.3f" ,(i+1) ,ans);
			System.out.println("%");
		}
	}
}
