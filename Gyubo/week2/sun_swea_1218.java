import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class sun_swea_1218 {

    private static final Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map.put("(", ")");
        map.put("{", "}");
        map.put("[", "]");
        map.put("<", ">");

        for (int tc = 1; tc < 11; tc++) {
            String length = br.readLine();
            String input = br.readLine();
            String[] data = input.split("");

            Stack<String> stack = new Stack<>();
            for (String s : data) {
                if (stack.isEmpty()) {
                    stack.add(s);
                    continue;
                }
                // stack의 마지막 값과 같다면 stack pop
                if (map.containsKey(stack.peek())) {
                    if (map.get(stack.peek()).equals(s)) {
                        stack.pop();
                        continue;
                    }
                }
                // 아니라면 stack에 현재 값 추가
                stack.add(s);
            }

            if (stack.isEmpty()) {
                System.out.println("#" + tc + " " + 1);
            } else {
                System.out.println("#" + tc + " " + 0);

            }
        }


    }
}
