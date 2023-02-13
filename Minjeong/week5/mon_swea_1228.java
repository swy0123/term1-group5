import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	String data;
	Node next;
	
	public Node(String data, Node next) {
		this.data = data;
		this.next = next;
	}
}

public class Main {
	static Node head;
	static int size;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int testCase = 1; testCase <= 10; testCase++) {
        	head = null;
        	int n = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < n; i++) {
				add(i, st.nextToken());
			}
        	
        	int commCnt = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	
        	for (int i = 0; i < commCnt; i++) {
        		String s = st.nextToken();
        		int idx = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				for (int j = idx; j < idx + t; j++) {
					add(j, st.nextToken());
				}
				
			}
        	
        	System.out.print("#" + testCase + " ");
        	printList(head);
        }
    }
    
    private static void add(int idx, String data) {
    	if (idx == 0) {
    		if (head == null) head = new Node(data, null);
    		else head = new Node(data, head);
    	}
    	else {
    		Node pre = getNode(idx - 1);
    		Node post = getNode(idx);
    		Node newNode = new Node(data, post);
    		pre.next = newNode;
    	}
    	size++;
    }
    
    private static Node getNode(int index) {
		if (size > index) {
			Node x = head;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}
			return x;
		}
		return null;
	}
    
    private static void printList(Node head) {
    	int cnt = 0;
    	for (Node i = head; i != null ; i = i.next) {
			System.out.print(i.data + " ");
			if(++cnt == 10) break;
		}
    	System.out.println();
    }
}
