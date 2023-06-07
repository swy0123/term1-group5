package algorithm.week1;

import java.util.Scanner;

public class mon_baek_17478 {
	static String tmp = "____";
	static String str1 = "\"재귀함수가 뭔가요?\"";
	static String str2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
	static String str3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
	static String str4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
	static String str5 = "라고 답변하였지.";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		print(0, n);
	}
	
	private static void print(int cur, int n) {
		if(n==0) {
			for(int i=0; i<cur; i++) System.out.print(tmp);
			System.out.println(str1);
			for(int i=0; i<cur; i++) System.out.print(tmp);
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			for(int i=0; i<cur; i++) System.out.print(tmp);
			System.out.println(str5);
			return;
		}
		
		for(int i=0; i<cur; i++) System.out.print(tmp);
		System.out.println(str1);
		for(int i=0; i<cur; i++) System.out.print(tmp);
		System.out.println(str2);
		for(int i=0; i<cur; i++) System.out.print(tmp);
		System.out.println(str3);
		for(int i=0; i<cur; i++) System.out.print(tmp);
		System.out.println(str4);
		
		print(cur+1, n-1);
		for(int i=0; i<cur; i++) System.out.print(tmp);
		System.out.println(str5);
		
	}
	

}
