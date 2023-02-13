import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Node {
	int idx;
	int val;
	
	public Node(int idx, int val) {
		this.idx = idx;
		this.val = val;
	}
}

public class Main {
    private static Stack<Node> s1 = new Stack<>();
    private static Stack<Node> s2 = new Stack<>();
    private static int n;
    private static int[] res;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        res = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	int a = Integer.parseInt(st.nextToken());
        	s1.push(new Node(i, a));
        }
        
        boolean flag = false;
        while (true) {
        	if (s2.empty()) {
        		s2.push(s1.peek());
        		s1.pop();
        	}
        	
        	if (s1.empty()) break;
        	
        	if (s1.peek().val >= s2.peek().val) {
        		flag = true;
        		res[s2.peek().idx] = s1.peek().idx + 1;
        		s2.pop();
        	}
        	else {
        		s2.push(s1.peek());
        		s1.pop();
        	}
        }
        
        if (!flag) System.out.println(0);
        else {
        	for (int i = 0; i < n; i++) {
        		System.out.print(res[i] + " ");
        	}
        }
    }
}