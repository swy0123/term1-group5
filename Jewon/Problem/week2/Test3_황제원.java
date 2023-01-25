
public class Test3_황제원 {

	public void execute(String msg) {
		// 여기에 작성하세요
		int[] list = new int[10];

		for (int i = 0; i < msg.length(); i++) {
			list[msg.charAt(i) - '0']++;
		}

		for (int i = 0; i < list.length; i++) {
			if (list[i] != 0)
				System.out.println(i + " : " + list[i]);
		}
	}

	public static void main(String[] args) {
		Test3_황제원 c = new Test3_황제원();
		c.execute("53290539955364534323455987827332679340558347453272569584");
		System.out.println("=======");
		c.execute("13334444555557777777");
	}
}
