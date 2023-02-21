import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 
 * boj_2493 탑 골드5
 * 
 * @author SSAFY
 *
 */
public class boj_2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] ans = new int[N];
		//{value, idx}
		Stack<Integer[]> stk = new Stack<Integer[]>();
		
		Integer[] temp = new Integer[2];
		temp[0] = arr[arr.length - 1];
		temp[1] = arr.length - 1;
		stk.add(temp);


		for (int i = arr.length - 2; i >= 0; i--) {
			temp  =  new Integer[2];
			temp[0] = arr[i];
			temp[1] = i;
			
			do {
				if (!stk.isEmpty() && arr[i] > stk.peek()[0]) {
					ans[stk.pop()[1]] = i+1;
					
					if (stk.isEmpty()) {
						stk.push(temp);
						break;
					}
				} else {
					stk.push(temp);
					break;
				}
			} while (!stk.isEmpty());
		}
		
		

		
		
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

}
