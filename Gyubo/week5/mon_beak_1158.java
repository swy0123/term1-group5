import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class mon_beak_1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int index = 0;
        while (!list.isEmpty()) {
            index += k - 1;
            index %= list.size();

            sb.append(list.remove(index));
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(">");

        System.out.println(sb.toString());
    }
}
