package assign;

import java.util.Scanner;
/**
 * 백준 [골드5] 14719 : 빗물
 * @author SSAFY
 *
 */
public class fri_baek_14719 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		int[] arr = new int[w];
		
		int max = 0;
		int maxIdx = 0;
		int sum = 0;
		
		for(int i=0; i<w; i++) {
			arr[i] = sc.nextInt();
			sum -= arr[i];
			if(arr[i] > max) {
				max = arr[i];
				maxIdx = i;
			}
		}
		int cur = 0;
		for(int i=0; i<maxIdx; i++) {
			if(arr[i]>cur) {
				cur = arr[i];
			}
			sum+=cur;
		}
		cur = 0;
		for(int i=w-1; i>=maxIdx; i--) {
			if(arr[i]>cur) {
				cur = arr[i];
			}
			sum+=cur;
		}
		System.out.println(sum);
	}

}
