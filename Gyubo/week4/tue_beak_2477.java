import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class tue_beak_2477 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> results = new ArrayDeque<>();
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int vector = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if (vector <= 2) {
                value *= -1;
            }

            results.add(value);
        }
        Integer min = Collections.min(results);
        Integer max = Collections.max(results);

        int count = 0;
        while (true) {
            if (count == 2) {
                break;
            }
            int pop = results.pop();
            if (pop == max || pop == min){
                count++;
                continue;
            }
            results.add(pop);
        }

        results.pop();
        int a = results.pop();
        int b = results.pop();

        int answer = min * max * -1 - (a * b * -1);
        answer *= n;
        System.out.println(answer);
    }
}