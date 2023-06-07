import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class mon_swea_1228 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int tc = 1; tc < 11; tc++) {
            List<Integer> list = new LinkedList<>();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            String[] split = br.readLine().split("I");

            for (int i = 1; i < m + 1; i++) {
                st = new StringTokenizer(split[i].trim());
                int index = Integer.parseInt(st.nextToken());
                int size = Integer.parseInt(st.nextToken());
                int[] tmpArr = new int[size];

                for (int j = size - 1; j >= 0; j--) {
                    tmpArr[j] = Integer.parseInt(st.nextToken());
                }
                for (int j = 0; j < size; j++) {
                    list.add(index, tmpArr[j]);
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#");
            sb.append(tc);
            sb.append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i) + " ");
            }

            System.out.println(sb.toString());
        }
    }
}