
public class Test3_이시영 {
	
	public void execute(String msg) {
		//여기에 작성하세요

		//0~9배열 생성 후 해당 문자를 인덱스값으로 해서 배열의 값을 증가시킴
		int[] arr = new int[10];
		for(int i=0; i<msg.length(); i++) {
			arr[(msg.charAt(i)-'0')]++;
		}
		//배열 출력
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 0) continue;
			System.out.println(i + " : " + arr[i]);
		}
		
		
	}
	
	public static void main(String[] args) {
		Test3_이시영 c=new Test3_이시영();
		c.execute("53290539955364534323455987827332679340558347453272569584"); 
		System.out.println("=======");
		c.execute("13334444555557777777"); 
	}
}
