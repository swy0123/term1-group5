import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

// 프로젝트 스케줄링
public class thu_baek_14907 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] degree = new int[26];
        int[] time = new int[26];
        int[] res = new int[26];
        Set<Character> works = new HashSet<>();
        List<Character>[] list = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            list[i] = new ArrayList<>();
        }

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] input = s.split(" ");
            char work = input[0].charAt(0);
            works.add(work);
            time[work - 'A'] = Integer.parseInt(input[1]);
            if (input.length == 3) {
                for (int i = 0; i < input[2].length(); i++) {
                    int idx = input[2].charAt(i) - 'A';
                    list[idx].add(work);
                    degree[work - 'A'] += 1;
                }
            }
        }

        int result = 0;
        Queue<Character> q = new ArrayDeque<>();
        for (char c : works) {
            if (degree[c - 'A'] == 0) {
                q.offer(c);
                res[c - 'A'] = time[c - 'A'];
                result = Math.max(result, res[c - 'A']);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (char next : list[cur - 'A']) {
                int idx = next - 'A';
                degree[idx] -= 1;
                res[idx] = Math.max(res[idx], res[cur - 'A']);
                if (degree[idx] == 0) {
                    res[idx] += time[idx];
                    result = Math.max(result, res[idx]);
                    q.offer(next);
                }
            }
        }

        System.out.println(result);
    }
}
