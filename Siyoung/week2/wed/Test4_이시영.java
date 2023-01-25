
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test4_이시영 {

	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(System.in);
		Scanner sc = new Scanner(new File("Test4.txt"));
		//여기에 작성하세요
		int t = sc.nextInt();
		int n, sum, m;
		float avg, rate, ret;
		for(int i=1; i<=t; i++) {
			n = sc.nextInt();
			int[] arr = new int[n];
			sum = 0;
			//응시생 수만큼 배열 생성 후 점수 입력, 총점 구하기
			for(int j=0; j<n; j++) {
				arr[j] = sc.nextInt();
				sum += arr[j];
			}
			m=0;
			avg = (float)sum/n;
			//평균과 비교하여 평균 이하인 응시생 수를 구함
			for(int j=0; j<n; j++) {
				if(arr[j]<avg) m++;
			}
			ret = (float)m/n*100;
			System.out.printf("#%d %.3f%s\n",i, ret, "%");
		}
		
	}
}
