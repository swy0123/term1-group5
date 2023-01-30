import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws Exception {
        Map<Character, Character> m = new HashMap<>();
        m.put(']', '[');
        m.put('}', '{');
        m.put(')', '(');
        m.put('>', '<');

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int testCase = 1; testCase <= 10; testCase++) {
            int len = Integer.parseInt(br.readLine());
            String s = br.readLine();

            Stack<Character> st = new Stack<>();
            st.push(s.charAt(0));
            boolean flag = true;
            for (int i = 1; i < len; i++) {
                char c = s.charAt(i);
                if (m.containsKey(c)) {
                    if (st.peek() != m.get(c)) {
                        flag = false;
                        break;
                    }
                    else st.pop();
                }
                else st.push(c);
            }

            if (!st.empty() || !flag) System.out.println("#" + testCase + " 0");
            else System.out.println("#" + testCase + " 1");
        }
    }
}