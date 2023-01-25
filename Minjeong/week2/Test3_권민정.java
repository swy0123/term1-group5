import java.util.HashMap;
import java.util.Map;

public class Test3_권민정 {
	
	public void execute(String msg) {
		//여기에 작성하세요
		Map<Character, Integer> m = new HashMap<>();
		
		for (int i = 0; i < msg.length(); i++) {
			char c = msg.charAt(i);
			if (m.get(c) == null) m.put(c, 1);
			else m.replace(c,  m.get(c) + 1);
		}
		
		printResult(m);
	}
	
	private void printResult(Map<Character, Integer> m) {
		for (Map.Entry<Character, Integer> e : m.entrySet()) {
			Character key = e.getKey();
			Integer val = e.getValue();
			System.out.println(key + " : " + val);
		}
	}
	
	public static void main(String[] args) {
		Test3_권민정 c=new Test3_권민정();
		c.execute("53290539955364534323455987827332679340558347453272569584"); 
		System.out.println("=======");
		c.execute("13334444555557777777"); 
	}
}
