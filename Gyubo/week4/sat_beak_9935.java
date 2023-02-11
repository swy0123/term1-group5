import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class sat_beak_9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        char[] bombWord = br.readLine().toCharArray();
        int wordSize = bombWord.length;

        Stack<Character> stack = new Stack<>();

        for (char c : input) {
            stack.add(c);

            if (stack.size() >= wordSize) {
                boolean flag = false;
                for (int i = 1; i <= wordSize; i++) {
                    if (stack.get(stack.size() - i) != bombWord[bombWord.length - i]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    for (int i = 0; i < wordSize; i++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Character character : stack) {
                sb.append(character);
            }
            System.out.println(sb.toString());
        }
    }
}
