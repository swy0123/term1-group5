import java.util.Scanner;
import java.util.Stack;

class Node {
    int idx;
    char c;

    public Node(int idx, char c) {
        this.idx = idx;
        this.c = c;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String pattern = sc.nextLine();
        Stack<Node> st = new Stack<>();

        for (int i = 0, idx = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (idx > 0 && pattern.charAt(0) == c){
                idx = 0;
                st.push(new Node(idx++, c));
                continue;
            }

            if (pattern.charAt(idx) != c) {
                idx = 0;
                st.push(new Node(-1, c));
            }
            else {
                st.push(new Node(idx++, c));
                if (idx == pattern.length()) {
                    while (idx-- != 0) st.pop();

                    if (st.empty()) idx = 0;
                    else idx = st.peek().idx + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.empty()) sb.append(st.pop().c);
        if (sb.toString().isEmpty()) System.out.println("FRULA");
        else System.out.println(sb.reverse());
    }
}