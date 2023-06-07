import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class sun_beak_1062 {


    private static List<Set<Character>> lst;
    private static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        final char[] essentialAlphabet = {'a', 't', 'i', 'c', 'n'};
        k -= essentialAlphabet.length;

        lst = new ArrayList<>();
        Set<Character> alphaSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char[] inputs = br.readLine().toCharArray();
            Set<Character> tmpSet = new HashSet<>();
            for (char input : inputs) {
                tmpSet.add(input);
            }

            for (char alpha : essentialAlphabet) {
                tmpSet.remove(alpha);
            }

            lst.add(tmpSet);
            alphaSet.addAll(tmpSet);
        }

        if (k == 0) {
            int count = 0;
            for (Set<Character> set : lst) {
                if (set.isEmpty()) {
                    count++;
                }
            }
            System.out.println(count);
            return;
        } else if (k < 0) {
            System.out.println(0);
            return;
        }

        Character[] alphabets = alphaSet.toArray(new Character[0]);
        if (k > alphabets.length) {
            k = alphabets.length;
        }
        dfs(k, alphabets, 0, 0);

        System.out.println(maxValue);
    }


    private static void dfs(int targetDepth, Character[] allAlpha, int index, int depth) {
        if (depth == targetDepth) {
            int count = 0;
            for (Set<Character> set : lst) {
                if (set.isEmpty()) {
                    count++;
                }
            }
            maxValue = Math.max(count, maxValue);
            return;
        }

        for (int i = index; i < allAlpha.length; i++) {
            char currentAlpha = allAlpha[i];

            boolean[] visited = new boolean[lst.size()];
            for (int j = 0; j < lst.size(); j++) {
                Set<Character> currentSet = lst.get(j);
                if (currentSet.contains(currentAlpha)) {
                    visited[j] = true;
                    currentSet.remove(currentAlpha);
                }
            }
            dfs(targetDepth, allAlpha, i + 1, depth + 1);
            for (int j = 0; j < visited.length; j++) {
                if (visited[j]) {
                    Set<Character> currentSet = lst.get(j);
                    currentSet.add(currentAlpha);
                }
            }
        }
    }
}
