import java.util.Scanner;

public class Test5_이시영 {

	public static String[] sarr = {
			"000000", "001111", "010011", "011100",
			"100110", "101001", "110101", "111010"
	};
	public static String[] alph = {"A", "B", "C", "D", "E", "F", "G", "H"};
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		String ret = "";
		
		for(int i=0; i<str.length(); i+=6) {
			int[] arr = new int[8];
			//입력받은 문자열을 6개씩 나누어 문자표와 비교해 맞는 문자의 개수를 파악한다 
			for(int j=0; j<6; j++) {
				for(int k=0; k<8; k++) {
					if(str.charAt(i+j) == sarr[k].charAt(j)) {
						arr[k]++;
					}
				}
			}
			//맞는 개수가 5개 이상인 알파벳을 결과에 추가한다
			int cnt = 0;
			for(int j=0; j<8; j++) {
				if(arr[j]>=5) ret += alph[j];
				else cnt++;
			}
			//만약 5개 이상 맞는 알파벳이 없을 경우 해당 위치를 출력하고 종료
			if(cnt==8) {
				System.out.println((i+1)/6+1);
				return;
			}
		}
		//결과 출력
		System.out.println(ret);
		
		
	}
	
}