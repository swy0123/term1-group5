import java.util.Scanner;

public class Test5_권민정 {
	static String[] letter = {"000000", "001111", "010011", "011100",
			"100110", "101001", "110101", "111010"};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		String s = sc.next();
		
		StringBuilder result = new StringBuilder();		// 출력될 결과 문자열
		for(int i = 0; i < s.length(); i += 6) {
			String pattern = s.substring(i, i + 6);
			// 1. 일치하는 문자가 있는지 확인하여 result에 해당 문자 첨가
			boolean flag = false;
			for (int j = 0; j < letter.length; j++) {
				if (pattern.equals(letter[j])) {
					flag = true;
					char c = (char) (65 + j);
					result.append(c);
				}
			}
			// 2. 없다면 숫자 하나만 다른 문자가 있는지 확인
			if (!flag) {
				for (int j = 0; j < letter.length; j++) {
					int sameCnt = 0;
					for (int k = 0; k < pattern.length(); k++) {
						if (letter[j].charAt(k) == pattern.charAt(k)) {
							sameCnt++;
						}
					}
					// 2-1. 하나만 다르다면 result에 해당 문자 첨가
					if (sameCnt == 1) {
						char c = (char) (65 + j);
						result.append(c);
						break;
					}
					// 2-2. 없다면 i/6 출력하고 리턴
					else {
						System.out.println((i / 6) + 1);
						return;
					}
				}
			}
		}
		System.out.println(result.toString());
	}
	
}