
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Test4_권민정 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
//		Scanner in = new Scanner(new File("Test4.txt"));
		//여기에 작성하세요
		int T = in.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int cnt = in.nextInt();		// 응시생 수
			int[] score = new int[cnt];
			// 응시생 점수 입력
			for (int i = 0; i < cnt; i++) {
				score[i] = in.nextInt();
			}
			
			float avg = 0f, failedRate = 0f;	// 평균 점수, fail된 학생 비율
			
			// 응시생 평균 점수 계산
			for (int i = 0; i < cnt; i++) {
				avg += score[i];
			}
			avg /= cnt;
			
			// fail된 학생 비율 계산
			for (int i = 0; i < cnt; i++) {
				if (score[i] < avg) failedRate++;
			}
			
			failedRate = failedRate / cnt * 100;
			System.out.printf("#%d %.3f", testCase, failedRate);
			System.out.println("%");
			
		}
	}
}
